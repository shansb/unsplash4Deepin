package top.imshan.wallpaper.test;

import org.junit.Test;

import top.imshan.wallpaper.os.BashExecutor;

public class BashExecutorTest {
    @Test
    public void executeWithResult() {
    	System.out.println(BashExecutor.executeWithResult("pwd"));
    }
}