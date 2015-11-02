// automatically generated, do not modify

package src.refer;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class IntelStudent extends Table {
  public static IntelStudent getRootAsIntelStudent(ByteBuffer _bb) { return getRootAsIntelStudent(_bb, new IntelStudent()); }
  public static IntelStudent getRootAsIntelStudent(ByteBuffer _bb, IntelStudent obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public IntelStudent __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public int id() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createIntelStudent(FlatBufferBuilder builder,
      int id) {
    builder.startObject(1);
    IntelStudent.addId(builder, id);
    return IntelStudent.endIntelStudent(builder);
  }

  public static void startIntelStudent(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addId(FlatBufferBuilder builder, int id) { builder.addInt(0, id, 0); }
  public static int endIntelStudent(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

