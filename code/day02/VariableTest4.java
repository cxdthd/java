class VariableTest4 
{
	public static void main(String[] args) 
	{
		//1.编码情况1：
		long l = 123456;
		System.out.println(l);
		//编译失败：过大的整数
		//long l1 = 12345678912345;
		long l1 = 12345678912345l;

		//***********************************
		//编译失败
		//float f1 = 12.3;

		//2.编译情况2：
		//整型常量，默认类型为int型
		//浮点型常量，默认类型为double型
		byte b = 12;
		//byte b1 = b + 1;   //编译失败

		//float f1 = b + 12.3;    //编译失败
		double d1 = b + 12.3;

		String s = '';

	}
}
