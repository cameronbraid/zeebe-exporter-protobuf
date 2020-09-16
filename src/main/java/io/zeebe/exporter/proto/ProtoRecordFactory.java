package io.zeebe.exporter.proto;

import io.zeebe.protocol.record.Record;
import io.zeebe.protocol.record.ValueType;
import io.zeebe.protocol.record.value.WorkflowInstanceRecordValue;

public class ProtoRecordFactory {

  public static final Record<WorkflowInstanceRecordValue> workflowInstance(Schema.WorkflowInstanceRecord message) {
    return new ProtoRecord<WorkflowInstanceRecordValue>(
      message.getMetadata(), 
      new ProtoWorkflowInstanceRecordValue(message),
      ValueType.WORKFLOW_INSTANCE
    );
  }

  public static final Record<ProtoWorkflowInstanceCreationRecordValue> workflowInstanceCreation(Schema.WorkflowInstanceCreationRecord message) {
    return new ProtoRecord<ProtoWorkflowInstanceCreationRecordValue>(
      message.getMetadata(), 
      new ProtoWorkflowInstanceCreationRecordValue(message),
      ValueType.WORKFLOW_INSTANCE_CREATION
    );
  }

}