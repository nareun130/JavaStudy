package string;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringEx4 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello");
		String hello = new String(sb);
		System.out.println(hello);

		int firstIndex = hello.indexOf('l');//indexOf(int ch) ~> 보충문자 지원 : 유니코드 16비트 -> 20비트로 확장 
		int lastIndex = hello.lastIndexOf('l');
		int lIndex = hello.indexOf('l', 3);
		System.out.printf("firstIndex : %d, lastIndex : %d, lIndex : %d \n", firstIndex, lastIndex, lIndex);

		String abc1 = new String("abc");
		String abc2 = new String("abc");
		boolean b1 = (abc1 == abc2);
		boolean b2 = (abc1.equals(abc2));
		boolean b3 = abc1.intern() == abc2.intern();

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);

		String animals = "dog,cat,bear,duck,eagle";
		String[] aniArr = animals.split(",");
		String[] aniArr2 = animals.split(",", 3);// * 지정된 수 만큼 자름
		System.out.println(Arrays.toString(aniArr));
		System.out.println(aniArr.length);
		System.out.println(Arrays.toString(aniArr2));
		System.out.println(aniArr2.length);
		System.out.println(aniArr2[0]);
		System.out.println(aniArr2[1]);
		System.out.println(aniArr2[2]);

		// String - join
		String joinAnimals = (String) String.join("-", aniArr);
		System.out.println(joinAnimals);

		// *StringJoiner
		StringJoiner sj = new StringJoiner(",", "[", "]");
		String[] strArr = { "aaa", "bbb", "ccc" };

		for (String s : strArr) {
			sj.add(s.toUpperCase());
		}

		System.out.println(sj.toString());

		StringJoiner sj2 = new StringJoiner("&", "{", "}");
		for (String s : aniArr2) {
			sj2.add(s.toUpperCase());
		}
		System.out.println(sj2.toString());

	}

}
