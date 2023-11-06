package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReservationJson {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String json = "{\"id\":10,\"\scheduleAt\":\"2023-11-17\"}";

		Reservation reservation = ReservationJson.parse(json, Reservation.class);
		System.out.println(reservation);
		System.out.println(reservation.id);
		System.out.println(reservation.scheduledAt);
	}

	private static <T> T parse(String json, Class<T> clazz) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<T> constructor = clazz.getConstructor();
		T t = constructor.newInstance();
		Field[] fields = clazz.getDeclaredFields();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 10);
		map.put("scheduledAt", "2023-11-11");

		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			Object value = map.get(name);

			if (value == null)
				continue;

			if (value instanceof Integer)
				fields[i].setInt(t, (Integer) value);

			if (value instanceof String)
				fields[i].set(t, (String) value);
		}

		return t;
	}
}

class Reservation {
	int id;
	String scheduledAt;

	public Reservation() {
	}
}
