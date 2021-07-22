package myexer;

public class StudentTest {
	public static void main(String[] args) {
		Student stud = new Student("Tom", '男', 18, 123456, 66, 32, 45);

		String str = stud.toString();
		System.out.println(str);
		double aver = stud.aver();
		System.out.println("平均分：" + aver);
		int m = stud.max();
		System.out.println("最高分：" + m);
	}
}
