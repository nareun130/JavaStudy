package set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {
	public static void main(String[] args) {
		Set set = new HashSet();

		for (int i = 0; i < 6; i++) {
			int num = (int) (Math.random() * 45) + 1;
			set.add(Integer.valueOf(num));
		}

		List list = new LinkedList(set);
		//! Collection은 인터페이스, Collections는 클래스 
		Collections.sort(list);
		System.out.println(list);
	}
}
