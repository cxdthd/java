package exer;

public abstract class GeometricObject {
	protected String color;
	protected double weight;

	protected GeometricObject() {
	}

	protected GeometricObject(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public abstract  double findArea();
}
