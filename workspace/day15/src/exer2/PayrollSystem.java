package exer2;

import java.util.Calendar;
import java.util.Scanner;

import javax.swing.text.AttributeSet.CharacterAttribute;

/*
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
	public static void main(String[] args) {
		
		//方式一
//		Scanner scan = new Scanner(System.in);
//		System.out.print("请输入当前月份：");
//		int nowMonth = scan.nextInt();
		
		//方式二
		Calendar calendar = Calendar.getInstance();
		int nowMonth = calendar.get(Calendar.MONTH) +1;//获取当前的月份(从零开始，所有使用要加一)
		
		Employee[] empls = new Employee[2];
		
		empls[0] = new SalariedEmployee("Tom", 1001, new MyDate(2000,11,14),10000);
		empls[1] = new HourlyEmployee("QWE", 1002, new MyDate(2000,12,17),60,240);
		for(int i = 0;i < empls.length;i++){
			System.out.println(empls[i]);
			double earnings = empls[i].earnings();
			
			if(nowMonth == empls[i].getBirthday().getMonth()){
				earnings += 100;
			}
			System.out.println("工资为： " + earnings);
		}
	}
}
