package finaltest;

public class FinalCardTest {
	public static void main(String[] args) {
		Card c = new Card("HEART",10);
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		Card c2 = new Card();
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		
	}
}

class Card {

	final int NUMBER;//! 상수는 생성자에서 단 한번만 초기화 가능  
	final String KIND;

	static int width = 100;
	static int height = 250;

	Card(String kind, int num) {
		KIND = kind;
		NUMBER = num;
	}

	Card() {
		this("HEART", 1);
		System.out.println("기본 생성자 호출 ");
	}

	public String toString() {
		return KIND + " " + NUMBER;
	}
}
