package java0;

/**
 * @author YANG
 * @create 2021-04-26 15:50
 */
public class Xy {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        x = x++;    //左边x=0，右边x=1
        y = x++;    //左边y=0，右边x=1
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
