package Object;

public class ValueTransferTest {
	public static void main(String[] args) {

		// String s1 = "hello";

		// String属于类，不是基本数据类型，所以可以new一个对象出来调用
		String s1 = new String();
		s1 = "hello";

		ValueTransferTest test = new ValueTransferTest();
		test.change(s1);

		System.out.println(s1); // hello

	}

	public void change(String s) {
		s = "hi~~";
	}
}
