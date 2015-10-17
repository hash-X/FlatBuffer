// automatically generated, do not modify

package src.genstudent;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FemaleStudent extends Table {
  public static FemaleStudent getRootAsFemaleStudent(ByteBuffer _bb) { return getRootAsFemaleStudent(_bb, new FemaleStudent()); }
  public static FemaleStudent getRootAsFemaleStudent(ByteBuffer _bb, FemaleStudent obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public FemaleStudent __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public short numcosmetics() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 0; }

  public static int createFemaleStudent(FlatBufferBuilder builder,
      short numcosmetics) {
    builder.startObject(1);
    FemaleStudent.addNumcosmetics(builder, numcosmetics);
    return FemaleStudent.endFemaleStudent(builder);
  }

  public static void startFemaleStudent(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addNumcosmetics(FlatBufferBuilder builder, short numcosmetics) { builder.addShort(0, numcosmetics, 0); }
  public static int endFemaleStudent(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

