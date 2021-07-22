/*
从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序。

说明:
1.不在循环条件部分限制次数的结构: for(;;) 或while(true)
2. 结束循环有几种方式?
	方式一:循环条件部分返回false
	方式二:在循环体中，执行break


*/
import java.util.Scanner;
class ForWhileTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int conzheng = 0;
		int confu = 0;
		//for( ; ;)     没有触发条件也可以做出类似效果
		while (true)	//让循环一直进行
		{
			System.out.print("请输入一个整数：");
			int num = scan.nextInt();
			if (num > 0)
			{
				conzheng ++;
			}else if (num < 0)
				{
				confu ++;
			}else 
			{
				break;
			}
		}
		System.out.println("一共有" + conzheng + "个正数");
		System.out.println("一共有" + confu + "个负数");
		
	}
}
