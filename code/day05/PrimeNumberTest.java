/*
100以内所有质数的输出
质数：素数，只能被1和它本身整除的自然数。 -->从2开始，到这个数-1结束为止，都不能被这个数本身整除。

*/
class PrimeNumberTest 
{
	public static void main(String[] args) 
	{
		//方法一
		int count = 0;
		for (int i = 2;i <= 100 ;i++ )
		{
			for (int yinShu = 2;yinShu < i ; yinShu++)
			{
				if (i % yinShu == 0)
				{
					count++;	
				}
			}
			if (count == 0)
			{
				System.out.print(i + "  ");
			}
			count = 0;
		}

		System.out.println("\n");
		//方法二
		

		for(int i = 2;i <= 100;i++){//遍历100以内的自然数
			
		boolean isFlag = true;//标识i是否被j除尽，一旦除尽，修改其值
			for(int j = 2;j < i;j++){//j:被i去除
				
				if(i % j == 0){ //i被j除尽
					isFlag = false;
				}
				
			}
			//
			if(isFlag == true){
				System.out.println(i);
			}
			//重置isFlag
			//isFlag = true;
			}
	}
}
