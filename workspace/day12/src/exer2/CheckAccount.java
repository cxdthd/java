package exer2;

/*
 * 创建Account类的一个子类CheckAccount代表可透支的账户，该账户中定义一个属性overdraft代表可透支限额。
 * 在CheckAccount类中重写withdraw方法，其算法如下：
		如果（取款金额<账户余额），
		可直接取款
		如果（取款金额>账户余额），
		计算需要透支的额度
		判断可透支额overdraft是否足够支付本次透支需要，如果可以
			将账户余额修改为0，冲减可透支金额
		如果不可以
			提示用户超过可透支额的限额

 * 
 * 
 */
public class CheckAccount extends Account {
	private double overdraft; // 可透支限额

	public CheckAccount(int id, double balance, double annuallnterestRate) {
		super(id, balance, annuallnterestRate);
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public void withdraw(double amount) {
		double balance2 = getBalance();
		if (amount <= getBalance()) { // 余额足够消费
			// 方式一
			// setBalance(getBalance() - amount);
			// System.out.println("取钱成功，你这次共取了" + amount + "，余额还有" + balance2);
			// return;

			// 方式二
			super.withdraw(amount);
			return;

		} else if (amount > getBalance()) { // 透支额度足够消费
			double sum = getBalance() + overdraft;
			if (sum >= amount) {
				overdraft = sum - amount;
				System.out.println("您本次取钱金额为：" + amount + ",还有可透支限额为： " + overdraft);
				amount = 0;
				return;
			}
		}
		System.out.println("对不起，你超出了你的限额：" + overdraft + "加余额：" + getBalance() + "，一共：" + (overdraft + balance2));

	}

}
