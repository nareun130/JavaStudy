package wrapper;

public class WrapperEx2 {
	public static void main(String[] args) {
		int i = new Integer("100");
		int i2 = Integer.parseInt("100");// 이 방법을 젤 많이 사용.
		Integer i3 = Integer.parseInt("100");

		int i4 = Integer.valueOf("100"); // ~> parseInt가 성능이 좀 더 좋다.

		// 진수값으로 나타내기 -> 기본 : 10진수 
		int dI = Integer.valueOf("100", 2);
		int oI = Integer.valueOf("100", 8);
		int hI = Integer.valueOf("100", 16);
		int hI2 = Integer.valueOf("FF", 16);

		System.out.println(dI);
		System.out.println(oI);
		System.out.println(hI);
		System.out.println(hI2);

	}

}
