package math;

import java.math.BigInteger;

public class BigIntegerEx2 {
	public static void main(String[] args) throws Exception {
		// * long 타입으로는 20! 까지 밖에 계산 불가
		for (int i = 1; i < 100; i++) {
			System.out.printf("%d!=%s%n", i, calcFactorial(i));
			Thread.sleep(300); // 0.3초 지연
		}
		// 10의 6억 제곱
		System.out.println(Math.log10(2) * Integer.MAX_VALUE);

	}

	private static String calcFactorial(int n) {

		return factorial(BigInteger.valueOf(n)).toString();
	}

	private static BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		else
			return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}
