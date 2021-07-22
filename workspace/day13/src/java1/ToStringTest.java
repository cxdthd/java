package java1;

import java.util.Date;

/*
 * Object类中toString()的使用：
 * 
 * 1.当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 2.Object类中toString()的定义：
 * 		public String toString() {
 *      	return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *  	}
 * 
 * 3.像String、Date、File、包装类都重写了Object类中的toString()方法。
 * 	 使得在调用对象的toString()时，返回"实体内容"信息
 * 
 * 4.自定义类也可以重写toString()方法，当调用此方法时，返回对象"实体内容"。
 */
public class ToStringTest {
	public static void main(String[] args) {
		Customer cust1 = new Customer("Tom", 21);
		System.out.println(cust1.toString());// java1.Customer@15db9742 --> Customer [name=Tom, age=21]
		System.out.println(cust1);// java1.Customer@15db9742 --> Customer [name=Tom, age=21]

		// 说明String类和Date类重写了toSting()方法
		String str = new String("abc");
		System.out.println(str);// abc

		Date date = new Date(12345);
		System.out.println(date);// Thu Jan 01 08:00:12 CST 1970
	}
}
