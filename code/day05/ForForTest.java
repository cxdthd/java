/*
Ƕ��ѭ����ʹ��
1.Ƕ��ѭ��:��һ��ѭ���ṹA��������һ��ѭ���ṹB��ѭ�����У��͹�����Ƕ��ѭ��
2.
���ѭ��:ѭ���ṹB
�ڲ�ѭ��:ѭ���ṹA

3.˵��
���ڲ�ѭ���ṹ����һ�飬ֻ�൱�����ѭ��ѭ����ִ����һ��
D�������ѭ����Ҫִ��m�Σ��ڲ�ѭ����Ҫִ��n�Ρ���ʱ�ڲ�ѭ����ѭ����һ��ִ����m*n��

*/


class ForForTest 
{
	public static void main(String[] args) 
	{
		//******
		//System.out.println("******");
		for (int i = 0;i < 6 ;i++ )
		{
			System.out.print('*');
		}

		/*
		*****
		*****
		*****
		*****
		*/
		for (int i = 1;i < 5 ;i++ )
		{
			System.out.println();
			for (int j = 0;j < 7 ;j++ )
			{
				System.out.print('*');
			}
		}
		System.out.println("\n");

		/*
		*
		**
		***
		****
		*****
		*/
		for (int i = 0;i < 5 ;i ++ )
		{
			for (int j = 0;j <= i ;j++ )
			{
				System.out.print('*');
			}
			System.out.println();
		}


		/*				i(����)		j(*�ĸ���)			���ɣ�i + j =6  ���仰˵��j = 6 - i
		*****			1			5
		****			2			4
		***				3			3
		**				4			2
		*				5			1
		*/
		for (int i = 0;i < 5 ;i++ )
		{
			for (int j = 0 ;j < 5 - i ;j++ )
			{
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println("\n");

		/*					i(����)			j(- �ĸ���)			k(* �ĸ���)		j = 5 - i		k = i
		    *				1				4					1
		   * *				2				3					2
		  * * *				3				2					3
		 * * * *			4				1					4
		* * * * *			5				0					5
		 * * * *			1				1					4
		  * * *				2				2					3
		   * *				3				3					2
		    *				4				4					1				j = i		k = 5 - i
		*/
		
		//�ϰ벿��
		for (int i = 1;i <= 5 ;i++ )
		{
			for (int j = 1 ;j <= 5 - i ;j++ )
			{
				System.out.print(" ");
			}
			for (int k = 1 ;k <= i  ;k++ )
				{
					System.out.print('*');
					System.out.print(" ");
				}
			System.out.println();
		}


		//�°벿��
		for (int i = 1;i <= 4 ;i++ )
		{
			for (int j = 1;j <= i ;j++ )
			{
				System.out.print(" ");
			}
			for (int k = 1;k <= 5 - i ;k++ )
			{
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}
