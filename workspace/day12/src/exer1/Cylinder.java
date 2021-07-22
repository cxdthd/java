package exer1;

public class Cylinder extends Circle {
	private double length;

	public Cylinder() {
		length = 1.0;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double findVolume() {
		// 计算圆柱体积
		// return Math.PI * getRadius() * getRadius() * getLength();
		return super.findArea() * length;
	}

	@Override
	public double findArea() {
		// 计算圆柱的表面积
		return Math.PI * getRadius() * getRadius() * 2 + 2 * Math.PI * getRadius() * getLength();
	}
}
