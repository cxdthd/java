package Java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author YANG
 * @create 2021-04-05 21:34
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）


    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */
@Test
public void test1(){
    TreeSet treeSet = new TreeSet();

    //失败：不能添加不同类的对象
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add("AA");  //java.lang.ClassCastException
//        treeSet.add("BB");
//        treeSet.add(new User("Tom",18));
//        treeSet.add(new User("Tom",18));
//        treeSet.add(new String("CC"));
//        treeSet.add(123);

    //举例一：
//        treeSet.add(34);
//        treeSet.add(-34);
//        treeSet.add(123);
//        treeSet.add(4);

    //举例二：
    treeSet.add(new User("Tom",18));
    treeSet.add(new User("Jerry",32));
    treeSet.add(new User("Jim",2));
    treeSet.add(new User("Mike",65));
    treeSet.add(new User("Jack",33));
    treeSet.add(new User("Jack",66));

    Iterator iterator = treeSet.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next());
    }
}


    @Test
    public void test2(){
        Comparator comparator=new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User)o1;
                    User user2 = (User)o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }else{
                    throw new RuntimeException("输入的内容不匹配！！！");
                }
            }

        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new User("Tom",18));
        treeSet.add(new User("Jerry",32));
        treeSet.add(new User("Jim",2));
        treeSet.add(new User("Mike",65));
        treeSet.add(new User("Jack",33));
        treeSet.add(new User("Mary",33));
        treeSet.add(new User("Jack",66));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
