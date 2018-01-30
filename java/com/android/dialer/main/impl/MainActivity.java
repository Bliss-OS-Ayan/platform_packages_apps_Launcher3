/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.dialer.main.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.QuickContact;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.android.dialer.calllog.ui.NewCallLogFragment;
import com.android.dialer.common.FragmentUtils.FragmentUtilListener;
import com.android.dialer.common.LogUtil;
import com.android.dialer.common.concurrent.DialerExecutorComponent;
import com.android.dialer.common.concurrent.UiListener;
import com.android.dialer.compat.CompatUtils;
import com.android.dialer.constants.ActivityRequestCodes;
import com.android.dialer.contactsfragment.ContactsFragment;
import com.android.dialer.contactsfragment.ContactsFragment.Header;
import com.android.dialer.contactsfragment.ContactsFragment.OnContactSelectedListener;
import com.android.dialer.database.Database;
import com.android.dialer.dialpadview.DialpadFragment;
import com.android.dialer.dialpadview.DialpadFragment.DialpadListener;
import com.android.dialer.dialpadview.DialpadFragment.LastOutgoingCallCallback;
import com.android.dialer.dialpadview.DialpadFragment.OnDialpadQueryChangedListener;
import com.android.dialer.main.impl.BottomNavBar.OnBottomNavTabSelectedListener;
import com.android.dialer.main.impl.toolbar.MainToolbar;
import com.android.dialer.postcall.PostCall;
import com.android.dialer.searchfragment.list.NewSearchFragment.SearchFragmentListener;
import com.android.dialer.smartdial.util.SmartDialPrefix;
import com.android.dialer.speeddial.SpeedDialFragment;
import com.android.dialer.telecom.TelecomUtil;
import com.android.dialer.voicemail.listui.NewVoicemailFragment;
import com.google.common.util.concurrent.ListenableFuture;

/** This is the main activity for dialer. It hosts favorites, call log, search, dialpad, etc... */
public final class MainActivity extends AppCompatActivity implements FragmentUtilListener {

  private static final String KEY_SAVED_LANGUAGE_CODE = "saved_language_code";

  private final MainOnContactSelectedListener onContactSelectedListener =
      new MainOnContactSelectedListener(this);
  private final MainDialpadFragmentHost dialpadFragmentHostInterface =
      new MainDialpadFragmentHost();

  private MainSearchController searchController;
  private MainOnDialpadQueryChangedListener onDialpadQueryChangedListener;
  private MainDialpadListener dialpadListener;
  private MainSearchFragmentListener searchFragmentListener;

  /** Language the device was in last time {@link #onSaveInstanceState(Bundle)} was called. */
  private String savedLanguageCode;

  private View snackbarContainer;
  private UiListener<String> getLastOutgoingCallListener;

  /**
   * @param context Context of the application package implementing MainActivity class.
   * @return intent for MainActivity.class
   */
  public static Intent getIntent(Context context) {
    return new Intent(context, MainActivity.class)
        .setAction(Intent.ACTION_VIEW)
        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtil.enterBlock("MainActivity.onCreate");
    setContentView(R.layout.main_activity);
    initUiListeners();
    initLayout(savedInstanceState);
    SmartDialPrefix.initializeNanpSettings(this);
  }

  private void initUiListeners() {
    getLastOutgoingCallListener =
        DialerExecutorComponent.get(this)
            .createUiListener(getFragmentManager(), "Query last phone number");
  }

