package string;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringEx5 {
	public static void main(String[] args) throws Exception {
		String str = "가";

		byte[] bArr = str.getBytes("UTF-8");
		System.out.println(Arrays.toString(bArr));
		byte[] bArr2 = str.getBytes("CP949");

		System.out.println("UTF-8 : " + joinByteArr(bArr));
		System.out.println("CP949 : " + joinByteArr(bArr2));

		System.out.println("UTF-8 : " + new String(bArr, "UTF-8"));
		System.out.println("CP949 : " + new String(bArr2, "CP949"));

		int i = 100;
		String str1 = i + "";
		String str2 = String.valueOf(i); // * valueOf가 성능은 더 좋음

	}

	// UTF-8, CP949 문자열로 변환
	private static String joinByteArr(byte[] bArr) {
		StringJoiner sj = new StringJoiner(":", "[", "]");

		// 0xEAB080
		// 0xB0A1
		for (byte b : bArr)
			// * 2자리 16진수로 포맷 설정
			sj.add(String.format("%02X", b));

		return sj.toString();

	}

	//
}
