package java1;

public class Student extends Person {
	String major;

	public Student() {
	}

	public Student(String major) {
		this.major = major;
	}

	public void study() {
		System.out.println("学习，专业是：" + major);
	}

	// 当父类为private时，不构成重写
	public void show() {
		System.out.println("我是一个学生！");
	}

	// 对父类中的eat()方法进行重写
	public void eat() { // overrides java1.Person.eat
		System.out.println("学生应该多吃有营养的食物！");
	}

	public String info() {
		return null;
	}
	
	// public int info1(){
	// return 0;
	// }

	// public int shiyan1(){
	// return 0;
	// }
}
