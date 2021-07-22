package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author YANG
 * @create 2021-04-06 16:18
 */
public class CollectionTest {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add("123");
        collection.add("AA");
        collection.add(new String("CC"));

        collection.forEach(System.out::println);
    }


}
