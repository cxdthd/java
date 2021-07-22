package java2;

import java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author YANG
 * @create 2021-05-07 11:14
 */
public class MethodTest {

    @Test
    public void test1() {
        Class clazz = Person.class;

        //getMethods()：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /*
    @Xxxx
    权限修饰符  返回值类型  方法名(参数类型1 形参名1,...) throws XxxException{}
     */
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //1.获取方法注解信息
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }

            //2.获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.获取返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.获取方法名
            System.out.print(m.getName());

            //5.获取形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i] + "\targs_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i] + "\targs_" + i + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes.length > 0){
                System.out.print("throws ");
                for (int i = 0;i < exceptionTypes.length;i++){
                    if (i == exceptionTypes.length -1){
                        System.out.print(exceptionTypes[i]);
                        break;
                    }

                    System.out.print(exceptionTypes[i] + ",");
                }
            }


            System.out.println();
        }


    }
}