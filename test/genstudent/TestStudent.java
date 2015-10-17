package test.genstudent;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genstudent.ClassInfo;
import src.genstudent.MaleStudent;
import src.genstudent.Student;

import java.nio.ByteBuffer;

/**
 * Created by minglei on 15-10-17.
 */
public class TestStudent {
  static void print(ClassInfo classInfo) {
    int numT = classInfo.numTeacher();
//    int stuLength = classInfo.stuLength();
    Student student = classInfo.stu(0);
    int age = student.age();
    String name = student.name();
    System.out.println("numT = " + numT + '\n' +
//          "stuLength = " + stuLength + '\n' +
          "age = " + age + '\n' +
          "name = " + name);
  }
  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;
    ClassInfo.startClassInfo(fbb);
    ClassInfo.addNumTeacher(fbb, (short)2);
    int[] stuData = new int[2];
    stuData[0] = 1;
    stuData[1] = 2;
    ClassInfo.createStuVector(fbb, stuData);
    Student.addName(fbb, fbb.createString("zhangsan"));
    Student.addAge(fbb, (short)23);
    MaleStudent.addNumspecialLove(fbb, (short)4);
    int end = ClassInfo.endClassInfo(fbb);
    ClassInfo.finishClassInfoBuffer(fbb, end);
    byteBuffer = fbb.dataBuffer();
    ClassInfo classInfo = ClassInfo.getRootAsClassInfo(byteBuffer);
    print(classInfo);
  }
}
