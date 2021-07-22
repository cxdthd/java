package exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author YANG
 * @create 2021-04-13 23:10
 */
public class FileDemo {

    /*
    利用File构造器，new 一个文件目录file
    1)在其中创建多个文件和目录
    2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test() throws IOException {
        File file1 = new File("C:\\Users\\17527\\Desktop\\hello.txt");

        //创建一个同一个目录下的文件，文件名为：haha.txt
        File file2 = new File(file1.getParent(),"haha.txt");
        file2.createNewFile();


        //删除file中指定的文件
        deleteFile(file1,"hello.txt");
    }

    public static void deleteFile(File file,String string){
        new File(file.getParent(),string).delete();
    }


    /*
     判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     */
    @Test
    public void test2(){
        File file1 = new File("E:\\Picture\\壁纸");
        String[] list = file1.list();
        for (String string : list){
            if (string.endsWith(".png")){
                System.out.println(string);
            }
        }
    }

    /*
    遍历指定目录所有文件名称，包括子文件目录中的文件。
    拓展1：并计算指定目录占用空间的大小
    拓展2：删除指定文件目录及其下的所有文件

     */
    @Test
    public void test3(){
        File file = new File("E:\\Picture\\123");
        long l = 0;
        ListFiles(file);
    }

    public static void ListFiles(File file){
        File[] files = file.listFiles();

        for (File file1 : files){
            if (file1.isDirectory()){
                ListFiles(file1);
            }else {
                System.out.println(file1);

            }
        }

    }


    /*
    拓展1：并计算指定目录占用空间的大小
     */
    @Test
    public void test4(){
        File file = new File("E:\\Picture\\123");
        System.out.println(sizeFiles(file));
    }
    public static long sizeFiles(File file){
        long size = 0;
        File[] files = file.listFiles();
        for (File file1:files){
            if (file1.isFile()){
                size += file1.length();
            }else {
                sizeFiles(file1);
            }
        }
        return size;
    }

    /*
    拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test5(){
        File file = new File("E:\\Picture\\123");
        deleteFiles(file);
    }
    public static void deleteFiles(File file){
        File[] files = file.listFiles();
        for (File file1:files){
            if (file1.isFile()){
                file1.delete();
            }else{
                deleteFiles(file1);
                file1.delete();
            }
        }
    }

}
