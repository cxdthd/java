/*
Whileѭ����ʹ��

һ��ѭ���ṹ��4��Ҫ��
�ٳ�ʼ������
��ѭ������ --->��boolean����
��ѭ����
�ܵ�������

����whileѭ���Ľṹ

��
while(��){ 
	��;
	��;
}

˵����
1.дwhileѭ��ǧ��Ҫ���˵���������һ�����ˣ��Ϳ��ܵ�����ѭ����
2.����д����Ҫ���������ѭ����
3.forѭ����whileѭ���ǿ����໥ת���ġ�


�㷨��������

*/
class WhileTest 
{
	public static void main(String[] args) 
	{
		//����100���ڵ�����ż��
		int num = 1;
		while (num <= 100)
		{
			if (num % 2 == 0)
			{
				System.out.print(num + " ");
			}
			num ++;
		}

		//����whileѭ���Կ��Ե���
		System.out.println(num);	//101
	}
}