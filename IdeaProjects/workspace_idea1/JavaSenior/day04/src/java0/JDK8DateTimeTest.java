package java0;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 *
 * @author YANG
 * @create 2021-02-20 14:05
 */
public class JDK8DateTimeTest {

    @Test
    public void DateTest() {
        //偏移量：Date中的年份是从1900年开始的，而月份从零开始。
        Date date = new Date(2021 - 1900, 2 - 1, 20);
        System.out.println(date);   //Sat Feb 20 00:00:00 CST 2021
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        LocalDateTime相较于LocalDate、LocalTime使用频率要高一些
        类似于Calendar

     */
    @Test
    public void test1() {
        //now():获取当前的日期、时间、时间+日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);  //2021-02-20
        System.out.println(localTime);  //15:53:38.542
        System.out.println(localDateTime);  //2021-02-20T15:53:38.542

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(1999, 2, 20, 15, 58, 58);
        System.out.println(localDateTime1); //1999-02-20T15:58:58

        //getXxx()：获取相关属性
        System.out.println(localDateTime.getDayOfMonth());  //20
        System.out.println(localDateTime.getDayOfWeek());   //SATURDAY
        System.out.println(localDateTime.getDayOfYear());   //51
        System.out.println(localDateTime.getMinute());      //4

        //体现了LocalDate、LocalTime、LocalDateTime的不可变性
        //withXxx():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(21);
        System.out.println(localDate);  //2021-02-20
        System.out.println(localDate1); //2021-02-21

        LocalTime localTime1 = localTime.withHour(2);
        System.out.println(localTime);  //16:14:07.550
        System.out.println(localTime1); //02:14:07.550

        //不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(1);
        System.out.println(localDateTime);  //2021-02-20T16:17:50.190
        System.out.println(localDateTime2); //2021-03-20T16:17:50.190


    }

    @Test
    public void test2() {
//now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);    //2021-04-01T08:07:41.997Z

//添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2021-04-01T16:07:41.997+08:00

//toEpochMilli():获取当前时间的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);  //1617264461997
        long l = offsetDateTime.toEpochSecond();
        System.out.println(l);  //1617264461

//ofEpochMilli(long epochMilli)
        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);   //2021-04-01T08:07:41.997Z
    }


    /*
    java.time.format.DateTimeFormatter 类
     */
    @Test
    public void test3() {
//      实例化方式一：
//        预定义的标准格式。如： ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime now = LocalDateTime.now();
        //格式化：日期 ---> 字符串
        String format = isoLocalDateTime.format(now);
        System.out.println("格式化前："+ now);   //格式化前：2021-04-01T16:25:23.458
        System.out.println("格式化后："+ format);    //格式化后：2021-04-01T16:25:23.458

        //解析：字符串 ---> 日期
        TemporalAccessor parse = isoLocalDateTime.parse("2021-04-01T16:25:23.458");
        System.out.println(parse);  //{},ISO resolved to 2021-04-01T16:25:23.458



//          实例化方式二：
//        本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        LocalDateTime now1 = LocalDateTime.now();
        //格式化
        String format1 = dateTimeFormatter.format(now1);
        String format2 = dateTimeFormatter2.format(now1);
        String format3 = dateTimeFormatter3.format(now1);
        System.out.println("格式化前：" + now1); //格式化前：2021-04-01T18:48:18.278
        System.out.println("FormatStyle.MEDIUM格式化后：" + format1);    //FormatStyle.MEDIUM格式化后：2021-4-1 18:48:18
        System.out.println("FormatStyle.SHORT格式化后：" + format2);    //FormatStyle.SHORT格式化后：21-4-1 下午7:07
        System.out.println("FormatStyle.LONG格式化后：" + format3);    //FormatStyle.LONG格式化后：2021年4月1日 下午07时07分07秒

        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse(format1);
        System.out.println(parse1); //{},ISO resolved to 2021-04-01T18:49:42


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String format4 = dateTimeFormatter1.format(LocalDate.now());
        System.out.println(format4);    //2021年4月1日 星期四
        //解析
        TemporalAccessor parse2 = dateTimeFormatter1.parse(format4);
        System.out.println(parse2); //{},ISO resolved to 2021-04-01


//      重点：  自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format5 = dateTimeFormatter4.format(LocalDateTime.now());
        System.out.println(format5);    //2021-04-01 07:55:27
        //解析
        TemporalAccessor parse3 = dateTimeFormatter4.parse(format5);
        System.out.println(parse3); //{SecondOfMinute=54, NanoOfSecond=0, MicroOfSecond=0, HourOfAmPm=8, MinuteOfHour=15, MilliOfSecond=0},ISO resolved to 2021-04-01


    }


}
