package java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *  http://localhost:8080/examples/beauty.jpg?username=Tom
 *  协议   主机名    端口号  资源地址           参数列表
 *
 * @author YANG
 * @create 2021-04-28 11:29
 */
public class URLTest {
    public static void main(String[] args) {
        try {

URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

System.out.println(url.getProtocol());
System.out.println(url.getHost());
System.out.println(url.getPort());
System.out.println(url.getPath());
System.out.println(url.getFile());
System.out.println(url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
