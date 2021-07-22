package Object;

public class OrderTest {
	public static void main(String[] args) {
		Order order = new Order();

		order.orderDefault = 1;
		order.orderPublic = 2;
		// 报错：属性不可见
		// order.orderPrivate = 3; // The field Order.orderPrivate is not
		// visible
	}
}
