package exer4;

public class Account {

	private double balance;

	public Account(double init_balance) {
		balance = init_balance;
	}

	public double getBalance() {
		return balance;
	}

	// 存钱操作
	public void deposit(double amt) { // 存款
		if (amt > 0) {
			balance += amt;
			System.out.println("成功存入：" + amt + ",现有金额为：" + balance);
			return;
		}
		System.out.println("请输入正确的金额！！！");
	}

	// 取钱操作
	public void withdraw(double amt) { // 取款
		if (amt > 0 && amt <= balance) {
			balance -= amt;
			System.out.println("成功取出：" + amt + ",现有金额为：" + balance);
			return;
		}
		System.out.println("你输入的金额不正确或余额不足！！！");
	}
}
