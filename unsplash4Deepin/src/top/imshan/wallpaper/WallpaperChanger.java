package top.imshan.wallpaper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import top.imshan.wallpaper.os.BashExecutor;
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
        this.savePath = IOHelper.SETTING_PATH+"cache/";
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
        int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
        int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
        StringBuilder sb = new StringBuilder("https://source.unsplash.com/random/");
        fullUrl = sb.append(screenWidth).append("x").append(screenHeight).toString();
		if (automatic) {
			String fileName = new StringBuilder(format(new Date())).append(".jpg").toString();
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
     * 检查路径
     */
    private void checkPath() {
        BashExecutor.execute(new StringBuilder("rm -rf ").append(savePath).toString());
        File file = new File(savePath);
        file.mkdirs();
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public void setWallpaper(OSWallpaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
