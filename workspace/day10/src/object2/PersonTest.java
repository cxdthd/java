package object2;

/*
 * this关键字的使用
 * 1.this可以用来修饰：属性、方法、构造器
 * 
 * 2.this修饰属性和方法：
 * 	 this理解为：当前对象 	当前正在创建的对象
 * 
 * 	在类的方法或构造器中，我们可以使用"this.属性"或"this.方法"的方式，调用当前对象属性或方法。
 * 	但是，通常情况下，我们都选择省略"this."。
 * 	特殊情况下，如果方法的形参和类的属性同名时，我们必须显式的使用"this.变量"的方式，表明此变量是属性，而非形参。
 * 
 * 3. this调用构造器
 * 		① 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
 * 		② 构造器中不能通过"this(形参列表)"方式调用自己
 * 		③ 如果一个类中有n个构造器，则最多有 n - 1 个构造器中使用了"this(形参列表)"
 * 		④ 规定："this(形参列表)"必须声明在当前构造器的首行
 * 		⑤ 构造器内部，最多只能声明一个"this(形参列表)"，用来调用其他的构造器
 */
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setAge(1);
		System.out.println(p1.getAge());

		p1.eat();

		System.out.println("*********************************************");

		Person p2 = new Person("Tom");
		System.out.println(p2.getName());
	}
}

class Person {
	private String name;
	private int age;

	public Person() {
		String info = "Person初始化时，需要注意的问题";
		System.out.println(info);
	}

	public Person(String name) {
		// 调用构造器,构造器的调用必须在首行
		this();
		this.name = name;
	}

	public Person(int age) {
		this.age = age;
	}

	public void setName(String name) {
		name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		// this. 代表当前对象.属性 或者 当前对象.方法
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void eat() {
		System.out.println("人吃饭");
		// 这里省略了this.
		study();
	}

	public void study() {
		System.out.println("人学习");
	}
}