  private void initLayout(Bundle savedInstanceState) {
    snackbarContainer = findViewById(R.id.coordinator_layout);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(v -> searchController.showDialpad(true));

    MainToolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(findViewById(R.id.toolbar));

    BottomNavBar bottomNav = findViewById(R.id.bottom_nav_bar);
    bottomNav.setOnTabSelectedListener(new MainBottomNavBarBottomNavTabListener());

    searchController = new MainSearchController(this, bottomNav, fab, toolbar);
    toolbar.setSearchBarListener(searchController);

    onDialpadQueryChangedListener = new MainOnDialpadQueryChangedListener(searchController);
    dialpadListener = new MainDialpadListener(this, searchController, getLastOutgoingCallListener);
    searchFragmentListener = new MainSearchFragmentListener(searchController);

    // Restore our view state if needed, else initialize as if the app opened for the first time
    if (savedInstanceState != null) {
      savedLanguageCode = savedInstanceState.getString(KEY_SAVED_LANGUAGE_CODE);
      searchController.onRestoreInstanceState(savedInstanceState);
    } else {
      // TODO(calderwoodra): Implement last tab
      bottomNav.selectTab(BottomNavBar.TabIndex.SPEED_DIAL);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    // Start the thread that updates the smart dial database if the activity is recreated with a
    // language change.
    boolean forceUpdate = !CompatUtils.getLocale(this).getISO3Language().equals(savedLanguageCode);
    Database.get(this).getDatabaseHelper(this).startSmartDialUpdateThread(forceUpdate);
    showPostCallPrompt();
  }

  private void showPostCallPrompt() {
    if (TelecomUtil.isInManagedCall(this)) {
      // No prompt to show if the user is in a call
      return;
    }

    if (searchController.isInSearch()) {
      // Don't show the prompt if we're in the search ui
      return;
    }

    PostCall.promptUserForMessageIfNecessary(this, snackbarContainer);
  }

  @Override
  protected void onSaveInstanceState(Bundle bundle) {
    super.onSaveInstanceState(bundle);
    bundle.putString(KEY_SAVED_LANGUAGE_CODE, CompatUtils.getLocale(this).getISO3Language());
    searchController.onSaveInstanceState(bundle);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == ActivityRequestCodes.DIALTACTS_VOICE_SEARCH) {
      searchController.onVoiceResults(resultCode, data);
    } else {
      LogUtil.e("MainActivity.onActivityResult", "Unknown request code: " + requestCode);
    }
  }

  @Override
  public void onBackPressed() {
    if (searchController.onBackPressed()) {
      return;
    }
    super.onBackPressed();
  }

  @Nullable
  @Override
  @SuppressWarnings("unchecked") // Casts are checked using runtime methods
  public <T> T getImpl(Class<T> callbackInterface) {
    if (callbackInterface.isInstance(onContactSelectedListener)) {
      return (T) onContactSelectedListener;
    } else if (callbackInterface.isInstance(onDialpadQueryChangedListener)) {
      return (T) onDialpadQueryChangedListener;
    } else if (callbackInterface.isInstance(dialpadListener)) {
      return (T) dialpadListener;
    } else if (callbackInterface.isInstance(dialpadFragmentHostInterface)) {
      return (T) dialpadFragmentHostInterface;
    } else if (callbackInterface.isInstance(searchFragmentListener)) {
      return (T) searchFragmentListener;
    } else {
      return null;
    }
  }

  /** @see OnContactSelectedListener */
  private static final class MainOnContactSelectedListener implements OnContactSelectedListener {

    private final Context context;

    MainOnContactSelectedListener(Context context) {
      this.context = context;
    }

    @Override
    public void onContactSelected(ImageView photo, Uri contactUri, long contactId) {
      // TODO(calderwoodra): Add impression logging
      QuickContact.showQuickContact(
          context, photo, contactUri, QuickContact.MODE_LARGE, null /* excludeMimes */);
    }
  }

  /** @see OnDialpadQueryChangedListener */
  private static final class MainOnDialpadQueryChangedListener
      implements OnDialpadQueryChangedListener {

    private final MainSearchController searchController;

    MainOnDialpadQueryChangedListener(MainSearchController searchController) {
      this.searchController = searchController;
    }

    @Override
    public void onDialpadQueryChanged(String query) {
      searchController.onDialpadQueryChanged(query);
    }
  }

  /** @see DialpadListener */
  private static final class MainDialpadListener implements DialpadListener {

    private final MainSearchController searchController;
    private final Context context;
    private final UiListener<String> listener;

    MainDialpadListener(
        Context context, MainSearchController searchController, UiListener<String> uiListener) {
      this.context = context;
      this.searchController = searchController;
      this.listener = uiListener;
    }

    @Override
    public void getLastOutgoingCall(LastOutgoingCallCallback callback) {
      ListenableFuture<String> listenableFuture =
          DialerExecutorComponent.get(context)
              .backgroundExecutor()
              .submit(() -> Calls.getLastOutgoingCall(context));
      listener.listen(context, listenableFuture, callback::lastOutgoingCall, throwable -> {});
    }

