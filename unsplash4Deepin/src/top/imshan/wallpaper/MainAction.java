package top.imshan.wallpaper;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 程序主入口
 * @author Shansb
 */
public class MainAction {
    public static void main(String[] args) {
        Map<String, Object> settingMap = IOHelper.loadSettings();
        WallpaperChanger changer = new WallpaperChanger();
        final Integer cycleMinutes = loadCycleTime(settingMap);
        TrayUI ui = new TrayUI();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (changer.lock){
                        try {
                            ui.setIconImage("/resource/TrayIcon.gif");
                            changer.randomWallpaper(true);
                            ui.setIconImage("/resource/TrayIcon16x16.png");
                            System.gc();
                            changer.lock.wait(TimeUnit.HOURS.toMillis(cycleMinutes));
                        } catch (Exception e) {
                            e.printStackTrace();
                            ui.icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/TrayIcon16x16.png")));
                        }
                    }
                }
            }
        });
        thread.start();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ui.initTrayIcon(changer);
            }
        });
    }

	/**
	 * 加载壁纸更新循环时间（最小值10分钟、默认值30分钟）
	 * @param settingMap 设置
	 * @return 更新周期（分）
	 */
	private static Integer loadCycleTime(Map<String, Object> settingMap) {
		Integer cycleTime = null;
        try {
            cycleTime = settingMap.get("CycleTime") == null ? 30 : Integer.parseInt((String) settingMap.get("CycleTime"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            cycleTime = 30;
        }
        return cycleTime > 10 ? cycleTime : 10;
	}

}
