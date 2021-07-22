package java0;

import java.util.Date;

/*
 * 面向对象特征之三：多态性
 * 
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 * 		对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 * 
 * 3. 多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
 * 		总结：编译，看左边；运行，看右边。
 * 
 * 4.多态性的使用前提：	① 类的继承关系	② 方法的重写
 * 
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
 * 
 * ******************************************************************************
 */
public class PersonTest {
	public static void main(String[] args) {

		Person p1 = new Person();
		p1.eat();

		Man man = new Man();
		man.eat();
		man.age = 25;
		man.earnMoney();

		System.out.println("***************************************");
		// ********************************************
		// 对象的多态性：父类的引用指向子类的对象
		Person p2 = new Man();
		// 多态的使用，当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法---虚拟方法调用
		p2.eat();
		p2.walk();

		System.out.println(p2.id); // 1001

		Person p3 = new Woman();

		System.out.println("***********************************************");

		// 父类无法调用子类所特有的方法、属性，编译时，p2是Person类型
		// p2.earnMoney();

		// 有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致
		// 编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。

		// 如何才能调用子类特有的属性和方法？
		// 向下转型：使用强制类型转换符。
Man m1 = (Man) p2;
m1.earnMoney();
		m1.isSmoking = true;

		// 使用强转时，可能出现ClassCastException的异常。
		// Woman w1 = (Woman)p2;
		// w1.goshopping();

		/*
		 * instanceof关键字的使用
		 * 
		 * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
		 * 
		 * 
		 * 使用情景：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先进行instanceof的判断，一旦
		 * 返回true，我们就向下转型。如果返回false，不进行向下转型。
		 * 
		 * 如果a instanceof A返回true，且类B时类A的父类，则a instanceof B也返回true。
		 */
if (p2 instanceof Woman) { // false
	Woman w1 = (Woman) p2;
	w1.goshopping();
	System.out.println("*******Woman*******");
}
		if (p2 instanceof Man) { // true
			Man m2 = (Man) p2;
			m2.earnMoney();
			System.out.println("*******Man*******");
		}
		if (p2 instanceof Person) { // true
			System.out.println("*******Person*******");
		}
		if (p2 instanceof Object) { // true
			System.out.println("*******Object*******");
		}

		// 练习
		// 问题一：编译时通过，运行时不通过
		// 举例一
		// Person p4 = new Woman();
		// Man m4 = (Man)p4;
		// 举例二
		// Person p5 = new Person();
		// Man m5 = (Man)p5;

		// 问题二：编译通过，运行时也通过
		// Object obj = new Woman();
		// Person p = (Person)obj;

		// 问题三：编译不通过
		// Man m6 = new Woman();
		// 骗过编译器
		// Person p6 = new Woman();
		// Man m6 = (Man)p6;

		// String str = new Date();
		// 骗过编译器
		// Object o = new Date();
		// String str1 = (String)o;
		
		//************************************************
		Person pp = new Man();
		Person pp1 = new Person();
		System.out.println(pp.toString());	//java0.Man@15db9742
		System.out.println(pp1.toString());	//java0.Person@6d06d69c
		Man ppp = (Man)pp;
		System.out.println(ppp);	//java0.Man@15db9742

	}
}
