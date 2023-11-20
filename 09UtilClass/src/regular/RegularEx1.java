package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {
	public static void main(String[] args) {
		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date",
				"disc" };
		// c로 시작하는 소문자 영단어
		Pattern p = Pattern.compile("c[a-z]*");

		for (String str : data) {
			Matcher m = p.matcher(str);
			if (m.matches()) {
				System.out.println(str + ", ");
			}
		}
	}
}
