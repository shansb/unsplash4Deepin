package top.imshan.wallpaper;

import java.util.Map;

import com.google.gson.JsonObject;

public class WallpaperChanger {
	@SuppressWarnings("unchecked")
	public void randomWallpaper() {
		UrlHandler handler = new UrlHandler();
		String url = "https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c";
		JsonObject json = handler.getXpath(url);
		Map<String, Object> pictrueInfo = handler.json2Map(json);
		Map<String, Object> urlMap = (Map<String, Object>) pictrueInfo.get("urls");
		String thumbUrl =(String) urlMap.get("thumb");
		String fullUrl = (String) urlMap.get("full");
		handler.download(thumbUrl, "review.jpg", System.getProperty("user.home")+"/Pictures/unsplashWallpaper/");
	}
}
