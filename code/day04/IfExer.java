class IfExer 
{
	public static void main(String[] args) 
	{
		int x = 4;
		int y = 3;
		if (x > 2)
		
			if (y > 4)
			
				System.out.println("1111");
				//System.out.println("2222");
		
		else	//就近原则
		System.out.println("3333");


		//练习：如何获取一个随机数
		int value = (int)(Math.random() * 90 + 10);	// [0.0,1.0) --> [0.0,90.0) --> [10.0,100.0) -->[10,99]
		System.out.println(value);

		//公式：[a,b]	:	(int)(Math.random() * (b - a + 1) + a)
	}
}
