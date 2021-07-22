package java0;

/**
 * @author YANG
 * @create 2021-03-19 16:37
 */

class mThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        mThread mThread = new mThread();
        Thread thread = new Thread(mThread);
        thread.start();

        Thread thread1 = new Thread(mThread);
        thread1.start();
    }
}