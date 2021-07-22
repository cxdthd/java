package Array;
/*
2.从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
➢成绩>=最高分-10	等级为'A'
➢成绩>=最高分-20	等级为'B'
➢成绩>=最高分-30	等级为'C'
➢其佘 			等级为'D'
提示:先读入学生人数，根据人数创建int组,存放学生成绩。
*/

import java.util.Scanner;

public class ArrayDemo1 {
	public static void main(String[] args) {
		// 1.使用Scanner，读取学生个数
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生人数：");
		int number = scan.nextInt();

		// 2.创建数组，存储学生成绩：动态初始化
		int[] scores = new int[number];
		// 3.给数组中的元素赋值
		System.out.println("请依次输入" + number + "个学生的成绩");
		int maxScore = 0;
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scan.nextInt();
			// 4.获取数组中的元素的最大值：最高分
			if (maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}
		// for (int i = 0; i < scores.length; i++) {
		// }
		// 5.根据每个学生成绩与最高分的差值，得到每个学生的等级，并输出等级和成绩
		char level;
		for (int i = 0; i < scores.length; i++) {
			if (maxScore - scores[i] <= 10) {
				level = 'A';
			} else if (maxScore - scores[i] <= 20) {
				level = 'B';

			} else if (maxScore - scores[i] <= 30) {
				level = 'C';
			} else {
				level = 'D';
			}
			System.out.println("学生" + i + "的成绩为：" + scores[i] + ",等级为：" + level);
		}
	}
}
