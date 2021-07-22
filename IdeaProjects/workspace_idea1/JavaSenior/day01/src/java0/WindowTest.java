package java0;

/**
 * 例子：创建三个窗口卖票，总票数为100张  --->使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。。。。
 *
 *
 * @author YANG
 * @create 2021-01-19 15:52
 */

class Window extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {
        for(;;){

            if(ticket > 0){
                System.out.println(getName() + "卖票，票号为:" + ticket--);
            }else {
                break;
            }

        }
    }
    public Window(String name){
        super(name);
    }

}

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window("窗口一");
        Window w2 = new Window("窗口二");
        Window w3 = new Window("窗口三");
        w1.start();
        w2.start();
        w3.start();

    }
}
