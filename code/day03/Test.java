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
		//不加花括号时if条件作用域是第一条语句，这个一条指的是第一个分号之前的语句，Java中以分号；作为一条语句的结束。

		int i = 3<<2;
		System.out.println(i);	//12
	}
}
