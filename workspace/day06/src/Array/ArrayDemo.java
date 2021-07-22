package Array;

public class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = new int[] { 8, 2, 1, 0, 3, 6, 7, 9 };
		int[] index = new int[] { 2, 0, 6, 6, 7, 1, 5, 3, 5, 4, 3 };
		String tel = "";
		for (int i = 0; i < index.length; i++) {
			tel += arr[index[i]];
		}
		System.out.println("联系方式：" + tel); // 18779260630
	}
}
