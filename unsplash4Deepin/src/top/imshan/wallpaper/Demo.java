package top.imshan.wallpaper;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

public class Demo {
	public static void main(String[] args) throws IOException {
//        initGlobalFont();
		String os = System.getProperty("os.name");
		System.out.println(os);
		WallpaperChanger changer = new WallpaperChanger();
		WallpaperUI ui = new WallpaperUI(changer);

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                WallpaperUI ui = new WallpaperUI();
//            }
//        });
//        String res = BashExecutor.executeWithResult("ps -A ");
//        System.out.println(res.contains("startdde"));
	}

	private static void initGlobalFont(){
		FontUIResource fontUIResource = new FontUIResource(new Font("文泉驿微米黑",Font.PLAIN, 12));
		for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value= UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontUIResource);
			}
		}
	}
}
