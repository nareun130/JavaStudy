package reflection;

import java.lang.reflect.Constructor;

public class PersonEx1 {
	// 동적으로 생성자 가져와 초기화
	public static void main(String[] args) throws Exception {
		// 클래스 객체 가져오기
		Class<Person> personClass = (Class<Person>) Class.forName("reflection.Person");

		// 동저생성자 가져오기 - PErson(String name, int age)
		Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);

		// 가져온 생성자로 인스턴스 만들기
		Person person1 = constructor.newInstance("홍길동", 55);
		person1.getField();

	}
}
