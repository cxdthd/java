/*
标识符的使用
1.标识符：凡是自己可以起名字的地方都叫标识符。
	比如：类名、变量名、方法名、接口名、包名...

2.标识符的命名规则：-->
由26个英文字母大小写，0-9，_或$组成
数字不可以开头。
不可以使用关键字和保留字，但能包含关键字和保留字。
Java中严格区分大小写，长度无限制。
标识符不能包含空格。

3.Java中的名称命名规范：

包名：多单词组成时所有字母都小写：xxxyyyzzz
类名、接口名：多单词组成时，所以单词的首字母大写：XxxYyyZzz
变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz
常量名：所以字母都大写。多单词时每个单词用下划线连接：xxx_yyy_zzz

*/
class IdentifierTest
{
	public static void main(String[] args){
		//int myNumber = 1001;
		//System.out.println(myNumber);
		int mynumber = 1002;
		System.out.println(mynumber);
	}
}