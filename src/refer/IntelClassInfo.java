// automatically generated, do not modify

package src.refer;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class IntelClassInfo extends Table {
  public static IntelClassInfo getRootAsIntelClassInfo(ByteBuffer _bb) { return getRootAsIntelClassInfo(_bb, new IntelClassInfo()); }
  public static IntelClassInfo getRootAsIntelClassInfo(ByteBuffer _bb, IntelClassInfo obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public IntelClassInfo __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public short numTeacher() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public IntelStudent stu() { return stu(new IntelStudent()); }
  public IntelStudent stu(IntelStudent obj) { int o = __offset(6); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }

  public static int createIntelClassInfo(FlatBufferBuilder builder,
      short numTeacher,
      int stu) {
    builder.startObject(2);
    IntelClassInfo.addStu(builder, stu);
    IntelClassInfo.addNumTeacher(builder, numTeacher);
    return IntelClassInfo.endIntelClassInfo(builder);
  }

  public static void startIntelClassInfo(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addNumTeacher(FlatBufferBuilder builder, short numTeacher) { builder.addShort(0, numTeacher, 0); }
  public static void addStu(FlatBufferBuilder builder, int stuOffset) { builder.addOffset(1, stuOffset, 0); }
  public static int endIntelClassInfo(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishIntelClassInfoBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

