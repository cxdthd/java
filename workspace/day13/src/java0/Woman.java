package java0;

public class Woman extends Person {
	boolean isBeauty;

	public void goshopping() {
		System.out.println("女人：购物");
	}

	@Override
	public void eat() {
		System.out.println("女人：吃饭");
	}

	@Override
	public void walk() {
		System.out.println("女人：走路");
	}
}
