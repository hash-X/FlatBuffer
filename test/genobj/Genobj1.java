package test.genobj;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genobj.TestObj;

import java.nio.ByteBuffer;

/**
 * test.fbs
 */
public class Genobj1 {
  public static void main(String[] args) {
    // Serialization
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;
    TestObj.startTestObj(fbb);
    TestObj.addName(fbb, fbb.createString("lisi"));
    int env = TestObj.endTestObj(fbb);
    TestObj.finishTestObjBuffer(fbb, env);
    byteBuffer = fbb.dataBuffer();
    // Deserialization
    TestObj testObj = TestObj.getRootAsTestObj(byteBuffer);
    long id = testObj.id();
  }
}
