package test.refer;

import com.google.flatbuffers.FlatBufferBuilder;
import src.refer.IntelClassInfo;
import src.refer.IntelStudent;

/**
 * Created by root on 15-11-2.
 */
public class Test1 {
  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    int end = IntelClassInfo.createIntelClassInfo(fbb, (short)3,
        IntelStudent.createIntelStudent(fbb, 1231312423));
    IntelClassInfo.finishIntelClassInfoBuffer(fbb, end);
    IntelClassInfo info = IntelClassInfo.getRootAsIntelClassInfo(fbb.dataBuffer());
    int id = info.stu().id();
  }
}
