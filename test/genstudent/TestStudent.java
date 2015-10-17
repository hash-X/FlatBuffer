package test.genstudent;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genstudent.ClassInfo;
import src.genstudent.Student;

import java.nio.ByteBuffer;

/**
 * Created by minglei on 15-10-17.
 */
public class TestStudent {

  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;

//    Do not have this code , or have an error of "FlatBuffers: object serialization must not be nested"
//    ClassInfo.startClassInfo(fbb);
    short numTeacher = 8;
    // student zhangsan info
    int name1 = fbb.createString("Tom");
    short age1 = 15;
    int id1 = 1;
    int firstStu = Student.createStudent(fbb, name1, age1, id1);

    // student lisi info
    int name2 = fbb.createString("Atom");
    short age2 = 16;
    int id2 = 2;
    int secStu = Student.createStudent(fbb, name2, age2, id2);

    int[] data = new int[]{ firstStu,secStu };
    int stu = ClassInfo.createStuVector(fbb, data);
    int end = ClassInfo.createClassInfo(fbb, numTeacher, stu);
    ClassInfo.finishClassInfoBuffer(fbb, end);
    byteBuffer = fbb.dataBuffer();
    ClassInfo classInfo = ClassInfo.getRootAsClassInfo(byteBuffer);

    short numT = classInfo.numTeacher();
    int stuL = classInfo.stuLength();
    Student s1 = classInfo.stu(0);
    String s1Name = s1.name();
    short s1Age = s1.age();

    Student s2 = classInfo.stu(1);
    String s2Name = s2.name();
    short s2Age = s2.age();


  }
}
