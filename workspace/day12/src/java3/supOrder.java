package java3;

import java2.Order;
import java2.OrderTest;

//在主函数main中，必须进行实例化对象才可以调用它的属性和方法
public class supOrder extends Order {
	public static void main(String[] args) {
		Order o1 = new Order();

		// o1.orderPrivate = 1;
		// o1.orderDefault = 2;
		// o1.orderProtected = 3;
		o1.orderPublic = 4;

	}

	// 在普通的方法中，如果是子类，那么不需要实例化对象就可以直接调用该类的方法和属性
	public void method() {
		orderProtected = 3;
		orderPublic = 4;

		methodProtected();
		methodPublic();

		// 在不同包的子类中，不能调用Order类中声明为private和缺省权限的属性、方法
		// orderPrivate = 1;
//		 orderDefault = 2;
		// methodPrivate();
		// methodDefault();
	}

	// 没有继承类想调用它的属性或方法时，要进行import导包操作，再实例化对象才可以调用
	public void methodTest() {
		OrderTest oe = new OrderTest();
		oe.i = 1;
	}

}
