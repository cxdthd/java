public class MainClass{

	public static void main(String args[])
	{
		Teacher teacherOne = new Teacher();
		teacherOne.a=12;
		teacherOne.b=236;
		double add = teacherOne.add();
		System.out.println("12��236�ĺ�Ϊ"+add);

		Teacher teacherTwo = new Teacher();
		teacherTwo.a=236;
		teacherTwo.b=120;
		double sub = teacherTwo.sub();
		System.out.println("236��120�Ĳ�Ϊ"+sub);



		Student student = new Student();
		student.speak();
	}
}