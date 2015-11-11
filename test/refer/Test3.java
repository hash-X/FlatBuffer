package test.refer;

import com.google.flatbuffers.FlatBufferBuilder;
import src.refer.IntelClassInfo;
import src.refer.IntelStudent;

/**
 * Order is very important in the Serialization process.
 *
 * This line of code :  int stu = IntelStudent.createIntelStudent(fbb, 101437);
 * can not below this line of code :  IntelClassInfo.startIntelClassInfo(fbb);
 * for the performance issue from google employee.
 */
public class Test3 {
	public static void main(String[] args) {
		FlatBufferBuilder fbb = new FlatBufferBuilder();
		int stu = IntelStudent.createIntelStudent(fbb, 101437);
		IntelClassInfo.startIntelClassInfo(fbb);
		IntelClassInfo.addStu(fbb, stu);
		IntelClassInfo.addNumTeacher(fbb, (short)5);
		int env = IntelClassInfo.endIntelClassInfo(fbb);
		IntelClassInfo.finishIntelClassInfoBuffer(fbb, env);

		IntelClassInfo info =
				IntelClassInfo.getRootAsIntelClassInfo(fbb.dataBuffer());
		int id = info.stu().id();
	}
}
