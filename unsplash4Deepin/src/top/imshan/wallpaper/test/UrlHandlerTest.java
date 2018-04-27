package top.imshan.wallpaper.test;

import com.google.gson.JsonObject;
import org.junit.Test;
import top.imshan.wallpaper.UrlHandler;

import static org.junit.Assert.*;

public class UrlHandlerTest {

    @Test
    public void getXpath() {
        UrlHandler handler = new UrlHandler();
        JsonObject json = handler.getXpath("https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c");
        System.out.println(json);
        assertNotNull(json);
    }
}