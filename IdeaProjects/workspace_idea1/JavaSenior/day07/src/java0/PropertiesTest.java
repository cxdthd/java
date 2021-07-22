package java0;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author YANG
 * @create 2021-04-09 16:39
 */
public class PropertiesTest {

    //    Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        properties.load(fileInputStream);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name = " + name + ",password = " + password);   //name = Tom,password = abc123


    }
}
