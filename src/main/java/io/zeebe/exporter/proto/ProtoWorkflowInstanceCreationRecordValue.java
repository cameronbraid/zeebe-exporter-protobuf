package io.zeebe.exporter.proto;

import java.util.Map;

import io.zeebe.protocol.record.value.WorkflowInstanceCreationRecordValue;

public class ProtoWorkflowInstanceCreationRecordValue implements WorkflowInstanceCreationRecordValue {

  private final Schema.WorkflowInstanceCreationRecord record;

  private final Map<String, Object> variables;
  public ProtoWorkflowInstanceCreationRecordValue(Schema.WorkflowInstanceCreationRecord record) {
    this.record = record;
    this.variables = RecordTransformer.fromStruct(record.getVariables());
  }

  public String toJson() {
    return JsonUtil.toJson(this);
  }

  public String getBpmnProcessId() {
    return record.getBpmnProcessId();
  }

  public int getVersion() {
    return record.getVersion();
  }

  public long getWorkflowKey() {
    return record.getWorkflowKey();
  }

  public long getWorkflowInstanceKey() {
    return record.getWorkflowInstanceKey();
  }

  public Map<String, Object> getVariables() {
    return variables;
  }

}