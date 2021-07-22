package java2;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			Student s = new Student();
			int n = scan.nextInt();
			s.regist(n);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Student {

	private int id;

	public void regist(int id) throws Exception {
		if (id > 0) {
			this.id = id;
		} else {
//			System.out.println("你输入的id错误！！！");
			//手动抛出一个异常
//			throw new RuntimeException("你输入的id错误！！！");
//			throw new Exception("你输入的id错误！！！");
			throw new MyException("你输入的是负数");
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}

}
