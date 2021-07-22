package java0;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author YANG
 * @create 2021-04-22 23:08
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("cxdthd.JPG"),"r");
            raf2 = new RandomAccessFile(new File("cxdthd1.JPG"),"rw");

            byte[] buffer = new byte[5];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(new File("hello.txt").length());
        raf1.write("-opqrstuvwxyz".getBytes());

        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt","rw");

        raf1.seek(7);//将指针调到角标7的位置
        //保存指针7后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int)new File("hello1.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针，写入数据
        raf1.seek(7);
        raf1.write("\nhijklmn".getBytes());

        raf1.write(builder.toString().getBytes());

        raf1.close();

    }
}
