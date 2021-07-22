package p2.ui;

import p2.bean.Customer;
import p2.service.CustomerList;
import p2.util.CMUtility;

/**
 * 
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author cxdthd Email:1752713908@qq.com
 * @version
 * @date 2020年11月13日上午8:50:15
 *
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer cu = new Customer("Tom", '男', 18, "18779260111", "123@126.c");
		customerList.addCustomer(cu);
	}

	/**
	 * 
	 * @Description 显示《客户信息管理软件》界面的方法
	 * @author cxdthd
	 * @date 2020年11月13日下午2:35:43
	 */
	public void enrerMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                   1 添 加 客 户");
			System.out.println("                   2 修 改 客 户");
			System.out.println("                   3 删 除 客 户");
			System.out.println("                   4 客 户 列 表");
			System.out.println("                   5 退       出\n");
			System.out.print("                   请选择(1-5)：");

			char menu = CMUtility.readMenuSelection();

			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				System.out.print("确认是否退出(Y/N):");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					// System.exit(0);
					isFlag = false;
				}
				// break;
			}
		}
	}

	/**
	 * 
	 * @Description 添加客户的操作
	 * @author cxdthd
	 * @date 2020年11月13日下午2:50:53
	 */
	public void addNewCustomer() {
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(4);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);

		// 将上述数据封装到对象中
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customerList.addCustomer(customer);
		if (isSuccess) {
			System.out.println("---------------------------添加成功---------------------------");
		} else {
			System.out.println(
					"----------------客户目录已达上限(" + customerList.getCustomer1().length + ")---------------------");
		}
	}

	/**
	 * 
	 * @Description 修改客户的操作
	 * @author cxdthd
	 * @date 2020年11月13日下午2:51:15
	 */
	public void modifyCustomer() {
		System.out.println("---------------------修改客户---------------------");
		Customer cust;
		int number;
		for (;;) {
			System.out.print("请选择待修改客户编号(-1退出)：");
			number = CMUtility.readInt();

			if (number == -1) {
				// 直接结束modifyCustomer()方法
				return;
			}
			// 这里把声明放在外面，出了循环一样可以调用
			// Customer cust = customerList.getCustomer(number - 1);
			cust = customerList.getCustomer(number - 1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");
			} else {// 找到了相应编号的客户
				// break跳出for(;;)循环
				break;
			}

		}
		// 修改客户信息
		System.out.print("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("性别(" + cust.getGender() + "):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.print("邮箱(" + cust.getEmail() + "):");
		String email = CMUtility.readString(30, cust.getEmail());

		// 直接在原数据上进行更改，不改变地址
		// cust.setAge(age);
		// cust.setEmail(email);
		// cust.setGender(gender);
		// cust.setName(name);
		// cust.setPhone(phone);
		// System.out.println("---------------------修改完成---------------------");

		// 新建一个对象地址替换了原来的那个地址
		Customer newCust = new Customer(name, gender, age, phone, email);
		boolean isRepalaced = customerList.replaceCustomer(number - 1, newCust);
		if (isRepalaced) {
			System.out.println("---------------------修改完成---------------------");
		} else {
			System.out.println("---------------------修改失败---------------------");
		}
	}

	/**
	 * 
	 * @Description 删除客户的操作
	 * @author cxdthd
	 * @date 2020年11月13日下午2:51:33
	 */
	public void deleteCustomer() {
		System.out.println("---------------------删除客户---------------------");
		int number;
		for (;;) {
			System.out.print("请选择删除客户编号(-1退出)：");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}
			Customer customer = customerList.getCustomer(number - 1);
			if (customer == null) {
				System.out.println("无法找到指定客户！");
			} else {
				break;
			}
		}

		// 找到了指定的客户
		System.out.println("确认是否删除(Y/N):");
		char isDelete = CMUtility.readConfirmSelection();
		if (isDelete == 'Y') {
			boolean deleteSuccess = customerList.deletCustomer(number - 1);
			if (deleteSuccess) {
				System.out.println("---------------------删除完成---------------------");
			} else {
				System.out.println("---------------------删除失败---------------------");
			}
		} else {
			return;
		}
	}

	/**
	 * 
	 * @Description 查看客户列表的操作
	 * @author cxdthd
	 * @date 2020年11月13日下午2:51:56
	 */
	public void listAllCustomer() {

		System.out.println("---------------------------客户列表---------------------------");
		int total = customerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录！");
		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t" + "邮箱");
			Customer[] custs = customerList.getAllCustomer();
			for (int i = 0; i < custs.length; i++) {
				System.out.println((i + 1) + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t"
						+ custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
			}
		}
		System.out.println("--------------------------客户列表完成-------------------------");
	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enrerMainMenu();
	}
}
