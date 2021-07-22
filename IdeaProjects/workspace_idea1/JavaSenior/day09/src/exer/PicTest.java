package exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author YANG
 * @create 2021-04-20 16:14
 */
public class PicTest {

    //图片的加密
    @Test
    public void test1(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream("1607663557663.jpg");
            fo = new FileOutputStream("3333333333.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fi.read(buffer)) != -1) {
                //字节数组进行修改
                //错误的：这里修改的是新的变量，并不会对数组进行修改
    //            for (byte b:buffer){
    //                b = (byte)(b ^ 5);
    //            }
                //正确的：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fo.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null)
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fo != null)
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    //图片的解密密
    @Test
    public void test2(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream("3333333333.jpg");
            fo = new FileOutputStream("444444444.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fi.read(buffer)) != -1) {
                //字节数组进行修改
                //错误的：这里修改的是新的变量，并不会对数组进行修改
                //            for (byte b:buffer){
                //                b = (byte)(b ^ 5);
                //            }
                //正确的：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                fo.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
