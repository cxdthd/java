package exer2;

public class Boy {

	private String name;
	private int age;

	public Boy(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String i) {
		name = i;
	}

	public String getName() {
		return name;
	}

	public void setAge(int i) {
		age = i;
	}

	public int getAge() {
		return age;
	}

	public void marry(Girl girl) {
		System.out.println("我想娶" + girl.getName());
	}

	public void shout() {
		if (age > 22) {
			System.out.println("你已到达合法年龄，可以去登记了！");
		} else {
			System.out.println("年龄不够~~");
		}
	}
}
