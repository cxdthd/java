package exer;

/*
 * 1.编写程序，定义三个重载方法并调用。方法名为mOL。
	三个方法分别接收一个int参数、两个int参数、一个字符串参数。
	分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
	在主类的main ()方法中分别用参数区别调用三个方法。
	
	
 * 
 * 
 */
public class OverloadExer {

	public static void main(String[] args) {
		OverloadExer exer1 = new OverloadExer();
		int a1 = exer1.mOL(3);
		System.out.println(a1);
		int a2 = exer1.mOL(2, 6);
		System.out.println(a2);
		exer1.mOL("123");
	}

	public int mOL(int a) {
		return a * a;
	}

	public int mOL(int a, int b) {
		return a * b;
	}

	public void mOL(String a) {
		System.out.println("输出字符串:" + a);
	}
}
