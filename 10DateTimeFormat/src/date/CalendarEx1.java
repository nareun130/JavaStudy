package date;

import java.util.Calendar;

public class CalendarEx1 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println("이 번년도 : " + today.get(Calendar.YEAR));
		System.out.println("월(0~11, 0:1월) : " + today.get(Calendar.MONTH));
		System.out.println("이 해의 몇 째 주 :" + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 :" + today.get(Calendar.WEEK_OF_MONTH));
		// 우리나라는 GMT+9 -> Greeniwich Mean Time
		System.out.println("TimeZone(-12~+12):" + (today.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000)));
		System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE));
	}
}
