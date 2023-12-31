package basic;

@FunctionalInterface
interface MyFunction3{
	void myMethod();
}
public class LambdaEx3 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}

class Outer{

	int val = 10; // Outer.this.val
	
	class Inner{
		int val = 20; // this.val
		
		void method(int i) {
			int val = 30; //final int val = 30;
//			i = 10; // 상수 값 변경 x 
			
			MyFunction3 f = ()->{ // 외부 직역변수와 같은 이름의 람다식 매개변수 x
				System.out.println("           i   : "+ i);
				System.out.println("           val : "+ val);
				System.out.println("      this.val : "+ ++this.val);
				System.out.println("Outer.this.val : "+ ++Outer.this.val);
			};
			
			f.myMethod();
		}
	}

}