package thread;

public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		t.setDaemon(true); // 이 부분이 없으면 종료 x
		//~> start전에 Demon 설정해야 함. 
		t.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.println(i);

			if (i == 5)
				autoSave = true;

		}
	}

	@Override
	public void run() {
		//* 3 초마다 autoSave값을 확인해서 autoSave() 실행 
		//~> demon으로 설정 안하면 영원히 종료 x
		while (true) {
			try {
				Thread.sleep(3 * 1000);// 3초마다
			} catch (InterruptedException e) {
			}
			System.out.println("autoSave 확인 : "+ autoSave);
			if (autoSave) {
				autoSave();
			}
		}
	}

	private void autoSave() {
		System.out.println("작업파일을 자동저장.");
	}

}
