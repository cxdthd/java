
//题目一
class Something{
	public int addOne(final int x){
//		return ++x;
//		return x++;
		return x + 1;//这种返回没对x进行修改
	}
}


public class MyFinalTest {
	public static void main(String[] args) {
		
	}
	
	public void addOne(final Other o){
//		o = new Other();//o不能更改，所有不能新建对象
		o.i++;
	}
	
}

class Other{
	public int i ;
}


