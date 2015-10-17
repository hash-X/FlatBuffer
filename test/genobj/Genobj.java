package test.genobj;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genobj.TestObj;

import java.nio.ByteBuffer;

/**
 * Created by minglei on 15-10-17.
 */
public class Genobj {
  public static void main(String[] args) {
    // Serialization
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;
    long id = 123;
    int name = fbb.createString("zhangsan");
    long[] data = new long[]{1,2,3,4,5};
    int list = TestObj.createListVector(fbb, data);
    int env = TestObj.createTestObj(fbb, id, name, list);
    TestObj.finishTestObjBuffer(fbb, env);
    byteBuffer = fbb.dataBuffer();

    // Deserialization
    TestObj testObj = TestObj.getRootAsTestObj(byteBuffer);
    String str = testObj.name();
    long l = testObj.id();
    for (int i = 0; i < testObj.listLength() ; i++) {
      System.out.print(testObj.list(i) + " ");
    }

  }
}
