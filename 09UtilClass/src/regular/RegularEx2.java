package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2 {
	public static void main(String[] args) {
		String[] data = { "bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date",
				"disc" };
		String[] patterns = { ".*", "c[a-z]*", "c[a-z]", "c[a-zA-z]", "c[a-zA-Z0-9]", "c.", "c.*", "c\\.", "c\\w",
				"c\\d", "c.*t", "[b|c].*", ".*a.*", ".*a.+", "[b|c].[2]" };

		for (String pattern : patterns) {
			Pattern p = Pattern.compile(pattern);
			System.out.print("Pattern : " + p + " 결과 : ");
			for (String d : data) {
				Matcher m = p.matcher(d);
				if (m.matches()) {
					System.out.print(d + ",");
				}
			}
			System.out.println();
		}
	}
}
