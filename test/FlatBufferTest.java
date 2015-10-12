package test;

import com.google.flatbuffers.FlatBufferBuilder;
import src.Monster;
import src.Vec3;

import java.nio.ByteBuffer;

/**
 * Created by mingleiz on 9/13/2015.
 */
public class FlatBufferTest {

  private static final int BUFFER_SIZE = 1000;
  static FlatBufferBuilder fbb = null;
  static ByteBuffer byteBuffer = null;
  static byte GREEN = 1;

  /**
   * Construct data and Serialization.
   *
   */
  static void BufferConstruction() {
    fbb = new FlatBufferBuilder(BUFFER_SIZE);
    int str = fbb.createString("I am a Monster\n");
    Monster.startMonster(fbb);

    Monster.addPos(fbb, Vec3.createVec3(fbb, 12.0f, 2.0f, 3.0f));
    Monster.addHp(fbb, (short)180);
    Monster.addName(fbb, str);
    Monster.addColor(fbb, GREEN);
    Monster.addMana(fbb, (short)330);

    int mon = Monster.endMonster(fbb);
    Monster.finishMonsterBuffer(fbb, mon);
    byteBuffer = fbb.dataBuffer();
  }

  /**
   * Deserialization
   *
   * @param buffer
   */
  static void GetDataFromBuffer(ByteBuffer buffer) {
    buffer = byteBuffer;
    Monster monster = Monster.getRootAsMonster(buffer);
    System.out.println("Monster hp = " + monster.hp() +
        "\nMonster name = " + monster.name() + "\nMonster new position = " + "x : " + monster.pos().x()
        + " y : " + monster.pos().y() + " z : " + monster.pos().z() + "\n" + " Monster color = " + monster.color()
    + "\n" + " Monster Mana = " + monster.mana());
}

  public static void main(String[] args) {
    byte[] bytes = new byte[BUFFER_SIZE];
    ByteBuffer bb = ByteBuffer.wrap(bytes);

    BufferConstruction();
    GetDataFromBuffer(bb);
  }
}
