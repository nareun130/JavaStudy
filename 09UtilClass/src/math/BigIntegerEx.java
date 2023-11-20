package math;

import java.math.BigInteger;

public class BigIntegerEx {
	public static void main(String[] args) {
		BigInteger bi = new BigInteger("4");
		// * 짝수 검사 -> 짝수는 제일 오른쪽 비트가 0일 것이므로, testBit(0)으로 마지막 비트 확인하는 게 더 효율적
		long time1 = 0, time2 = 0;
		long start = System.currentTimeMillis();
		if (bi.remainder(new BigInteger("2")).equals(BigInteger.ZERO)) {
			System.out.println("짝수");
		}
		long end = System.currentTimeMillis();
		time1 = end - start;
		System.out.println("bi.remainder(new BigInteger(\"2\")).equals(BigInteger.ZERO)걸린 시간 : " + time1);
		start = 0;
		end = 0;

		start = System.currentTimeMillis();
		if (bi.testBit(0)) {
			System.out.println("짝수");
		}
		end = System.currentTimeMillis();
		time2 = end - start;
		System.out.println("bi.testBit(0)걸린 시간 : " + time2);
		System.out.println("time1 > time2?" + (time1 > time2));
	}
}
