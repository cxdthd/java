package myPackage;

/*
 * 面试题：排除
 */

interface A{
	int x = 0;
}

class B{
	int x = 1;
}

public class C extends B implements A{
	public void pX(){
		//x是不明确的
//		System.out.println(x);//The field x is ambiguous
		
		
		/*
		 * super调用父类中的
		 * 接口中的属性为全局常量，所有可以直接接口名调用
		 * 
		 */
		System.out.println(super.x);//1
		System.out.println(A.x);//0
	}
	
	public static void main(String[] args) {
		new C().pX();
	}
}
