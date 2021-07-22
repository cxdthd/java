package java1;


public class ArrayUtilTest {
	public static void main(String[] args) {
		ArrayUtil util = new ArrayUtil();
		int[] arr0 = new int[] { 1, 3, 5, 6, 234, 14, -432, 0, 324, 2345, -345, 1 };
		util.print(arr0);
		// System.out.println("arr0数组为：" + util.print(arr0)); //没有返回值无法直接输出
		int max = util.getMax(arr0);
		System.out.println("最大值是" + max);
		System.out.println("最小值为：" + util.getMin(arr0));
		System.out.println("总和为：" + util.getSum(arr0));
		System.out.println("平均数为： " + util.getAge(arr0));
		// System.out.println("反转：" + util.reverse(arr0)); //没有返回值无法直接输出
		util.reverse(arr0);
		System.out.print("排序前：");
		util.print(arr0); // 1 -345 2345 324 0 -432 14 234 6 5 3 1

		util.copy(arr0); // arr1

		System.out.println(util.getIndex(arr0, 0));

		util.sort(arr0);
		System.out.print("排序后：");
		util.print(arr0);
		
		System.out.println("********************static后********************");
		
		System.out.println("最大值为：" + ArrayUtil.getMax(arr0));

	}
}
