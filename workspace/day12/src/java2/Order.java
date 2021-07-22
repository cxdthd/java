package java2;

/*
 * 体会4种不同的权限修饰
 */
public class Order {
	private int orderPrivate;
	int orderDefault;
	protected int orderProtected;
	public int orderPublic;

	private void methodPrivate() {
		orderPrivate = 1;
		orderDefault = 2;
		orderProtected = 3;
		orderPublic = 4;
		System.out.println("methodPrivate");
	}

	void methodDefault() {
		System.out.println("methodDefault");
	}

	protected void methodProtected() {
		System.out.println("methodProtected");
	}

	public void methodPublic() {
		System.out.println("methodPublic");
	}
}
