package java2;

import org.junit.Test;

/*
 *包装类的使用：
 *1.Java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *
 *2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 *
 */
public class WrapperTest {

	// String类型--->基本数据类型、包装类:调用包装类的parseXxx(String s)方法
	@Test
	public void test5() {
		String str1 = "123";
		System.out.println(str1 + 1);// 1231

		// 错误的情况：只有子父类关系的情况下才可以使用强转
		// int i1 = (int)str1;
		// Integer integer = (Integer)str1;

		// 两步：先转成Integer包装类，再转成int型（自己写的）
		Integer integer = new Integer(str1);
		int i1 = integer;
		System.out.println(i1 + 1);// 124

		// 一步到位：调用包装类的parseXxx(String s)方法
		int parseInt = Integer.parseInt(str1);
		System.out.println(parseInt + 2);// 125

		String str2 = "trUe";
		boolean parseBoolean = Boolean.parseBoolean(str2);
		System.out.println(parseBoolean);// true
	}

	// 基本数据类型、包装类 --->String类型:调用String重载的valueOf(Xxx xxx)
	@Test
	public void test4() {

		// 基本数据类型String类型:调用String重载的valueOf(Xxx xxx)
		// 方式一：连接运算
		int num1 = 10;
		String str1 = num1 + "";
		System.out.println(str1 + 1);// 101
		// 方式二:调用String重载的valueOf(Xxx xxx)
		float f1 = 12.3f;
		String str2 = String.valueOf(f1);
		System.out.println(str2 + 1);// 12.31

		// 包装类 --->String类型:调用String重载的valueOf(Xxx xxx)
		Double d1 = new Double(12.4);
		String valueOf = String.valueOf(d1);
		System.out.println(valueOf);
	}

	/*
	 * JDK 5.0新特性：自动装箱与自动拆箱
	 */
	@Test
	public void test3() {
		// int num1 = 1001;
		// Integer integer = new Integer(num1);
		// method(num1);
		// method(integer);

		// 自动装箱:不需要新new一个构造器，可以直接赋给对象
		// 基本数据类型 --->包装类
		int num2 = 10;
		Integer in1 = num2;

		boolean b1 = true;
		Boolean b2 = b1;

		// 自动拆箱:不需要调用包装类，也是直接赋值给基本数据类型
		// 包装类 --->基本数据类型
		int num3 = in1;
		System.out.println(num3 + 1); // 11
	}

	public void method(Object obj) {
		System.out.println("method");
	}

	// 包装类 --->基本数据类型：调用包装类的xxxValue()
	@Test
	public void test2() {
		Integer in1 = new Integer(12);
		int number1 = in1.intValue();
		System.out.println(number1 + 1); // 13

		Float f1 = new Float(12.3);
		float f2 = f1.floatValue();
		System.out.println(f2 + 1);// 13.3
	}

	// 基本数据类型 --->包装类：调用包装类的构造器
	@Test
	public void test1() {
		int num1 = 10;
		// System.out.println(num1.toString());
		Integer integer = new Integer(num1);
		System.out.println(integer.toString());

		Integer integer2 = new Integer("123");
		System.out.println(integer2.toString());

		// 报异常
		 Integer integer3 = new Integer("123abc");
		// System.out.println(integer3.toString());

		Float float1 = new Float(12.3f);
		Float float2 = new Float("12.3");
		System.out.println(float1);
		System.out.println(float2);

		Boolean boolean1 = new Boolean(true); // true
		Boolean boolean2 = new Boolean("tRue"); // true
		Boolean boolean3 = new Boolean("abc"); // false
		System.out.println(boolean1);
		System.out.println(boolean2);
		System.out.println(boolean3);

		System.out.println("***************************");
		Order order = new Order();
		System.out.println(order.isMale);// false
		System.out.println(order.isFemale);// null
	}
}

class Order {
	boolean isMale;
	Boolean isFemale;
}
