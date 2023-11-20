package date;

import java.util.Calendar;

public class CalendarEx5 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();

		date.set(2015, 0, 31);
		System.out.println(toString(date));

		//~> 원래 roll은 다른 필드에 영향을 미치지 않지만 DATE가 말일 일때만 월 필드 변경시 일 필드가 영향갈 수 있음.
		date.roll(Calendar.MONTH, 1);
		System.out.println(toString(date));
	}

	private static String toString(Calendar date) {

		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
	}
}
