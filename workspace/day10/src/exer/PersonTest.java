package exer;

public class PersonTest {
	public static void main(String[] args) {
		Person b = new Person();
		// b.setAge(1222);
		int a = b.getAge();
		System.out.println("年龄为" + a);

		Person p = new Person("Tom", 21);
		System.out.println("name = " + p.getName() + ",age = " + p.getAge());
	}

}
