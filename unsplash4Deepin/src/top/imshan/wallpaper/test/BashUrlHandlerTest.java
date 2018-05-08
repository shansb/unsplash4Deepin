package top.imshan.wallpaper.test;

import org.junit.Test;

import top.imshan.wallpaper.BashUrlHandler;

public class BashUrlHandlerTest {

    @Test
    public void getXpath() {
        BashUrlHandler.getXpath("https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c"
                ,System.getProperty("user.home")+"/Pictures/unsplashWallpaper/APIJson.json");
    }

    @Test
    public void json2Map() {
    }

    @Test
    public void download() {
    }
}