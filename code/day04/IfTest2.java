/*
��д����:�ɼ����������������ֱ�������num1�� num2�� num3,
�����ǽ�������(ʹ��if-else if-else),���Ҵ�С���������

˵����
if������ֻ��һ��ִ�����Ļ�����ʡ�Ի�����{}����������ʡ�ԡ�
*/

import java.util.Scanner;
class IfTest2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("�������һ��������");
		int num1 = scan.nextInt();
		System.out.println("������ڶ���������");
		int num2 = scan.nextInt();
		System.out.println("�����������������");
		int num3 = scan.nextInt();

		int max1 = (num1 >= num2)? num1 : num2;
		int max2 = (max1 >= num3)? max1 : num3;
		int min = num1 + num2 + num3 -max1 - max2;
		System.out.println("�Ӵ�С����Ϊ:" + max2 + " " + max1 + " " + min);
	}
}