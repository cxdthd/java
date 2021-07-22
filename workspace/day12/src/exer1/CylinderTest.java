package exer1;

public class CylinderTest {
	public static void main(String[] args) {
		Cylinder cy = new Cylinder();
		cy.setRadius(2);
		cy.setLength(2);
		double findVolume = cy.findVolume();
		System.out.println("圆柱的体积为：" + findVolume);

		double area = cy.findArea();
		System.out.println("圆柱的表面积为：" + area);
	}
}
