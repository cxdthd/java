/*
��С���μ�Java���ԣ����͸�������Ⱥ��ɳ�ŵ:
���:
�ɼ�Ϊ100��ʱ������һ��BMW;
�ɼ�Ϊ(80��99]ʱ������һ̨iphone XS max;
���ɼ�Ϊ[60,80]ʱ������һ��iPad;
����ʱ��ʲô����Ҳû�С�
��Ӽ���������С������ĩ�ɼ����������ж�


˵��:
1. else�ṹ�ǿ�ѡ�ġ�
2.������������ʽ:
	>�������������ʽ֮���ǡ����⡱��ϵ(��û�н����Ĺ�ϵ)���ĸ��жϺ�ִ��������������滹�����棬����ν��
	>�������������ʽ֮���н����Ĺ�ϵ����Ҫ����ʵ��������������Ӧ�ý��ĸ��ṹ���������档
	>�������������ʽ֮���а����Ĺ�ϵ��ͨ������£���Ҫ����ΧС�������ڷ�Χ������档���򣬷�ΧС�ľ�û����ִ���ˡ�



*/
import java.util.Scanner;
class IfTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("��������С���ĳɼ���");
		int grade = scan.nextInt();
		if (grade == 100)
		{
			System.out.println("����һ��BMW");
		}else if (grade > 80 && grade <= 99)
		{
			System.out.println("����һ̨iphone XS max");
		}else if (60 <= grade && grade <= 80)
		{
			System.out.println("����һ̨iPad");
		}else if (0 <= grade && grade < 60)
		{
			System.out.println("ʲô����Ҳû��");
		}else 
			{
				System.out.println("��������ȷ�ĳɼ���");
		}
	}
}
