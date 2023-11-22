package format;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageForamtEx3 {
	public static void main(String[] args) throws Exception {
		String[] data = { "INSERT INTO CUST_INFO VALUES ('이자바','02-123-1234','27,'07-09');",
				"INSERT INTO CUST_INFO VALUES ('김프로','032-333-1234','33,'10-07');" };
		String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
		MessageFormat mf = new MessageFormat(pattern);

		for (String d : data) {
			Object[] objs = mf.parse(d);
			System.out.println(mf.format(pattern, objs));
			for (Object obj : objs) {
				System.out.print(obj);
			}
			System.out.println();
		}

	}
}
