package java2;

public class SingletionTest2 {
	public static void main(String[] args) {
		Order o1 = Order.getInstance();
		Order o2 = Order.getInstance();

		System.out.println(o1 == o2);// true
	}
}

class Order {

	// 1.私有化类的构造器
	private Order() {

	}

	// 2.声明当前对象，没有初始化
	// 4。此对象也必须声明为static的
	private  static Order instance = null;

	// 3.声明public、static的返回当前类对象的方法
	public synchronized static Order getInstance() {	//synchronized为线程安全的

		if (instance == null) {

			// 这个地方会发生堵塞，多线程不安全，可能会出现多个线程同时进入并且都new了一个对象出去
			instance = new Order();
		}
		return instance;
	}

}
