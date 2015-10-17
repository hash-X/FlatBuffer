package test.genobj;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genobj.TestObj;

import java.nio.ByteBuffer;

/**
 * Created by minglei on 15-10-17.
 */
public class Genobj2 {
  public static void main(String[] args) {
    // Serialization
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;

    TestObj.startTestObj(fbb);
    TestObj.addId(fbb, 7);
    TestObj.addName(fbb, fbb.createString("lisi"));
    long[] data = new long[]{1,2,3,4,5};
    int listOffset = TestObj.createListVector(fbb, data);
    TestObj.addList(fbb, listOffset);
    int env = TestObj.endTestObj(fbb);
    // This line of code mush be have for finish the buffer
    TestObj.finishTestObjBuffer(fbb, env);
    // Deserialization
    byteBuffer = fbb.dataBuffer();
    TestObj testObj = TestObj.getRootAsTestObj(byteBuffer);
    int len = testObj.listLength();
    String str = testObj.name();
    long l = testObj.id();
    for (int i = 0; i < testObj.listLength() ; i++) {
      System.out.print(testObj.list(i) + " ");
    }

  }
}
