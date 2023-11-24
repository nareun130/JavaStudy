package properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesEx3 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Properties prop = new Properties();
		prop.setProperty("timeout", "30");

		prop.setProperty("language", "한글");

		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");

		try {
			prop.store(new FileOutputStream("output.txt"), "Properties Example");
			// ! 한글이 포함된 경우 xml로 저장! 
			prop.storeToXML(new FileOutputStream("output.xml"), "Properties Example");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
