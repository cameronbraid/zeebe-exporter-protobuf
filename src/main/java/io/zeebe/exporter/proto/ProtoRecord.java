package io.zeebe.exporter.proto;

import io.zeebe.protocol.record.Record;
import io.zeebe.protocol.record.RecordType;
import io.zeebe.protocol.record.RecordValue;
import io.zeebe.protocol.record.RejectionType;
import io.zeebe.protocol.record.ValueType;
import io.zeebe.protocol.record.intent.Intent;

public class ProtoRecord<T extends RecordValue> implements Record<T> {

  private final Schema.RecordMetadata metadata;
  private final T value;
  private final ValueType valueType;

  public ProtoRecord(Schema.RecordMetadata metadata , T value, ValueType valueType) {
    this.metadata = metadata;
    this.value = value;
    this.valueType = valueType;
  }
  
  public long getPosition() {
    return metadata.getPosition();
  }

  public long getSourceRecordPosition(){
    return metadata.getSourceRecordPosition();
  }

  public long getKey(){
    return metadata.getKey();
  }

  public long getTimestamp(){
    return metadata.getTimestamp();
  }

  public Intent getIntent() {
    return Intent.fromProtocolValue(valueType, metadata.getIntent());
  }

  public int getPartitionId() {
    return metadata.getPartitionId();
  }

  public RecordType getRecordType() {
    return RecordTransformer.fromRecordType(metadata.getRecordType());
  }

  public RejectionType getRejectionType() {
    return RejectionType.valueOf(metadata.getRejectionType());
  }

  public String getRejectionReason() {
    return metadata.getRejectionReason();
  }

  public ValueType getValueType() {
    return valueType;
  }

  public T getValue() {
    return value;
  }

  public Record<T> clone() {
    // immutable so no need to clone
    return this;
  }

  @Override
  public String toJson() {
    return JsonUtil.toJson(this);
  }
}