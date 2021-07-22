package Array;

/* 二维数组的使用
 * 	规定：二维数组分为外层数组的元素，内层数组的元素
 * 		int[][] arr = new int[4][3];
 * 		外层元素：arr[0],arr[1]等
 * 		内层元素：arr[0][0],arr[1][2]等
 * 
 *  ⑤ 数组元素的默认初始化值
 *  针对于初始化方式一：比如：int[][] arr = new int[4][3];
 *  	外层元素的初始化值为：地址值
 *  	内层元素的初始化值为：与一维数组初始化值相同
 *  
 *  针对于初始化方式二：比如：int[][] arr = new int[4][];
 *  	外层元素的初始化值为：null
 *  	内层元素的初始化值为：不能调用，否则报错
 *  
 *  ⑥ 数组的内存解析	
 * 
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		
		int[][] arrr = new int[4][];
		System.out.println(arrr[0][0]);
		
		
int[][] arr = new int[4][3];
System.out.println(arr[0]);// [I@15db9742 地址值:一个[表示一维，I表示整形int，@后为地址
System.out.println(arr[0][0]); // 0
System.out.println(arr);// [[I@6d06d69c 表示int型的二维数组，地址为6d06d69c

System.out.println("*****************************************");

float[][] arr1 = new float[4][3];
System.out.println(arr1[0]);// [F@7852e922 地址值:一个[表示一维，F表示浮点型float，@后为地址
System.out.println(arr1[0][0]); // 0.0
System.out.println(arr1);// [[F@4e25154f 表示float型的二维数组，地址为4e25154f

System.out.println("*****************************************");

String[][] arr2 = new String[4][3];
System.out.println(arr2[0]);// [Ljava.lang.String;@70dea4e
							// 地址值:一个[表示一维，L表示字符串型String，@后为地址
System.out.println(arr2[0][0]); // null
System.out.println(arr2);// [[Ljava.lang.String;@5c647e05
							// 表示String型的二维数组，地址为5c647e05

System.out.println("*****************************************");

double[][] arr3 = new double[4][];
System.out.println(arr3[1]); // null
								// 因为数组属于引用数据类型，这里没有对arr3[1]初始化，所以默认为null
//		 System.out.println(arr3[1][0]);// 报错：空指针异常
	}
}
