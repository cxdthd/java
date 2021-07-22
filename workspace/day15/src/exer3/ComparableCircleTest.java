package exer3;

public class ComparableCircleTest {
	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(2.9999);
		ComparableCircle c2 = new ComparableCircle(2.9998);
		int compareTo = c1.compareTo(c2);
		
		if (compareTo >0){
			System.out.println("c1对象大");
		}else if(compareTo < 0 ){
			System.out.println("c2对象大");
		}else{
			System.out.println("一样大");
		}
		
		System.out.println(compareTo);
		
		System.out.println("*********************************");
		
		int compareTo2 = c1.compareTo(new String("AA"));
		System.out.println(compareTo2);
	}
}
