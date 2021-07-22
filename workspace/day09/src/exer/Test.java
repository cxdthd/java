package exer;

public class Test {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		method(a, b); // 需要在method方法被调用之后，仅打印出a = 100，b = 200，请写出method方法的代码
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

	// 代码编写处
	public static void method(int a, int b) {
		a = a * 10;
		b = b * 20;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.exit(0); // 退出程序

	}
}
