/*
��֧�ṹ֮����switch-case

1.��ʽ
switch(����ʽ){
case ����1:
	ִ�����1;
	//break;	

case ����2:
	ִ�����2;
	//break

...

default:
	ִ�����n;
	//break;

˵����
   �ٸ���switch����ʽ�е�ֵ������ƥ�����case�еĳ�����һ��ƥ��ɹ����������Ӧcase�ṹ�У�������ִ����䡣
	��������ִ������Ժ�����Ȼ��������ִ������case�ṹ�е�ִ����䣬ֱ������break�ؼ��ֻ��switch-case�ṹ
	ĩβΪֹ������

   ��break,����ʹ����switch-case�ṹ�У���ʾһ��ִ�е��˹ؼ��֣�������switch-case�ṹ

   ��switch�ṹ�еı���ʽ��ֻ�������µ�6����������֮һ: byte ��short�� char�� int�� ö�����͡�String����

   ��case֮��ֻ����������������������Χ����Ϊ���巶Χ���Ϊboolean��

   ��break�ؼ����ǿ�ѡ��

   ��default�൱��if-else���else
    default�ǿ�ѡ�ģ�����λ��������
}

*/
class SwitchCaseTest
{
	public static void main (String[] args)
		{
			int num = 1;
			switch (num)
			{
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("tow");
				break;
			case 3:
				System.out.println("three");
				break;
			default:
				System.out.println("other");

			}
			
	}
}