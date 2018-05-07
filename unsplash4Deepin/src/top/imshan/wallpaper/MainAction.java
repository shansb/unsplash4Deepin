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
        File setting = new File("setting.json");
        System.out.println(setting.getAbsolutePath());
        Map<String, Object> settingMap = new HashMap<>();
        if (setting.exists()) {
            settingMap = IOHelper.getJsonMapFromFile(setting);
        }
        WallpaperChanger changer = new WallpaperChanger();
        String savePath = (String) settingMap.get("DownloadPath");
        String api = (String) settingMap.get("API");
        if (null != savePath) {
            changer.setSavePath(savePath);
        }
        if (null != api) {
            changer.setApi(api);
        }
        String cycleTime = (String) settingMap.get("CycleTime");
        final Integer cycleMinute = cycleTime == null ? 30 : Integer.parseInt(cycleTime);
        TrayUI ui = new TrayUI();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (changer.lock){
                        try {
                            ui.icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/TrayIcon.gif")));
                            changer.randomWallpaper(true);
                            ui.icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/TrayIcon16x16.png")));
                            System.out.println("Hello");
                            changer.lock.wait(TimeUnit.MINUTES.toMillis(cycleMinute));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
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
        setting = null;
        api = null;
        cycleTime = null;
    }

}
