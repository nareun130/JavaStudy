package exception;

public class ExceptionEx12 {
	public static void main(String[] args) throws Exception {
		//* 콜스택에 main -> method1 -> method2 순서대로 쌓여있다.
		//~> 결국 try-catch를 해주지 않아서 마지막 main method가 종료 ->프로글매의 비정상적인 종료  
		method1();
	}

	static void method1() throws Exception {
		method2();
	}

	static void method2() throws Exception {
		throw new Exception();
	}
}
