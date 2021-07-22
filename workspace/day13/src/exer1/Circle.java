package exer1;

public class Circle extends GeometricObject {
	private double radius;

	public Circle(double radius, String color, double weight) {
		super();
		this.radius = radius;
		this.color = color;
		this.weight = weight;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double findArea() {
		return Math.PI * radius * radius;
	}
}
