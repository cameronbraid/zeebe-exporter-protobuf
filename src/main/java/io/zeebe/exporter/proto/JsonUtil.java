package io.zeebe.exporter.proto;

import io.zeebe.protocol.record.Record;
import io.zeebe.protocol.record.RecordValue;

public class JsonUtil {
  
  public static String toJson(Record<?> record) {
    throw new RuntimeException("Not supported");
  }
  
  public static String toJson(RecordValue recordValue) {
    throw new RuntimeException("Not supported");
  }
}
