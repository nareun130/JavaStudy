package thread;

public class ThreadEx2 {
	public static void main(String[] args) {
		
		//호출 스택의 첫 번째 메서드는 main이 아닌, run 메서드
		//~> exception을 던져도 maindㅔ서 잡히지 않는다. 
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();

	}
}

class ThreadEx2_1 extends Thread {
	@Override
	public void run() {
		throwException();
	}

	private void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class ExceptionClass {
	public void throwException() throws Exception {
		throw new Exception();
	}
}