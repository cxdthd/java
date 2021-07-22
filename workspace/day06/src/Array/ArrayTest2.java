package Array;

/*
 * 二维数组得到使用
 * 
 * 1.理解
 * 对于二维数组的理解，我们可以看成是一维数组array1又作为另一个array2的元素而存在。
 * 其实，从数组底层运行机制来看，没有多维数组。
 * 
 * 2.二维数组的使用：
 *  ① 二维数组的声明和初始化
 * 	② 如何调用数组的指定位置的元素
 * 	③ 如何获取数组的长度
 * 	④ 如何遍历数组
 * 	⑤ 数组元素的默认初始化值	//见ArrayTest3.java
 * 	⑥ 数组的内存解析		//见ArrayTest3.java
 * 
 */
public class ArrayTest2 {
	public static void main(String[] args) {
		// 1.二维数组的声明和初始化
		int[] arr = new int[] { 1, 2, 3 };// 一维数组的静态初始化
		// 静态初始化
		int[][] arr1 = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		// 动态初始化1
		String[][] arr2 = new String[3][2];
		// 动态初始化2
		String[][] arr3 = new String[3][];
		// 错误的情况
		// String[][] arr4=new String[][2];
		// int[][] arr5 = new int[3][2]{{1,2,3},{4,5},{6,7,8,9}};
		// 也是正确的写法，但不是标准的
		int[] arr4[] = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		int arr5[][] = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
		int[][] arr6 = { { 1, 2, 3 }, { 4, 5, 6 } }; // 类型推断

		// 2.如何调用数组的指定位置的元素
		System.out.println("数组arr1的第0个元素里的第1个元素为：" + arr1[0][1]);// 2
		System.out.println(arr2[1][1]);// null
		/*
		 * System.out.println(arr3[1][1]); //Exception in thread "main"
		 * java.lang.NullPointerException at
		 * Array.ArrayTest2.main(ArrayTest2.java:40) //报错：空指针异常
		 */
		arr3[1] = new String[4];
		System.out.println(arr3[1][0]);// null

		// 3.如何获取数组的长度
		System.out.println("数组arr1的长度为" + arr1.length);// 3
		System.out.println("数组arr1的第3个元素数组的长度为" + arr1[2].length);

		// 4.如何遍历数组
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "  ");
			}
			System.out.println();
		}

	}
}
