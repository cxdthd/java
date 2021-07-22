package java2;

import java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author YANG
 * @create 2021-05-07 15:17
 */
public class ReflectionTest {

    /*
    有缺陷
     */
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p =(Person) clazz.newInstance();

        //获取指定的属性：要求运行时类中的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值

        set()：参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
         */
        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);

    }

    /*
    如何操作运行时类中指定的属性 ---> 需要掌握
     */
    @Test
    public void test2() throws Exception{
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //1.getDeclaredField(String fieldName)：获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.setAccessible(true)：保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的此属性值
//        set()：参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
        name.set(p,"Tom");

        //get():参数1：获取哪个对象的当前属性值
        String pName = (String) name.get(p);
        System.out.println(pName);
    }

    /*
    如何操作运行时类中指定的方法 ---> 需要掌握
     */
    @Test
    public void test3() throws Exception{

Class<Person> clazz = Person.class;

Person p = clazz.newInstance();
/*
1.获取指定的某个方法
getDeclaredMethod()：参数1：指明获取的方法的名称  参数2：指明获取的方法的形参列表
 */
Method show = clazz.getDeclaredMethod("show", String.class);
//2.保证当前方法是可访问的
show.setAccessible(true);

/*
3.调用invoke()：参数1：方法的调用者   参数2：给方法形参赋值的实参
invoke()的返回值即为对应类中调用的方法的返回值。
 */
Object chn = show.invoke(p, "CHN");
System.out.println(chn);

System.out.println("**************如何调用静态方法？***************");
//private static void staticMethod()
Method staticMethod = clazz.getDeclaredMethod("staticMethod");
staticMethod.setAccessible(true);
//        Object invoke = staticMethod.invoke(null);
Object invoke = staticMethod.invoke(Person.class);
//如果调用的运行时类中的方法没有返回值，则此invoke()返回null
System.out.println(invoke); //null
    }

    /*
    如何调用运行时类中指定的构造器
     */
    @Test
    public void test4() throws Exception{
        Class<Person> clazz = Person.class;

        /*
        1.获取指定的构造器
        getDeclaredConstructor()：参数：指明构造器的参数列表
         */
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可以访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person p = constructor.newInstance("Tom");

        System.out.println(p);


    }

    @Test
    public void test(){
        System.out.println((int)0x1.0p3);
    }
}
