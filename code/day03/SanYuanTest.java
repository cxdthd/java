/*
�����֮������Ԫ�����
1.�ṹ��(��������ʽ)? ����ʽ1 : ����ʽ2
2.˵��
	�� ��������ʽ�Ľ��Ϊboolean����
	�� ������������ʽ���٣�����ִ�б���ʽ1�����Ǳ���ʽ2.
	  �������ʽΪtrue����ִ�б���ʽ1.
	  �������ʽΪfalse����ִ�б���ʽ2.
	�� ����ʽ1 �ͱ���ʽ2 Ҫ����һ�µġ�
	�� ��Ԫ���������Ƕ��ʹ��

3.���ǿ���ʹ����Ԫ������ĵط������Ը�д��if - else
  ��֮����һ������

4.�������ȿ���ʹ����Ԫ��������ֿ���ʹ��if-else�ṹ����ô����ѡ����Ԫ�������ԭ��:��ࡢִ��Ч�ʸߡ�

*/
class SanYuanTest 
{
	public static void main(String[] args) 
	{
		//��ȡ���������Ľϴ�ֵ
		int m = 12;
		int n = 5;
		int max = (m > n) ? m : n;
		System.out.println(max);

		double num = (m > n)? 2 : 1.0;

		//(m > n)? 2 : "n��"��	//�������

		//*******************************************
		m = 5;
		String maxStr = (m > n)? "m��" : (m == n)? "m��n���" : "n��";
		System.out.println(maxStr);

		//*********************************************
		//��ȡ�������Ľϴ�ֵ
		int i1 = 12;
		int i2 = 42;
		int i3 = 34;

		int max1 = (i1 > i2)? i1 : i2;
		int max2 = (max1 > i3)? max1 : i3;
		//�ɶ��Եͣ����Ƽ�ʹ��
		//int max2 = (i1 > i2)? ((i1 >i3)? i1 : i3) : ((i2 > i3)? i2 : i3);
		System.out.println(max2);

		//******************************************
		m = 13;
		if (m > n)
		{
			System.out.println(m);
		}else {
			System.out.println(n);
		}



	}
}