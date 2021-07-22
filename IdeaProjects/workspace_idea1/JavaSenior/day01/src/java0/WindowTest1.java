package java0;

/**
 * 例子：创建三个窗口卖票，总票数为100张 --> 使用实现Runnable接口的方式
 *
 * 存在线程的安全问题，待解决。。。。
 *
 * @author YANG
 * @create 2021-01-19 20:52
 */

class meThread implements Runnable {

    //因为这里只造了一个对象，所以三个线程共享这一个ticket
    private int ticket = 100;

    @Override
    public void run() {

        for (; ; ) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出票号为：0000" + ticket-- + "的票");
            }else{
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        meThread meThread = new meThread();

        Thread t1 = new Thread(meThread);
        Thread t2 = new Thread(meThread);
        Thread t3 = new Thread(meThread);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
