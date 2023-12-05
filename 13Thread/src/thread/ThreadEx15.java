 package thread;

public class ThreadEx15 {
	public static void main(String[] args) {
		RunImplEx15 r = new RunImplEx15();
		Thread th1 = new Thread(r,"*");
		Thread th2= new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();// th1 일시 중지 
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();//th1 재동작 
			Thread.sleep(3000);
			th1.stop();//th1 강제 종료  
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class RunImplEx15 implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}