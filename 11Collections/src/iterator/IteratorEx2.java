package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);

		for (int i = 0; i < 10; i++) {
			original.add(i + "");
		}

		Iterator it = original.iterator();

		while (it.hasNext()) {
			copy1.add(it.next());
		}
		System.out.println("=Original에서 copy1로 복사 ");
		System.out.println("original : " + original);
		System.out.println("copy1 : " + copy1);
		System.out.println();

		it = original.iterator();// Iterator는 재사용 불가 -> 다시 얻어야 함

		while (it.hasNext()) {
			copy2.add(it.next());
			//next로 가져와야 remove가능 
			it.remove();
		}
		System.out.println("Originl에서 copy2로 이동 ");
		System.out.println("original : " + original);
		System.out.println("copy2 : " + copy2);

	}
}
