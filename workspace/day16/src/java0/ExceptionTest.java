package java0;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * 一、异常体系结构
 * 
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|------编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|------运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException：类型转换异常
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException:输入不匹配
 * 					|-----ArithmeticException:算数异常
 * 
 * 
 * 
 * 面试题：常见的异常都有哪些？举例说明
 */
public class ExceptionTest {
	
	//******************************以下是编译时异常**************************************
//	@Test
//	public void test7(){
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//		
//		int date = fis.read();
//		while(date != -1){
//			System.out.print((char)date);
//			date = fis.read();
//		}
//		
//		fis.close();
//	}
	
	
	
	
	//******************************以下是运行时异常**************************************
//	ArithmeticException:算数异常
	@Test
	public void test6(){
		int a = 10;
		int b = 0;
		int c = a/b;
		System.out.println(c);
		
		
	}
	
	
//	InputMismatchException:输入不匹配
	@Test
	public void test5(){
		Scanner scan = new Scanner(System.in);
		int nextInt = scan.nextInt();
		System.out.println(nextInt);
		
		scan.close();//资源回收
	}
	
//	NumberFormatException
	@Test
	public void test4(){
		String str = "123";
		str = "abc";
		int num = Integer.parseInt(str);
	}
	
//	ClassCastException：类型转换异常
	@Test
	public void test3(){
		
		Object obj = new Date();
		String str = (String)obj;
		
	}
	
	

//	IndexOutOfBoundsException:角标越界异常
	@Test
	public void test2(){
		
		//ArrayIndexOutOfBoundsException
//		int[] arr = new int[10];
//		System.out.println(arr[10]);
		
		//StringIndexOutOfBoundsException
		String str = "abc";
		System.out.println(str.charAt(3));
		
	}
	
	
	//NullPointerException:空指针异常
	@Test
	public void test1(){
		
//		int[] arr = null;
//		System.out.println(arr[3]);
		
		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));
	}
}
