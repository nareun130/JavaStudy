package synchronize.case3;

import java.util.ArrayList;

public class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 
		 * waiting pool에 요리사 쓰레드와 손님 쓰레드가 같이 기다리고 있음. 
		 * notify()호출 시 요리사 쓰레드와 손님 쓰레드 중 누가 통지 받을 지 알 수 x
		 * 
		 * 만약 테이블의 음식이 줄어들어 notify() 호출되면 요리사가 통지를 받아야 함. 
		 * 하지만 notify()는 그저 waiting pool에서 대기 중인 쓰레드 중 하나를 임의로 선택해서 통지만 할뿐
		 * 요리사 쓰레드를 선택해서 통지가 안 됨.
		 * ~> notifyAll로 기아현상을 막아도 손님쓰레드까지 통지를 받음
		 * -> 불필요하게 요리사 쓰레드와 lock을 얻으려고 경쟁하게 됨. 
		 * => Look과 Condition 이용 선별적인 통지를 해야 함.  
		 */
		Table table = new Table();
		
		new Thread(new Cook(table),"COOK1").start();
		new Thread(new Customer(table, "donut"),"CUST1").start();
		new Thread(new Customer(table, "burger"),"CUST2").start();
		Thread.sleep(2000);
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
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			String name = Thread.currentThread().getName();

			table.remove(food);
			System.out.println(name + " ate a " + food);
		}
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
				Thread.sleep(10);
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
		while (dishes.size() >= MAX_FOOD) {
			//요리가 table에 가득차면 기다림
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();

			while (dishes.size() == 0) {
				System.out.println(name + " is waiting");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			while (true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}
				System.out.println(name + " is waiting");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}

			}
		}
	}

	public int dishNum() {
		return dishNames.length;
	}

}