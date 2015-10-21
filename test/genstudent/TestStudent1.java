package test.genstudent;

import com.google.flatbuffers.FlatBufferBuilder;
import src.genstudent.ClassInfo;
import src.genstudent.Student;


/**
 * Created by minglei on 15-10-20.
 * https://github.com/google/flatbuffers/issues/301
 *
 */
public class TestStudent1 {

  static void methodOne(FlatBufferBuilder fbb) {
    int[] data =
        {
            Student.createStudent(fbb, fbb.createString("zhangsan"),
                (short)19,
                1)};
    int stu = 0;

    stu = ClassInfo.createStuVector(fbb, data);
    int classInfoOffset = ClassInfo.createClassInfo(fbb, (short)3, stu);
    ClassInfo.finishClassInfoBuffer(fbb, classInfoOffset);

    ClassInfo classInfo = ClassInfo.getRootAsClassInfo(fbb.dataBuffer());
    String name = classInfo.stu(0).name();
    System.out.println(name);
  }
  // It's a wrong method before, but now it is collect.
  static void methodTwo(FlatBufferBuilder fbb) {
    // wrong way
    // Comments from gwvo : field stu needs to be a [Student], but you serialize it as a Student.
    // int stuOffset = Student.createStudent(fbb,fbb.createString("lisi"), (short)19, 1);

    // right way
    int stu1 = Student.createStudent(fbb, fbb.createString("zhangsan"), (short)19, 1);
    int stu2 = Student.createStudent(fbb, fbb.createString("lisi"), (short)29, 2);

    int[] data =
        {
            32,
                  68
        };

    int stuOffset = ClassInfo.createStuVector(fbb, data);
    ClassInfo.startClassInfo(fbb);
    ClassInfo.addStu(fbb, stuOffset);
    ClassInfo.addNumTeacher(fbb, (short) 3);
    int env = ClassInfo.endClassInfo(fbb);
    ClassInfo.finishClassInfoBuffer(fbb, env);
    ClassInfo classInfo = ClassInfo.getRootAsClassInfo(fbb.dataBuffer());
    short num = classInfo.numTeacher();
    System.out.println(num);
    System.out.print(classInfo.stu(1).name());
  }

  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
//    methodOne(fbb);
    methodTwo(fbb);
  }
}
