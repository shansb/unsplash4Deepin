package top.imshan.wallpaper.os;

/**
 * 系统壁纸更换
 * @author Shansb
 */
public abstract class OSWallpaper {
    /**
     * 更换壁纸
     * @param picturePath 壁纸路径文件名
     * @return 是否更换成功
     */
    public abstract boolean changeWallpaper(String picturePath);
}
