/*
例题：对学生成绩大于60分的，输出"合格"，低于60分的，输出"不合格"。

说明：如果switch-case结构中的多个case的执行语句相同，则可以考虑进行合并。

*/
import java.util.Scanner;
class SwitchCaseTest1 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你的成绩：");
		int score = scan.nextInt();
		
		switch (score /60)
		{
		case 0:
			System.out.println("不及格");
			break;
		case 1:
			System.out.println("合格");
		}


		/*
		switch (score / 10)
		{
		case 0:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("不及格");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("合格");
		}
		*/
		
	}
}
