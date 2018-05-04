package top.imshan.wallpaper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.*;

/**
 * swing UI
 * @author shansb
 *
 */
public class WallpaperUI extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8644142156577085613L;
	private final int DEFAULT_WIDTH = 300;
    private final int DEFAULT_HEIGHT = 200;
    private WallpaperChanger changer;
//    private static SystemTray tray = SystemTray.getSystemTray();

    public void init(WallpaperChanger changer) {
        this.changer = changer;
//        System.setProperty("awt.useSystemAAFontSettings", "on");
//        System.setProperty("swing.aatext", "true");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("unsplash4Deepin");
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resource/Taskbar.png"));
//        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);//居中
        setResizable(false);//窗口大小不可更改
        //布局
//        setLayout(new FlowLayout());
//        Box box1, box2, boxBase, boxFinal;
//        boxBase = Box.createHorizontalBox();
//        box1 = Box.createVerticalBox();
//        box1.add(new JLabel("name"));
//        box1.add(Box.createVerticalStrut(8));
//        box1.add(new JLabel("sex"));
//        box1.add(Box.createVerticalStrut(8));
//        box1.add(new JLabel("age"));
//        box2 = Box.createVerticalBox();
//        box2.add(new JTextField(10));
//        box2.add(Box.createVerticalStrut(8));
//        box2.add(new JTextField(10));
//        box2.add(Box.createVerticalStrut(8));
//        box2.add(new JTextField(10));
//        boxBase.add(box1);
//        boxBase.add(Box.createHorizontalStrut(8));
//        boxBase.add(box2);
//        boxFinal = Box.createHorizontalBox();
//        boxFinal.add(new JButton("保存"));
//        add(boxBase);
//        add(boxFinal);



        if (SystemTray.isSupported()) {//判断系统是否托盘
            //1.最小化到托盘图标
            this.addWindowListener(new WindowAdapter() { // 窗口关闭事件
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(false);
                    dispose();
                    System.gc();
                }
                @Override
                public void windowIconified(WindowEvent e) { // 窗口最小化事件  
                    setVisible(false);
                    dispose();
                }
            });
            //2.创建一个托盘图标对象  
//            initTrayIcon(changer);
        }
    }




}
