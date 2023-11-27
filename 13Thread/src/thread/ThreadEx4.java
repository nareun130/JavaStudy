package thread;

public class ThreadEx4 {
	//싱글 스레드로 계산을 돌렸을 때 실행결과 
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println("소요시간1:" + (System.currentTimeMillis() - startTime));

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));

		}
		System.out.println("소요시간2:" + (System.currentTimeMillis() - startTime));
	}
}
