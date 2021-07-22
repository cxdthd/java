package java2;

import org.junit.Test;

/*
 * Java中的JUnit单元测试
 * 
 * 步骤：
 * 1.选中当前工程 - 右键选择：build path - add libraries - JUnit 4 - 下一步
 * 2.创建Java类，进行单元测试。
 * 	 此时Java类要求：① 此类时public的 ② 此类提供公共的无参的构造器
 * 3.此类中声明单元测试方法。
 * 	 此时的单元测试方法：方法的权限是public,没有返回值，没有形参
 * 
 * 4.此单元测试方法上需要声明注解： @Test,并在单元测试类中导入：import org.junit.Test;
 * 
 * 5.声明好单元测试方法以后，就可以在方法体内测试相关的代码。
 * 6.写完代码以后，左键双击单元测试方法名，右键：run as - JUnit Test
 * 
 * 简单步骤：写完@Test后直接ctrl + 1即可
 * 
 * 说明：
 * 1.如果执行结果没有任何异常：绿条
 * 2.如果执行结果出现异常：红条
 */
public class JUnitTest {

	int number = 10;

	@Test
	public void testEquals() { // 之所以能像main方法一样输出但却不用造对象是因为main方法是static静态的，静态方法是需要对象才可以输出的
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1.equals(s2));

		System.out.println(number);
	}
}
