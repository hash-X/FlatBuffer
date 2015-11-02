package test.genstudent;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genstudent.Student;

import java.nio.ByteBuffer;

/**
 * Created by root on 15-10-27.
 */
public class TestTableStudent {

  static void method1() {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    ByteBuffer byteBuffer = null;
    int stu = Student.createStudent(fbb, fbb.createString("atom"), (short)13, 1);
    Student.finishStudentBuffer(fbb, stu);
    byteBuffer = fbb.dataBuffer();
    Student student = Student.getRootAsStudent(byteBuffer);
    short age = student.age();
    String str = student.name();
    System.out.println(str);
  }

  static void method2() {

  }

  public static void main(String[] args) {
    method1();
  }
}
