// automatically generated, do not modify

package src.reposchema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class User extends Table {
  public static User getRootAsUser(ByteBuffer _bb) { return getRootAsUser(_bb, new User()); }
  public static User getRootAsUser(ByteBuffer _bb, User obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public User __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String type() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer typeAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }

  public static int createUser(FlatBufferBuilder builder,
      int type) {
    builder.startObject(1);
    User.addType(builder, type);
    return User.endUser(builder);
  }

  public static void startUser(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addType(FlatBufferBuilder builder, int typeOffset) { builder.addOffset(0, typeOffset, 0); }
  public static int endUser(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

