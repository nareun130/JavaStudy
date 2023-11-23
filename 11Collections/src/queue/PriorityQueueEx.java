package queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
	public static void main(String[] args) {
		// * 우선순위 큐는 힙 자료구조로 저장되어있음. 
		Queue pq = new PriorityQueue();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);

		Object obj = null;

		while ((obj = pq.poll()) != null)
			System.out.println(obj);
	}
}
