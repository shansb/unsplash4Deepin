package top.imshan.wallpaper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.google.gson.JsonObject;

import top.imshan.wallpaper.os.OSWallpaper;
import top.imshan.wallpaper.os.OSWallpaperFactory;

/**
 * 壁纸更换实现
 * @author Shansb
 *
 */
public class WallpaperChanger {
    /**
     * 锁
     */
    public final Object lock = new Object();
    /**
     * 图片保存路径
     */
    private String savePath;
    /**
     * unsplash API地址
     */
    private String api;
    /**
     * 预览图地址
     */
    private String thumbUrl;
    /**
     * 大图地址
     */
    private String fullUrl;
    /**
     * 日期转换
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 系统壁纸更换服务
     */
    private OSWallpaper wallpaper;

    public WallpaperChanger() {
        this.savePath = System.getProperty("user.home") + "/Pictures/unsplashWallpapers/";
        this.api = "https://api.unsplash.com/photos/random?client_id=c35c3e173211004dea1b7835216e4840618a9c6f2903689a943126eaaba20b38";
        this.wallpaper = OSWallpaperFactory.getWallpaperInstance();
    }

    /**
     * 随机壁纸
     * @param automatic 是否自动下载大图
     */
	public void randomWallpaper(boolean automatic) {
		/*
        1. 检查路径是否存在
        2. 随机下载需要的图片thumb
        3. 随机下载全尺寸图片
        4. 设置壁纸
         */
        checkPath();

        if (!getUrlsFromAPI()) {
            System.err.println("无法从API中获得需要的图片地址");
            return;
        }

		if (automatic) {
		    String fileName = format(new Date()) + ".jpg";
		    BashUrlHandler.download(fullUrl, fileName,savePath);
		    changeWallpaper(savePath+fileName);
        }
	}

    /**
     * 更改壁纸
     * @param file 新壁纸路径
     * @return 是否成功执行
     */
    private boolean changeWallpaper(String file) {
       return wallpaper.changeWallpaper(file);
    }
    private synchronized String format(Date date){
	    return sdf.format(date);
    }
    /**
     * 从接口获得图片地址
     * @return 是否成功获得
     */
    @SuppressWarnings("unchecked")
	private boolean getUrlsFromAPI() {
        Map<String, Object> pictureInfo = null;
        try {
            JsonObject json = BashUrlHandler.getXpath(api,savePath+".api");
            pictureInfo = IOHelper.json2Map(json);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (null == pictureInfo){
            return false;
        }
        Map<String, Object> urlMap = (Map<String, Object>) pictureInfo.get("urls");
        thumbUrl =(String) urlMap.get("thumb");
        fullUrl = (String) urlMap.get("full");
        if (thumbUrl == null || fullUrl == null) {
            return  false;
        }
        return true;
    }

    /**
     * 检查路径是否存在，不存在则创建
     */
    private void checkPath() {
        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setWallpaper(OSWallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
