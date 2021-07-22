package exer;

/*
 * 数组的冒泡排序的实现
 * 
 */
public class BubbleSortTest {
	public static void main(String[] args) {
int[] arr = new int[] { 23, 34, 67, 32, -34, -56, 0, 23, 65, 342, 1234, -54, -644, 34, 10, 34 };

// 冒泡排序
for (int i = 0; i < (arr.length - 1); i++) {
	for (int j = 0; j < arr.length - i - 1; j++) {
		if (arr[j] > arr[j + 1]) {
			int temp = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = temp;
		}
	}
}

		// 遍历
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
