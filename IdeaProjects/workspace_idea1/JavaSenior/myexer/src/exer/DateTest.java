package exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author YANG
 * @create 2021-03-31 23:55
 */

/*
练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3 : 打渔
    总天数 % 5 == 4,0 : 晒网

    总天数的计算？
    方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
 */
public class DateTest {
    public static void main(String[] args) {
        try {
            Date.getShow("2020-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class Date{

    public static void getShow(String string) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parse = simpleDateFormat.parse(string);
        System.out.println("string = " + parse.getTime());

        java.util.Date parse1 = simpleDateFormat.parse("1990-01-01");
        System.out.println("1990-01-01 = "+ parse1.getTime());

//        System.out.println((parse.getTime() - parse1.getTime())/(1000 * 60 * 60 * 24) + 1);
        int allDay = (int)((parse.getTime() - parse1.getTime())/(1000 * 60 * 60 * 24) + 1);
//        System.out.println(allDay);

        switch (allDay % 5){
            case 0:
                System.out.println("晒网");
                break;
            case 1:
                System.out.println("打鱼");
                break;
            case 2:
                System.out.println("打鱼");
                break;
            case 3:
                System.out.println("打鱼");
                break;
            case 5:
                System.out.println("晒网");
                break;
        }

    }


}
