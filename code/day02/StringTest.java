/*
String���ͱ�����ʹ��
1.String���������������ͣ�����Ϊ���ַ���
2.����String���ͱ���ʱ��ʹ��һ��""
3.String���Ժ�8�ֻ����������ͱ��������㣬������ֻ�����������㣺+
*/

class StringTest 
{
	public static void main(String[] args) 
	{
		String s1 = "Hello World!";
		System.out.println(s1);

		String s2 = "a";
		String s3 = "";

		//char c = '';   //���벻ͨ��

		//**********************************
		int number = 1001;
		String numberStr = "ѧ��:";
		String info = numberStr + number;    //+:��������
		boolean b1 = true;
		String info1 = info + b1;
		System.out.println(info1);

		//*************************************
		//��ϰ1
		char c = 'a';   //97	A:65
		int num = 10;
		String str= "hello";
		System.out.println(c + num + str);	//107hello
		System.out.println(c + str + num);	//ahello10
		System.out.println(c + (num + str));	//a10hello
		System.out.println((c + num) + str);	//107hello
		System.out.println(str + num + c);	//hello10a


		//��ϰ2
		//*	*
		System.out.println("*	*");
		System.out.println('*' + '\t' + '*');	//93
		System.out.println('*' + "\t" + '*');
		System.out.println('*' + '\t' + "*");	//51*
		System.out.println('*' + ('\t' + "*"));


		//******************************************************
		
		//String����ı���ֵҪ��""
		//String str1 = 4;
		String str2 = 3.5f + "";
		System.out.println(str2);	//3.5
		System.out.println("str2");	//str2


		short s = 5;
		//s - 2���Զ�תΪint��
		//s = s - 2;

		byte b = 3;
		//b + 4���Զ�תΪint��
		//b = b + 4;
		b = (byte)(b+4);
		System.out.println(b);

		char c1 = 'a';
		int i = 5;
		float f = .314f;
		double result = c1 + i +f;
		System.out.println(result);

		byte b2 = 5;
		short s4 = 3;
		//short t = s4 + s4;
		/*
		��java�����У����漰���������ͷ�ΧС��int�ģ���byte��char��short��ʱ���������ͻ��Զ�����Ϊint���ͣ�
		���磬����byte���͵������ڽ�������ʱ���������ͻ���int���ͣ����Ҫ�����byte���͵Ļ���
		��Ҫǿת��byte���ͣ�������Ϊjava�������ڲ�������д���
		*/

		//**************************************************
		//123Ϊint�ͣ��޷��Զ�תΪString��
		//String str1 = 123;

		//intǿתΪString��: Integer.toString()
		//String str1 = (String)123;
		String str1 = Integer.toString(123);
		String str3 = "123";
		String str4 = 123 + "";
		System.out.println(str1);

		//int num1 = str1;
		//String�޷�ǿתΪint��
		//int num1 = (int)str1;

		int num1 = Integer.parseInt(str1);
		System.out.println(num1);

	}
}
