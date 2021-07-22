package myexer;

public class Student extends Person {
	long number;
	int math;
	int english;
	int computer;

	public Student() {

	}

	public Student(String n, char s, int a, long k, int m, int e, int c) {
		this.name = n;
		this.sex = s;
		this.age = a;
		this.number = k;
		this.math = m;
		this.english = e;
		this.computer = c;
	}

	public double aver() {
		return (double) (math + english + computer) / 3;
	}

	public int max() {
		int m, n;
		m = (math > english) ? math : english;
		n = (m > computer) ? m : computer;
		return n;
	}

	public int min() {
		int m, n;
		m = (math < english) ? math : english;
		n = (m < computer) ? m : computer;
		return n;
	}

	public String toString() {

		return "name:" + name + ",sex:" + sex + ",age:" + age + ",number:" + number + "，math:" + math + ",english:"
				+ english + ",computer:" + computer;
	}

}
