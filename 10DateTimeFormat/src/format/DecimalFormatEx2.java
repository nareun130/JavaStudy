package format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx2 {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");
		try {
			//parse를 통해 숫자값을 가져온다. 
			Number num = df.parse("1,234,567.89");
			System.out.print("1,234,567.89" + "->");
			double d = num.doubleValue();
			System.out.print(d + "->");

			//format으로 변환 
			System.out.println(df2.format(num));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
