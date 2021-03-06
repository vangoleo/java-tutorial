// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: request.proto

package com.leibangzhu.javatutorial.protobuf;

public final class RequestModel {
  private RequestModel() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:tutorial.Request)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 id = 1;</code>
     */
    int getId();

    /**
     * <code>string name = 2;</code>
     */
    String getName();
    /**
     * <code>string name = 2;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */
    int getParamsCount();
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */
    boolean containsParams(
            String key);
    /**
     * Use {@link #getParamsMap()} instead.
     */
    @Deprecated
    java.util.Map<String, String>
    getParams();
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */
    java.util.Map<String, String>
    getParamsMap();
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    String getParamsOrDefault(
            String key,
            String defaultValue);
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    String getParamsOrThrow(
            String key);
  }
  /**
   * Protobuf type {@code tutorial.Request}
   */
  public  static final class Request extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:tutorial.Request)
      RequestOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Request.newBuilder() to construct.
    private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Request() {
      id_ = 0;
      name_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Request(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              id_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                params_ = com.google.protobuf.MapField.newMapField(
                    ParamsDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000004;
              }
              com.google.protobuf.MapEntry<String, String>
              params__ = input.readMessage(
                  ParamsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              params_.getMutableMap().put(
                  params__.getKey(), params__.getValue());
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return RequestModel.internal_static_tutorial_Request_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetParams();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return RequestModel.internal_static_tutorial_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Request.class, Builder.class);
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile Object name_;
    /**
     * <code>string name = 2;</code>
     */
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PARAMS_FIELD_NUMBER = 3;
    private static final class ParamsDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          String, String> defaultEntry =
              com.google.protobuf.MapEntry
              .<String, String>newDefaultInstance(
                  RequestModel.internal_static_tutorial_Request_ParamsEntry_descriptor,
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "");
    }
    private com.google.protobuf.MapField<
        String, String> params_;
    private com.google.protobuf.MapField<String, String>
    internalGetParams() {
      if (params_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ParamsDefaultEntryHolder.defaultEntry);
      }
      return params_;
    }

    public int getParamsCount() {
      return internalGetParams().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    public boolean containsParams(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetParams().getMap().containsKey(key);
    }
    /**
     * Use {@link #getParamsMap()} instead.
     */
    @Deprecated
    public java.util.Map<String, String> getParams() {
      return getParamsMap();
    }
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    public java.util.Map<String, String> getParamsMap() {
      return internalGetParams().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    public String getParamsOrDefault(
        String key,
        String defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetParams().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; params = 3;</code>
     */

    public String getParamsOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetParams().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
      }
      com.google.protobuf.GeneratedMessageV3
        .serializeStringMapTo(
          output,
          internalGetParams(),
          ParamsDefaultEntryHolder.defaultEntry,
          3);
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
      }
      for (java.util.Map.Entry<String, String> entry
           : internalGetParams().getMap().entrySet()) {
        com.google.protobuf.MapEntry<String, String>
        params__ = ParamsDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(3, params__);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Request)) {
        return super.equals(obj);
      }
      Request other = (Request) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getName()
          .equals(other.getName());
      result = result && internalGetParams().equals(
          other.internalGetParams());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      if (!internalGetParams().getMap().isEmpty()) {
        hash = (37 * hash) + PARAMS_FIELD_NUMBER;
        hash = (53 * hash) + internalGetParams().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Request parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Request parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Request parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Request parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Request parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Request parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Request parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Request parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Request parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Request parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Request parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Request parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Request prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code tutorial.Request}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:tutorial.Request)
        RequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return RequestModel.internal_static_tutorial_Request_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 3:
            return internalGetParams();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 3:
            return internalGetMutableParams();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return RequestModel.internal_static_tutorial_Request_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Request.class, Builder.class);
      }

      // Construct using com.leibangzhu.javatutorial.protobuf.RequestModel.Request.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = 0;

        name_ = "";

        internalGetMutableParams().clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return RequestModel.internal_static_tutorial_Request_descriptor;
      }

      public Request getDefaultInstanceForType() {
        return Request.getDefaultInstance();
      }

      public Request build() {
        Request result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Request buildPartial() {
        Request result = new Request(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.id_ = id_;
        result.name_ = name_;
        result.params_ = internalGetParams();
        result.params_.makeImmutable();
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Request) {
          return mergeFrom((Request)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Request other) {
        if (other == Request.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        internalGetMutableParams().mergeFrom(
            other.internalGetParams());
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Request parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Request) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private Object name_ = "";
      /**
       * <code>string name = 2;</code>
       */
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string name = 2;</code>
       */
      public Builder setName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 2;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<
          String, String> params_;
      private com.google.protobuf.MapField<String, String>
      internalGetParams() {
        if (params_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              ParamsDefaultEntryHolder.defaultEntry);
        }
        return params_;
      }
      private com.google.protobuf.MapField<String, String>
      internalGetMutableParams() {
        onChanged();;
        if (params_ == null) {
          params_ = com.google.protobuf.MapField.newMapField(
              ParamsDefaultEntryHolder.defaultEntry);
        }
        if (!params_.isMutable()) {
          params_ = params_.copy();
        }
        return params_;
      }

      public int getParamsCount() {
        return internalGetParams().getMap().size();
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public boolean containsParams(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        return internalGetParams().getMap().containsKey(key);
      }
      /**
       * Use {@link #getParamsMap()} instead.
       */
      @Deprecated
      public java.util.Map<String, String> getParams() {
        return getParamsMap();
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public java.util.Map<String, String> getParamsMap() {
        return internalGetParams().getMap();
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public String getParamsOrDefault(
          String key,
          String defaultValue) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetParams().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public String getParamsOrThrow(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        java.util.Map<String, String> map =
            internalGetParams().getMap();
        if (!map.containsKey(key)) {
          throw new IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearParams() {
        internalGetMutableParams().getMutableMap()
            .clear();
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public Builder removeParams(
          String key) {
        if (key == null) { throw new NullPointerException(); }
        internalGetMutableParams().getMutableMap()
            .remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @Deprecated
      public java.util.Map<String, String>
      getMutableParams() {
        return internalGetMutableParams().getMutableMap();
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */
      public Builder putParams(
          String key,
          String value) {
        if (key == null) { throw new NullPointerException(); }
        if (value == null) { throw new NullPointerException(); }
        internalGetMutableParams().getMutableMap()
            .put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, string&gt; params = 3;</code>
       */

      public Builder putAllParams(
          java.util.Map<String, String> values) {
        internalGetMutableParams().getMutableMap()
            .putAll(values);
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:tutorial.Request)
    }

    // @@protoc_insertion_point(class_scope:tutorial.Request)
    private static final Request DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Request();
    }

    public static Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Request>
        PARSER = new com.google.protobuf.AbstractParser<Request>() {
      public Request parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Request(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Request> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Request> getParserForType() {
      return PARSER;
    }

    public Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Request_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Request_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Request_ParamsEntry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Request_ParamsEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rrequest.proto\022\010tutorial\"\201\001\n\007Request\022\n\n" +
      "\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022-\n\006params\030\003 \003(\0132" +
      "\035.tutorial.Request.ParamsEntry\032-\n\013Params" +
      "Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001B4\n" +
      "$com.leibangzhu.javatutorial.protobufB\014R" +
      "equestModelb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_tutorial_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Request_descriptor,
        new String[] { "Id", "Name", "Params", });
    internal_static_tutorial_Request_ParamsEntry_descriptor =
      internal_static_tutorial_Request_descriptor.getNestedTypes().get(0);
    internal_static_tutorial_Request_ParamsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Request_ParamsEntry_descriptor,
        new String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
