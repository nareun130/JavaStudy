package practice.ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import practice.robot.Toy;
import practice.robot.ToyFactory;

public class ToyToJson {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String json = "{\"name\":Rocket,\"cost\":10000}";
		System.out.println(json);

		ToyFactory factory = ToyFactory.getInstance();
		Toy parsedToy = ToyToJson.parse(json, Toy.class);
		System.out.println(parsedToy);
	}

	private static Toy parse(String json, Class<Toy> clazz) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 생성자를 가져와서 Toy객체 생성
		Constructor<Toy> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		Toy toy = constructor.newInstance();

		// json 값을 Map에 넣어줌.
		String name = json.substring(json.indexOf("name"), json.indexOf(",")).trim().replace("name\":", "");
		int cost = Integer
				.parseInt(json.substring(json.indexOf("cost"), json.indexOf("}")).trim().replace("cost\":", ""));
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("name", name);
		jsonMap.put("cost", cost);

		// private 필드를 접근 가능하게 만들어 줌.
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String keyName = field.getName();
			Object value = jsonMap.get(keyName);

			if (value == null)
				continue;
			if (value instanceof Integer)
				field.setInt(toy, (Integer) value);
			if (value instanceof String)
				field.set(toy, (String) value);

		}
		return toy;
	}
}
