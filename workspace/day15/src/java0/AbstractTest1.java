package java0;
/*
 * abstract使用上的注意点：
 * 1.abstract不能用来修饰：属性、构造器等结构
 * 
 * 2.abstract不能用来修饰私有方法、静态方法、final的方法、final的类
 */
public class AbstractTest1 {

}


abstract class Person1{

//	private abstract void show();	//报错
	
}

class Student extends Person1{
	private void show() {

	}

}
