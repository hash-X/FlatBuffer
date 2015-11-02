// automatically generated, do not modify

package src.separateschema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class ClassInfo extends Table {
  public static ClassInfo getRootAsClassInfo(ByteBuffer _bb) { return getRootAsClassInfo(_bb, new ClassInfo()); }
  public static ClassInfo getRootAsClassInfo(ByteBuffer _bb, ClassInfo obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public ClassInfo __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public short numTeacher() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public Student stu(int j) { return stu(new Student(), j); }
  public Student stu(Student obj, int j) { int o = __offset(6); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int stuLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }

  public static int createClassInfo(FlatBufferBuilder builder,
      short numTeacher,
      int stu) {
    builder.startObject(2);
    ClassInfo.addStu(builder, stu);
    ClassInfo.addNumTeacher(builder, numTeacher);
    return ClassInfo.endClassInfo(builder);
  }

  public static void startClassInfo(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addNumTeacher(FlatBufferBuilder builder, short numTeacher) { builder.addShort(0, numTeacher, 0); }
  public static void addStu(FlatBufferBuilder builder, int stuOffset) { builder.addOffset(1, stuOffset, 0); }
  public static int createStuVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startStuVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endClassInfo(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishClassInfoBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

