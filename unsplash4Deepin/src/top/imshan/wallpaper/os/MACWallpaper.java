package top.imshan.wallpaper.os;

/**
 * MAC_OS_X 壁纸更改
 */
public class MACWallpaper extends OSWallpaper{
    @Override
    public boolean changeWallpaper(String file) {
        String cmd = "src/mac.sh "+file;
        return BashExecutor.execute(cmd);
    }
}
