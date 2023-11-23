package stack;

import java.util.Stack;

public class StackEx1 {
	public static Stack back = new Stack();
	public static Stack forward = new Stack();

	public static void main(String[] args) {
		goURL("1.google");
		goURL("2.naver");
		goURL("3.AWS");
		goURL("4.StackOverFlow");

		printStatus();

		goBack();
		System.out.println("뒤로 버튼 누른 후 ");
		printStatus();

		goBack();
		System.out.println("뒤로 버튼 누른 후 ");
		printStatus();

		goForward();
		System.out.println("앞으 버튼 누른 후 ");
		printStatus();

		goURL("github.com");
		System.out.println("새로운 주소 이동 후 ");
		printStatus();
	}

	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("현재 화면은 '" + back.peek() + "' 입니다. ");
		System.out.println();
	}

	public static void goURL(String url) {
		back.push(url);
		if (!forward.empty()) {
			forward.clear();
		}
	}

	public static void goBack() {
		if (!back.empty()) {
			forward.push(back.pop());
		}
	}

	public static void goForward() {
		if (!back.empty()) {
			back.push(forward.pop());
		}
	}
}
