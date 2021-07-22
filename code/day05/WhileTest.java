/*
While循环的使用

一、循环结构的4个要素
①初始化条件
②循环条件 --->是boolean类型
③循环体
④迭代条件

二、while循环的结构

①
while(②){ 
	③;
	④;
}

说明：
1.写while循环千万不要丢了迭代条件。一旦丢了，就可能导致死循环！
2.我们写程序，要避免出现死循环。
3.for循环和while循环是可以相互转化的。


算法：有限性

*/
class WhileTest 
{
	public static void main(String[] args) 
	{
		//遍历100以内的所有偶数
		int num = 1;
		while (num <= 100)
		{
			if (num % 2 == 0)
			{
				System.out.print(num + " ");
			}
			num ++;
		}

		//出了while循环仍可以调用
		System.out.println(num);	//101
	}
}
