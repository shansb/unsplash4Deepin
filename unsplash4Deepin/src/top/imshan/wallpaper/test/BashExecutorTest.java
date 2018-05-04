package top.imshan.wallpaper.test;

import org.junit.Test;

import top.imshan.wallpaper.os.BashExecutor;

public class BashExecutorTest {
    @Test
    public void executeWithResult() {
    	System.out.println(BashExecutor.executeWithResult("wget https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c --output-document=/home/deep4win/Pictures/unsplashWallpaper/APIJson.json"));
    }
}