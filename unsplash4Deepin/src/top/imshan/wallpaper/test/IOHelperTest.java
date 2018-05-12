package top.imshan.wallpaper.test;

import org.junit.Test;
import top.imshan.wallpaper.IOHelper;

import java.util.Map;

import static org.junit.Assert.*;

public class IOHelperTest {

    @Test
    public void loadSettings() {
        Map<String,Object> setting = IOHelper.loadSettings();
        System.out.println(setting.get("CycleTime"));
    }
}