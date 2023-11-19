package math;

import static java.lang.System.*;
import static java.lang.Math.*;

public class MathEx2 {
	public static void main(String[] args) {
		int i = Integer.MIN_VALUE;

		out.println("i = " + i);
		out.println("-i = " + (-i)); // 오버 플로우 발생 ~a+1 이므로

		try {
			out.printf("negateExact(%d)=%d%n", 10, negateExact(10));
			out.printf("negateExact(%d)=%d%n", -10, negateExact(-10));
			// 매개변수의 부호를 반대로 바꿔줌 -> Exception 발생 시킴 ~> overFlow 여부 확인 가능 
			out.printf("negateExact(%d)=%d%n", i, negateExact(i)); 
			
		} catch (ArithmeticException e) {
			out.printf("negateExact(%d)=%d%n", (long) i, negateExact((long) i));
		}

	}
}
