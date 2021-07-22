/*
String类型变量的使用
1.String属于引用数据类型，翻译为：字符串
2.声明String类型变量时，使用一对""
3.String可以和8种基本数据类型变量做运算，且运算只能是连接运算：+
*/

class StringTest 
{
	public static void main(String[] args) 
	{
		String s1 = "Hello World!";
		System.out.println(s1);

		String s2 = "a";
		String s3 = "";

		//char c = '';   //编译不通过

		//**********************************
		int number = 1001;
		String numberStr = "学号:";
		String info = numberStr + number;    //+:连接运算
		boolean b1 = true;
		String info1 = info + b1;
		System.out.println(info1);

		//*************************************
		//练习1
		char c = 'a';   //97	A:65
		int num = 10;
		String str= "hello";
		System.out.println(c + num + str);	//107hello
		System.out.println(c + str + num);	//ahello10
		System.out.println(c + (num + str));	//a10hello
		System.out.println((c + num) + str);	//107hello
		System.out.println(str + num + c);	//hello10a


		//练习2
		//*	*
		System.out.println("*	*");
		System.out.println('*' + '\t' + '*');	//93
		System.out.println('*' + "\t" + '*');
		System.out.println('*' + '\t' + "*");	//51*
		System.out.println('*' + ('\t' + "*"));


		//******************************************************
		
		//String定义的变量值要用""
		//String str1 = 4;
		String str2 = 3.5f + "";
		System.out.println(str2);	//3.5
		System.out.println("str2");	//str2


		short s = 5;
		//s - 2会自动转为int型
		//s = s - 2;

		byte b = 3;
		//b + 4会自动转为int型
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
		在java运算中，在涉及到数据类型范围小于int的（如byte，char，short）时，数据类型会自动提升为int类型，
		比如，两个byte类型的数据在进行运算时，运算结果就会变成int类型，如果要结果是byte类型的话，
		就要强转成byte类型，这是因为java编译器内部对其进行处理。
		*/

		//**************************************************
		//123为int型，无法自动转为String型
		//String str1 = 123;

		//int强转为String用: Integer.toString()
		//String str1 = (String)123;
		String str1 = Integer.toString(123);
		String str3 = "123";
		String str4 = 123 + "";
		System.out.println(str1);

		//int num1 = str1;
		//String无法强转为int型
		//int num1 = (int)str1;

		int num1 = Integer.parseInt(str1);
		System.out.println(num1);

	}
}
