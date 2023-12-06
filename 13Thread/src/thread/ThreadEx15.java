 package thread;

public class ThreadEx15 {
	public static void main(String[] args) {
		RunImplEx15 r = new RunImplEx15();
		Thread th1 = new Thread(r,"*");
		Thread th2= new Thread(r,"**");
		Thread th3 = new Thread(r,"***");
		Timer timer = new Timer();
		Thread counter = new Thread(timer,"timer");
		th1.start();
		th2.start();
		th3.start();
		counter.start();
//		counter.setDaemon(true);
		
		try {
			Thread.sleep(2000);
			System.out.println("th1 중지 ");
			th1.suspend();// th1 일시 중지 
			Thread.sleep(2000);
			System.out.println("th2 중지 ");
			th2.suspend();
			Thread.sleep(3000);
			System.out.println("th1 재동작 ");
			th1.resume();//th1 재동작 
			Thread.sleep(3000);
			System.out.println("th1 종료 ");
			th1.stop();//th1 강제 종료  
			System.out.println("th2 종료 ");
			th2.stop();
			Thread.sleep(2000);
			System.out.println("th3 종료 ");
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
class Timer implements Runnable{
	int count = 0;
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println(++count+"초 ");
				Thread.sleep(1000);
				
			}
			
		} catch (InterruptedException e) {
		}
	}
}