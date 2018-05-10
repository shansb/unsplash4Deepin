package top.imshan.wallpaper.test;

import org.junit.Test;

import top.imshan.wallpaper.IOHelper;
import top.imshan.wallpaper.os.BashExecutor;

public class BashExecutorTest {
    @Test
    public void executeWithResult() {
        String cmd = "rm '/home/deep4win/.config/unplash4deepin/*.jpg'";
    	System.out.println(BashExecutor.executeWithResult(cmd));
    }
    @Test
    public void execute(){
        BashExecutor.execute("rm -f /home/deep4win/.config/unplash4deepin/*.jpg");
    }
}