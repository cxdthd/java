package java0;

import org.junit.Test;

public class E {
	@Test
	public void test(){
		int i = method();
		System.out.println(i);
	}
	
	public int method(){
		try{
			int arr[] = new int[10];
			System.out.println(arr[11]);
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return 2;
		} finally{
			System.out.println("一定会执行。。。");
			return 3;
		}
	}
}
