package java2;

public class InnerClassTest2 {

	//开发中很少见
	public void method(){
		
		class AA{
			
		}
	}
	
	//返回一个实现了Comparable接口类的对象
	public Comparable getComparable(){
		
		//创建一个实现了Comparable接口的类：局部内部类
		//方式一:创建了一个有名的实现类的匿名对象
//		class MyComparable implements Comparable{
//
//			@Override
//			public int compareTo(Object o) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		}
//		
//		return new MyComparable();
		
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
