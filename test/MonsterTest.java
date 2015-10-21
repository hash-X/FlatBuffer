package test;

import com.google.flatbuffers.FlatBufferBuilder;
import src.Monster;

/**
 * Created by minglei on 15-10-20.
 */
public class MonsterTest {
  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    Monster.startMonster(fbb);
    Monster.addHp(fbb, (short)90);
    Monster.addInventory(fbb,
        Monster.createInventoryVector(fbb, new byte[]{1, 2, 3}));
    int end = Monster.endMonster(fbb);
    Monster.finishMonsterBuffer(fbb, end);
    Monster monster = Monster.getRootAsMonster(fbb.dataBuffer());
    short hp = monster.hp();
    System.out.println(hp);
  }
}
