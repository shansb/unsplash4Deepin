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
     * 允许使用http://picsum.photos/的API
     */
    private boolean OtherAPI =false;
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
        StringBuilder sb = new StringBuilder(System.getProperty("user.home"));
        this.savePath = sb.append("/Pictures/unsplashWallpapers/").toString();
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
        2. 随机下载全尺寸图片
        4. 设置壁纸
         */
        checkPath();
        if (OtherAPI) {
        	int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        	int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        	StringBuilder sb = new StringBuilder("https://source.unsplash.com/random/");
        	fullUrl = sb.append(screenWidth).append("x").append(screenHeight).toString();
		} else {
			if (!getUrlsFromAPI()) {
				System.err.println("无法从API中获得需要的图片地址");
				return;
			}
		}
		if (automatic) {
			String fileName = new StringBuilder(format(new Date())).append(".jpg").toString();
		    BashUrlHandler.download(fullUrl, fileName,savePath);
		    changeWallpaper(savePath+fileName);
        }
	}

    public void setOtherAPI(boolean otherAPI) {
		OtherAPI = otherAPI;
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
            pictureInfo = BashUrlHandler.getXpath(api,savePath+".api");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (null == pictureInfo){
            return false;
        }
        Map<String, Object> urlMap = (Map<String, Object>) pictureInfo.get("urls");
        fullUrl = (String) urlMap.get("full");
        if (fullUrl == null) {
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
