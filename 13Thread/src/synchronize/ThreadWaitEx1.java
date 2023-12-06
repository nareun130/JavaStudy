package synchronize;

import synchronize.restaurant.Cook;
import synchronize.restaurant.Customer;
import synchronize.restaurant.Table;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception {
		Table table = new Table();
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		Thread.sleep(2000);
		System.exit(0);// 시스템 종료 -> 모든 쓰레드 종료

	}
}

