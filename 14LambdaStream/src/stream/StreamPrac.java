package stream;

import java.util.stream.Stream;

public class StreamPrac {
	public static void main(String[] args) {
		String[] names = { "java", "python", "dart", "javascript" };
		Stream<String> nameStrm = Stream.of(names);
		// 최종 연산을 하지 않으면 peek은 돌아가지 않는다.
		nameStrm.peek(s -> System.out.println("peek : " + s))
				.map(s -> s.toUpperCase())
				.sorted()
				.forEach(s -> System.out.println(s));
		;
	}
}
