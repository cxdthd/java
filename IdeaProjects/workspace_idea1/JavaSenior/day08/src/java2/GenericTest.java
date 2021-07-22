package java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 *
 *
 * 2. 通配符的使用
 *
 *
 * @author YANG
 * @create 2021-04-11 16:48
 */
public class GenericTest {
    /*
    1. 泛型在继承方面的体现

    虽然类A时类B的父类，但是G<A>和G<B>两者不具备子父类关系，二者是并列关系。

        补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;  //因为String类继承于Object类，所有可以直接赋值

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
//        list1 = list2;  //与下面错误信息一样

//        Date date = new Date();
//        str = date;
        /*
        反证法：
        假设list1 = list2;
            list1.add(123); 导致混入非String的数据，出错。
         */

        show(list1);
        show1(list2);

    }

    public void show(List<Object> list){
    }
    public void show1(List<String> list){
    }


    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

        //类似于：
        List<String> list = new ArrayList<>();

    }





    /*
    2. 通配符的使用
        通配符：?

        类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        //此时的list就相当于list1和list2的通用父类
        list = list1;
        list = list2;

        print(list1);
        print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list3.add("AA");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外
//        list.add();
        list.add(null); //因为add里只能加对象，而null是任何对象的默认值

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);

    }

    //一个通用方法遍历集和
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }



    /*
    3. 有限制条件的通配符的使用
        ? extends Person:
        ? super Person:

     */
    @Test
    public void test4(){

List<? extends Person> list1 = null;
List<? super Person> list2 = null;

List<Student> list3 = null;
List<Person> list4 = null;
List<Object> list5 = null;

list1 = list3;
list1 = list4;
//        list1 = list5;

//        list2 = list3;
list2 = list4;
list2 = list5;

//读取数据：
list1 = list3;
Person person = list1.get(0);
//编译不通过
//Student s = list1.get(1);

list2 = list4;
Object object = list2.get(0);
//编译不通过
//Person obj = list2.get(0);

//写入数据：
//编译不通过
//list1.add(new Student());
//list1.add(new Object());

//编译通过
list2.add(new Person());
list2.add(new Student());

    }

}
