/*
��60ת����ʮ�����Ƶ�3c
*/
class Jinzzhuanhua 
{
	public static void main(String[] args) 
	{
		//��ʽһ���Զ�ʵ��
		String str1 = Integer.toBinaryString(60);
		String str2 = Integer.toHexString(60);
		System.out.println(str1);
		System.out.println(str2);


		//��ʽ�����ֶ�ʵ��
		int i1 = 60;	//����һ�����α���60
		int i2 = i1&15;	//��60�Ķ����Ƶ������λ��15(1111)ȡ��Ϊ1�Ĳ��֣�&λ����Ϊ1&1�Ľ����Ϊ1
		//����ע��(char)ת����char�ͺ�Ҫ�ټӸ� "" ת����String�ͣ���Ȼ����û�취ͨ��
		String Str1 = (i2 > 9)? (char)(i2 - 10 + 'A') + "" : i2 + "";	//��ȡ���Ĳ��ֺ�9���Ƚϣ�����9���ȼ�ȥ10�ټ���ʮ�����Ƶ�A
		int i3 = i1 >> 4;	//��60�Ķ���������ƶ�4λ
		int i4 = i3&15;
		String Str2 = (i4 > 9)? (char)(i4 - 10 + 'A') + "" : i4 + "";
		System.out.println(Str2 + Str1);
	}
}