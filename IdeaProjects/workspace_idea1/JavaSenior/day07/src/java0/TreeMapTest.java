package java0;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author YANG
 * @create 2021-04-09 11:43
 */
public class TreeMapTest {
    /*
    向TreeMap中添加key-value，要求key必须是同一个类创建的对象
    因为要按照key进行排序：自然排序、定制排序
     */
    //自然排序
    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        User user1 = new User("Tom", 23);
        User user2 = new User("Mike", 34);
        User user3 = new User("Jueey", 65);
        User user4 = new User("Mastor", 4533);
        User user5 = new User("Rider", 235);
        treeMap.put(user1,98);
        treeMap.put(user2,94);
        treeMap.put(user3,24);
        treeMap.put(user4,56);
        treeMap.put(user5,79);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //定制排序
    @Test
    public void test2(){
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }
                throw new RuntimeException("输入的数据不匹配！！！");
            }
        });
        User user1 = new User("Tom", 23);
        User user2 = new User("Mike", 34);
        User user3 = new User("Jueey", 65);
        User user4 = new User("Mastor", 4533);
        User user5 = new User("Rider", 235);
        treeMap.put(user1,98);
        treeMap.put(user2,94);
        treeMap.put(user3,24);
        treeMap.put(user4,56);
        treeMap.put(user5,79);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
