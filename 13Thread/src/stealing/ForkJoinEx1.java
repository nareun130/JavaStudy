package stealing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
	static final ForkJoinPool pool = new ForkJoinPool();
	
	public static void main(String[] args) {
		long from = 1L, to = 100_000_000L;
		
		SumTask task = new SumTask(from, to);
		
		long start = System.currentTimeMillis();
		Long result = pool.invoke(task);
		System.out.println("Elapsed time(10 Core):"+(System.currentTimeMillis()-start));
		
		System.out.printf("sum of %d~%d=%d%n",from,to,result);
		System.out.println();
		
		result = 0L;
		start = System.currentTimeMillis();
		for(long i = from; i<=to; i++)
			result +=i;
		System.out.println("Elapsed time(1 Core):"+(System.currentTimeMillis()-start));
		System.out.printf("sum of %d~%d=%d%n",from,to,result);
	}
	
}

class SumTask extends RecursiveTask<Long> {
	long from, to;

	public SumTask(long from, long to) {
		this.from = from;
		this.to = to;
	}

	@Override
	protected Long compute() {
		long size = to - from + 1;

		if (size <= 5)
			return sum();

		long half = (from + to) / 2;
		// 범위를 반으로 나눠서 두 개의 작업을 생성
		SumTask leftSum = new SumTask(from, half);
		SumTask rightSum = new SumTask(half + 1, to);

		leftSum.fork();// 작업을 쓰레드 풀의 작업 큐에 넣음 -> 비동기
		//join : 해당 작업의 수행이 끝날 때까지 기다렸다가, 수행이 끝나면 결과를 반환 -> 동기 메서드
		//~> returne에서 comput()재귀호출 시 join은 호출x 
		//더 이상 작업을 나눌 수 없을 때 compute()재귀호출 끝나고 join()의 결과를 기다렸다가 더해서 결과를 반환 
		return rightSum.compute() + leftSum.join();  

	}

	long sum() {
		long tmp = 0L;

		for (long i = from; i <= to; i++) {
			tmp += i;
		}

		return tmp;
	}

}
