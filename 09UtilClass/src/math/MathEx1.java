package math;

import static java.lang.System.*;
import static java.lang.Math.*;

public class MathEx1 {
	public static void main(String[] args) {
		double val = 90.7552;
		out.println("round(" + val + ")=" + round(val));
		val *= 100;

		out.println("round(" + val + ")=" + round(val));// 반올림

		out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5));// 두 정수 가운데 가장 가까운 짝수 정수 반환

		out.printf("ceil(%3.1f)=%1.1f%n", -1.5, ceil(-1.5));// 올림

		out.printf("floor(%3.1f)=%f%n", -1.5, floor(-1.5)); // 버림

	}
}
