package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionEx2 {
	public static void main(String[] args) {

		// 방법 1.
		Card card = new Card();
		Class<? extends Card> clazz1 = card.getClass();
		System.out.println("Object.getClass()로 얻은 Class : " + clazz1);
		// 방법 2.
		Class<? extends Card> clazz2 = Card.class;
		System.out.println(".class 리터럴로 얻은 Class : " + clazz2);

		// 방법 3.
		try {
			Class<?> clazz3 = Class.forName("reflection.Card");
			System.out.println("Class.forName으로 얻은 Class : " + clazz3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("--------Reflection의 클래스명, pakcage명 메서드------------");
		System.out.println("clazz1.getSimpleName() : " + clazz1.getSimpleName());
		System.out.println("clazz1.getPackage() : " + clazz1.getPackage());
		System.out.println("clazz1.getName() : " + clazz1.getName());
		System.out.println("clazz1.toString() : " + clazz1.toString());
		System.out.println("clazz1.toGenericString() : " + clazz1.toGenericString());

		System.out.println("--------Reflection의 클래스 구성요소 메서드-----------");
		Field[] fields = clazz1.getFields();
		System.out.println("clazz1의 필드들>>>");
		for(Field field : fields){
			System.out.println(field);
		}
		Method[] methods = clazz1.getMethods();
		System.out.println("clazz1의 메서드들>>>");
		for(Method method : methods){
			System.out.println(method);
		}
		
		Class<?>[] interfaces = clazz1.getInterfaces();
		System.out.println("clazz1의 인터페이스들>>>");
		for(Class interfaze : interfaces){
			System.out.println(interfaze);
		}
		Class<?> superClasses = clazz1.getSuperclass();
		System.out.println("clazz1의 superClass");
		System.out.println(superClasses);
	}
}
