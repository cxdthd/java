package object1;

public class ArrayPrintTest {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3 };
		System.out.println(arr); // [I@15db9742 println(Object x)

		char[] arr1 = new char[] { 'a', 'b', 'c' };
		System.out.println(arr1); // abc println(char[] x)

		char[] arr2 = new char[2];
		System.out.println(arr2); // 无输出
	}
}
