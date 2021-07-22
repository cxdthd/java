/*
运算符之四：逻辑运算符

1.逻辑运算符操作的都是boolean类型的变量

*/
class LogicTest 
{
	public static void main(String[] args) 
	{
		//区分	逻辑与&	与	短路与&&
		//相同点1：& 与 && 的运算结果相同
		//相同点2：当符号左边是true时，两者都会执行符号右边的运算
		//不同点：当符号左边是false时，& 会继续执行符号右边的运算。 && 不会再执行符号右边的运算。
		//开发中，推荐使用 &&
		boolean b1 = true;
		b1 = false;
		int num1 = 10;
		if(b1 & (num1++ > 0)){
			System.out.println("我现在在北京");
		}else{
			System.out.println("我现在在南京");
			}

		System.out.println("num1 = " + num1);

		boolean b2 = true;
		b2 = false;
		int num2 = 10;
		if(b2 && (num2++ > 0)){
			System.out.println("我现在在北京");
		}else{
			System.out.println("我现在在南京");
			}

		System.out.println("num2 = " + num2);

		boolean b3 = true;
		b3 = false;
		int num3 = 10;
		if((num3++ > 0) && b3){
			System.out.println("我现在在北京");
		}else{
			System.out.println("我现在在南京");
			}

		System.out.println("num3 = " + num3);
	}
}
