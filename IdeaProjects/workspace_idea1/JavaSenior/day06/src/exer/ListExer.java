package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANG
 * @create 2021-04-05 18:48
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)
     */
@Test
public void testListRemove() {
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    updateList(list);
    System.out.println(list);//
}

private static void updateList(List list) {
//        list.remove(2);   //输出的内容是：[1,2]
    list.remove(new Integer(2));    //输出的内容是：[1,3]
}
}
