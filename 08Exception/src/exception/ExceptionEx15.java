package exception;

import java.io.File;


public class ExceptionEx15 {
	
	//~> 실행 시 java ExceptionEx15.java "파일 이름"
	public static void main(String[] args) {
		File f = createFile(args[0]);
		System.out.println(f.getName() + " 파일이 성공적으로 생성됨.");

	}

	private static File createFile(String fileName) {
		try {
			if (fileName == null || fileName.equals(""))
				throw new Exception("파일 이름 유효x");
		} catch (Exception e) {
			fileName = "untitled.txt";
		} finally {
			File f = new File(fileName);
			createNewFile(f);

			return f;

		}

	}

	private static void createNewFile(File f) {
		try {
			f.createNewFile();
		} catch (Exception e) {
			
		}
	}
}
