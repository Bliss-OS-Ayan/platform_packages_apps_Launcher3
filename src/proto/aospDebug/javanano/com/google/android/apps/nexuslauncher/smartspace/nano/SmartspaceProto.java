// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.google.android.apps.nexuslauncher.smartspace.nano;

@SuppressWarnings("hiding")
public interface SmartspaceProto {

  public static final class a extends
      com.google.protobuf.nano.MessageNano {

    private static volatile a[] _emptyArray;
    public static a[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new a[0];
          }
        }
      }
      return _emptyArray;
    }

    // repeated .nano.b cw = 1;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b[] cw;

    public a() {
      clear();
    }

    public a clear() {
      cw = com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b.emptyArray();
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.cw != null && this.cw.length > 0) {
        for (int i = 0; i < this.cw.length; i++) {
          com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b element = this.cw[i];
          if (element != null) {
            output.writeMessage(1, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.cw != null && this.cw.length > 0) {
        for (int i = 0; i < this.cw.length; i++) {
          com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b element = this.cw[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(1, element);
          }
        }
      }
      return size;
    }

    @Override
    public a mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 10);
            int i = this.cw == null ? 0 : this.cw.length;
            com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b[] newArray =
                new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b[i + arrayLength];
            if (i != 0) {
              java.lang.System.arraycopy(this.cw, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b();
            input.readMessage(newArray[i]);
            this.cw = newArray;
            break;
          }
        }
      }
    }

    public static a parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new a(), data);
    }

    public static a parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new a().mergeFrom(input);
    }
  }

  public static final class b extends
      com.google.protobuf.nano.MessageNano {

    private static volatile b[] _emptyArray;
    public static b[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new b[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional bool cy = 1;
    public boolean cy;

    // optional int32 cJ = 2;
    public int cJ;

    // optional .nano.c cB = 3;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c cB;

    // optional .nano.c cC = 4;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c cC;

    // optional .nano.c cH = 5;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c cH;

    // optional .nano.f cx = 6;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.f cx;

    // optional int32 cA = 7;
    public int cA;

    // optional .nano.g cG = 8;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.g cG;

    // optional int64 cK = 9;
    public long cK;

    // optional int64 cD = 10;
    public long cD;

    // optional int64 cE = 11;
    public long cE;

    // optional .nano.h cF = 12;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.h cF;

    // optional int32 cz = 13;
    public int cz;

    public b() {
      clear();
    }

    public b clear() {
      cy = false;
      cJ = 0;
      cB = null;
      cC = null;
      cH = null;
      cx = null;
      cA = 0;
      cG = null;
      cK = 0L;
      cD = 0L;
      cE = 0L;
      cF = null;
      cz = 0;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.cy != false) {
        output.writeBool(1, this.cy);
      }
      if (this.cJ != 0) {
        output.writeInt32(2, this.cJ);
      }
      if (this.cB != null) {
        output.writeMessage(3, this.cB);
      }
      if (this.cC != null) {
        output.writeMessage(4, this.cC);
      }
      if (this.cH != null) {
        output.writeMessage(5, this.cH);
      }
      if (this.cx != null) {
        output.writeMessage(6, this.cx);
      }
      if (this.cA != 0) {
        output.writeInt32(7, this.cA);
      }
      if (this.cG != null) {
        output.writeMessage(8, this.cG);
      }
      if (this.cK != 0L) {
        output.writeInt64(9, this.cK);
      }
      if (this.cD != 0L) {
        output.writeInt64(10, this.cD);
      }
      if (this.cE != 0L) {
        output.writeInt64(11, this.cE);
      }
      if (this.cF != null) {
        output.writeMessage(12, this.cF);
      }
      if (this.cz != 0) {
        output.writeInt32(13, this.cz);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.cy != false) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(1, this.cy);
      }
      if (this.cJ != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.cJ);
      }
      if (this.cB != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(3, this.cB);
      }
      if (this.cC != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(4, this.cC);
      }
      if (this.cH != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(5, this.cH);
      }
      if (this.cx != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(6, this.cx);
      }
      if (this.cA != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(7, this.cA);
      }
      if (this.cG != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(8, this.cG);
      }
      if (this.cK != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(9, this.cK);
      }
      if (this.cD != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(10, this.cD);
      }
      if (this.cE != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(11, this.cE);
      }
      if (this.cF != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(12, this.cF);
      }
      if (this.cz != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(13, this.cz);
      }
      return size;
    }

    @Override
    public b mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.cy = input.readBool();
            break;
          }
          case 16: {
            this.cJ = input.readInt32();
            break;
          }
          case 26: {
            if (this.cB == null) {
              this.cB = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c();
            }
            input.readMessage(this.cB);
            break;
          }
          case 34: {
            if (this.cC == null) {
              this.cC = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c();
            }
            input.readMessage(this.cC);
            break;
          }
          case 42: {
            if (this.cH == null) {
              this.cH = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.c();
            }
            input.readMessage(this.cH);
            break;
          }
          case 50: {
            if (this.cx == null) {
              this.cx = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.f();
            }
            input.readMessage(this.cx);
            break;
          }
          case 56: {
            this.cA = input.readInt32();
            break;
          }
          case 66: {
            if (this.cG == null) {
              this.cG = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.g();
            }
            input.readMessage(this.cG);
            break;
          }
          case 72: {
            this.cK = input.readInt64();
            break;
          }
          case 80: {
            this.cD = input.readInt64();
            break;
          }
          case 88: {
            this.cE = input.readInt64();
            break;
          }
          case 98: {
            if (this.cF == null) {
              this.cF = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.h();
            }
            input.readMessage(this.cF);
            break;
          }
          case 104: {
            this.cz = input.readInt32();
            break;
          }
        }
      }
    }

    public static b parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new b(), data);
    }

    public static b parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new b().mergeFrom(input);
    }
  }

  public static final class c extends
      com.google.protobuf.nano.MessageNano {

    private static volatile c[] _emptyArray;
    public static c[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new c[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional .nano.d cL = 1;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.d cL;

    // optional .nano.d cM = 2;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.d cM;

    public c() {
      clear();
    }

    public c clear() {
      cL = null;
      cM = null;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.cL != null) {
        output.writeMessage(1, this.cL);
      }
      if (this.cM != null) {
        output.writeMessage(2, this.cM);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.cL != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(1, this.cL);
      }
      if (this.cM != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(2, this.cM);
      }
      return size;
    }

    @Override
    public c mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            if (this.cL == null) {
              this.cL = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.d();
            }
            input.readMessage(this.cL);
            break;
          }
          case 18: {
            if (this.cM == null) {
              this.cM = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.d();
            }
            input.readMessage(this.cM);
            break;
          }
        }
      }
    }

    public static c parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new c(), data);
    }

    public static c parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new c().mergeFrom(input);
    }
  }

  public static final class d extends
      com.google.protobuf.nano.MessageNano {

    private static volatile d[] _emptyArray;
    public static d[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new d[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional string cN = 1;
    public java.lang.String cN;

    // optional int32 cP = 2;
    public int cP;

    // repeated .nano.e cO = 3;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e[] cO;

    public d() {
      clear();
    }

    public d clear() {
      cN = "";
      cP = 0;
      cO = com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e.emptyArray();
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.cN.equals("")) {
        output.writeString(1, this.cN);
      }
      if (this.cP != 0) {
        output.writeInt32(2, this.cP);
      }
      if (this.cO != null && this.cO.length > 0) {
        for (int i = 0; i < this.cO.length; i++) {
          com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e element = this.cO[i];
          if (element != null) {
            output.writeMessage(3, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.cN.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.cN);
      }
      if (this.cP != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.cP);
      }
      if (this.cO != null && this.cO.length > 0) {
        for (int i = 0; i < this.cO.length; i++) {
          com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e element = this.cO[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(3, element);
          }
        }
      }
      return size;
    }

    @Override
    public d mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.cN = input.readString();
            break;
          }
          case 16: {
            this.cP = input.readInt32();
            break;
          }
          case 26: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 26);
            int i = this.cO == null ? 0 : this.cO.length;
            com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e[] newArray =
                new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e[i + arrayLength];
            if (i != 0) {
              java.lang.System.arraycopy(this.cO, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.e();
            input.readMessage(newArray[i]);
            this.cO = newArray;
            break;
          }
        }
      }
    }

    public static d parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new d(), data);
    }

    public static d parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new d().mergeFrom(input);
    }
  }

  public static final class e extends
      com.google.protobuf.nano.MessageNano {

    private static volatile e[] _emptyArray;
    public static e[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new e[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional string cR = 1;
    public java.lang.String cR;

    // optional int32 cS = 2;
    public int cS;

    // optional int32 cQ = 3;
    public int cQ;

    // optional bool cU = 4;
    public boolean cU;

    public e() {
      clear();
    }

    public e clear() {
      cR = "";
      cS = 0;
      cQ = 0;
      cU = false;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.cR.equals("")) {
        output.writeString(1, this.cR);
      }
      if (this.cS != 0) {
        output.writeInt32(2, this.cS);
      }
      if (this.cQ != 0) {
        output.writeInt32(3, this.cQ);
      }
      if (this.cU != false) {
        output.writeBool(4, this.cU);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.cR.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.cR);
      }
      if (this.cS != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.cS);
      }
      if (this.cQ != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(3, this.cQ);
      }
      if (this.cU != false) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(4, this.cU);
      }
      return size;
    }

    @Override
    public e mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.cR = input.readString();
            break;
          }
          case 16: {
            this.cS = input.readInt32();
            break;
          }
          case 24: {
            this.cQ = input.readInt32();
            break;
          }
          case 32: {
            this.cU = input.readBool();
            break;
          }
        }
      }
    }

    public static e parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new e(), data);
    }

    public static e parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new e().mergeFrom(input);
    }
  }

  public static final class f extends
      com.google.protobuf.nano.MessageNano {

    private static volatile f[] _emptyArray;
    public static f[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new f[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional string cV = 1;
    public java.lang.String cV;

    // optional string cW = 2;
    public java.lang.String cW;

    // optional string cX = 3;
    public java.lang.String cX;

    public f() {
      clear();
    }

    public f clear() {
      cV = "";
      cW = "";
      cX = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (!this.cV.equals("")) {
        output.writeString(1, this.cV);
      }
      if (!this.cW.equals("")) {
        output.writeString(2, this.cW);
      }
      if (!this.cX.equals("")) {
        output.writeString(3, this.cX);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (!this.cV.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, this.cV);
      }
      if (!this.cW.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(2, this.cW);
      }
      if (!this.cX.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(3, this.cX);
      }
      return size;
    }

    @Override
    public f mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            this.cV = input.readString();
            break;
          }
          case 18: {
            this.cW = input.readString();
            break;
          }
          case 26: {
            this.cX = input.readString();
            break;
          }
        }
      }
    }

    public static f parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new f(), data);
    }

    public static f parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new f().mergeFrom(input);
    }
  }

  public static final class g extends
      com.google.protobuf.nano.MessageNano {

    private static volatile g[] _emptyArray;
    public static g[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new g[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional int32 cY = 1;
    public int cY;

    // optional string cZ = 2;
    public java.lang.String cZ;

    public g() {
      clear();
    }

    public g clear() {
      cY = 0;
      cZ = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.cY != 0) {
        output.writeInt32(1, this.cY);
      }
      if (!this.cZ.equals("")) {
        output.writeString(2, this.cZ);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.cY != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(1, this.cY);
      }
      if (!this.cZ.equals("")) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(2, this.cZ);
      }
      return size;
    }

    @Override
    public g mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.cY = input.readInt32();
            break;
          }
          case 18: {
            this.cZ = input.readString();
            break;
          }
        }
      }
    }

    public static g parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new g(), data);
    }

    public static g parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new g().mergeFrom(input);
    }
  }

  public static final class h extends
      com.google.protobuf.nano.MessageNano {

    private static volatile h[] _emptyArray;
    public static h[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new h[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional int64 da = 1;
    public long da;

    // optional int32 db = 2;
    public int db;

    public h() {
      clear();
    }

    public h clear() {
      da = 0L;
      db = 0;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.da != 0L) {
        output.writeInt64(1, this.da);
      }
      if (this.db != 0) {
        output.writeInt32(2, this.db);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.da != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(1, this.da);
      }
      if (this.db != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, this.db);
      }
      return size;
    }

    @Override
    public h mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.da = input.readInt64();
            break;
          }
          case 16: {
            this.db = input.readInt32();
            break;
          }
        }
      }
    }

    public static h parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new h(), data);
    }

    public static h parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new h().mergeFrom(input);
    }
  }

  public static final class i extends
      com.google.protobuf.nano.MessageNano {

    private static volatile i[] _emptyArray;
    public static i[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new i[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional bool dc = 6;
    public boolean dc;

    // optional bytes dd = 5;
    public byte[] dd;

    // optional .nano.b de = 1;
    public com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b de;

    // optional int64 df = 2;
    public long df;

    // optional int32 dg = 4;
    public int dg;

    // optional int64 dh = 3;
    public long dh;

    public i() {
      clear();
    }

    public i clear() {
      dc = false;
      dd = com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES;
      de = null;
      df = 0L;
      dg = 0;
      dh = 0L;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.de != null) {
        output.writeMessage(1, this.de);
      }
      if (this.df != 0L) {
        output.writeInt64(2, this.df);
      }
      if (this.dh != 0L) {
        output.writeInt64(3, this.dh);
      }
      if (this.dg != 0) {
        output.writeInt32(4, this.dg);
      }
      if (!java.util.Arrays.equals(this.dd, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
        output.writeBytes(5, this.dd);
      }
      if (this.dc != false) {
        output.writeBool(6, this.dc);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.de != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(1, this.de);
      }
      if (this.df != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(2, this.df);
      }
      if (this.dh != 0L) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(3, this.dh);
      }
      if (this.dg != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(4, this.dg);
      }
      if (!java.util.Arrays.equals(this.dd, com.google.protobuf.nano.WireFormatNano.EMPTY_BYTES)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBytesSize(5, this.dd);
      }
      if (this.dc != false) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(6, this.dc);
      }
      return size;
    }

    @Override
    public i mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            if (this.de == null) {
              this.de = new com.google.android.apps.nexuslauncher.smartspace.nano.SmartspaceProto.b();
            }
            input.readMessage(this.de);
            break;
          }
          case 16: {
            this.df = input.readInt64();
            break;
          }
          case 24: {
            this.dh = input.readInt64();
            break;
          }
          case 32: {
            this.dg = input.readInt32();
            break;
          }
          case 42: {
            this.dd = input.readBytes();
            break;
          }
          case 48: {
            this.dc = input.readBool();
            break;
          }
        }
      }
    }

    public static i parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new i(), data);
    }

    public static i parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new i().mergeFrom(input);
    }
  }
}
