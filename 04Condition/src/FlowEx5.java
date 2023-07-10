import java.util.Scanner;

public class FlowEx5 {
	public static void main(String[] args) {
		int score = 0;
		char grade = ' ', opt = '0';

		System.out.println("점수 입력 > ");
		Scanner scanner = new Scanner(System.in);

		score = scanner.nextInt();

		System.out.printf("당신의 점수는 %d.%n", score);
		
		grade = changeScore(score);
		opt = changeOpt(score);
		
		System.out.printf("당신의 학점은 %c%c.%n", grade, opt);
		scanner.close();
	}

	static char changeOpt(int score) {
		char opt = '0';
		if (score % 10 >= 8 || score == 100) {
			opt = '+';
			return opt;
		}
		if (score % 10 < 4) {
			opt = '-';
			return opt;
		}
		return opt;
	}

	static char changeScore(int score) {
		char grade = 'C';

		if (score >= 90 || score == 100) {
			grade = 'A';
			return grade;
		}
		if (score >= 80) {
			grade = 'B';
			return grade;
		}
		return grade;
	}
}
