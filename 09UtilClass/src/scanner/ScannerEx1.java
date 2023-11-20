package scanner;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] argArr = null;

		while (true) {
			String prompt = ">>";
			System.out.print(prompt);

			String input = s.nextLine();

			input = input.trim();
			argArr = input.split(" +");// 입력 받은 내용의 공백을 구분자로 자른다. -> 정규식 넣어줌. 

			String command = argArr[0].trim();

			if ("".equals(command))
				continue;

			if (command.equals("q")) {
				System.exit(0);
			} else {
				for (int i = 0; i < argArr.length; i++) {
					System.out.println(argArr[i]);
				}
			}

		}
	}
}
