package java3;

/*
 * 类的成员之四：代码块（或初始化块）
 * 
 * 1. 代码块的作用：用来初始化类、对象
 * 2. 代码块如果有修饰的话，只能使用static。
 * 3. 分类：静态代码块 vs 非静态代码块
 * 
 * 4.静态代码块
 * 		>内部可以有输出语句
 * 		>随着类的加载而加载并且执行,而且只执行一次
 * 		>作用：初始化类的信息
 * 		>如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * 		>静态代码块的执行要优于非静态代码块的执行
 *		>静态代码块只能调用静态的属性、静态的方法，不能调用非静态的结构
 * 
 * 5.非静态代码块
 * 		>内部可以有输出语句
 * 		>随着对象的创建而执行
 * 		>每创建一个对象，就执行一次非静态代码块
 * 		>作用：可以在创建对象时，对对象的属性等进行初始化
 * 		>如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 * 		>非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法
 * 
 * 
 * 对属性可以赋值的位置：
 * ①默认初始化
 * ②显式初始化
 * ③构造器中初始化
 * ④有了对象以后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * ⑤在代码块中赋值
 * 
 * 
 * 非静态的方法可以调用静态的属性及方法，反之不行
 */
public class BlockTest {
	public static void main(String[] args) {
		// String desc = Person.desc;
		// System.out.println(desc);

		Person.info();

		Person p = new Person();
		Person p1 = new Person();
		System.out.println(p.age);
		System.out.println(p1.age);

		Person.info();

		String desc = Person.desc;
		System.out.println(desc);

	}
}

class Person {

	// 属性
	String name;
	int age;
	static String desc = "我是一个人";

	// 构造器
	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// static代码块
	static {
		System.out.println("static block-1");
		desc = "我是一个爱学习的人";
	}

	static {
		System.out.println("static block-2");
	}

	// 非static代码块
	{
		System.out.println("非static block -1");
		age = 18;
	}

	{
		System.out.println("非static block -2");
		age = 19;
	}

	// 方法
	public void eat() {
		System.out.println("吃饭");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public static void info() {
		System.out.println("我是一个静态方法");
	}

}
