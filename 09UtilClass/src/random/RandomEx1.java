package random;

import java.nio.file.spi.FileSystemProvider;
import java.util.Random;

public class RandomEx1 {
	public static void main(String[] args) {
		// Math.random();과 동일
		double randNum = new Random().nextDouble(); // 0~1 사이의 난수 생성
		System.out.println(randNum);

		Random rand = new Random(1); // seed(종자값)으로 Random객체 생성 
		Random rand2 = new Random(1);

		//! 같은 종자값이라서 같은 순서로 반환 -+
		System.out.println("=rand=");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + ":" + rand.nextInt());
		}
		System.out.println();
		System.out.println("=rand2=");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + ":" + rand2.nextInt());
		}
	}
}
