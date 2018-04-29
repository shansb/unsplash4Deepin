package top.imshan.wallpaper.test;

import org.junit.Test;
import top.imshan.wallpaper.WallpaperChanger;
import top.imshan.wallpaper.os.MACWallpaper;

import static org.junit.Assert.*;

public class WallpaperChangerTest {

    @Test
    public void randomWallpaper() {
        WallpaperChanger changer = new WallpaperChanger();
        changer.setSavePath(System.getProperty("user.home")+"/Pictures/unsplashWallpaper/");
        changer.setApi("https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c");
        changer.setWallpaper(new MACWallpaper());
        changer.randomWallpaper(true);
    }
}