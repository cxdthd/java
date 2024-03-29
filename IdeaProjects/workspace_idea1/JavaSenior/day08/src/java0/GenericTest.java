package java0;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *  总结：
 *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *    比如：add(E e)  --->实例化以后：add(Integer e)
 *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 * @author YANG
 * @create 2021-04-10 18:01
 */
public class GenericTest {


    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);

        }

    }

    //在集和中使用范型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(78);
        integers.add(45);
        integers.add(78);
        integers.add(98);

        //方式一：
//        for (Integer score : integers){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二：
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            System.out.println(next);
        }

    }

    //在集和中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
//Map<String, Integer> map = new HashMap<String, Integer>();
//jdk7新特性：类型推断
Map<String, Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",87);

//        map.put(123,"Tom");
        //泛型的嵌套
Set<Map.Entry<String, Integer>> set = map.entrySet();
Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "---->" + value);
        }
    }








}


