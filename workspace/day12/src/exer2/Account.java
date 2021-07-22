package exer2;

public class Account {
	private int id; // 账户
	private double balance; // 余额
	private double annallnterestRate; // 年利率
	
//	public Account(){
//		
//	}

	public Account(int id, double balance, double annuallnterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annallnterestRate = annuallnterestRate;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public double getAnnuallnterestRate() {
		return annallnterestRate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAnnuallnterestRate(double annuallnterestRate) {
		this.annallnterestRate = annuallnterestRate;
	}

	// 返回月利率
	public double getMonthlylnterest() {
		return annallnterestRate / 12;
	}

	// 取钱
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("取钱成功，你这次共取了" + amount + "，余额还有" + balance);
			return;
		}
		System.out.println("余额不足，取钱失败！！！");
	}

	// 存钱
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("存钱成功，你这次共存了" + amount + "，余额共有" + balance);
			return;
		}
	}
}
