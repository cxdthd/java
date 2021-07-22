package java0;

/**
 * @author YANG
 * @create 2021-03-22 16:37
 */

class myThread1 implements Runnable{

    private int num = 1;
    @Override
    public void run() {
        for (;;){
            synchronized (this) {
                notify();
                if (num <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

public class CommunicationTest {

    public static void main(String[] args) {
        myThread1 myThread1 = new myThread1();
        Thread thread = new Thread(myThread1);
        Thread thread2 = new Thread(myThread1);
        thread.setName("线程一");
        thread2.setName("线程二*");

        thread.start();
        thread2.start();
    }
}
