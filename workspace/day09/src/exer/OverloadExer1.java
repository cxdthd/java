package exer;

/*\
 * 2.定义三个重载方法max()，
	第一个方法求两个int值中的最大值，
	第二个方法求两个double值中的最大值，
	第三个方法求三个double值中的最大值，
	并分别调用三个方法。
 */
public class OverloadExer1 {
	public static void main(String[] args) {
		OverloadExer1 exer = new OverloadExer1();
		int a1 = exer.max(2, 3);
		System.out.println(a1);
		double b1 = exer.max(1.7, 3);
		System.out.println(b1);
		double b2 = exer.max(12.2143124, 143210000, 132434.1234);
		System.out.println(b2);
	}

	public int max(int a, int b) {
		if (a >= b) {
			return a;
		}
		return b;
	}

	public double max(double a, double b) {
		if (a >= b) {
			return a;
		}
		return b;
	}

	public double max(double a, double b, double c) {
		if (a >= b && a >= c) {
			return a;
		}
		if (b >= a && b >= c) {
			return b;
		}
		return c;
	}
}
