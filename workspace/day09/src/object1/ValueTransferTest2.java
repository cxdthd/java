package object1;

public class ValueTransferTest2 {
	public static void main(String[] args) {
		Date date = new Date();
		date.m = 10;
		date.n = 20;
		System.out.println("m = " + date.m + ",n = " + date.n);

		// 交换m和n的值
		// int temp = date.m;
		// date.m = date.n;
		// date.n = temp;

		ValueTransferTest2 test = new ValueTransferTest2();
		test.swap(date);

		System.out.println("交换后的m = " + date.m + ",n = " + date.n);
	}

	public void swap(Date date) // Date为引用数据类型，date存的是地址值
	{
		int temp = date.m;
		date.m = date.n;
		date.n = temp;
	}
}

class Date {
	int m;
	int n;
}