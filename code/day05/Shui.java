/*
������е�ˮ�ɻ�������νˮ�ɻ�����ָһ��3λ���������λ�����������͵����䱾��
����: 153= 1*1*1 + 3*3*3 + 5*5*5

*/
class  Shui
{
	public static void main(String[] args) 
	{
		for (int i = 100; i < 1000 ; i++)
		{
			int bai = i / 100;
			int shi = i / 10 % 10;
			int ge = i % 10;
			if (i == bai * bai * bai + shi * shi * shi + ge * ge * ge )
			{
				System.out.println(i);
			}
		}
	}
}
