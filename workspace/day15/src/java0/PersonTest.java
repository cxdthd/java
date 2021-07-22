package java0;

/*
 * 抽象类的匿名子类
 */
public class PersonTest {

	public static void main(String[] args) {

		// 匿名对象
		method(new Student());

		Worker worker = new Worker();
		method1(worker);// 非匿名类非匿名对象

		method1(new Worker());// 非匿名的类匿名的对象

		System.out.println("*************************************");
		
		// 创建了一匿名子类的对象：p
		Person p = new Person() {// 这个Person不是原来的那个，是他的子类

			@Override
			public void eat() {
				System.out.println("Person子类吃饭");
			}

			@Override
			public void breath() {
				System.out.println("Person子类呼吸");
			}

		};
		
		method1(p);
		
		System.out.println("*************************************");
		
		//创建匿名子类匿名对象
		method1(new Person(){
			@Override
			public void eat() {
				System.out.println("Person匿名子类匿名对象吃饭");
			}

			@Override
			public void breath() {
				System.out.println("Person匿名子类匿名对象呼吸");
			}
		});

	}

	public static void method1(Person p) {
		p.eat();
		p.breath();
		p.walk();
	}

	public static void method(Student s) {

	}
}

class Worker extends Person {

	@Override
	public void eat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub

	}

}
