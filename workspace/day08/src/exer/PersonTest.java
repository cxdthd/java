package exer;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "张三";
		p1.age = 18;
		p1.sex = 1;

		p1.study();

		p1.showAge();

		int newAge = p1.addAge(2);
		System.out.println("张三的新年龄为：" + newAge);

		System.out.println(p1.age); // 20

		System.out.println("*****************************************");
		Person p2 = new Person();
		p2.showAge(); // 0
		p2.addAge(10);
		p2.showAge();// 10
		p1.showAge();// 20

	}
}
