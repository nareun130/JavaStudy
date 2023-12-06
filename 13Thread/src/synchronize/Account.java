package synchronize;

public class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int money) {
		// 1. 메서드에 synchronized를 쓰는 경우
//	public synchronized void withdraw(int money) {

		// 2.synchronized블럭을 사용하는 경우 -> 이걸로 임계영역 최소화 하는게 효율적 
		synchronized (this) {
			if (balance >= money) {
				// * if문을 통과하자마자 다른 쓰레드에게 제어권을 넘김.
				// 그래서 잔고가 0인 상태에서도 출금이 되버리는 경우가 생겨버림
				// 조건식이 true인 상태에서 sleep을 통해 다른 쓰레드에게 제어권이 넘어가며
				// 다른 쓰레드에서 출금한 경우 -가 되버리는 상황이 발생
				// ~> 동기화가 필요!!
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				balance -= money;
			}
		}

	}

}
