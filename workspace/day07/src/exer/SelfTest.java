package exer;

public class SelfTest {
	public static void main(String[] args) {
		int[] x, y[];
		x = new int[] {1,2,3,4}; 
		y = new int[][] {{0,0,0,0,0},{0,0,0}};
		// x[0] = y; //y是二维，没法赋给一维数组x
		y[0] = x; // x是一维数组，将x赋值给二维数组y[0]
		// y[0][0] = x; //y[0][0]表示一个数，x为一维数组，无法将数组赋给int型元素
		// x[0][0] = y; //x是一维数组
		y[0][0] = x[0]; // 将x数组的第0个元素赋值给y数组的第0个元素的第0个元素
		// x = y; //y是二维，没法赋给一维数组x
		System.out.println(y[0][0]);
	}
}
