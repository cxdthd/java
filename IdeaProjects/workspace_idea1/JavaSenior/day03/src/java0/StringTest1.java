package java0;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author YANG
 * @create 2021-01-27 14:13
 */
public class StringTest1 {
    /*
String 与 byte[]之间的转换
编码：String --> byte[]:调用String的getBytes()
解码：byte[] --> String:调用String的构造器

编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
 */

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes(); //使用默认的字符集，进行编码，一个汉字对应三个字节
        System.out.println(Arrays.toString(bytes)); //[97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]

        byte[] gbks = str1.getBytes("gbk"); //使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));  //[97, 98, 99, 49, 50, 51, -42, -48, -71, -6]

        System.out.println("******************************");

        String str2 = new String(bytes);    //使用默认的字符集，进行解码
        System.out.println(str2);   //abc123中国

        String str3 = new String(gbks);
        System.out.println(str3);   //abc123�й� (出现乱码，原因：编码集和解码集不一致导致的！)

        String str4 = new String(gbks,"gbk");
        System.out.println(str4);   //abc123中国

    }






    /*
String 与 char[]之间的转换

String --> char[]:调用String的toCharArray()
char[] --> String:调用String的构造器
 */
    @Test
    public void test0() {
        String str = "abc123";  //题目a21cb3
        char[] arr = str.toCharArray();


//        int j = arr.length-2;
//        for (int i = 1;i<=j; i++) {
//            for (;i<=j;){
//                char index = arr[i];
//                arr[i] = arr[j];
//                arr[j] = index;
//                j--;
//                break;
//            }
//        }

        int i = 1;
        int j = arr.length - 2;
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        //
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test2() {
        String str = "abc123";  //题目a21cb3,见test0

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] array = new char[]{'h', 'e', 'l', 'l', 'o' };
        String str2 = new String(array);
        System.out.println(str2);
    }

    /*
复习：
String 与基本数据类型、包装类之间的转换。

String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)

 */
    @Test
    public void test() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i + 1);  //124

        String s = String.valueOf(i);
        String s1 = i + ""; //s1在堆里，只要有变量参与就是在堆里
        System.out.println(s + "1");    //1231

        System.out.println(str1 == s);  //false
        System.out.println(str1 == s1);  //false
        System.out.println(s == s1);  //false

    }

}
