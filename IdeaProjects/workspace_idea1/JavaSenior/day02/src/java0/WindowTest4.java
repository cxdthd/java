package java0;

/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 * @author YANG
 * @create 2021-01-22 16:31
 */
class Window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        for (; ; ) {
        show();
        }

    }
        private static synchronized void show() {   //同步监视器：Window4.class  ---因为静态方法随着类的加载而加载
//    private synchronized void show(){   //同步监视器：w1,w2,w3  <--此种解决方式是错误的

        if (ticket > 0) {
            //因为是静态方法，所以这个的getName()必须用类来调用
            System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket--);
        }
    }

    public Window4(String name) {
        super(name);
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4("窗口一");
        Window4 w2 = new Window4("窗口二");
        Window4 w3 = new Window4("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
