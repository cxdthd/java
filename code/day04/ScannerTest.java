/*
��δӼ��̻�ȡ��ͬ���͵ı�������Ҫʹ��Scanner��

����ʵ�ֲ��裺
1.������import java.util.Scanner;
2.Scanner��ʵ������Scanner scan = new Scanner(System.in);
3.����Scanner�����ط���������ȡָ�����͵ı���


ע�⣺
��Ҫ������Ӧ�ķ�����������ָ�����͵�ֵ��������������������Ҫ������Ͳ�ƥ��ʱ���ᱨ�쳣: InputMismatchException,
������ֹ����

*/
import java.util.Scanner;	//������importΪ�������˼
class  ScannerTest
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);	//System.inΪ�����������˼
		System.out.println("�������������");
		String name = scan.next();//����Scanner����
		System.out.println(name + ",��������Ա��ǣ�");
		char sex = scan.next().charAt(0);	//charAt() Ϊ��String�л�ȡchar�͵ķ�����()��Ϊ��String�ĵڼ�λ��ȡ
		if (sex == '��')
		{
			String str = name + "����";
			System.out.println(str + ",���������������");
			int age = scan.nextInt();
			System.out.println(str + "����������������");
			double height = scan.nextDouble();
			System.out.println(str + "�����������������");
			double weight = scan.nextDouble();
			System.out.println(str + "�������" + age + "\n" + "���Ϊ��" + height + "cm ,����Ϊ:" + weight + "kg");
		}else if (sex == 'Ů')
		{
			String str = name + "Ůʿ";
			System.out.println(str + "�����������������");
			int age = scan.nextInt();
			System.out.println(str + "����������������");
			double height = scan.nextDouble();
			System.out.println(str + "�����������������");
			double weight = scan.nextDouble();
			System.out.println(str + "�������" + age + "\n" + "���Ϊ��" + height + "cm,����Ϊ��" + weight + "kg");
		}else System.out.println("��������ȷ���Ա�");
		

	}
}
