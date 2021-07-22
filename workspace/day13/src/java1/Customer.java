package java1;

public class Customer {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer() {
		super();
	}

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

// 自动生成的equals()方法
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Customer other = (Customer) obj;
	if (age != other.age)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}



// //重写的原则：比较两个对象的实体内容(即：name和age)是否相同
// //手动实现
// @Override
// public boolean equals(Object obj) {
// if (this == obj) {
// return true;
// }
// if (obj instanceof Customer) {
//
// // 方法一
// // if (this.name.equals(((Customer) obj).name) && this.age ==
// // ((Customer) obj).age) {
// // return true;
// // }
//
// // 方法二
// return this.name.equals(((Customer) obj).name) && this.age == ((Customer)
// obj).age;
// }
//
// return false;
// }
	
	
	//手动实现
	// @Override
	// public String toString() {
	// return name + age;
	// }
	//自动生成toString()方法
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

}
