package java3;

/*
 * 对属性可以赋值的位置：
 * ①默认初始化
 * ②显式初始化
 * ③构造器中初始化
 * ④有了对象以后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * ⑤在代码块中赋值
 * 
 * 执行的先后顺序：① - ②/⑤ - ③ - ④ 
 */
public class OrderTest {
	public static void main(String[] args) {
		Order o = new Order();
		System.out.println(o.i);
	}
}

class Order {
	int i = 1;

	{
		i = 2;
	}

}