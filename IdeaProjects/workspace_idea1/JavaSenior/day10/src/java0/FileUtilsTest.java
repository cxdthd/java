package java0;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author YANG
 * @create 2021-04-24 16:43
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File file = new File("day10\\cxdthd.JPG");
        File file2 = new File("day10\\cxdthd2.JPG");
        try {
            FileUtils.copyFile(file,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

