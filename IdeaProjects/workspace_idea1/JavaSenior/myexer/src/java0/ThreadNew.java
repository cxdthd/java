package java0;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YANG
 * @create 2021-03-23 9:27
 */

//1、创建一个实现Callable接口的实现类
class Call implements Callable {
    private int sum;

    //2、实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3、创建Callable接口实现类的对象
        Call call = new Call();

        //4、将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(call);

        //5、将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTest构造器参数Callable实现类重写的call()的返回值。
            Object o = futureTask.get();
            System.out.println("总和为：" + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
