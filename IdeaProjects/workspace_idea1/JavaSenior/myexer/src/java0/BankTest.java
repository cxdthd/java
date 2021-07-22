package java0;

/**
 * @author YANG
 * @create 2021-03-21 10:55
 */
public class BankTest {
    public static void main(String[] args) {

        myThread mythread = new myThread();
        Thread thread = new Thread(mythread);
        Thread thread2 = new Thread(mythread);
        Thread thread3 = new Thread(mythread);
        thread.start();
        thread2.start();
        thread3.start();

        Bank instance = Bank.getInstance();

    }
}

class Bank{
    static int i= 0;
    private  Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        synchronized(Bank.class) {
            if (instance == null) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                instance = new Bank();
                System.out.println(i++);

            }
            return instance;
        }
    }

}

class myThread implements Runnable{
    @Override
    public void run() {
        Bank.getInstance();
    }
}


