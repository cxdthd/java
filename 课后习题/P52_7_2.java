class P52_7_2 
{
	public static void main(String[] args) 
	{
		for (int i = 1;i < 1000 ;i++ )
		{
			int factor = 0;
			for (int j = 1;j <= i/2 ;j++ )
			{
				if (i % j == 0)
				{
					factor += j;
				}
			}
			if (factor == i)
			{
				System.out.println(i);
			}
		}
	}
}
