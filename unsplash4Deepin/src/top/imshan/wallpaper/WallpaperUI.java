package top.imshan.wallpaper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * swing UI
 * @author shansb
 *
 */
public class WallpaperUI extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
//    private static SystemTray tray = SystemTray.getSystemTray();

    public WallpaperUI() {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("unsplash4Deepin");
        File file = new File("unsplash4Deepin/resource/gallery.png");
        System.out.println(file.getAbsolutePath());
        ImageIcon imageIcon = new ImageIcon("unsplash4Deepin/resource/gallery.png");
        setIconImage(imageIcon.getImage());
    }

//    private void miniTray() { // 窗口最小化到任务栏托盘
//
//        ImageIcon trayImg = new ImageIcon("unsplash4Deepin/resource/gallery.png");// 托盘图标
//        TrayIcon trayIcon;
//        trayIcon = new TrayIcon(trayImg.getImage(), "test", new PopupMenu());
//        trayIcon.setImageAutoSize(true);
//
//        trayIcon.addMouseListener(new MouseAdapter() {
//
//            public void mouseClicked(MouseEvent e) {
//
//                if (e.getClickCount() == 1) {// 单击 1 双击 2
//
//                    tray.remove(trayIcon);
//                    setVisible(true);
//                    setExtendedState(JFrame.NORMAL);
//                    toFront();
//                }
//
//            }
//
//        });
//
//        try {
//
//            tray.add(trayIcon);
//
//        } catch (AWTException e1) {
//            e1.printStackTrace();
//        }
//
//    }
}
