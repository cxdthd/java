package object1;

/*
 * 方法的重建（overlord）	loading...	加载中...
 * 
 * 1.定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
 * 			"两同一不同"：同一个类、相同方法名
 * 						参数列表不同：参数个数不同，参数类型不同
 * 2.举例：
 * 		Arrays类中重载sort() / binarySearch()
 * 
 * 3.判断是否是重载：
 * 		跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！
 * 		方法的重载只跟 方法名和形参列表有关，与修饰符和返回值类型无关
 * 
 * 4.在通过对象调用方法时，如何确认某一个指定的方法：
 * 		方法名 ---> 参数列表
 */
public class OverLoadTest {

	public static void main(String[] args) {
		OverLoadTest test = new OverLoadTest();
		test.getSum(1, 1); // 当注释掉getSum(int a, int b) 输出为2：原因是：自动类型提升
	}

	// 如下的四个方法就构成了重载

	 public void getSum(int a, int b) {
	 System.out.println("1");
	 }

	public void getSum(double a, double b) {
		System.out.println("2");
	}

	public void getSum(String a, int b) {
		System.out.println("3");
	}

	public void getSum(int a, String b) {
		System.out.println("4");
	}

	// 不行
//	public int getSum(int i, int j) {
//		return 0;
//	}
}
