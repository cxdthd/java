/*
�Ӽ��̶��������ȷ�������������ж϶���������͸����ĸ���������Ϊ0ʱ��������

˵��:
1.����ѭ�������������ƴ����Ľṹ: for(;;) ��while(true)
2. ����ѭ���м��ַ�ʽ?
	��ʽһ:ѭ���������ַ���false
	��ʽ��:��ѭ�����У�ִ��break


*/
import java.util.Scanner;
class ForWhileTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int conzheng = 0;
		int confu = 0;
		//for( ; ;)     û�д�������Ҳ������������Ч��
		while (true)	//��ѭ��һֱ����
		{
			System.out.print("������һ��������");
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
		System.out.println("һ����" + conzheng + "������");
		System.out.println("һ����" + confu + "������");
		
	}
}
