package exer1;

/*
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。
 */
public class EmployeeTest {
	public static void main(String[] args) {
		
		Manager manager = new Manager("kuke", 1001, 5000, 50000);
		
		manager.work();
		
		//多态性
		Employee comm = new CommonEmployee();
		
		comm.work();
		
	}
}
