package top.imshan.wallpaper.test;

import org.junit.Test;
import top.imshan.wallpaper.os.MACWallpaper;

import static org.junit.Assert.*;

public class MACWallpaperTest {

    @Test
    public void changeWallpaper() {
        MACWallpaper wallpaper = new MACWallpaper();
        boolean yes = wallpaper.changeWallpaper("/Users/shanshengbo/Pictures/unsplashWallpaper/test.jpg");
        assertTrue(yes);
    }
}