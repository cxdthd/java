package exer;

/*
 * 算法的考查：求数值型数组中元素的最大值、最小值、平均数、总和数等
 * 
 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值，最小值，总和，
 * 要求：所有随机数都是两位数。
 * 
 * [10,99]
 * 公式：(int)(Math.random() * (99 - 10 + 1) + 10)
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
			System.out.print(arr[i] + "\t");
			sum += arr[i];
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 求最小值
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		// 求平均数
		double average = sum / (double)arr.length;
		System.out.println();
		System.out.println("最大值为：" + max);
		System.out.println("最小值为：" + min);
		System.out.println("总和为：" + sum);
		System.out.println("平均数为：" + average);
	}

}
