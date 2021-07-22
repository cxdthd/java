package exer;

/**
 * @author YANG
 * @create 2021-03-26 0:22
 */
public class E {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m = " + m + ",n = " + n);

        E test = new E();
        test.swap(m, n);//因为这条语句结束后，swap()方法里的m和n就被销毁了，在main()方法里输出的只有main()方法里							  的变量
        System.out.println("交换后的m = " + m + ",n = " + n); // m = 10,n = 20
    }

    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
        //System.out.println("交换后的m = " + m + ",n = " + n);	//m = 20,n = 10
    }
}
