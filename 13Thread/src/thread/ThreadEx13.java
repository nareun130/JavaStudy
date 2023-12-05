package thread;

import javax.swing.JOptionPane;

public class ThreadEx13 {
public static void main(String[] args) {
	ThreadEx13_1 th1 = new ThreadEx13_1();
	th1.start();
	String input = JOptionPane.showInputDialog("아무 값이나 입력");
	System.out.println("입력한 값은 "+ input);
	th1.interrupt();// interrupted 상태를 true로 
	System.out.println("isInterrupted():"+th1.isInterrupted());

}
}
class ThreadEx13_1 extends Thread{
	@Override
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x<Long.MAX_VALUE; x++); // 시간 지연 
		}
		System.out.println("카운트 종료");
	}
}