package java0;

public class Man extends Person {
	boolean isSmoking;
	
	int id = 1002;

	public void earnMoney() {
		System.out.println("男人：挣钱");
	}

	@Override
	public void eat() {
		System.out.println("男人：吃饭");
	}

	@Override
	public void walk() {
		System.out.println("男人：走路");
	}
}
