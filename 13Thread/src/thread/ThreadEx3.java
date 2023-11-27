package thread;

public class ThreadEx3 {
	public static void main(String[] args) {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run(); //~> main에서 잡힌다. 
	}
}

class ThreadEx3_1 extends Thread {
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