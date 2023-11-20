package date;

import java.util.Calendar;

public class CalendarEx2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = { "", "일", "월", "화", "수", "목", "금", "토" };

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		// month는 0부터 시작-> 11월 이면 10으로 설정
		date1.set(2016, 3, 21);
		System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "일 이고, ");
		System.out.println("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일 ");

		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("두 날짜의 차이는 " + difference + "초이고 ");
		System.out.println("날짜로 계산하면 " + difference / (24 * 60 * 60) + "일  ");
	}

	private static String toString(Calendar date) {

		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
	}
}
