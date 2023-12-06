package synchronize.case2;

import java.util.ArrayList;

public class ThreadWaitEx2 {
	/*
	 * 문제
	 * 
	 * 손님 쓰레드가 lock을 쥐고 기다리고 있음.
	 * eatFood() -> remove : 여기서 lock 
	 * ~> wait() & notify()로 해결 
	 * wiat()으로 lock을 풀고 기다리다가 음식 추가가되면 notify()로 통보받고
	 * 다시 lock을 얻어 나머지 작업을 진행 
	 */
	public static void main(String[] args) throws Exception {
		Table table = new Table();
		
		new Thread(new Cook(table),"COOK1").start();
		new Thread(new Customer(table, "donut"),"CUST1").start();
		new Thread(new Customer(table, "burger"),"CUST2").start();
		
		Thread.sleep(5000);
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
			if (eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}

	boolean eatFood() {
		return table.remove(food);
	}
}

class Cook implements Runnable {
	private Table table;

	public Cook(Table table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes:" + dish.toString());
	}

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is wating.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public int dishNum() {
		return dishNames.length;
	}
}
