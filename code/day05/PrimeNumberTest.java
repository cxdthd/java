/*
100�����������������
������������ֻ�ܱ�1����������������Ȼ���� -->��2��ʼ���������-1����Ϊֹ�������ܱ����������������

*/
class PrimeNumberTest 
{
	public static void main(String[] args) 
	{
		//����һ
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
		//������
		

		for(int i = 2;i <= 100;i++){//����100���ڵ���Ȼ��
			
		boolean isFlag = true;//��ʶi�Ƿ�j������һ���������޸���ֵ
			for(int j = 2;j < i;j++){//j:��iȥ��
				
				if(i % j == 0){ //i��j����
					isFlag = false;
				}
				
			}
			//
			if(isFlag == true){
				System.out.println(i);
			}
			//����isFlag
			//isFlag = true;
			}
	}
}