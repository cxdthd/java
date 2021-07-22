package java3;

import java2.Order;

public class orderTest {
	public static void main(String[] args) {
		// 在同一个工程只能调用public的属性、方法
		Order o = new Order();
		o.orderPublic = 1;
		o.methodPublic();

		// 不同包下的普通类（非子类）要使用Order类，不可以调用声明为private、缺省、protected权限的属性、方法
		// o.orderPrivate = 2;
		// o.orderDefault = 3;
		// o.orderProtected = 4;
		//
		// o.methodPrivate();
		// o.methodDefault();
		// o.methodProtected();
	}

	// 在形参列表创建一个该类类型的数据也可以用该类型的值调用属性、方法
	public void show(Order o) {
		o.orderPublic = 1;
		o.methodPublic();

		// 不同包下的普通类（非子类）要使用Order类，不可以调用声明为private、缺省、protected权限的属性、方法
		// o.orderPrivate = 2;
		// o.orderDefault = 3;
		// o.orderProtected = 4;
		//
		// o.methodPrivate();
		// o.methodDefault();
		// o.methodProtected();
	}

	// 不是子类必须实例化对象才可以调用
	// public void method(){
	// orderPublic = 1;
	// }
}
