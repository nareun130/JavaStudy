package thread;

import javax.swing.JOptionPane;

public class ThreadEx14 {
	public static void main(String[] args) {
		ThreadEx14_1 th1 = new ThreadEx14_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력.");
		System.out.println("입력한 값은 " +input);
		th1.interrupt();
		System.out.println("IsInterrupted():"+th1.isInterrupted());
		
	}
}

class ThreadEx14_1 extends Thread {
	@Override
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//~> sleep()에 의해 Thread가 잠시 멈춰 있을 때, interrupt()호출로
				//InterruptedException 발생 
				//interrupted 상태는 false로 자동 초기화 됨. 
				interrupt();//* 이걸 추가해야 interrupted 상태가 true로 바뀜
			}
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}