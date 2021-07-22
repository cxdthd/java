package exer;

/*
 * 2.利用面向对象的编程方法，设计类Circle计算圆的面积。
 */
//测试类
public class CircleTest {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.radius = 12.2;
		// 对应方式一
		// double area = c1.findArea();
		// System.out.println(area);

		// 对应方式二
		c1.findArea();

		c1.findArea(1);
		System.out.println("错误显示面积" + c1.findArea(1));

	}
}

// 圆
class Circle {

	// 属性
	double radius;

	// 求圆的面积
	// 方式一
	// public double findArea() {
	// double area = Math.PI * radius * radius; // Math.PI就是3.14
	// return area;
	// }

	public void findArea() {
		double area = Math.PI * radius * radius;
		System.out.println("面积为：" + area);
	}

	// 错误的情况
	public double findArea(double r) {
		double area = Math.PI * r * r;
		return area;	//return返回area，在调用这个方法时就会输出area

	}
}
