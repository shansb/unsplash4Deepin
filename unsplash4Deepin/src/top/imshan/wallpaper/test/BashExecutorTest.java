package top.imshan.wallpaper.test;

import org.junit.Before;
import org.junit.Test;
import top.imshan.wallpaper.os.BashExecutor;

import static org.junit.Assert.*;

public class BashExecutorTest {
    BashExecutor changer;
    @Before
    public void setUp() throws Exception {
        changer = new BashExecutor();
    }

    @Test
    public void satisfy() {

        assertTrue(changer.satisfy("curl"));
        assertFalse(changer.satisfy("valid command"));
    }
    @Test
    public void installPackage() {
        assertTrue(changer.installPackage("curl","123456"));
    }
    @Test
    public void changeWallpaper(){
        assertTrue(changer.changeWallpaper());
    }
}