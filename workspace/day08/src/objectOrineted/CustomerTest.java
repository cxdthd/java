package objectOrineted;

/*
 * 类中方法的声明和使用
 * 
 * 方法：描述类应该具有的功能。
 * 比如： Math类：sqrt()\random() \...
 * 		Scanner类：nextXxx() ...
 * 		Arrays类：sort() \ binarySrarch() \ toString() \ equals() \ ...
 * 
 * 1.举例：
 * 		void是没有返回值的意思，()内写的是形参
 * 	public void eat() {}
 * 	public void sleep(int hour) {}
 * 		String是要返回值，返回字符串
 * 	public String getName() {}
 * 	public String getNation(String nation) {}
 * 
 * 2.方法的声明：权限修饰符 返回值类型  方法名(形参列表){
 * 				方法体
 * 			  }
 * 	
 * 注意：static、final、abstract修饰方法。
 * 
 * 3.说明：
 * 		3.1关于权限修饰符：默认权限修饰符都先使用public
 * 			Java规定的4种权限修饰符：private、public、缺省、protected   ----> 封装性(使用频率从大到小)
 * 
 * 		3.2返回值类型：有返回值 vs 没有返回值
 * 			3.2.1如果方法有返回值，则必须在方法声明时，指定返回值的类型。
 * 					同时，在方法中也需要使用return关键字来返回指定类型的变量或常量
 * 				 如果方法中没有返回值，则方法声明时，使用void来表示。通常，没有返回值的方法中，就不能使用return。
 * 					但是，如果使用的话，只能"return;"表示结束此方法的意思。
 * 			3.2.2我们定义方法该不该有返回值？
 * 					① 题目要求
 * 					② 凭经验：具体问题具体分析
 * 
 * 		3.3 方法名：属于标识符，遵循标识符的规则和规范，“见名知意”
 * 		3.4形参列表：方法中可以声明0个，1个，或多个形参。
 * 			格式：数据类型1 形参1,数据类型2 形参2,...
 * 		3.5方法功能的体现。
 * 
 * 4.return关键字的使用：
 * 		1.使用范围：使用在方法体中
 * 		2.作用：① 结束方法
 *			  ②针对于有返回值类型的方法，使用"return 数据"的方法，数据可以是变量也可以是常量。
 *		3.注意点：return关键字后面不可以声明执行语句。
 *
 *5.方法的使用中，可以调用当前类的属性或方法
 *		特殊的，方法A中再调用方法A：递归方法
 *		方法中，不可以定义方法
 */
public class CustomerTest {
	public static void main(String[] args) {
		Customer cust1 = new Customer();
		// cust1.eat(); //报错：因为private是私有的意思
		// int[] arr = new int[] { 1, 2, 3, 4543, 34, 12, 34, 35 };
		cust1.sort();
		System.out.println();
		cust1.sleep(6);

	}
}

// 客户类
class Customer {

	// 属性
	String name;
	int age;
	boolean isMale;

	// 方法
	private void eat() {
		System.out.println("客户吃饭");
		// return; // 结束方法的作用
		// System.out.println(); //Unreachable code 不可到达的：说明return后面不能再写语句，否则报错
	}

	public void sleep(int hour) {
		System.out.println("休息了" + hour + "个小时");
		// 在sleep方法里面调用eat()方法。
		eat();
	}

	public String getName() {
		// 调用当前类的属性age
		if (age > 18) {
			return name;
		} else {
			return "Tom"; // 也可以写成这样的形式
		}

	}

	public String getNation(String nation) {
		String info = "我的国籍是：" + nation;
		return info;
	}

	// 体会形参
	public void sort() {
		int[] arr = new int[] { 1, 2, 3, 4543, 34, 12, 34, 35 };
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
