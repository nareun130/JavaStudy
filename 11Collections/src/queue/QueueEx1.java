package queue;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("help를 입력하여 도움말 ");

		while (true) {
			System.out.print(">>");
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();

			if ("".equals(input))
				continue;

			if (input.equalsIgnoreCase("q")) {
				System.exit(0);
			} else if (input.equalsIgnoreCase("help")) {
				System.out.println(" help - 도움말을 보여줌.");
				System.out.println(" q 또는 Q - 프로그램 종료 ");
				System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다. ");

			} else if (input.equalsIgnoreCase("history")) {
				int i = 0;
				// 입력받 명령어 저장
				save(input);

				// LinkedList의 내용을 보여줌
				LinkedList tmp = (LinkedList) q;
				ListIterator it = tmp.listIterator();

				while (it.hasNext()) {
					System.out.println(++i + "." + it.next());
				}
			} else {
				save(input);
				System.out.println(input);
			}
		}
	}

	public static void save(String input) {
		// queue에 저장
		if (!"".equals(input))
			q.offer(input);
		// queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제
		if (q.size() > MAX_SIZE)
			q.remove();
	}
}
