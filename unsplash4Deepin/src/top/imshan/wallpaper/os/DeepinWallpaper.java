package top.imshan.wallpaper.os;

/**
 * deepin的壁纸设置实现
 * @author Shansb
 */
public class DeepinWallpaper extends OSWallpaper {

	@Override
	public boolean changeWallpaper(String picturePath) {
		return BashExecutor.execute(
				new StringBuilder("gsettings set com.deepin.wrap.gnome.desktop.background picture-uri ").append(picturePath).toString());
	}

}
