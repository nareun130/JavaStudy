package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");

		System.out.println("sb == sb2 ? " + (sb == sb2));
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));

		String s = sb.toString();
		String s2 = sb2.toString();

		System.out.println("s.equals(s2) ? : " + s.equals(s2));

		StringBuffer sb3 = new StringBuffer("0123456");// * 기존16 + length:7 추가
		sb3.insert(4, '.');

		System.out.println(sb3);
		System.out.println(sb3.capacity());

		StringBuffer defaultSb = new StringBuffer();
		System.out.println(defaultSb.capacity());

		String korean = "가나다라마바사아자차카타파하";
		List<Character> koreanList = new ArrayList<Character>();
		for (char kor : korean.toCharArray()) {
			koreanList.add(kor);
		}

		koreanList.sort((a, b) -> b - a);
		System.out.println(koreanList);

		StringBuffer koreanBuffer = new StringBuffer(korean);
		String koreanReverse = koreanBuffer.reverse().toString();
		System.out.println(koreanBuffer);
		System.out.println(koreanReverse);

	}
}
