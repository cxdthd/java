/*
练习：随意给出一个三位数的整数，打印显示它的个位数，十位数，百位数的值。
格式如下：
数字xxx的情况如下：
个位数：
十位数：
百位数：

例如：
数字153的情况如下：
个位数：3
十位数：5
百位数：1


*/
class AriExer 
{
	public static void main(String[] args) 
	{
		int num = 123;
		int bai = num / 100;
		System.out.println("百位数：" + bai);
		int baiyu = num % 100;
		int shi = baiyu / 10;
		System.out.println("十位数：" + shi);
		int ge = baiyu % 10;
		System.out.println("个位数：" + ge);


		//练习1
		int i = 1;
		i *= 0.1;
		System.out.println(i);	//0
		i++;
		System.out.println(i);	//1

		//练习2
		int m = 2;
		int n = 3;
		n *= m++;		//n = n * m++;
		System.out.println("m = " + m);		//3
		System.out.println("n = " + n);		//6
		
		//练习3
		int n1 = 10;
		n1 += (n1++) + (++n1);	//n1 = n1 + (n1++) + (++n1);    10 + 10 + 12
		System.out.println(n1);		//32




		//**************************************************
		
		//例题1
		int x = 1;
		int y = 1;
		if (x++==2 & ++y==2)	//false & true
		{
			x = 7;
		}
		System.out.println("x=" + x + ",y=" + y);	//x=2,y=2

		//例题2
		int x1 = 1,y1 = 1;
		if (x1++==2 && ++y1==2)	//false
		{
			x1 = 7;
		}
		System.out.println("x1=" + x1 + ",y1=" + y1);	//x1=2,y1=1

		//例题3
		int x2 = 1,y2 = 1;
		if(x2++==1 | ++y2==1)	//true | false
		{
			x2 = 7;
		}
		System.out.println("x2=" + x2 + ",y2=" + y2);	//x2=7,y1=2

		//例题4
		int x3 = 1,y3 = 1;
		if (x3++==1 || ++y3==1)
		{
			x3 = 7;
		}
		System.out.println("x3=" + x3 + ",y3=" + y3);	//x3=7,y3=1


	}
}
