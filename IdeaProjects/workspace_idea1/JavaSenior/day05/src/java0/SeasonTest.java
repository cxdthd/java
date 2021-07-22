package java0;

/**
 * @author YANG
 * @create 2021-04-02 17:27
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring); //Season{seasonName='春季', seasonDesc='春暖花开'}
    }
}

class Season{
    //1.声明Season对象的属性：用 private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器，并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象：public static final
    public static final Season  SPRING = new Season("春季","春暖花开");
    public static final Season  SUMMER = new Season("夏季","夏日炎炎");
    public static final Season  AUTUMN = new Season("秋季","秋高气爽");
    public static final Season  WINTER = new Season("冬季","冰天雪地");


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //4.其他诉求2：提供toString()方法
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

