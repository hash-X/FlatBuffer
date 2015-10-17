// automatically generated, do not modify

package src.genstudent;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class MaleStudent extends Table {
  public static MaleStudent getRootAsMaleStudent(ByteBuffer _bb) { return getRootAsMaleStudent(_bb, new MaleStudent()); }
  public static MaleStudent getRootAsMaleStudent(ByteBuffer _bb, MaleStudent obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public MaleStudent __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public short numspecialLove() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 0; }

  public static int createMaleStudent(FlatBufferBuilder builder,
      short numspecialLove) {
    builder.startObject(1);
    MaleStudent.addNumspecialLove(builder, numspecialLove);
    return MaleStudent.endMaleStudent(builder);
  }

  public static void startMaleStudent(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addNumspecialLove(FlatBufferBuilder builder, short numspecialLove) { builder.addShort(0, numspecialLove, 0); }
  public static int endMaleStudent(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

