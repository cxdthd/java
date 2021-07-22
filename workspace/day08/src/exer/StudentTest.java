package exer;

/*
 * 4. 对象数组题目：
定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
问题一：打印出3年级(state值为3）的学生信息。
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

提示：
1) 生成随机数：Math.random()，返回值类型double;  
2) 四舍五入取整：Math.round(double d)，返回值类型long。
 */
public class StudentTest {
	public static void main(String[] args) {

		// 声明Student类型的数组
		Student[] stud = new Student[20]; // 数组元素可以是任何类型，Student为类类型，也可以

		for (int i = 0; i < stud.length; i++) {
			// 给数组元素赋值
			stud[i] = new Student();
			// 给Student对象的属性赋值
			stud[i].number = i + 1;
			// 年级：[1,6]
			stud[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
			// 成绩：[0,100]
			stud[i].score = (int) (Math.random() * (100 - 0 + 1) + 0);
		}

		// 遍历学生数组
		for (int i = 0; i < stud.length; i++) {
			System.out.print("学生" + i + "的学号：" + stud[i].number + "\t");
			System.out.print("年级为：" + stud[i].state + "年级" + "\t");
			System.out.println("成绩为" + stud[i].score + "分");
		}

		for (int i = 0; i < stud.length; i++) {
			String str = stud[i].info(); // return的值要用str来接收，或者直接Syso输出stud[i].info()
			System.out.print(str);
		}

		// 问题一：打印出3年级(state值为3）的学生信息。
		for (int i = 0; i < stud.length; i++) {
			if (stud[i].state == 3) {
				System.out.print(stud[i].info());
			}
		}
		System.out.println("***********************************************");
		// 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
		for (int i = 0; i < stud.length - 1; i++) {
			for (int j = 0; j < stud.length - 1 - i; j++) {
				if (stud[j].score > stud[j + 1].score) {
					Student temp = stud[j];
					stud[j] = stud[j + 1];
					stud[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < stud.length; i++) {
			System.out.print(stud[i].info());
		}

	}

}

class Student {
	int number;
	int state;
	int score;

	public String info() {
		return "学生的学号：" + number + "," + "年级为：" + state + "年级" + "," + "成绩为" + score + "分" + "\n";
	}
}
