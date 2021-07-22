package java0;

import java.util.Calendar;
import java.util.Date;

/**
 * @author YANG
 * @create 2021-04-01 11:03
 */
public class CalendarTest {
    public static void main(String[] args) {
        //实例化
        Calendar instance = Calendar.getInstance();

        //这里说明了用Calendar.getInstance()方式返回的对象是GregorianCalendar
        System.out.println(instance.getClass());    //class java.util.GregorianCalendar

        int date = instance.get(Calendar.DATE);
        System.out.println("今天是这个月的第" + date + "天");

        int dayMonth = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天是这个月的第" + date + "天(和DATE一个意思)");

        int dayWeek = instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("今天是这周的第" + dayWeek + "天");

        int dayWeekMonth = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println("这个星期是这个月的第" + dayWeekMonth + "周");

        int dayYear = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println("今天是今年的第" + dayYear + "天");

        int hourDay = instance.get(Calendar.HOUR_OF_DAY);
        System.out.println("现在是今天的第" + hourDay + "个小时");

        int year = instance.get(Calendar.YEAR);
        System.out.println("今年是" + year + "年");

        int millisecond = instance.get(Calendar.MILLISECOND);
        System.out.println("获取当前毫秒数：" + millisecond);

        int month = instance.get(Calendar.MONTH);
        System.out.println("获取当前月份：" + month);

        int second = instance.get(Calendar.SECOND);
        System.out.println("获取当前的秒数："+second);

        int minute = instance.get(Calendar.MINUTE);
        System.out.println("返回当前的分钟："+minute);

        //******************************************************
        instance.set(Calendar.MONTH,2);
        int month1 = instance.get(Calendar.MONTH);
        System.out.println("修改后的月份为："+month1);

        //******************************************************
        Date time = instance.getTime();
        System.out.println(time);   //Mon Mar 01 11:47:07 CST 2021

        Date date1 = new Date();
        instance.setTime(date1);
        int i = instance.get(Calendar.MONTH);
        System.out.println(i);  //3

    }
}
