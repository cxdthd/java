package java0;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 *
 * @author YANG
 * @create 2021-04-20 10:46
 */
public class BufferedTest {

    /*
    实现对非文本文件的复制
     */
    @Test
    public void BufferedSteamTest(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File srcFile = new File("1607663557663.jpg");
            File destFle = new File("2222222.jpg");

            //2.造流
            //2.1 造节点流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFle);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制的细节：读取、写入的过程
            byte[] buffer = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bufferedInputStream != null)
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null)
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略不写。
//        fileInputStream.close();
//        fileOutputStream.close();

        }



    }


    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFle = new File(destPath);

            //2.造流
            //2.1 造节点流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFle);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.复制的细节：读取、写入的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer,0,len);

//                bufferedOutputStream.flush();//刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null)
                    bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略不写。
//        fileInputStream.close();
//        fileOutputStream.close();

        }
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        copyFileWithBuffered("C:\\Users\\17527\\Desktop\\不知火.mp4","C:\\Users\\17527\\Desktop\\不知火2.mp4");
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));  //652
    }


    /*
    使用BufferedReader和BuferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int read;
//            while ((read = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,read);
//            }

            //方式二：使用String
            String data;
            while ((data = br.readLine()) !=null){  //readLine()一次读取一行数据，但是不会换行
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //资源的关闭
            try {
                if (br != null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
