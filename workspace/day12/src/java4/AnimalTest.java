package java4;

import java.sql.Connection;

//多态性的使用举例一：
public class AnimalTest {
	public static void main(String[] args) {
		AnimalTest animalTest = new AnimalTest();

		// 方式一
		// Animal animal1 = new Animal();
		// Animal dog1 = new Dog();
		// Animal cat1 = new Cat();
		//
		// animalTest.funtion(animal1);
		// animalTest.funtion(dog1);
		// animalTest.funtion(cat1);

		// 方式二：匿名对象
		animalTest.funtion(new Animal());
		animalTest.funtion(new Dog());
		animalTest.funtion(new Cat());

	}

	public void funtion(Animal animal) {
		animal.eat();
		animal.shout();
	}
}

class Animal {

	public void eat() {
		System.out.println("动物：进食");
	}

	public void shout() {
		System.out.println("动物：叫");
	}
}

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("狗吃骨头");
	}

	@Override
	public void shout() {
		System.out.println("汪！汪！汪！");
	}
}

class Cat extends Animal {
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}

	@Override
	public void shout() {
		System.out.println("喵！喵！喵！");
	}
}

// 举例二：直接创建Object类来调用它的子类
class Order {
	public void method(Object obj) {

	}
}

// 举例三：在连接数据库时，先在方法的形参列表写Connection数据类型的变量，再根据数据库的不同调用子类的不同对象
class Driver {

	public void doDate(Connection conn) {// conn = new MySQlConnection()
		// 规范的步骤去操作数据
		// conn.method1();
		// conn.method2();
		// conn.method3();

	}
}
