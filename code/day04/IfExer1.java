/*
��Ҷ�֪�����д󵱻飬Ů�󵱼ޡ���ôŮ���ҳ�Ҫ��Ů������ȻҪ���һ��������:
��: 180cm����;��:�Ƹ�1ǧ������;˧:�ǡ�
�������������ͬʱ���㣬��:����һ��Ҫ�޸���!!!��
�������������Ϊ����������:���ްɣ����ϲ��㣬�������ࡣ��
������������������㣬��:������!��

*/
import java.util.Scanner;
class IfExer1
{
	public static void main (String[] args)
		{
		Scanner scan = new Scanner(System.in);
		System.out.println("�������������(cm)");
		int height = scan.nextInt();
		System.out.println("��������ļҲ�(��)");
		int property = scan.nextInt();

		/*
		//��ʽһ
		System.out.println("�Ƿ�˧(true/false)");
		boolean dou = scan.nextBoolean();
		if(height >=180 && property>= 1000 && dou)
			{
				System.out.println("��һ��Ҫ�޸���������");
		}else if (height >=180 || property>= 1000 || dou)
		{
			System.out.println("�ްɣ����ϲ��㣬�������ࡣ");
		}else
				System.out.println("���ޣ�");

		*/

		//��ʽ��
		System.out.println("�Ƿ�˧(��/��)");
		String dou = scan.next();
		if(height >=180 && property>= 1000 && dou.equals("��"))		//equals���Զ��ַ�������ƥ�䣬ƥ��ɹ�����true�����򷵻�false
			{
				System.out.println("��һ��Ҫ�޸���������");
		}else if (height >=180 || property>= 1000 || dou.equals("��"))
		{
			System.out.println("�ްɣ����ϲ��㣬�������ࡣ");
		}else
				System.out.println("���ޣ�");


	
	}
}