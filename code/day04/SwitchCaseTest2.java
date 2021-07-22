/*
编写程序：从键盘上输入2020年的"month"和"day"，要求通过程序输出输入的日期为2020年的第几天。

说明：break在switch-case中是可选的
*/
import java.util.Scanner;
class SwitchCaseTest2
{
	public static void main (String[] args)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入月份(month):");
			int month = scan.nextInt();
			System.out.println("请输入日期(day)");
			int day = scan.nextInt();

			int sumDays = 0;
			
			/*
			//冗余
			switch (month)
			{
			case 1:
				sumDays = day;
			case 2:
				sumDays = 31 + day;
			case 3:
				sumDays = 31 + 29 + day;
			case 4:
				sumDays = 31 + 29 + 31 + day;

			
			}
			*/

			switch (month)
			{
			case 12:
				sumDays += 30;
			case 11:
				sumDays += 31;
			case 10:
				sumDays += 30;
			case 9:
				sumDays += 31;
			case 8:
				sumDays += 31;
			case 7:
				sumDays += 30;
			case 6:
				sumDays += 31;
			case 5:
				sumDays += 30;
			case 4:
				sumDays += 31;
			case 3:
				sumDays += 29;
			case 2:
				sumDays += 31;
			case 1:
				sumDays += day;

			
			}
			System.out.println("这是2020年的第" + sumDays + "天");

	}

}