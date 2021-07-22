package java0;

import org.junit.Test;

public class ReviewTest {
	
@Test
public void test3(){
	String s = "abc";
	System.out.println(s);//abc 
	System.out.println(s.toString());//abc
	
	s = "null";
	System.out.println(s);//null为字符串
	System.out.println(s.toString());//null
	
	s = null;
	System.out.println(s);	//null为空
	System.out.println(s.toString());//NullPointerException
}
	
	//区别手动写的自动生成的equals()
@Test
public void test2(){
	Person p = new Person("Tom",18);
	Man m = new Man("Tom",18);
	System.out.println(p.equals(m));//true ---> false
	System.out.println(p.getClass());
}

	//数组也作为Object类的子类出现，可以调用Object类中声明的方法
	@Test
	public void test1() {
		int[] arr = new int[] { 1, 2, 3 };
		print(arr);// [I@443b7951

		System.out.println(arr.getClass());		//class [I
		System.out.println(arr.getClass().getSuperclass());// class java.lang.Object
	}

	public void print(Object obj) {
		System.out.println(obj);
	}

}
