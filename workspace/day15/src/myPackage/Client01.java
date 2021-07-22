package myPackage;
/*
 * 无工厂模式
 */
interface Car1 {
	void run();
}

class Audi1 implements Car1 {
	@Override
	public void run() {
		System.out.println("奥迪1在跑！！！");
	}
}

class BYD1 implements Car1 {
	@Override
	public void run() {
		System.out.println("比亚迪1在跑！！！");
	}
}

public class Client01 {
	public static void main(String[] args) {
		//多态性
		Car1 a = new Audi1();
		Car1 b = new BYD1();
		a.run();
		b.run();
	}
}
