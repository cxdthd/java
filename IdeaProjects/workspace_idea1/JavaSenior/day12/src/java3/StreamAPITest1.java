package java3;

import java2.Employee;
import java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 的中间操作
 *
 * @author YANG
 * @create 2021-05-14 9:01
 */
public class StreamAPITest1 {
//    1-筛选与切片
    @Test
    public void test1(){
List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
Stream<Employee> stream = list.stream();
//查询员工表中薪资大于7000的员工信息
stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

System.out.println();
//        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
list.add(new Employee(1009,"Tom",18,10000));
list.add(new Employee(1009,"Tom",18,10000));
list.add(new Employee(1009,"Tom",18,10000));
list.stream().distinct().forEach(System.out::println);

System.out.println();
//        limit(long maxSize) 截断流，使其元素不超过给定数量
list.stream().limit(5).forEach(System.out::println);

System.out.println();
//        skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一 个空流。与 limit(n) 互补
list.stream().skip(5).forEach(System.out::println);
    }

    //2-映 射
    @Test
    public void test2(){

//        map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

//练习1：获取员工姓名长度大于3的员工的姓名
List<Employee> employees = EmployeeData.getEmployees();
Stream<String> stringStream = employees.stream().map(Employee::getName);
stringStream.filter(str -> str.length() > 3).forEach(System.out::println);

//练习2：
Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::formStringToStream);
streamStream.forEach(e -> e.forEach(System.out::println));

//        flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::formStringToStream);
characterStream.forEach(System.out::println);
    }

//将字符串中的多个字符构成的集和转换为对应的Stream的实例
public static Stream<Character> formStringToStream(String string){
    ArrayList<Character> list = new ArrayList<>();
    for (Character c : string.toCharArray()){
        list.add(c);
    }
    return list.stream();
}

    @Test
    public void test3(){
ArrayList list1 = new ArrayList();
list1.add(1);
list1.add(2);
list1.add(3);
ArrayList list2 = new ArrayList();
list2.add(4);
list2.add(5);
list2.add(6);

//        list1.add(list2);   //[1, 2, 3, [4, 5, 6]]
//        list1.addAll(list2);    //[1, 2, 3, 4, 5, 6]
System.out.println(list1);
    }

    //3-排序
    @Test
    public void test4(){
//        sorted() 产生一个新流，其中按自然顺序排序
List<Integer> list = Arrays.asList(12, 32, 41, 1, 0, -3, -42, 32, 21, 54, 3);
Stream<Integer> sorted = list.stream().sorted();
sorted.forEach(System.out::println);
//抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
List<Employee> employees = EmployeeData.getEmployees();
employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

    }
}

