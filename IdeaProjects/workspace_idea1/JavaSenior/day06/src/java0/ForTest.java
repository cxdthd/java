package java0;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author YANG
 * @create 2021-04-05 9:29
 */
public class ForTest {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("Tom"));
        collection.add(new Person("Tom", 18));
        collection.add(new Date());
        collection.add(456);
        collection.add(false);

        //for(集和元素的类型 局部变量 : 集和对象)
        //内部仍然调用了迭代器
        for (Object object : collection){
            System.out.println(object);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};
        //for(数组元素的类型 局部变量 : 数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }

    //笔试题
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","AA","AA"};

        //方式一：普通for循环
//        for (int i = 0;i<arr.length;i++){
//            arr[i] = "aa";
//        }

        //方式二：增强for循环
        for (String s : arr){
            s = "aa";
        }

        //遍历
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + ",");
            //方式一输出：aa,aa,aa,
            //方式二输出：AA,AA,AA,
        }
    }

}
