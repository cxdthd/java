package java0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * try-catch-finally中finally的使用：
 * 
 * 
 * 1.finally是可选的
 * 
 * 2.finally中声明的是一定会被执行的代码。即使catch中又出现异常了，try中有return语句，catch中有 return语句等情况。
 * 
 * 3.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的
 * 释放。此时的资源释放，就需要声明在finally中。
 * 
 * 
 * 
 */
public class FinallyTest {

	@Test
	public void test2() {
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);

			int date = fis.read();
			while (date != -1) {
				System.out.print((char) date);
				date = fis.read();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)//避免空指针异常
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testMethod() {
		int num = method();
		System.out.println(num);
	}

	public int method() {
		int c = 0;
		try {
			int a = 10;
			int b = 0;
			c = a / b;
			return 1;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			return 2;
		}
		// System.out.println("可能会执行的语句！！！");
		// return 4;
		finally {
			System.out.println("一定会执行的语句！！！");
			return 3;
		}
	}

	@Test
	public void test1() {
		try {
			int a = 10;
			int b = 0;
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			// e.printStackTrace();

			int[] arr = new int[10];
			System.out.println(arr[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println("可能会执行的语句！！！");

		finally {
			System.out.println("一定会执行的语句！！！");
		}
	}

}
