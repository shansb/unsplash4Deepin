package top.imshan.wallpaper;

import java.io.File;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) throws IOException {
		String fiel = System.getProperty("user.home")+"/Pictures/test/1.jpg";
		System.out.println( fiel);
		File file = new File(fiel);
		if (!file.exists()) {
			file.createNewFile();
		}
	}
}
