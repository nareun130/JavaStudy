import java.util.Scanner;

public class FlowEx7 {
	public static void main(String[] args) {
		System.out.println("가위(1), 바위(2), 보(3) 중 입력 > ");

		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		int com = (int) (Math.random() * 3) + 1;

		System.out.println("당신은 " + convertNum(user) + "입니다.");
		System.out.println("컴퓨터는 " + convertNum(com) + "입니다.");

		switch (user - com) {
		case 1:
		case -2:
			System.out.println("당신이 이겼습니다.");
			break;
		case 2:
		case -1:
			System.out.println("당신이 졌습니다.");
			break;
		case 0:
			System.out.println("비겼습니다.");
			break;
		default:
			System.out.println(convertNum(user));
		}

	}

	static String convertNum(int num) {
		String result = "";
		switch (num) {
		case 1:
			result = "가위";
			break;
		case 2:
			result = "바위";
			break;
		case 3:
			result = "보";
			break;
		default:
			result = "잘못 입력하였습니다.";

		}
		return result;

	}
}
