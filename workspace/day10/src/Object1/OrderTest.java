package Object1;

//导包
import Object.Order;

public class OrderTest {
	public static void main(String[] args) {
		Order order = new Order();

		// order.orderDefault = 1; //The field Order.orderDefault is not visible
		order.orderPublic = 2;
		// 报错：属性不可见
		// order.orderPrivate = 3; // The field Order.orderPrivate is not
		// visible
	}
}
