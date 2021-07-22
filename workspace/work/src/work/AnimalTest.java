package work;


public class AnimalTest{
	public static void main(String[] args) {
		//多态性
		Animal dog = new Dog("旺财",4);
		dog.eat();
		Animal cat = new Cat("汤姆",3);
		cat.eat();
	}
}

class Animal {
	//封装性
	private String name;
	private int age;
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Animal() {
		super();
	}
	
	public void eat(){
		System.out.println("动物吃食物");
	}
}

//继承性
class Cat extends Animal{
	public Cat() {
		super();
	}
	public Cat(String name, int age) {
		super(name, age);
	}
	public void eat(){
		System.out.println("猫吃鱼");
	}
}
class Dog extends Animal{
	public Dog() {
		super();
	}
	public Dog(String name, int age) {
		super(name, age);
	}
	public void eat(){
		System.out.println("狗吃骨头");
	}
}
