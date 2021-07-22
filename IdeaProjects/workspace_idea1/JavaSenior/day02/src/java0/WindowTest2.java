package java0;

/**
 * 例子：创建三个窗口卖票，总票数为100张  --->使用继承Thread类的方式
 * <p>
 *
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 * @author YANG
 * @create 2021-01-21 12:00
 */

class Window2 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        for (; ; ) {

//            synchronized (this){  //错误的：因为这里一共创建了三个对象，所以会有三把锁🔒

//            synchronized (obj) {  //只有上面的obj声明成static的才可以用

            //反射
            synchronized (Window2.class) {//直接用Window2类来充当对象，这里也说明了类也是对象
                // Window2.class类只会加载一次，所以是唯一的

                if (ticket > 0) {
                    System.out.println(getName() + "卖票，票号为:" + ticket--);
                } else {
                    break;
                }
            }

        }
    }

    public Window2(String name) {
        super(name);
    }

}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2("窗口一");
        Window2 w2 = new Window2("窗口二");
        Window2 w3 = new Window2("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
