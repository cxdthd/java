/*
编写程序:由键盘输入三个整数分别存入变量num1、 num2、 num3,
对它们进行排序(使用if-else if-else),并且从小到大输出。

说明：
if语句如果只有一条执行语句的话可以省略花括号{}，但不建议省略。
*/

import java.util.Scanner;
class IfTest2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入第一个整数：");
		int num1 = scan.nextInt();
		System.out.println("请输入第二个整数：");
		int num2 = scan.nextInt();
		System.out.println("请输入第三个整数：");
		int num3 = scan.nextInt();

		int max1 = (num1 >= num2)? num1 : num2;
		int max2 = (max1 >= num3)? max1 : num3;
		int min = num1 + num2 + num3 -max1 - max2;
		System.out.println("从大到小依次为:" + max2 + " " + max1 + " " + min);
	}
}
