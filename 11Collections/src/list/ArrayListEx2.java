package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();

		//* 자동적으로 크기가 늘어나는 것은 소요 시간이 많이 걸림
		List list = new ArrayList(length / LIMIT + 10); // 크기를 약간 여유있게 잡아준다.

		for (int i = 0; i < length; i += LIMIT) {
			if (i + LIMIT < length) {
				list.add(source.substring(i, i + LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
