package top.imshan.wallpaper;

import java.io.IOException;

public class Demo {
	public static void main(String[] args) throws IOException {
		String os = System.getProperty("os.name");
		System.out.println(os);
		WallpaperUI ui = new WallpaperUI();
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                WallpaperUI ui = new WallpaperUI();
//            }
//        });
//        String res = BashExecutor.executeWithResult("ps -A ");
//        System.out.println(res.contains("startdde"));
	}


}
