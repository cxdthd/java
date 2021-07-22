package java0;

/**
 * @author YANG
 * @create 2021-05-17 23:35
 */
public class MyInterfaceImpl implements MyInterface{
    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("实现类重写的默认方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由自己调用
        MyInterface.methodStatic();
        //接口的实现类不能调用接口中的静态方法
//        MyInterfaceImpl.methodStatic();

        new MyInterfaceImpl().methodDefault();
        //接口中的私有方法不能在接口外部调用
//        new MyInterfaceImpl().methodPrivate();
    }
}
