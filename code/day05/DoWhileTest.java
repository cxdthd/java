/*
һ��ѭ���ṹ��4��Ҫ��
�ܳ�ʼ������
��ѭ������ --- >��boolean����
��ѭ����
�ܵ�������

����do-whileѭ���ṹ:
��
do{
	��;
	��;
}while(��);

ִ�й���:�� - �� - �� - �� - �� - �� - ... -  ��

˵����
do-while������ִ��һ��ѭ����
�����У�ʹ��for��while���һЩ������ʹ��do-while


*/
class DoWhileTest 
{
	public static void main(String[] args) 
	{
		//����100���ڵ�ż��,����������ż���ĺͺ�ż���ĸ���
		int num = 1;
		int sum = 0;
		int count = 0;
		do
		{
			if (num % 2 == 0)
			{
				System.out.print(num + " ");
				sum += num;
				count ++;
			}
			num ++;
			
		}
		while (num <= 100);
		System.out.println();
		System.out.println("100��������ż���ĺ�Ϊ��" + sum);
		System.out.println("100����һ����" + count + "��ż��");
	}
}