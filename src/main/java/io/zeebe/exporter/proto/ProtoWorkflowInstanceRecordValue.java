package io.zeebe.exporter.proto;

import io.zeebe.protocol.record.value.BpmnElementType;
import io.zeebe.protocol.record.value.WorkflowInstanceRecordValue;

public class ProtoWorkflowInstanceRecordValue implements WorkflowInstanceRecordValue {

  private final Schema.WorkflowInstanceRecord record;

  private final BpmnElementType bpmnElementType;
  public ProtoWorkflowInstanceRecordValue(Schema.WorkflowInstanceRecord record) {
    this.record = record;
    this.bpmnElementType = RecordTransformer.fromBpmnElementType(record.getBpmnElementType());
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

  public String getElementId() {
    return record.getElementId();
  }

  public long getFlowScopeKey() {
    return record.getFlowScopeKey();
  }

  public BpmnElementType getBpmnElementType() {
    return bpmnElementType;
  }

  public long getParentWorkflowInstanceKey() {
    return record.getParentWorkflowInstanceKey();
  }

  public long getParentElementInstanceKey() {
    return record.getParentElementInstanceKey();
  }

  public String toJson() {
    return JsonUtil.toJson(this);
  }
}