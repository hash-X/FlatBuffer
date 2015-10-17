// automatically generated, do not modify

package src.genobj;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class TestObj extends Table {
  public static TestObj getRootAsTestObj(ByteBuffer _bb) { return getRootAsTestObj(_bb, new TestObj()); }
  public static TestObj getRootAsTestObj(ByteBuffer _bb, TestObj obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public TestObj __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public long id() { int o = __offset(4); return o != 0 ? bb.getLong(o + bb_pos) : 0; }
  public String name() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public long list(int j) { int o = __offset(8); return o != 0 ? bb.getLong(__vector(o) + j * 8) : 0; }
  public int listLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer listAsByteBuffer() { return __vector_as_bytebuffer(8, 8); }

  public static int createTestObj(FlatBufferBuilder builder,
      long id,
      int name,
      int list) {
    builder.startObject(3);
    TestObj.addId(builder, id);
    TestObj.addList(builder, list);
    TestObj.addName(builder, name);
    return TestObj.endTestObj(builder);
  }

  public static void startTestObj(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addId(FlatBufferBuilder builder, long id) { builder.addLong(0, id, 0); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(1, nameOffset, 0); }
  public static void addList(FlatBufferBuilder builder, int listOffset) { builder.addOffset(2, listOffset, 0); }
  public static int createListVector(FlatBufferBuilder builder, long[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addLong(data[i]); return builder.endVector(); }
  public static void startListVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static int endTestObj(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishTestObjBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

