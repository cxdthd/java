/*
分支结构之二：switch-case

1.格式
switch(表达式){
case 常量1:
	执行语句1;
	//break;	

case 常量2:
	执行语句2;
	//break

...

default:
	执行语句n;
	//break;

说明：
   ①根据switch表达式中的值，依次匹配各个case中的常量。一旦匹配成功，则进入相应case结构中，调用其执行语句。
	当调用完执行语句以后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字或此switch-case结构
	末尾为止结束。

   ②break,可以使用在switch-case结构中，表示一旦执行到此关键字，就跳出switch-case结构

   ③switch结构中的表达式，只能是如下的6种数据类型之一: byte 、short、 char、 int、 枚举类型、String类型

   ④case之后只能声明常量，不能声明范围。因为定义范围结果为boolean型

   ⑤break关键字是可选的

   ⑥default相当于if-else里的else
    default是可选的，而且位置是灵活的
}

*/
class SwitchCaseTest
{
	public static void main (String[] args)
		{
			int num = 1;
			switch (num)
			{
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("tow");
				break;
			case 3:
				System.out.println("three");
				break;
			default:
				System.out.println("other");

			}
			
	}
}