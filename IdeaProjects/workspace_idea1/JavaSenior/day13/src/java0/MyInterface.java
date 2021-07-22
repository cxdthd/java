package java0;

/**
 * @author YANG
 * @create 2021-05-17 23:33
 */
public interface MyInterface {
    //如下的三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){   //这里的default只作为关键字，而不是权限
        System.out.println("我是接口中的默认方法");

        methodPrivate();
    }
    //jdk 9中允许接口中定义私有的方法
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}

