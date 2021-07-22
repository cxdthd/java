package java0;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 集和元素的遍历操作，使用迭代器Iterator接口
 * 内部的方法：hasNext() 和 next()
 *
 * 3.内部定义了remove(),可以在遍历的时候，删除集和中的元素。此方法不同于集和直接调用remove()
 *
 * @author YANG
 * @create 2021-04-04 19:43
 */
public class IteratorTest {
    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(new Person("Tom", 18));
        collection.add(new Date());
        collection.add(456);
        collection.add(false);

//        System.out.println(collection); //[123, Tom, Person{name='Tom', age=18}, Sun Apr 04 19:53:53 CST 2021, 456, false]

        Iterator iterator = collection.iterator();
//        System.out.println(iterator);   //java.util.ArrayList$Itr@78e03bb5

        //方式一：
//        System.out.println(iterator.next());    //123
//        System.out.println(iterator.next());    //Tom
//        System.out.println(iterator.next());    //Person{name='Tom', age=18}
//        System.out.println(iterator.next());    //Sun Apr 04 19:58:13 CST 2021
//        System.out.println(iterator.next());    //456
//        System.out.println(iterator.next());    //false
//        //报异常：java.util.NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0;i<collection.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        //hasNext()：判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next()：①指针下移 ② 将下移以后集和位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(new Person("Tom", 18));
        collection.add(new Date());
        collection.add(456);
        collection.add(false);

        Iterator iterator = collection.iterator();

        //错误方式一：间隔输出，并且报错：java.util.NoSuchElementException
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：一直输出第一个元素（死循环）
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合 的第一个元素之前。
        while (collection.iterator().hasNext()){
            System.out.println(collection.iterator().next());
        }

    }

    //测试Iterator中的remove()
    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(new Person("Tom", 18));
        collection.add(new Date());
        collection.add(456);
        collection.add(false);

        Iterator iterator = collection.iterator();

        //利用remove()方法移除数据："Tom"
        while (iterator.hasNext()){
            Object next = iterator.next();
            if ("Tom".equals(next)){
                iterator.remove();
            }
        }

        //遍历
        iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}