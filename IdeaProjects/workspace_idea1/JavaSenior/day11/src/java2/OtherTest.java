package java2;

import java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @author YANG
 * @create 2021-05-07 14:07
 */
public class OtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors()：获取当前运行时类中所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c:declaredConstructors){
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    /*
    获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    /*
    获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test4(){
Class<Person> clazz = Person.class;
Type genericSuperclass = clazz.getGenericSuperclass();
ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
//getActualTypeArguments()：获取泛型的类型
Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//只有转成Class类型才可以调用getName()方法
//        System.out.println(((Class)actualTypeArguments[0]).getName());
System.out.println(actualTypeArguments[0].getTypeName());   //java.lang.String
    }

    /*
    获取运行时类所实现的接口
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c.getName());
        }

        System.out.println();
        //获取运行时类父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1){
            System.out.println(c.getName());
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage.getName());
    }
    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7(){
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }
    }
}

