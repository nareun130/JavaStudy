package thread;

public class ThreadEx1 {
	public static void main(String[] args) {
		ThreadEx_1 t1 = new ThreadEx_1();

		Runnable r = new ThreadEx_2();
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class ThreadEx_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			// Thread의 메서드 getName();
			System.out.println(getName());
		}
	}
}

class ThreadEx_2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			//Thread.currentThread() : 현재 실행중인 Thread 반환 
			System.out.println(Thread.currentThread().getName());  
		}
	}
}