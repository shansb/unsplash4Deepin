package top.imshan.wallpaper.os;

public class DeepinWallpaper extends OSWallpaper {

	@Override
	public boolean changeWallpaper(String picturePath) {
		String cmd = "gsettings set com.deepin.wrap.gnome.desktop.background picture-uri " + picturePath;
		return BashExecutor.execute(cmd);
	}

}
