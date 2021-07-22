package exer2;

import java.util.*;

/**
 * @author YANG
 * @create 2021-04-10 10:16
 */
public class E {

    /*
    1.请从键盘随机输入10个整数保存到List中，并按倒序、从大 到小的顺序显示出来
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(next);
        for (int i = 0;i<10;i++){
            int anInt = scanner.nextInt();
            list.add(anInt);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    Integer list1 = (Integer) o1;
                    Integer list2 = (Integer) o2;
                    return Integer.compare(list1,list2);
                }
                throw new RuntimeException("输入的不是整数！！！");
            }
        });

        System.out.println(list);
    }
}
