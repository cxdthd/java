package java0;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YANG
 * @create 2021-04-02 14:41
 */
public class OtherClassTest {

    @Test
    public void test() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);  //java的version:1.8.0_131
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);    //java的home:E:\developTools\Java\jdk1.8.0_131\jre
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);    //os的name:Windows 10
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);  //os的version:10.0
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);    //user的name:17527
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);    //user的home:C:\Users\17527
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);  //user的dir:E:\Project\java\IdeaProjects\workspace_idea1\JavaSenior\day04
    }

    @Test
    public void test1() {
BigInteger bi = new BigInteger("1243312314254325364364765241123");
BigDecimal bd = new BigDecimal("12435.351");
BigDecimal bd2 = new BigDecimal("11");
System.out.println(bi); //1243312314254325364364765241123
// System.out.println(bd.divide(bd2));
 System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));  //1130.486
 System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));  //1130.486454545454545

    }
    /*
    将字符串“2017-08-16”转换为对应的java.sql.Date类的对象
     */
    @Test
    public void test3(){
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(string);
//        System.out.println(dateTimeFormatter);
//        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
//        TemporalAccessor parse = isoLocalDate.parse(string);

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        TemporalAccessor parse = dateTimeFormatter.parse(string);
//        System.out.println(parse);


//        LocalDate now = LocalDate.now();

        String string = "2017-08-16";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(string);
            java.sql.Date date = new java.sql.Date(parse.getTime());
            System.out.println(date);
            System.out.println(date.getClass());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


}
