package java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author YANG
 * @create 2021-04-12 18:15
 */
public class FileTest {

    @Test
    public void test(){

        //构造器1
        File file1 = new File("hello.txt");  //相对于当前module
        File file2 = new File("E:\\Project\\java\\IdeaProjects\\workspace_idea1\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:\\Project\\java\\IdeaProjects\\workspace_idea1","JavaSenior");

        System.out.println(file3);

        //构造器3
        File file4 = new File(file3,"hi.txt");

        System.out.println(file4);

    }

    @Test
    public void test2(){

        File file1 = new File("hello.txt");
        File file2 = new File("C:\\Users\\17527\\Desktop\\hi.txt");

        //此时的调用都是内存层面的调用，不涉及硬盘层面的，所以没有文件也不会报任何错误
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println("***************************");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    @Test
    public void test3(){
        File file = new File("E:\\Picture");

        String[] list = file.list();
        for (String str: list){
            System.out.println(str);
        }

        File[] files = file.listFiles();
        for (File f : files){
            System.out.println(f);
        }
    }



    @Test
    public void test4(){
File file1 = new File("hello.txt");
File file2 = new File("C:\\Users\\17527\\Desktop\\hi.txt");

boolean b = file2.renameTo(file1);
System.out.println(b);
    }

    @Test
    public void test5(){
        File file = new File("hello.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

    }



    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功！！！");
        }else{  //文件存在
            file.delete();
            System.out.println("删除成功！！！");
        }
    }

}
