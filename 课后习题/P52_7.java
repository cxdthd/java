class P52_7 
{
	public static void main(String[] args) 
	{
		int temp = 1;
		int sum = 0;
		for (int i = 1;i <= 10 ;i++ )
		{
			temp *= i;
			//System.out.print(i+ " " + temp + "\n");
			sum += temp;
			//System.out.println("sum " + sum);
			if (sum > 9876)
			{
				System.out.println("����1 + 2��+3��+ ... + n! <= 9876 ���������n����  " + (i-1));
				break;
			}
		}
		
	}
}
