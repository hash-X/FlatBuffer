// automatically generated, do not modify

package src.reposchema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Repo extends Table {
  public static Repo getRootAsRepo(ByteBuffer _bb) { return getRootAsRepo(_bb, new Repo()); }
  public static Repo getRootAsRepo(ByteBuffer _bb, Repo obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Repo __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public long id() { int o = __offset(4); return o != 0 ? bb.getLong(o + bb_pos) : 0; }
  public String name() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public User owner() { return owner(new User()); }
  public User owner(User obj) { int o = __offset(8); return o != 0 ? obj.__init(__indirect(o + bb_pos), bb) : null; }

  public static int createRepo(FlatBufferBuilder builder,
      long id,
      int name,
      int owner) {
    builder.startObject(3);
    Repo.addId(builder, id);
    Repo.addOwner(builder, owner);
    Repo.addName(builder, name);
    return Repo.endRepo(builder);
  }

  public static void startRepo(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addId(FlatBufferBuilder builder, long id) { builder.addLong(0, id, 0); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(1, nameOffset, 0); }
  public static void addOwner(FlatBufferBuilder builder, int ownerOffset) { builder.addOffset(2, ownerOffset, 0); }
  public static int endRepo(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

