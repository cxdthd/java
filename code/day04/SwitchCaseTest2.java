/*
��д���򣺴Ӽ���������2020���"month"��"day"��Ҫ��ͨ������������������Ϊ2020��ĵڼ��졣

˵����break��switch-case���ǿ�ѡ��
*/
import java.util.Scanner;
class SwitchCaseTest2
{
	public static void main (String[] args)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("�������·�(month):");
			int month = scan.nextInt();
			System.out.println("����������(day)");
			int day = scan.nextInt();

			int sumDays = 0;
			
			/*
			//����
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
			System.out.println("����2020��ĵ�" + sumDays + "��");

	}

}