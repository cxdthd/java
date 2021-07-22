package exer3;

public class CircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle(2.3);
		Circle c2 = new Circle("white", 1.0, 2.3);

		// 判断颜色是否相等
		System.out.println("颜色是否相等：" + c1.color.equals(c2.color));
		System.out.println("颜色是否相等：" + (c1.color == c2.color));

		boolean equals = c1.equals(c2);
		System.out.println(equals);

		double findArea = c1.findArea();
		System.out.println(findArea);
		System.out.println(c1.toString());

	}
}
