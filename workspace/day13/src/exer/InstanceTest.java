package exer;

/*
 * 建立InstanceTest 类，在类中定义方法method(Person e);
		在method中:
		(1)根据e的类型调用相应类的getInfo()方法。
		(2)根据e的类型执行：
		如果e为Person类的对象，输出：
		“a person”;
		如果e为Student类的对象，输出：
		“a student”
		“a person ” 
		如果e为Graduate类的对象，输出： 
		“a graduated student”
		“a student”
		“a person” 

 * 
 * 
 * 
 */
public class InstanceTest {
	public static void main(String[] args) {
		InstanceTest test = new InstanceTest();
		// 匿名对象
		test.method(new Student());

	}

	public void method(Person e) {

		// 多态性：虚拟方法调用
		String info = e.getInfo();
		System.out.println(info);

		if (e instanceof Graduate) {
			System.out.println("a graduated student\na student\na person");
			return;
		}
		if (e instanceof Student) {
			System.out.println("a student\na person");
			return;
		}
		if (e instanceof Person) {
			System.out.println("a Person");
			return;
		}
	}
}

class Person {
	protected String name = "person";
	protected int age = 50;

	public String getInfo() {
		return "Name: " + name + "\n" + "age: " + age;
	}
}

class Student extends Person {
	protected String school = "pku";

	public String getInfo() {
		return "Name: " + name + "\nage: " + age + "\nschool: " + school;
	}
}

class Graduate extends Student {
	public String major = "IT";

	public String getInfo() {
		return "Name: " + name + "\nage: " + age + "\nschool: " + school + "\nmajor:" + major;
	}
}
