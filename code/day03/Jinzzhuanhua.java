/*
将60转换成十六进制的3c
*/
class Jinzzhuanhua 
{
	public static void main(String[] args) 
	{
		//方式一：自动实现
		String str1 = Integer.toBinaryString(60);
		String str2 = Integer.toHexString(60);
		System.out.println(str1);
		System.out.println(str2);


		//方式二：手动实现
		int i1 = 60;	//定义一个整形变量60
		int i2 = i1&15;	//将60的二进制的最后四位和15(1111)取都为1的部分，&位运算为1&1的结果才为1
		//这里注意(char)转换成char型后要再加个 "" 转换成String型，不然编译没办法通过
		String Str1 = (i2 > 9)? (char)(i2 - 10 + 'A') + "" : i2 + "";	//将取出的部分和9作比较，大于9则先减去10再加上十六进制的A
		int i3 = i1 >> 4;	//将60的二进制向后移动4位
		int i4 = i3&15;
		String Str2 = (i4 > 9)? (char)(i4 - 10 + 'A') + "" : i4 + "";
		System.out.println(Str2 + Str1);
	}
}
