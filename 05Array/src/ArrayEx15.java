
public class ArrayEx15 {
	public static void main(String[] args) {
		String source = "SOHELP";

		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		String result = "";

		for (int i = 0; i < source.length(); i++) {
			//charAt(i)는 아스키 코드 65 리턴 하므로 - 'A'를 해주어서 배열 인덱스값을 맞춰준다.
			result += morse[source.charAt(i)-'A'];
		}
		System.out.println("source : " + source);
		System.out.println("morse : " + result);
	}
}
