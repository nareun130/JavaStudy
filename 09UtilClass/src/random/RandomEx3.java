package random;

import java.util.Arrays;

public class RandomEx3 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(getRand(5, 10) + ",");
		}

		System.out.println();
		int[] result = fillRand(new int[10], new int[] { 2, 3, 7, 5 });

		System.out.println(Arrays.toString(result));

	}

	private static int[] fillRand(int[] arr, int[] data) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = data[getRand(0, data.length - 1)];
		}
		return arr;
	}

	//* from과 to 사이의 정수값을 반환 from과 to 모두 범위에 포함.
	private static int getRand(int from, int to) {

		return (int) (Math.random() * (Math.abs(to - from) + 1)) + Math.min(from, to);
	}
}
