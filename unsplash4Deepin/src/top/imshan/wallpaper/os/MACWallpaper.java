package top.imshan.wallpaper.os;

/**
 * MAC_OS_X 壁纸更改
 */
public class MACWallpaper extends OSWallpaper{
    @Override
    public boolean changeWallpaper(String picturePath) {
        String cmd = "src/mac.sh "+picturePath;
        return BashExecutor.execute(cmd);
    }
}
