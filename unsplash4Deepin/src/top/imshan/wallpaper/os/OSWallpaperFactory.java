package top.imshan.wallpaper.os;

/**
 * wallpaper工厂
 */
public class OSWallpaperFactory {
    /**
     * 得到对应系统的实例
     * @return 对应实例
     */
    public static OSWallpaper getWallpaperInstance(){
        String os = System.getProperty("os.name");
        if ("Mac OS X".equals(os)){
            return new MACWallpaper();
        }
        return null;
    }
}
