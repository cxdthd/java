/*
Forѭ���ṹ��ʹ��
һ��ѭ���ṹ��4��Ҫ��
�ٳ�ʼ������
��ѭ������  --- > ��boolean����
��ѭ����
�ܵ�������
����forѭ���Ľṹ
for(��;��;��){
	��
}
ִ�й���:	�� - �� - �� - �� - �� - �� - �� ... - �� �����㣬ѭ������


*/
class ForTest
{
	public static void main (String[] args)
	{
		
		for (int i = 1;i <= 5 ;i++ )
		{
			System.out.println("Hello,World!");
		}	
		//i ֻ��forѭ������Ч������forѭ����ʧЧ��

		//��ϰ
		int num = 1;
		for (System.out.print('a');num <= 3 ;System.out.print('c'),num++ )
		{
			System.out.print('b');
		}
		//��������abcbcbc
		
		System.out.print("\n");

		//���⣺����100������ż�����������ǵĺ�,��ż���ĸ���
		int sum = 0;
		int count = 0;
		for (int i = 2;i <= 100 ;i += 2 )
		{
			System.out.print(i + " ");
			sum += i;
			count ++;
		}
		System.out.println("\n" + "100��������ż���ĺ�Ϊ��" + sum);
		System.out.println("һ������һ����" + count + "��ż��");
	}
}