// automatically generated, do not modify

package src.separateschema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Student extends Table {
  public static Student getRootAsStudent(ByteBuffer _bb) { return getRootAsStudent(_bb, new Student()); }
  public static Student getRootAsStudent(ByteBuffer _bb, Student obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Student __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public short age() { int o = __offset(6); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public int id() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createStudent(FlatBufferBuilder builder,
      int name,
      short age,
      int id) {
    builder.startObject(3);
    Student.addId(builder, id);
    Student.addName(builder, name);
    Student.addAge(builder, age);
    return Student.endStudent(builder);
  }

  public static void startStudent(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addAge(FlatBufferBuilder builder, short age) { builder.addShort(1, age, 0); }
  public static void addId(FlatBufferBuilder builder, int id) { builder.addInt(2, id, 0); }
  public static int endStudent(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishStudentBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
};

