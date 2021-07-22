package java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 *
 * @author YANG
 * @create 2021-04-03 13:44
 */
public class CollectionTest {
    /*
    Collection接口中的方法的使用
     */
    @Test
    public void test(){
Collection collection = new ArrayList();

//add(Object e)：将元素e添加到集和collection中
collection.add("AA");
collection.add("BB");
collection.add(123);    //自动装箱
collection.add(new Date());

//size()：获取集和的个数
int size = collection.size();
System.out.println(size);   //4

//addAll(Collection collection)：将集和collection集和中的元素添加到当前的集和中
Collection collection1 = new ArrayList();
collection1.add("CC");
collection1.add("DD");
collection1.addAll(collection);
int size1 = collection1.size();
System.out.println(size1);  //6

//clear()：清空集和元素
collection.clear();

//isEmpty()：判断当前元素集和是否为空（判断当前集和的元素个数（size）是否为0）
System.out.println(collection.isEmpty());   //true

    }
}
