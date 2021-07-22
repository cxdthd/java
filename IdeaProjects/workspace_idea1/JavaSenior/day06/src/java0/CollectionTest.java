package java0;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明的方法的测试
 *
 * @author YANG
 * @create 2021-04-04 12:21
 */
public class CollectionTest {
    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(new Person("Tom", 18));
        collection.add(new Date());
        collection.add(456);
        collection.add(false);  //这个是包装类的Boolean

//contains(Object obj)：判断当前集和中是否包含obj
        boolean aa = collection.contains(123);
        System.out.println(aa); //true
//我们在判断时会调用obj对象所在类的equals().
        System.out.println(collection.contains(new String("Tom"))); //true
//我们自己定义的类中因为没有重写equals()方法，所以是false，重写了方法后可以改为true
        System.out.println(collection.contains(new Person("Tom", 18)));  //false ---> true

        //containsAll(Collection coll1)：判断形参coll1中的所有元素是否都存在与当前集和中
        Collection coll1 = Arrays.asList(123,456);
        boolean b = collection.containsAll(coll1);
        System.out.println(b);  //true
    }

    @Test
    public void test1(){
Collection collection = new ArrayList();
collection.add("AA");
collection.add(123);
collection.add(new String("Tom"));
collection.add(456);
collection.add(false);

//remove(Object obj)：
boolean remove = collection.remove(123);    //返回boolean型说明remove()方法里有equals()进行判断
System.out.println(collection); //[AA, Tom, 456, false]

//removeAll(Collection coll1)：差集：从当前集和中移除coll1中所有的元素（共有的元素）
Collection coll1 = Arrays.asList(123,4567);
collection.removeAll(coll1);
System.out.println(collection); //[AA, Tom, 456, false]

    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(456);
        collection.add(false);

        //retainAll(Collection coll1)：交集：获取当前集和和coll1集和的交集，并返回给当前集和
        Collection coll1 = Arrays.asList(123,456,789);
        collection.retainAll(coll1);
        System.out.println(collection); //[123, 456]

        //equals(Object obj)：要想返回true，需要当前集和和形参集和的元素都相同
        Collection collection1 = new ArrayList();
        collection1.add(123);
        collection1.add(456);
        System.out.println(collection.equals(collection1)); //true

    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add("AA");
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(456);
        collection.add(false);

        //hashCoae()：返回当前对象的哈希值
        System.out.println(collection.hashCode());  //2034219811

        //集和 ---> 数组：toArray()
        Object[] arr = collection.toArray();
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 ---> 集和：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);   //[AA, BB, CC]

        List<int[]> list1 = Arrays.asList(new int[]{123, 456});//这里注意集和会把这个数组当成一个元素
        System.out.println(list1);  //[[I@78e03bb5]
        System.out.println(list1.size());   //1

        List<Integer> integerList = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integerList);    //[123, 456]
        System.out.println(integerList.size()); //2

        //iterator()：返回Iterator接口的实例，用于遍历集和元素。放在IteratorTest.java中讲


    }



}
