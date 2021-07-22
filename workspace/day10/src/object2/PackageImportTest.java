package object2;

import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.*;

import exer4.Account;
import exer4.Bank;
import exer4.Customer;
//import object2.object3.Dog;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 * 一、package关键字的使用
 * 1.为了更好的实现项目中类的管理，提供包的概念
 * 2.使用package声明类或接口所属的包，声明在源文件的首行
 * 3.包，属于标识符，遵循标识符的命名规则、规范(xxxyyyzzz)、“见名知意”
 * 4.每"."一次，就代表一层文件目录。
 * 
 * 补充：同一个包下，不能命名同名的接口、类。
 * 		不同的包下，可以命名同名的接口、类。
 * 
 * 
 * 二、import关键字的使用
 * import：导入
 * 1.在源文件中显式的使用import结构导入指定包下的类、接口
 * 2.声明在包的声明和类的声明之间
 * 3.如果需要导入多个结构，则并列写出即可
 * 4.可以使用"xxx.*"的方式，表示可以导入xxx包下的所有结构
 * 5.如果使用的类或接口是java.lang包下定义的，则可以省略import结构，例如：String[]、System
 * 6.如果使用的类或接口是本包下定义的，则可以省略import结构
 * 7.如果在源文件中，使用了不同包下的同名的类，则必须至少有一个类需要以全名类的方式显示。
 * 8.使用"xxx.*" 方式表明可以调用xxx包下的所有结构。但是如果使用的是xxx子包下的结构，则仍需要显式调用。
 * 
 * 
 * 9.import static：导入指定类或接口中的静态结构：属性或方法。
 * 		只用import时，落脚点只需到类或接口就行。
 */
public class PackageImportTest {
	public static void main(String[] args) {
		java.lang.String info = Arrays.toString(new int[] { 1, 2, 3, 4, 5 });
		java.lang.System.out.println(info);
		System.out.println(Arrays.toString(new int[] { 1, 2, 3, 4, 5 }));

		Bank bank = new Bank();

		Customer cust = new Customer("1", "1");
		// Object1.Customer cust1 = new Customer();

		java.util.ArrayList a = new ArrayList();

		Account acc = new Account(1000);
		// 全类名，对于有同名的类都需要调用时，就需要用全类名的方式
		exer3.Account acc1 = new exer3.Account(1000, 2000, 0.0123);

		Date date = new Date();
		java.sql.Date date1 = new java.sql.Date(1);

		// 对于当前包的子包，还是需要调用
		object2.object3.Dog dog = new object2.object3.Dog();

		// 对于long包下的子包也是需要调用
		Field field = null;

		// System是类，前面导入后便可以在这里删掉
		out.println("**********************");
		double aaa = round(14.44);
		out.println(aaa);
	}
}
