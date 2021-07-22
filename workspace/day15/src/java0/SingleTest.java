package java0;

public class SingleTest {
	public static void main(String[] args) {
		Order order1 = Order.order;
		Order order2 = Order.order;

//		Order.order = null;

		Order order3 = Order.order;
		System.out.println(order1);// java0.Order@15db9742
		System.out.println(order2);// java0.Order@15db9742
		System.out.println(order3);// null ---> java0.Order@15db9742

		System.out.println(order1 == order2);// true
	}
}

//也算单例：饿汉式
class Order {

	private Order() {

	}

	public static final Order order = new Order();

}
