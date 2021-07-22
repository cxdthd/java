package java3;

import java2.Employee;
import java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YANG
 * @create 2021-05-14 10:11
 */
public class StreamAPITest2 {
    //1-匹配与查找
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
//        allMatch(Predicate p) 检查是否匹配所有元素
//判断员工年龄是否都大于18岁
        boolean b = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

//        anyMatch(Predicate p) 检查是否至少匹配一个元素
//是否存在员工的工资大于10000
        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

//        noneMatch(Predicate p) 检查是否没有匹配所有元素
//是否存在姓雷的员工
        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

//        findFirst() 返回第一个元素
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

//        findAny() 返回当前流中的任意元素
        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any);
    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
//        count() 返回流中元素总数
//返回员工薪资大于5000的员工数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
//        max(Comparator c) 返回流中最大值
//返回最高的工资
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compareTo);
        System.out.println(max);

//        min(Comparator c) 返回流中最小值
//返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

//        forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。
//            相反，Stream API 使用内部迭代——它帮你把迭代做了)
    }

    //2-归约
    @Test
    public void test3() {
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 T
//练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一 个值。返回 Optional<T>
//计算所有员工的总工资
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);

    }

    //3-收集
    @Test
    public void test4() {
//        collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总 的方法
        //练习1：查找工资大于6000的员工，结果返回员工List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        Set<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

}
