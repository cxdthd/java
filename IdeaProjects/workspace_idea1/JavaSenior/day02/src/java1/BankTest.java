package java1;

/**
 * 解决单例模式懒汉式的线程安全问题
 *
 * @author YANG
 * @create 2021-01-22 21:01
 */
public class BankTest {
    public static void main(String[] args) {

        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread1 t3 = new Thread1();
        Thread1 t4 = new Thread1();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        Bank.getInstance().show();
    }
}


//单例模式：懒汉式
class Bank {

    //私有化构造器
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {

        //方式一:效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二:效率稍高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;

    }

    public void show() {
        System.out.println(this.toString());
    }
}