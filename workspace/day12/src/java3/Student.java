package java3;

public class Student extends Person {
	String major;
	int id = 2180575;// 学号

	// 不写时。构造器默认有一个super();
	public Student() {
		// super();
		System.out.println("学生无处不在！");
	}

	public Student(String major) {
		this();
		this.major = major;
	}

	public Student(String name, int age, String major) {
		// this.name = name;
		// this.age = age;
		super(name, age);
		this.major = major;
	}

	@Override
	public void eat() {
		System.out.println("学生：吃饭！");
	}

	@Override
	public void walk() {
		System.out.println("学生：走路！");
	}

	public void study() {
		this.walk();
		super.walk();
		System.out.println("学生：学习！");
	}

	public void show() {
		System.out.println("name = " + this.name + ",age = " + super.age);
		System.out.println("studentid = " + this.id);
		System.out.println("personid = " + super.id);
	}
}
