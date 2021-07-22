package work;

import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a,b);	//需要在method方法被调用之后，仅打印出a = 100,b = 200,请写出method()方法的代码
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    
    //代码编写处
    public static void method(int a,int b) {
        PrintStream ps = new PrintStream(System.out){
            @Override
            public void println(String x){
                if ("a = 10".equals(x)){
                    x = "a = 100";
                }else if ("b = 10".equals(x)){
                    x = "b = 200";
                }
                
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}
