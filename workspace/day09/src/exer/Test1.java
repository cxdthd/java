package exer;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 3, 3, 34, 56, 77, 432 };
		testtt(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void testtt(int[] arr) {

		// 错误写法
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = arr[i] / arr[0];
		// }

		// 正确写法一
		 for (int i = arr.length - 1; i >= 0; i--) {
		 arr[i] = arr[i] / arr[0];
		 }

		// 正确写法二
		// int temp = arr[0];
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = arr[i] / temp;
		// }
	}
}
