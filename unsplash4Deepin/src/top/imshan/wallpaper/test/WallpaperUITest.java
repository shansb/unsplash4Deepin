package top.imshan.wallpaper.test;

import org.junit.Test;

import top.imshan.wallpaper.WallpaperChanger;
import top.imshan.wallpaper.WallpaperUI;

public class WallpaperUITest {

	@Test
	public void testWallpaperUI() {
		WallpaperUI ui = new WallpaperUI(new WallpaperChanger());
	}

}
