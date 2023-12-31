package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx4 {
	public static void main(String[] args) {

		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source:" + source);

		int i = 0;
		while (m.find()) {
			System.out.println(++i + "번재 매칭 : " + m.start() + "~" + m.end());
			// broken을 drunken으로 치환하여 sb에 저장.
			System.out.println("바뀌기 전 sb : " + sb.toString());
			m.appendReplacement(sb, "drunken");
			System.out.println("바뀐 후 sb : " + sb.toString());
		}
		// 마지막으로 치환된 이후의 부분을 sb에 덧붙인다.
		m.appendTail(sb);
		System.out.println("Replacement count : " + i);
		System.out.println("result : " + sb.toString());

	}
}
