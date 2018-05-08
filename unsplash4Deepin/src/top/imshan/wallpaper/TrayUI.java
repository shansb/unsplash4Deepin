package top.imshan.wallpaper;

import top.imshan.wallpaper.os.BashExecutor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * 系统托盘
 * @author Shansb
 */
public class TrayUI {
    /**
     * 图标
     */
    TrayIcon icon =
            new TrayIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/TrayIcon16x16.png")));

    /**
     * 初始化托盘图标行为
     * @param changer
     */
    public void initTrayIcon(WallpaperChanger changer) {
//            icon.setImageAutoSize(true);
        //3.双击打开主窗口
        icon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {// 单击 1 双击 2
                    synchronized (changer.lock){
                        changer.lock.notify();
                    }
                }
            }
        });
        //4.创建弹出菜单
        PopupMenu menu = new PopupMenu();
        //添加一个用于退出的按钮
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        MenuItem refreshItem = new MenuItem("Refresh");
        refreshItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                synchronized (changer.lock){
                    changer.lock.notify();
                }
            }
        });

        MenuItem settingItem = new MenuItem("Setting");
        settingItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(IOHelper.settingPathName);
                if (file.exists()) {
                    file = null;
                    BashExecutor.execute("gedit " + IOHelper.settingPathName);
                }
            }
        });
        menu.add(settingItem);
        menu.add(refreshItem);
        menu.add(quitItem);
        icon.setToolTip("Wallpaper");
        //添加弹出菜单到托盘图标
        icon.setPopupMenu(menu);
        SystemTray tray = SystemTray.getSystemTray();//获取系统托盘
        try {
            tray.add(icon);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }//将托盘图表添加到系统托盘
    }
}
