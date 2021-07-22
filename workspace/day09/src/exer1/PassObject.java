package exer1;

/*
 * 考察参数的值传递
 * 
 * 定义一个类PassObject,在类中定义一个方法printAreas(),
 * 该方法的定义如下：public void printAreas(Circle c,int time)
 * 在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。
 * 例如，time为5，则输出半径1，2，3，4，5，以及对应的圆面积。
 * 
 * 在main方法调用printAreas()方法，调用完毕后输出当前半径值。
 */
public class PassObject {
	public static void main(String[] args) {
		PassObject test = new PassObject();

		Circle c = new Circle();
		test.printAreas(c, 5);

		// test.printAreas(new Circle(), 5); //匿名对象的使用

		System.out.println("now Radius is\t" + c.radius);
	}

	public void printAreas(Circle c, int time) {
		System.out.println("Radius\t\tArea");
		// 只有将 int i = 1;放在上面下面for循环外才能再次调用i
		int i = 1;
		for (; i <= time; i++) {
			// 设置圆的半径
			c.radius = i;
			System.out.println(c.radius + "\t\t" + c.findArea());

		}

		// 方法一
		c.radius = time + 1;

		// 方法二
		c.radius = i;
	}
}
