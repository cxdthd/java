package java8;
/*
 * JDK8:除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
public interface CompareA {
	
	//接口中的静态方法有点类似与工具类
	//静态方法
	public static void method1(){
		System.out.println("CompareA:静态方法1");
	}
	
	//默认方法
	public default void method2(){
		System.out.println("CompareA:默认方法2");
	}
	
	default void method3(){
		System.out.println("CompareA:默认方法3");
	}
	
}
