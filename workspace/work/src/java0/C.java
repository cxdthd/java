package java0;

interface A {
	int x = 0;
}

class B {
	int x = 1;
}

class C extends B implements A {
	public void pX() {
		//System.out.println(x);	//The field x is ambiguous 模棱两可的; 含混不清的; 不明确的;
		System.out.println(super.x);	//1
		//因为接口中的属性是全局常量，所以可以用接口名直接调用
		System.out.println(A.x);	//0
	}

	public static void main(String[] args) {
		new C().pX();
	}
}
