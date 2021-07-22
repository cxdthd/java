package java3;
/*
 * final:最终的
 * 
 * 1.fianl可以用来修饰的结构：类、方法、变量
 * 
 * 2.final用来修饰一个类:此类不能被其他类所继承。
 * 			比如：String类、System类、StringBuffer类
 * 
 * 3. final 用来修饰方法：表明此方法不可以被重写
 * 			比如：Object类中getClass();
 * 
 * 4. final 用来修饰变量，此时的"变量"就称为是一个常量
 * 		4.1 final修饰属性，可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
 * 		4.2 final修饰局部变量：
 * 			尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参一个实参。一旦赋值以后，
 * 			就只能在方法体内使用此形参，但不能进行重新赋值。
 * 
 * static final 用来修饰属性：全局常量
 */
public class FinalTest {
	
	//常量一般用大写字母表示，ctrl+shift+X
	final int WIDTH = 0;
	final int LEFT;
	final int RIGHT;
	
	{
		LEFT = 1;
	}
	
	public FinalTest(){
		RIGHT = 2;
	}
	
	public FinalTest(int n){
		RIGHT = n;
	}
	
	
	
	public void doWidth(){
//		width = 20;
	}
	
	public void show(){
		final int SUM = 20;//常量
//		SUM =+ 20;
	}

	public void show(final int sum){
		//sum = 20;//编译不通过
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		FinalTest test = new FinalTest();
		test.show(10);
	}
}

final class FinalA{
	
}

//The type FinalB cannot subclass the final class FinalA
//class FinalB extends FinalA{
//	
//}

//The type B cannot subclass the final class String
//class B extends String{
//	
//}


class AA{
	public final void show(){
		
	}
}

class BB extends AA{
//	@Override
//	public void show() {
//
//	}
}
