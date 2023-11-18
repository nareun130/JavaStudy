package string;

public class StringEx3 {
	public static void main(String[] args) {
		char[] chArr = new char[0]; // chArr= {};
		String s = new String(chArr); // new String ("");

		String str1 = null;
		String str2 = "";
		char ch1 = '\u0000';
		char ch2 = ' ';// ~> 공백이 하나 들어 가줘야 함.
		System.out.println(str1);
		System.out.println(ch2);
		System.out.println(ch1);
		System.out.println(ch1==ch2);//~> 둘이 같지X
		
		System.out.println("chArr.length : " + chArr.length);
		System.out.println("@@@" +s+"@@@");
	}
}
