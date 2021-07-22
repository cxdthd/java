package myPackage;
/*
 * 普通工厂模式
 */
interface Car2 {
	void run();
}

class Audi2 implements Car2 {
	@Override
	public void run() {
		System.out.println("奥迪2在跑！！！");
	}
}

class BYD2 implements Car2 {
	@Override
	public void run() {
		System.out.println("比亚迪2在跑！！！");
	}
}

class CarFactory{
	
	//方式一
	public static Car2 getCar(String type){
		if("奥迪".equals(type)){
			return new Audi2();
		}else if("比亚迪".equals(type)){
			return new BYD2();
		}else{
			return null;
		}
	}
	
	//方式二
//	public static Car getAudi(){
//		return new Audi();
//	}
//	
//	public static Car getByd(){
//		return new BYD();
//	}
	
}

public class Client02 {
	public static void main(String[] args) {
		Car2 a = CarFactory.getCar("奥迪");
		a.run();
	}
}
