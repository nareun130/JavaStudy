package reflection;

public class ReflectionEx1 {
	public static void main(String[] args) {
		// * 객체를 생성하고 세가지 방법으로 Class 정보 얻기
		// 인스턴스
		String str = new String("Class클래스 테스");

		// * 1. getClass() 메서드로 얻기
		Class<? extends String> cls1 = str.getClass();
		System.out.println(cls1);

		// * 2. .class 리터럴로 얻기 -> 인스턴스가 존재x 컴파일된 클래스 파일만 존재
		Class<? extends String> cls2 = String.class;
		System.out.println(cls2);

		// * 3. Class.forName()으로 얻기 -> 동적 로딩 : 컴파일에 바인딩 되지 않고 런타임때 불러오게 돼서
		// * ClassNotFoundException으로 인해 예외처리 강제됨.
		// ~> 클래스의 도메인을 상세히 적어줘야 함. -> 실수 발생 높음.
		// ~> 다른 두가지 방법보다 메모리를 절약하며 동적 로딩 가능 -> 성능 젤 좋음.
		try {
			Class<?> cls3 = Class.forName("java.lang.String");
			System.out.println(cls3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
