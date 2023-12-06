package thread;

public class ThreadEx20 {
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		gc.setDaemon(true);
		gc.start();

		int requiredMemory = 0;

		for (int i = 0; i < 20; i++) {
			requiredMemory = (int) (Math.random() * 10) * 20;

			// 필요한 메모리가 사가능한 양보다 크거나 전체 메모리의 60% 이상을 사용하면 gc 깨움
			if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
				try {
					gc.join(100);// gc가 0.1초 동안 수행될 수 있도록 변경해야 함.
					//interupt로 깨어났어도 join으로 작시간을 어느 정도 주지 않으면 메모리가 1000이 넘어도 gc가 늦게 수행됨.
				} catch (InterruptedException e) {
				}
			}
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory:" + gc.usedMemory);

		}
	}
}

class ThreadEx20_1 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupt().");
			}

			gc();
			System.out.println("Garbage Collected. Free Memory :" + freeMemory());
		}
	}

	public void gc() {
		usedMemory -= 300;
		if (usedMemory < 0)
			usedMemory = 0;
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}