package top.imshan.wallpaper;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 程序主入口
 * @author Shansb
 */
public class MainAction {
    public static void main(String[] args) {
        Map<String, Object> settingMap = loadSettings();
        WallpaperChanger changer = new WallpaperChanger();
        applySettings(settingMap, changer);
        final Integer cycleHour = loadCycleTime(settingMap);
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
                            changer.lock.wait(TimeUnit.HOURS.toMillis(cycleHour));
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
	 * 加载壁纸更新循环时间（最小值及默认值为1）
	 * @param settingMap 设置
	 * @return 更新周期（小时）
	 */
	private static Integer loadCycleTime(Map<String, Object> settingMap) {
		Integer cycleTime = null;
        try {
            cycleTime = (String) settingMap.get("CycleTime") == null ? 1 : Integer.parseInt((String) settingMap.get("CycleTime"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            cycleTime = 1;
        }
        return cycleTime > 1 ? cycleTime : 1;
	}

	/**
	 * 应用配置参数
	 * @param settingMap 设置
	 * @param changer 壁纸更换器
	 */
	private static void applySettings(Map<String, Object> settingMap, WallpaperChanger changer) {
		Object savePath = settingMap.get("DownloadPath");
		Object api = settingMap.get("API");
		Object otherAPI = settingMap.get("EnableOtherAPI");
        if (null != savePath) {
            changer.setSavePath((String) savePath);
        }
        if (null != api) {
            changer.setApi((String) api);
        }
        if(null != otherAPI) {
        	changer.setOtherAPI((boolean) otherAPI);
        }
	}

	/**
	 * 加载参数
	 * @return 参数Map
	 */
	private static Map<String, Object> loadSettings() {
		File setting = new File(IOHelper.settingPathName);
        Map<String, Object> settingMap = new HashMap<>();
        if (setting.exists()) {
            settingMap = IOHelper.getJsonMapFromFile(setting);
        }
		return settingMap;
	}

}
