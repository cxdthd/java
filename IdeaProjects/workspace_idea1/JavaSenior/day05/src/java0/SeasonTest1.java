package java0;

/**
 * @author YANG
 * @create 2021-04-02 18:48
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("****************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
        winter.show();
    }
}

interface Info {
    void show();
}

//使用enum关键字定义枚举类
enum Season1 implements Info {
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春季", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天！！！");
        }
    },
    SUMMER("夏季", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏天！！！");
        }
    },
    AUTUMN("秋季", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天！！！");
        }
    },
    WINTER("冬季", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天！！！");
        }
    };

    //1.声明Season1对象的属性：用 private final 修饰
    private final String Season1Name;
    private final String Season1Desc;

    //2.私有化类的构造器，并给对象属性赋值
    private Season1(String Season1Name, String Season1Desc) {
        this.Season1Name = Season1Name;
        this.Season1Desc = Season1Desc;
    }
}
