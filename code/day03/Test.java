class Test 
{
	public static void main(String[] args) 
	{
		boolean x = true;
		boolean y = false;
		short z = 42;
		//if(y == true);
		if((z++==42)&&(y=true))z++;
		if((x=false)||(++z==45))z++;

		System.out.println("z=" + z);	//z=46
		//���ӻ�����ʱif�����������ǵ�һ����䣬���һ��ָ���ǵ�һ���ֺ�֮ǰ����䣬Java���Էֺţ���Ϊһ�����Ľ�����

		int i = 3<<2;
		System.out.println(i);	//12
	}
}