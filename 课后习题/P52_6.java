class P52_6 
{
	public static void main(String[] args) 
	{
		int sum = 0;
		for (int i = 1;i <= 1000 ;i++ )
		{
			for (int yinShu = i - 1; yinShu >= 1;yinShu-- )
			{
				if (i % yinShu == 0)
				{
					//System.out.println(i + "的因数有" + yinShu);
					sum += yinShu;
				}
			}
			//System.out.println(i + "的因数和为" + sum);
			if (sum == i)
			{
				System.out.println(i + "是完数");
			}
			sum = 0;

		}
	}
}
