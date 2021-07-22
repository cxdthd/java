package java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 *
 * @author YANG
 * @create 2021-05-09 14:16
 */
public class LambdaTest {

    @Test
    public void test(){
        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable接口的匿名实现类的run()方法");
            }
        };
        r1.run();

        System.out.println("***************************");

        Runnable r2 = () -> System.out.println("Lambda表达式输出语句");
        r2.run();

    }

    @Test
    public void test2(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = comparator.compare(12, 32);
        System.out.println(compare);    //-1

        System.out.println("***********************************");
        //Lambda表达式的写法
        Comparator<Integer> comparator1 =( o1, o2) -> Integer.compare(o1,o2);

        int compare1 = comparator1.compare(12, 32);
        System.out.println(compare1);    //-1

        System.out.println("***********************************");
        //方法引用
        Comparator<Integer> comparator2 =Integer::compare;

        int compare2 = comparator2.compare(12, 32);
        System.out.println(compare2);    //-1
    }

}
