package Array;
/*
 * ⑤ 数组元素的默认初始化值 
 * 		> 数组元素是整形：0
 * 		> 数组元素是浮点型：0.0
 * 		> 数组元素是char型：0或'\u0000'，而非'0'
 * 		> 数组元素是boolean型：float	//在boolean型里float代表0，true代表1
 * 
 * 		> 数组元素是引用数据类型String:null 而不是'null'
 * 
 * ⑥ 数组的内存解析
 * 
 */
public class ArrayTest1 {
	public static void main(String[] args) {
//		5.数组元素的默认初始化值
		
		System.out.print("int的默认初始化值为：");
		int[] arr = new int[4];
		for (int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + "  ");
		}
		
		System.out.println();
		
		System.out.print("short的默认初始化值为：");
		short[] arr1 = new short[4];
		for (int i = 0;i < arr1.length;i++)
		{
			System.out.print(arr1[i] + "  ");
		}
		
		System.out.println();
		
		System.out.print("float的默认初始化值为：");
		float[] arr2 = new float[4];
		for (int i = 0;i < arr2.length;i++)
		{
			System.out.print(arr2[i] + "  ");
		}
		
		System.out.println();
		
		System.out.println("char的默认初始化值为：");
		char[] arr3 = new char[4];
		for (int i = 0;i < arr3.length;i++)
		{
			System.out.println("----" + arr3[i] + "****");
		}
		if (arr3[3] == 0)
		{
			System.out.print("char的默认初始值为0");
		}
		
		System.out.println();
		
		System.out.print("boolean的默认初始化值为：");
		boolean[] arr4 = new boolean[4];
		for (int i = 0;i < arr4.length;i++)
		{
			System.out.print(arr4[i] + "  ");
		}
		
		System.out.println();
		
		System.out.print("String的默认初始化值为：");
		String[] arr5 = new String[4];
		for (int i = 0;i < arr5.length;i++)
		{
			System.out.print(arr5[i] + "  ");
		}
		if (arr5[1] == null)
		{
			System.out.println("String的默认初始值为null");
		}
	}
}
