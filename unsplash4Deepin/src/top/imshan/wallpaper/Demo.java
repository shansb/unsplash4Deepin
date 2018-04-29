package top.imshan.wallpaper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo {
	public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                WallpaperUI ui = new WallpaperUI();
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
	}


}
