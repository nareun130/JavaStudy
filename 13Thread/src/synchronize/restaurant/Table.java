package synchronize.restaurant;

import java.util.ArrayList;

public class Table {

	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;

	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is wating.");
			try {
				wait();// COOK 쓰레드를 기다리게 한다.
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		dishes.add(dish);
		notify(); // 기다리고 있는 CUST를 깨우기 위해
		System.out.println("Dishes:" + dishes.toString());
	}

	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait();// CUST 쓰레드를 기다리게 한다
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
			while (true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();// 자고있는 COOK을 깨우기 위함.
						return;
					}
				}
				try {
					System.out.println(name + " is waiting.");
					wait();// 원하는 음식이 없는 CUST 쓰레드를 기다리게 함.
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public int disNum() {
		return dishNames.length;
	}

}
