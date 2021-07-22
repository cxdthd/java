package java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author YANG
 * @create 2021-05-10 20:29
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买了瓶矿泉水，花了" + aDouble);
            }
        });
        System.out.println("*******************************");
        happyTime(400,money -> System.out.println("买了瓶矿泉水，花了" + money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        System.out.println("*************************");

        List<String> list2 = filterString(list,s -> s.contains("津"));
        System.out.println(list2);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String>list, Predicate<String>pre){

        ArrayList<String> filterList = new ArrayList<>();

        for (String s:list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
