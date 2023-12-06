package synchronize.case1;

import java.util.ArrayList;


public class ThreadWaitEx1 {
	/*
	 * 요리사는 1 ms마다 요리 생성 손님은 10ms 마다 음식 먹음
	 * 
	 * 문제1.
	 * 
	 * java.util.ConcurrentModificationException : 요리(Cook)사가 음식을 놓는도중에,
	 * 손님(Customer)이 음식을 가져가려 해서
	 * 
	 * 문제2.
	 * 
	 * java.lang.IndexOutOfBoundsException : 테이블의 마지막남은 음식을 가져가는 도중에 다른 손님 쓰레가
	 * 먼저 음식을 낚아서 있지도 않은 임식을 제거하려해서 
	 * 
	 * ~> 동기화가 필요하다!
	 */

	public static void main(String[] args) throws Exception {
		Table table = new Table();

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		Thread.sleep(100);
		System.exit(0);

	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	public Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			String name = Thread.currentThread().getName();
			if (eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. :(");
		}
	}

	boolean eatFood() {
		return table.remove(food);
	}

}

class Cook implements Runnable {
	private Table table;

	Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			// 임의의 요리 하나를 table에 추가
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}

}

class Table {

	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;

	private ArrayList<String> dishes = new ArrayList<>();

	public void add(String dish) {
		// 음식이 가득차면, 추가 x
		if (dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
	}

	public boolean remove(String dishName) {
		// 지정된 요리와일치하는 것을 제거
		for (int i = 0; i < dishes.size(); i++) {
			if (dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}

	public double dishNum() {
		return dishNames.length;
	}

}
