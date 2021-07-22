package exer1;

public class Circle {
	private double radius;

	 public Circle() {
	 radius = 1.0;
	 }

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public double findArea() {
		// 返回圆的面积
		return Math.PI * radius * radius;
	}
}
