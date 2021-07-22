package java2;

public class OrderTest {
	public int i;
	public static void main(String[] args) {
		Order o = new Order();

		o.orderDefault = 2;
		o.orderProtected = 3;
		o.orderPublic = 4;

		o.methodDefault();
		o.methodProtected();
		o.methodPublic();
		
		//同一个包中的其他类，不可以调用Order类中私有的属性、方法
		// o.orderPrivate = 1;
		// o.methodPrivate();
	}
}
