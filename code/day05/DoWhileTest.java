/*
一、循环结构的4个要素
④初始化条件
②循环条件 --- >是boolean类型
③循环体
④迭代条件

二、do-while循环结构:
①
do{
	③;
	④;
}while(②);

执行过程:① - ③ - ④ - ② - ③ - ④ - ... -  ②

说明：
do-while会至少执行一次循环体
开发中，使用for和while会多一些，较少使用do-while


*/
class DoWhileTest 
{
	public static void main(String[] args) 
	{
		//遍历100以内的偶数,并计算所有偶数的和和偶数的个数
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
		System.out.println("100以内所有偶数的和为：" + sum);
		System.out.println("100以内一共有" + count + "个偶数");
	}
}
