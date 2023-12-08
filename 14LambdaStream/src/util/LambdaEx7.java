package util;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaEx7 {
	public static void main(String[] args) {
		// 문자열을 숫자로 (16진수)
		Function<String, Integer> f = s -> Integer.parseInt(s, 16);
		// 숫자를 2진 문자열로
		Function<Integer, String> g = i -> Integer.toBinaryString(i);

		// f를 처리하고 g처리
		Function<String, String> h = f.andThen(g);
		// g를 처리하고 f처리
		Function<Integer, Integer> h2 = f.compose(g);

		System.out.println(h.apply("FF")); // 11111111
		System.out.println(h2.apply(2)); // 16

		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));

		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate(); // i >= 100;

		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));

		String str1 = "abc";
		String str2 = "abc";
		
		//str1과 str2 같은지 비교한 결과를 반환 
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
	}
}
