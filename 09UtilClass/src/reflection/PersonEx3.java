package reflection;

import java.lang.reflect.Field;

public class PersonEx3 {
	// 동적으로 필드 가져와 조작
	public static void main(String[] args) throws Exception {
		// 클래스 객체 가져오기
		Class<Person> personClass = (Class<Person>) Class.forName("reflection.Person");

		// static 필드 가져와 조작
		Field height_field = personClass.getField("height");
		height_field.set(null, 200);
		System.out.println(height_field.get(null)); // ~> static 필드라서 객체 생성 필요 없음.

		// public, private 필드를 조작하기 위한 객체 생성
		Person person = new Person("홍길동", 30);
		// public 필드 가져오기
		Field name_field = personClass.getField("name");

		// private 필드 가져오기
		Field age_field = personClass.getDeclaredField("age");
		age_field.setAccessible(true);

		// 필드 조작
		name_field.set(person, "임꺽정");
		age_field.set(person, 88);

		//person 객체의 필드값 가져오기 
		System.out.println(name_field.get(person));
		System.out.println(age_field.get(person));
		
		System.out.println(person);
	}
}
