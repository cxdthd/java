/*
�Ӽ��̷ֱ������ꡢ�¡��գ��ж���һ���ǵ���ĵڼ���
ע:
�ж�һ���Ƿ�������ı�׼:
1)���Ա�4�����������ɱ�100����
��
2)���Ա�400����

˵����
	�� ���ǿ���ʹ��switch-case�Ľṹ��������ת��Ϊif-else����֮����������
	�� ����д��֧�ṹʱ�������ּȿ���ʹ��switch-case, (ͬʱ��switch�� ����ʽ��ȡֵ�����̫��)��
      �ֿ���ʹ��if-elseʱ����������ѡ��ʹ��switch-case.

*/
import java.util.Scanner;
class SwitchCaseExer 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("��������һ��(year):");
		int year = scan.nextInt();
		System.out.println("�������·�(month):");
		int month = scan.nextInt();
		System.out.println("����������(day)");
		int day = scan.nextInt();

		int sumDays = 0;
		
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
				//sumDays += 29;
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
		{
				System.out.println(year + "��������");
				sumDays += 29;
		}else{
				System.out.println(year + "����ƽ��");
				sumDays += 28;
		}
			case 2:
				sumDays += 31;
			case 1:
				sumDays += day;

			
			}
			System.out.println("����" + year + "��ĵ�" + sumDays + "��");

		
}
}