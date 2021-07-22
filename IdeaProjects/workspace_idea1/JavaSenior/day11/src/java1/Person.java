package java1;

/**
 * @author YANG
 * @create 2021-05-07 10:28
 */
@MyAnnotation(value = "Person类")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){}

    @MyAnnotation(value = "private构造器")
    private Person(String name){
      this.name = name;
    }

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "private权限的方法show()")
    private String show(String nation){
        System.out.println("private权限的：我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests,int age) throws NumberFormatException,ClassNotFoundException{
        return interests + age;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是接口中的info()方法");
    }

    private static void staticMethod(){
        System.out.println("我是一个静态方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
