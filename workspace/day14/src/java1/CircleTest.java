package java1;

//static关键字的应用
public class CircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		Circle c3 = new Circle(1);

		System.out.println("c1的id为：" + c1.getId());
		System.out.println("c2的id为：" + c2.getId());
		System.out.println("c3的id为：" + c3.getId());

		System.out.println("创建的圆的个数为：" + Circle.getTotal());
	}
}

class Circle {
	private double radius;
	private int id;

	private static int total;
	private static int init = 1001; // static声明的变量被所有对象所共享

	public Circle() {
		id = init++;
		total++;
	}

	public Circle(double radius) {
		this();
		// id = init++;
		// total ++;
		this.radius = radius;
	}

	public double findArea() {
		return 3.14 * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getId() {
		return id;
	}

	public static int getTotal() {
		return total;
	}

}
