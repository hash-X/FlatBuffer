package test.proto_student;

import src.proto_student.Student;

import java.util.Iterator;
import java.util.List;

/**
 * Created by minglei on 15-10-18.
 */
public class Test {
  public static void main(String[] args) {
    // Serialization
    Student.Section.Builder b0 = Student.Section.newBuilder().setName("Section0")
        .setLength(1);
    Student.Section.Builder b1 = Student.Section.newBuilder().setName("Section1");
    Student.StudentSummary.Builder b = Student.StudentSummary.newBuilder()
        .setOndiskVersion(1).setCodec("RS").addSections(b0).addSections(b1);
    // Deserialization
    Student.StudentSummary summary = b.build();
    String codec = summary.getCodec();
    int diskVersion = summary.getOndiskVersion();
    System.out.println("Codec = " + codec + "\n" + "DiskVersion = " + diskVersion);
    List<Student.Section> sections = summary.getSectionsList();
    Iterator<Student.Section> list = sections.iterator();
    while (list.hasNext()) {
      Student.Section section = list.next();
      System.out.println(" @@@ " + section.getName());
    }
  }
}












