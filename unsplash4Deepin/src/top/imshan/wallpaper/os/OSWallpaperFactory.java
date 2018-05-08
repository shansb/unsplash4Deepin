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

        if ("Linux".equals(os)) {
        	String de = BashExecutor.executeWithResult("ps -A");
        	if (de.contains("startdde")) {
				return new DeepinWallpaper();
			}
        }
        return null;
    }
}
