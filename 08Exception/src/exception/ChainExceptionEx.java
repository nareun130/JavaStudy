package exception;

public class ChainExceptionEx {
	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException se) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(se);
			throw ie;
		} catch (MemoryException me) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(me);
			throw ie;

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

class InstallException extends Exception {
	public InstallException(String msg) {
		super(msg);
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
