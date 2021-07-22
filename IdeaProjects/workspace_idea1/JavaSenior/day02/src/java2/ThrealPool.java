package java2;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * 面试题：创建多线程有几种方式？四种！
 * @author YANG
 * @create 2021-01-26 11:08
 */
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread2 implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        return null;
    }
}

public class ThrealPool {

    public static void main(String[] args) {


        NumberThread2 numberThread2 = new NumberThread2();
        FutureTask futureTask = new FutureTask<>(numberThread2);

        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //因为ExecutorService是接口，所以无法进行属性的设置。需要强转成它的实现类ThreadPoolExector
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;//强转--->向下转型

        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();


        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());  //适用于Runnable
        service.submit(futureTask);   //适用于Callable

        //关闭连接池
        service.shutdown();
    }

}
