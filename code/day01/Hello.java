/*
对第一个java程序进行总结
1.java程序编写-编译-运行的过程
编写：我们将编写的java代码保存在以".java"结尾的源文件中
编译：使用javac.exe命令编译我们的源文件。格式：javac 源文件名.java
运行：使用java.exe命令解释运行我们的字节码文件。格式：java 类名

2.
在一个java源文件中可以声明多个class。但是，只能最多有一个类声明为public的。
而且要求声明为public的类的类名必须与源文件名相同。

3.程序的入口是main()方法。格式是固定的。

4.输出语句：
System.out.println():先输出数据，然后换行
System.out.print():只输出数据

5.每一个执行语句都以";"结尾。

6.编译的过程：编译以后，会生成一个或多个字节码文件。字节码文件的文件名与java源文件的类名相同。
*/
public class Hello 
{
	//args是arguments的缩写，代表参数的意思。可以改成其他变量，例如：a
	//[]的位置可以放到String后面,也可以放到变量名后面

	//public static void main(String a[]) 
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		System.out.println();//换行
	}
}

class Person
{

}

class Animal
{

}