package exception;

public class NewExceptionTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException e) {
			System.out.println("에러 msg : " + e.getMessage());
			e.printStackTrace();
			System.out.println("공간확보 후 다시 설치");
		} catch (MemoryException e) {
			System.out.println("에러 msg : " + e.getMessage());
			e.printStackTrace();
			System.gc();// Garbage Collection 수행으로 메모리 늘려줌.
			System.out.println("다시 설치 시도 ");

		} finally {
			deleteTempFiles();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace()) {
			throw new SpaceException("설치할 공간 부족");
		}
		if (!enoughMemory()) {
			throw new MemoryException("메모리 부족");
		}
	}

	static void copyFiles() {
		System.out.println("파일 복사 ");
	}

	static void deleteTempFiles() {
		System.out.println("임시 파일 삭제 ");
	}

	static boolean enoughSpace() {
		System.out.println("공간 확인 중 ...");
		return false;

	}

	static boolean enoughMemory() {
		System.out.println("메모리 확인 중 ...");
		return true;
	}

}

class SpaceException extends Exception {
	public SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}

}
