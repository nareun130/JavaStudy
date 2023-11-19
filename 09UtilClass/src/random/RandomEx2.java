package random;

import java.util.Random;

public class RandomEx2 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] number = new int[100];
		int[] counter = new int[10];

		for (int i = 0; i < number.length; i++) {
			// 0~9까지 임의의 정수 생성 ~> 대입하면서 생성
//			System.out.print(number[i] = (int) (Math.random() * 10));
			// 0<=x<10의 정수 반환
			System.out.print(number[i] = rand.nextInt(10));
		}
		System.out.println();

		// * 이렇게도 처리가 가능!
		for (int i = 0; i < number.length; i++) {
			counter[number[i]]++;
		}

		for (int i = 0; i < counter.length; i++) {
			System.out.println(i + "의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
		}

	}

	private static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);

	}
}
