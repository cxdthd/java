package exer2;

public class MyDateTest {
	public static void main(String[] args) {
		MyDate m1 = new MyDate(14, 3, 1976);
		MyDate m2 = new MyDate(14, 3, 1976);
		if (m1 == m2) {
			System.out.println("m1==m2");
		} else {
			System.out.println("m1!=m2"); // m1 != m2
		}

		if (m1.equals(m2)) {
			System.out.println("m1 is equal to m2");// m1 is equal to m2
		} else {
			System.out.println("m1 is not equal to m2");
		}
	}
}

class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof MyDate) {
			MyDate o = (MyDate) obj;
			if (year == o.year && month == o.month && day == o.day) {
				return true;
			}
		}
		return false;
	}

}