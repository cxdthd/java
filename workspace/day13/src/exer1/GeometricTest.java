package exer1;

/*
 * 
 * 定义一个测试类GeometricTest，
 * 编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术），
 * 编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）。

 */
public class GeometricTest {

	public static void main(String[] args) {

		GeometricObject o1 = new MyRectangle(2, 1, "red", 1);
		GeometricObject o2 = new Circle(1, "red", 1);

		GeometricTest test = new GeometricTest();

		boolean equalArea = test.equalArea(o1, o2);
		System.out.println(equalArea);
	}

	// 测试两个对象的面积是否相等
	public boolean equalArea(GeometricObject o1, GeometricObject o2) {
		return o1.findArea() == o2.findArea();
	}

	// 显示对象的面积
	public void displayGeometricObject(GeometricObject o) {
		System.out.println(o + "的面积为：" + o.findArea());
	}
}
