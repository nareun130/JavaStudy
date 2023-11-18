package string;

public class StringEx {
	public static void main(String[] args) {
		String a = "a";
		System.out.println("a의 해쉬코드 : " + System.identityHashCode(a));
		String b = "b";
		System.out.println("b의 해쉬코드 : " + System.identityHashCode(b));
		a = a + b; // ~> 새로운 객체가 생성
		System.out.println("바뀐 a의 해쉬코드 : " + System.identityHashCode(a));

		String str1 = "abc"; // * str1과 str2은 같은 String인스턴스를 참조
		String str2 = "abc";// * 이 문자열리터럴 값은 상수 저장소에 저장됨.

		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str3 == str4);

		char[] chArr = new char[0];// 길이가 0인 char 배열
		int[] iArr = {};// 길이가 0인 int 배열

	}
}
