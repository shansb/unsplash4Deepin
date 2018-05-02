package top.imshan.wallpaper;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 程序主入口
 * @author Shansb
 */
public class MainAction {
    public static void main(String[] args) {
        final WallpaperChanger changer = new WallpaperChanger();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (changer.lock){
                        try {
                            changer.randomWallpaper(true);
                            System.out.println("Hello");
                            changer.lock.wait(TimeUnit.MINUTES.toMillis(30));
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
                WallpaperUI ui = new WallpaperUI(changer);
            }
        });
    }
}
