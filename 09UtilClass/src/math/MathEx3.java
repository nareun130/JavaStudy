package math;

import static java.lang.Math.*;
import static java.lang.System.*;

public class MathEx3 {
	public static void main(String[] args) {
		// (x1,y1)= (1,1);
		int x1 = 1, y1 = 1;
		// (x2, y2) = (2,2);
		int x2 = 2, y2 = 2;

		// 두 점 사이의 거리 -> 빗변으로 하는 직각 삼각형
		double c = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
		// * Math에 PI와 자연상수 E가 상수로 정의되어 있음.
		double a = c * sin(PI / 4); // * cos(45도= 4분의 PI) -> 2^-1/2
//		double b = c * cos(toRadians(45)); // * 각도를 radian으로 변환
		double b = c * cos(PI / 4);

		out.printf("높이 a=%f%n", a);
		out.printf("밑변 b=%f%n", b);
		out.printf("빗변 c=%f%n", c);
		out.printf("a와b의 끼인 각=%f rad %n", atan2(a, b));
		out.printf("a와b의 끼인 각=%f%n", toDegrees(atan2(a, b)));// atan2(a,b) * 180/PI

		out.printf("10진수 2^24의 자릿수 = %f%n", 24 * log10(2)); // ~> float의 정밀도 7
		out.printf("53*log10(2)=%f%n", 53 * log10(2));// ~> double의 정밀도 15 

	}
}