    @Override
    public void onDialpadShown() {
      searchController.onDialpadShown();
    }

    @Override
    public void onCallPlacedFromDialpad() {
      // TODO(calderwoodra): logging
    }
  }

  /** @see SearchFragmentListener */
  private static final class MainSearchFragmentListener implements SearchFragmentListener {

    private final MainSearchController searchController;

    MainSearchFragmentListener(MainSearchController searchController) {
      this.searchController = searchController;
    }

    @Override
    public void onSearchListTouch() {
      searchController.onSearchListTouch();
    }

    @Override
    public void onCallPlacedFromSearch() {
      // TODO(calderwoodra): logging
    }
  }

  /** @see DialpadFragment.HostInterface */
  private static final class MainDialpadFragmentHost implements DialpadFragment.HostInterface {

    @Override
    public boolean onDialpadSpacerTouchWithEmptyQuery() {
      // No-op, just let the clicks fall through to the search list
      return false;
    }
  }

  /**
   * Implementation of {@link OnBottomNavTabSelectedListener} that handles logic for showing each of
   * the main tabs.
   */
  private final class MainBottomNavBarBottomNavTabListener
      implements OnBottomNavTabSelectedListener {

    private static final String SPEED_DIAL_TAG = "speed_dial";
    private static final String CALL_LOG_TAG = "call_log";
    private static final String CONTACTS_TAG = "contacts";
    private static final String VOICEMAIL_TAG = "voicemail";

    @Override
    public void onSpeedDialSelected() {
      hideAllFragments();
      SpeedDialFragment fragment =
          (SpeedDialFragment) getFragmentManager().findFragmentByTag(SPEED_DIAL_TAG);
      if (fragment == null) {
        getFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, SpeedDialFragment.newInstance(), SPEED_DIAL_TAG)
            .commit();
      } else {
        getFragmentManager().beginTransaction().show(fragment).commit();
      }
    }

    @Override
    public void onCallLogSelected() {
      hideAllFragments();
      NewCallLogFragment fragment =
          (NewCallLogFragment) getSupportFragmentManager().findFragmentByTag(CALL_LOG_TAG);
      if (fragment == null) {
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, new NewCallLogFragment(), CALL_LOG_TAG)
            .commit();
      } else {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
      }
    }

    @Override
    public void onContactsSelected() {
      hideAllFragments();
      ContactsFragment fragment =
          (ContactsFragment) getFragmentManager().findFragmentByTag(CONTACTS_TAG);
      if (fragment == null) {
        getFragmentManager()
            .beginTransaction()
            .add(
                R.id.fragment_container,
                ContactsFragment.newInstance(Header.ADD_CONTACT),
                CONTACTS_TAG)
            .commit();
      } else {
        getFragmentManager().beginTransaction().show(fragment).commit();
      }
    }

    @Override
    public void onVoicemailSelected() {
      hideAllFragments();
      NewVoicemailFragment fragment =
          (NewVoicemailFragment) getSupportFragmentManager().findFragmentByTag(VOICEMAIL_TAG);
      if (fragment == null) {
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, new NewVoicemailFragment(), VOICEMAIL_TAG)
            .commit();
      } else {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
      }
    }

    private void hideAllFragments() {
      FragmentTransaction supportTransaction = getSupportFragmentManager().beginTransaction();
      if (getSupportFragmentManager().findFragmentByTag(CALL_LOG_TAG) != null) {
        supportTransaction.hide(getSupportFragmentManager().findFragmentByTag(CALL_LOG_TAG));
      }
      if (getSupportFragmentManager().findFragmentByTag(VOICEMAIL_TAG) != null) {
        supportTransaction.hide(getSupportFragmentManager().findFragmentByTag(VOICEMAIL_TAG));
      }
      supportTransaction.commit();

      android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
      if (getFragmentManager().findFragmentByTag(SPEED_DIAL_TAG) != null) {
        transaction.hide(getFragmentManager().findFragmentByTag(SPEED_DIAL_TAG));
      }
      if (getFragmentManager().findFragmentByTag(CONTACTS_TAG) != null) {
        transaction.hide(getFragmentManager().findFragmentByTag(CONTACTS_TAG));
      }
      transaction.commit();
    }
  }
}
