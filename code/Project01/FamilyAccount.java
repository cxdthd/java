class FamilyAccount 
{
	public static void main(String[] args) 
	{
		boolean isFlag = true;
		//���ڼ�¼�û��������֧��������
		String details = "��֧\t�˻����\t��֧���\t˵��\n";
		//�����ʼ���
		int balance = 10000;
		while (isFlag)
		{
			System.out.println("--------------------��ͥ��֧��������--------------------\n");
			System.out.println("                      1  ��֧��ϸ");
			System.out.println("                      2  �Ǽ�����");
			System.out.println("                      3  �Ǽ�֧��");
			System.out.println("                      4  ��    ��\n");
			System.out.print("                      ������<1-4>: ");
			//��ȡ�û���ѡ��1-4
			char selection = Utility.readMenuSelection();

			switch (selection)
			{
			case '1':
				//System.out.println("1 ��֧��ϸ");
				System.out.println("--------------------��ǰ��֧��ϸ��¼--------------------\n");
				System.out.println(details);
				System.out.println("--------------------------------------------------------\n");
				break;
			case '2':
				//System.out.println("2 �Ǽ�����");
				System.out.print("���������");
				int money = Utility.readNumber();
				System.out.print("��������˵����");
				String info = Utility.readString();

				//����balance
				balance += money;
				
				//����details
				details += ("����\t" + balance + "\t\t" + money + "\t\t" + info + "\n");

				System.out.println("------------------------�Ǽ����------------------------\n");
				break;
			case '3':
				//System.out.println("3 �Ǽ�֧��");
				System.out.print("����֧����");
				int money1 = Utility.readNumber();
				

				//����balance
				if (money1 <= balance)
				{
					balance -= money1;
				} else 
				{
					System.out.println("����");
					break;
				}

				System.out.print("����֧��˵����");
				String info1 = Utility.readString();
				
				
				//����details
				details += ("֧��\t" + balance + "\t\t" + money1 + "\t\t" + info1 + "\n");

				System.out.println("------------------------�Ǽ����------------------------\n");
				break;
			case '4':
				//System.out.println("4 ��    ��");
				System.out.print("ȷ���Ƿ��˳�<Y/N>: ");
				char isExit = Utility.readConfirmSelection();
				if (isExit == 'Y')
				{
					isFlag = false;
				}
				
			
			}
			
		}
	}
}