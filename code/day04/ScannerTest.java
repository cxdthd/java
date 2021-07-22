/*
如何从键盘获取不同类型的变量：需要使用Scanner类

具体实现步骤：
1.导包：import java.util.Scanner;
2.Scanner的实例化：Scanner scan = new Scanner(System.in);
3.调用Scanner类的相关方法，来获取指定类型的变量


注意：
需要根据相应的方法，来输入指定类型的值。如果输入的数据类型与要求的类型不匹配时，会报异常: InputMismatchException,
导致终止程序。

*/
import java.util.Scanner;	//导包，import为导入的意思
class  ScannerTest
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);	//System.in为键盘输入的意思
		System.out.println("请输入你的姓名");
		String name = scan.next();//调用Scanner方法
		System.out.println(name + ",请问你的性别是？");
		char sex = scan.next().charAt(0);	//charAt() 为从String中获取char型的方法，()里为从String的第几位获取
		if (sex == '男')
		{
			String str = name + "先生";
			System.out.println(str + ",请再输入你的年龄");
			int age = scan.nextInt();
			System.out.println(str + "，请再输入你的身高");
			double height = scan.nextDouble();
			System.out.println(str + "，请再输入你的体重");
			double weight = scan.nextDouble();
			System.out.println(str + "，你今年" + age + "\n" + "身高为：" + height + "cm ,体重为:" + weight + "kg");
		}else if (sex == '女')
		{
			String str = name + "女士";
			System.out.println(str + "，请再输入你的年龄");
			int age = scan.nextInt();
			System.out.println(str + "，请再输入你的身高");
			double height = scan.nextDouble();
			System.out.println(str + "，请再输入你的体重");
			double weight = scan.nextDouble();
			System.out.println(str + "，你今年" + age + "\n" + "身高为：" + height + "cm,体重为：" + weight + "kg");
		}else System.out.println("请输入正确的性别");
		

	}
}
