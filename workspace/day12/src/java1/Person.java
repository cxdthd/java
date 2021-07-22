package java1;

public class Person {
	String name;
	int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void eat() {
		System.out.println("吃饭！");
		show();
	}

	private void show() {
		System.out.println("我是一个人！");
	}

	public void walk(int distance) {
		System.out.println("走路走了" + distance + "公里！");
	}

	public Object info() {
		return null;
	}
	
	public double info1(){
		return 0.0;
	}

	public void shiyan1() {
		System.out.println("shiyan1");
	}

}
