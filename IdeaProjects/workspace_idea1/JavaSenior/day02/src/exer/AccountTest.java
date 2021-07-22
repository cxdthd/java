package exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * <p>
 * 分析：
 * 1.是否是多线程问题？ 是，两个储户线程
 * 2.是否有共享数据？ 有，账户（或账户余额）
 * 3.是否有线程安全问题？有
 * 4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 *
 * @author YANG
 * @create 2021-01-23 12:28
 */

class Account {
    private int balance = 0;

    public void setbalance(int balance) {
        this.balance = balance;
    }

    public int getbalance() {
        return balance;
    }
}

class Customer implements Runnable {

    private Account account;

    private ReentrantLock lock = new ReentrantLock();

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {

                lock.lock();

                if (account.getbalance() < 3000) {
                    account.setbalance(account.getbalance() + 1000);
                    System.out.println(Thread.currentThread().getName() + "存入1000，现在余额为:" + account.getbalance());
                } else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }

    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer c = new Customer(acct);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.setName("用户一");
        t2.setName("用户二");
        t1.start();
        t2.start();

    }
}
