package thread;

import java.util.Iterator;
import java.util.Map;

public class ThreadEx11 {
	public static void main(String[] args) {
		ThreadEx11_1 t1 = new ThreadEx11_1("Thread1");
		ThreadEx11_2 t2 = new ThreadEx11_2("Thread2");
		t1.start();
		t2.start();
	}

}

class ThreadEx11_1 extends Thread {
	public ThreadEx11_1(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			// 5초 동안 대기
			sleep(5 * 1000);
		} catch (InterruptedException e) {
		}
	}
}

class ThreadEx11_2 extends Thread {
	public ThreadEx11_2(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 실행 중 또는 대기 상태의 작업 완료 x 모든 쓰레드의 호출스택 출력
		Map<Thread, StackTraceElement[]> map = getAllStackTraces();
		Iterator<Thread> it = map.keySet().iterator();

		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread) obj;
			StackTraceElement[] ste = (StackTraceElement[]) (map.get(obj));

			System.out.println("[" + ++x + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName()
					+ ", demon : " + t.isDaemon());

			for (int i = 0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}

			System.out.println();
		}
	}
}
