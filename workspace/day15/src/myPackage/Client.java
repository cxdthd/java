package myPackage;

/*
 * 工场方法模式
 */
interface Car {
	void run();
}

class Audi implements Car {
	@Override
	public void run() {
		System.out.println("奥迪在跑！！！");
	}
}

class BYD implements Car {
	@Override
	public void run() {
		System.out.println("比亚迪在跑！！！");
	}
}

// 工厂接口
interface Factory {
	Car getCar();
}

// 两个工厂类
class AudiFactory implements Factory {
	@Override
	public Audi getCar() {

		return new Audi();
	}
}

class BydFactory implements Factory {
	public BYD getCar() {
		return new BYD();
	}
}

public class Client {
	public static void main(String[] args) {
		Car a = new AudiFactory().getCar();
		a.run();
	}
}
