package reflection;

import java.lang.reflect.Method;

public class PersonEx2 {
	// 동적으로 메서드 가져와 실행하기
	public static void main(String[] args) throws Exception {
		Class<Person> personClass = (Class<Person>) Class.forName("reflection.Person");

		// 특정 public 메서드 가져와 실행
		// getMethod("메서드명", 매개변수 타입들)
		Method sum = personClass.getMethod("sum", int.class, int.class);
		int result = (int) sum.invoke(new Person(), 10, 20);
		System.out.println(result);

		// * 특정 static 메서드 가져와 실
		Method staticSum = personClass.getMethod("staticSum", int.class, int.class);
		// ! static 메서드라서 객체 생성 없이 실행 가능
		int staticResult = (int) staticSum.invoke(null, 100, 200);
		System.out.println(staticResult);

		// 특정 private 메서드 가져와서 실행
		Method privateSum = personClass.getDeclaredMethod("privateSum", int.class, int.class);
		privateSum.setAccessible(true);// ~> private메서드를 외부에서 access할 수 있도록 설정
		int privateResult = (int) privateSum.invoke(new Person(), 1000, 2000);
		System.out.println(privateResult);
	}
}
