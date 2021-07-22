package object;

/*
 * 自定义数组的工具类
 */
public class ArrayUtil {
	// 求数组的最大值
	public int getMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	// 求数组的最小值
	public int getMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	// 求数组的总和
	public int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// 求数组的平均值
	public double getAge(int[] arr) {

		return getSum(arr) / (double) arr.length;
	}

	// 反转数组
	public void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	// 复制数组
	public int[] copy(int[] arr) {
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		return arr1;
	}

	// 数组排序
	public void sort(int[] arr) {
		for (int i = 0; i < (arr.length - 1); i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// int temp = arr[j];
					// arr[j] = arr[j + 1];
					// arr[j + 1] = temp;
					// 错误的：
					// swap(arr[j], arr[j + 1]);//
					// 在同一个class里，都没有static可以不用new对象直接调用

					// 正确的：
					swap(arr, j, j + 1);
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	// 错误的：交换数组中指定两个位置元素的值
	// public void swap(int m, int n) {
	// int temp = m;
	// m = n;
	// n = temp;
	// }

	// 正确的：交换数组中指定两个位置元素的值
	public void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	// 遍历数组
	public void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("]");
	}

	// 查找指定元素
	public int getIndex(int[] arr, int dest) {

		for (int i = 0; i < arr.length; i++) {
			if (dest == arr[i]) {
				return i; // return返回就等于退出方法，相当于循环的break
			}
		}
		return -1;
	}
}
