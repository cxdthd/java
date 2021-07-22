package exer4;

public class BankTest {
	public static void main(String[] args) {
		Bank bank1 = new Bank();
		bank1.addCustomer("Aaa", "111");

		// 连续操作
		bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new Account(2000));
		bank1.getCustomer(0).getAccount().deposit(200);
		bank1.getCustomer(0).getAccount().withdraw(2100);
		double d = bank1.getCustomer(0).getAccount().getBalance();
		System.out.println(
				"客户" + bank1.getCustomer(0).getFirstName() + bank1.getCustomer(0).getLastName() + " 的余额为：" + d);

		System.out.println("*****************************************");

		bank1.addCustomer("Bbb", "222");
		int i = bank1.getNumOfCustomer();
		System.out.println("bank1银行有客户人数：" + i);

		System.out.println("*****************************************");
		bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new Account(3000));
		System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer() - 1).getFirstName()
				+ bank1.getCustomer(0).getLastName() + " 的余额为："
				+ bank1.getCustomer(bank1.getNumOfCustomer() - 1).getAccount().getBalance());

		// bank1.addCustomer("C", "3");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("D", "4");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(5000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("E", "5");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(6000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("F", "6");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("G", "7");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("H", "8");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("I", "9");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("J", "10");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("K", "11");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());
		//
		// bank1.addCustomer("L", "12");
		// bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new
		// Account(4000));
		// System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer()
		// - 1).getFirstName()
		// + bank1.getCustomer(0).getLastName() + " 的余额为："
		// + bank1.getCustomer(bank1.getNumOfCustomer() -
		// 1).getAccount().getBalance());

		for (int x = 99; x < 109; x++) {
			bank1.addCustomer("", "");
			bank1.getCustomer(bank1.getNumOfCustomer() - 1).setAccount(new Account(x));
			System.out.println("客户" + bank1.getCustomer(bank1.getNumOfCustomer() - 1).getFirstName()
					+ bank1.getCustomer(0).getLastName() + " 的余额为："
					+ bank1.getCustomer(bank1.getNumOfCustomer() - 1).getAccount().getBalance());

		}

		int q = bank1.getNumOfCustomer();
		System.out.println("bank1银行有客户人数：" + q);

	}
}
