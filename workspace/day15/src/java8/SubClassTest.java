package java8;

public class SubClassTest {
public static void main(String[] args) {
	SubClass s = new SubClass();
	
	//知识点一：接口中定义的静态方法，只能通过接口来调用。
//	s.method1();
	CompareA.method1();
	
	//知识点二：通过实现类的对象，可以调用接口中的默认方法
	//如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
	s.method2();
	/*
	 * 知识点三：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，
	 * 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。---> 类优先原则（针对与方法，属性还是要显示区分的）
	 * 
	 * 知识点四：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
	 * 那么在实现类没有重写此方法的情况下，报错。 --> 接口冲突。
	 * 这就需要我们必须在实现类中重写此方法
	 */
	s.method3();
	
	System.out.println("*******************************");
	
	s.myMethod();
}
}

class SubClass extends SupsubClass implements CompareA,CompareB{
	
	
	
	@Override
	public void method2() {
		System.out.println("SubClass:方法2");
	}

	@Override
	public void method3() {
		System.out.println("SubClass:方法3");
	}
	
	
	//知识点五：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
	public void myMethod(){
		method3();//调用自己定义的重写的方法
		super.method3();//调用的是父类中的声明的方法
		//调用接口中的默认方法
		CompareA.super.method3();
	}
}
