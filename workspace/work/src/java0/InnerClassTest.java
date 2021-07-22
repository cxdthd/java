package java0;

public class InnerClassTest {
	
	
	public Comparable getComparable(){
		
		//方式二:创建了匿名实现类的匿名对象
		return new Comparable(){

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
	}
}
	