package work;

public class E{
	
	public static void main(String[] args) {
		
		sub sub = new sub();
		//非匿名类非匿名对象
		method1(sub);
		
		//匿名对象
		method1(new sub());
		
		//匿名类
		Super sub1 = new Super(){

			@Override
			public void show1() {
				// TODO Auto-generated method stub
				System.out.println("匿名类的show1方法");
			}

			@Override
			public void show2() {
				// TODO Auto-generated method stub
				System.out.println("匿名类的show2方法");
			}
			
		};//这里的;一定要记得写
		
		method1(sub1);
		
		//匿名类的匿名对象
		method1(new Super(){

			@Override
			public void show1() {
				// TODO Auto-generated method stub
				System.out.println("匿名类匿名对象的show1方法");
			}

			@Override
			public void show2() {
				// TODO Auto-generated method stub
				System.out.println("匿名类匿名对象的show2方法");
			}
			
		});
		
	}
	
	public  static void method1(Super s){
		s.show1();
		s.show2();
	}
}

class sub extends Super{

	@Override
	public void show1() {
		System.out.println("show1");
		
	}
	
	@Override
	public void show2() {
		System.out.println("show1");
		
	}
	
}


abstract class Super{
	
	 public abstract void show1();
	 
	 public abstract void show2();
	 
	
}