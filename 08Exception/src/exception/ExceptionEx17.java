package exception;

public class ExceptionEx17 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println("main에서 예외 처림 됨.");
		}
	}

	static void method1() throws Exception {
		try {
			throw new Exception("method1에서 예외 발생시킴 ");
		} catch (Exception e) {
			System.out.println("error msg : " + e.getMessage());
			System.out.println("method1에서 예외 처리 됨.");
			throw e;// 다시 예외 발생 시킴.
		}
	}
}
