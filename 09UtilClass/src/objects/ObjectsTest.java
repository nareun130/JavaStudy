package objects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ObjectsTest {
	public static void main(String[] args) {

		String[][] str2D = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };
		String[][] str2D_2 = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };

		System.out.print("str2D = {");
		for (String[] arr : str2D) {
			System.out.print(Arrays.toString(arr));
		}
		System.out.println("}");

		System.out.print("str2D_2 = {");
		for (String[] arr : str2D_2) {
			System.out.print(Arrays.toString(arr));
		}
		System.out.println("}");

		// ~> Object가 아닌 Obejects
		System.out.println("equals(str2D, str2D_2)=" + Objects.equals(str2D, str2D_2));
		// ~> 재귀적으로 검사
		System.out.println("deepEquals(str2D, str2D_2)=" + Objects.deepEquals(str2D, str2D_2));
		System.out.println("isNull(null)=" + Objects.isNull(null));
		System.out.println("isNull(null)=" + Objects.nonNull(null));
		System.out.println("hashCode(null)=" + Objects.hashCode(null));// ~> 0
		System.out.println("toString(null,\"@\")=" + Objects.toString(null, "@")); // null 기본값 @

		Comparator c = String.CASE_INSENSITIVE_ORDER;// 대소문자 비교 x

		System.out.println("compare(\"aa\",\"bb\")=" + Objects.compare("aa", "bb", c));
		System.out.println("compare(\"bb\",\"aa\")=" + Objects.compare("bb", "aa", c));
		System.out.println("compare(\"ab\",\"AB\")=" + Objects.compare("ab", "AB", c));
	}
}
