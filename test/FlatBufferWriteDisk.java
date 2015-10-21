package test;

import com.google.flatbuffers.FlatBufferBuilder;
import src.Monster;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Created by mingleiz on 10/14/2015.
 */
public class FlatBufferWriteDisk {
  public static void main(String[] args) throws IOException{
    FlatBufferBuilder fbb = new FlatBufferBuilder(200);
    ByteBuffer byteBuffer = null;
    Monster.startMonster(fbb);
    Monster.addHp(fbb, (short) 80);
    Monster.addMana(fbb, (short) 100);
    int end = Monster.endMonster(fbb);
    Monster.finishMonsterBuffer(fbb, end);
    byteBuffer = fbb.dataBuffer();

    int len = byteBuffer.capacity() - byteBuffer.position();
//    byte[] bytes = new byte[len];
//    byteBuffer.get(bytes);
    // https://github.com/google/flatbuffers/issues/294
    byte[] bytes = fbb.sizedByteArray(); // Use FlatBufferBuilder.sizedByteArray() to get the bytes, much simpler.

    FileOutputStream fos = new FileOutputStream("C:\\Users\\mingleiz\\flatbuffer.txt");
    DataOutputStream dataOutputStream=new DataOutputStream(fos);
    dataOutputStream.writeInt(bytes.length);
    dataOutputStream.write(bytes);
    dataOutputStream.close();

    FileInputStream fis = new FileInputStream(new File("C:\\Users\\mingleiz\\flatbuffer.txt"));
    DataInputStream dataInputStream = new DataInputStream(fis);

    int length = dataInputStream.readInt();
    byte[] newBytes = new byte[length];
    dataInputStream.read(newBytes);
    dataInputStream.close();
    ByteBuffer newByteBuffer = ByteBuffer.wrap(newBytes);
    Monster monster = Monster.getRootAsMonster(newByteBuffer);
    System.out.println(monster.mana());
  }
}
