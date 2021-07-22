package Object1;

/*
 * 总结：属性赋值的先后顺序
 * 
 * 
 * ① 默认初始化
 * ② 显式初始化
 * ③ 构造器中赋值
 * ④ 通过"对象.方法"或"对象.属性"的方式赋值
 * 
 * 以上操作的先后顺序：① - ② - ③ - ④ 	
 */
public class UserTest {
	public static void main(String[] args) {
		User u1 = new User();
		System.out.println(u1.age);

		User u2 = new User(2);
		u2.setAge(3);
		System.out.println(u2.age);
	}
}

class User {
	int age = 1;

	public User() {
	}

	public User(int a) {
		age = a;
	}

	public void setAge(int a) {
		age = a;
	}

}