package test;

import com.google.flatbuffers.FlatBufferBuilder;
import src.Monster;
import src.Vec3;

import java.nio.ByteBuffer;

/**
 * Created by mingleiz on 9/13/2015.
 */
public class FlatBufferTest {

  private static final int BUFFER_SIZE= 1000;
  static FlatBufferBuilder fbb = null;
  static ByteBuffer byteBuffer = null;
  static short hp = 0;

  /**
   * construct a flat binary buffer. The generated functions allow you to add objects to this
   * buffer recursively. So simple.
   */
  static void BufferConstruction() {
    fbb = new FlatBufferBuilder(BUFFER_SIZE);
    int str = fbb.createString("MyMonster_I");
    Monster.startMonster(fbb);
    Monster.addPos(fbb, Vec3.createVec3(fbb, 1.0f, 2.0f, 3.0f));
    Monster.addHp(fbb, (short) 80);
    Monster.addName(fbb, str);
    int mon = Monster.endMonster(fbb);
    Monster.finishMonsterBuffer(fbb, mon);
  }

  /**
   * Store or send your buffer somewhere.
   * All data in this byeBuffer zone. You can get all the data from byteBuffer.
   */
  static void StoreOrTransmittedBuffer() {
    byteBuffer = fbb.dataBuffer();
  }

  static void GetDataFromBuffer(ByteBuffer buffer) {
    buffer = byteBuffer;
    String str = new String(buffer.array(), buffer.position(), fbb.offset());
    System.out.println("Str = " + str);
  }

  public static void main(String[] args) {
    byte[] bytes = new byte[BUFFER_SIZE];
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    Monster monster = Monster.getRootAsMonster(bb);
    // Access values
    hp = monster.hp();

    for (int i = 0; i < monster.inventoryLength(); i++)
      monster.inventory(i); // do something here

    BufferConstruction();
    StoreOrTransmittedBuffer();
    GetDataFromBuffer(bb);
  }
}
