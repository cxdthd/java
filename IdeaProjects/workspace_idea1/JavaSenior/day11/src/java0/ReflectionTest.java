package java0;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author YANG
 * @create 2021-04-28 16:03
 */
public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p);
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);

        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("************************************");

        //通过反射，可以调用Person类的私有结构。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p1 =(Person) constructor1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Jerry1");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation =(String) showNation.invoke(p1, "中国");//相当于String nation = p1.showNation("中国")
        System.out.println(nation);
    }

    //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
    //建议：直接new的方式。
    //什么时候会使用：反射的方式。 反射的特征：动态性
    //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
//方式一：调用运行时类的属性：.class
Class<Person> personClass = Person.class;
System.out.println(personClass);    //class java0.Person
//方式二：通过运行时类的对象，调用getClass()方法
Person p1 = new Person();
Class aClass = p1.getClass();
System.out.println(aClass); //class java0.Person
//方式三：调用Class的静态方法：forName(String classPath)    ---常用
Class aClass1 = Class.forName("java0.Person");  //类的全类名
System.out.println(aClass1);    //class java0.Person

System.out.println(personClass == aClass);  //true
System.out.println(personClass == aClass1); //true

//方式四：使用类的加载器：ClassLoader   （了解）
ClassLoader classLoader = ReflectionTest.class.getClassLoader();
Class aClass2 = classLoader.loadClass("java0.Person");
System.out.println(aClass2);    //class java0.Person

    }

    //Class实例可以是哪些结构的说明
    @Test
    public void test4(){
Class c1 = Object.class;
Class c2 = Comparable.class;
Class c3 = String[].class;
Class c4 = int[][].class;
Class c5 = ElementType.class;
Class c6 = Override.class;
Class c7 = int.class;
Class c8 = void.class;
Class c9 = Class.class;
int[] a = new int[10];
int[] b = new int[100];
Class c10 = a.getClass();
Class c11 = b.getClass();
// 只要数组元素类型与维度一样，就是同一个Class
System.out.println(c10 == c11); //true
    }


}
