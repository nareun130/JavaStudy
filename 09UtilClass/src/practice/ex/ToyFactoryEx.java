package practice.ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import practice.robot.ToyFactory;
import practice.robot.Toy;

public class ToyFactoryEx {
	public static void main(String[] args) throws Exception {
		ToyFactory toyFactory = ToyFactory.getInstance();
		Toy toy = toyFactory.makeToy("robot", 10000);

		// 장난감 공장 객체 가져오기
		Class<ToyFactory> factoryClass = (Class<ToyFactory>) Class.forName("practice.robot.ToyFactory");
		System.out.println(factoryClass);

		// 장난감 객체 생성을 위한 메서드 가져오기
		Method makeToyMethod = factoryClass.getDeclaredMethod("makeToy", String.class, int.class);
		// 메서드를 이용한 로봇 생성
		Toy makedToy = (Toy) makeToyMethod.invoke(ToyFactory.getInstance(), "robot", 10000);
		System.out.println(makedToy);

		// 필드를 가져와서 조작하기
		Field cost_field = makedToy.getClass().getDeclaredField("cost");
		cost_field.setAccessible(true);
		cost_field.set(makedToy, 20000);
		System.out.println(makedToy);

		// 생성자를 가져와서 생성하기
		Class<Toy> toyClass = (Class<Toy>) ToyFactory.getInstance().makeToy().getClass();
		Constructor<Toy> toyConstructor = toyClass.getDeclaredConstructor(String.class, int.class);
		toyConstructor.setAccessible(true);
		
		//생성자를 이용한 장난감 생성 
		Toy makedToyByConstructor = toyConstructor.newInstance("Tedy Bear", 15000);
		System.out.println(makedToyByConstructor);
	}
}
