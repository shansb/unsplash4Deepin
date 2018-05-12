package top.imshan.wallpaper;

import top.imshan.wallpaper.os.BashExecutor;

/**
 * bash命令执行类
 * @author Shansb
 */
class BashUrlHandler {

    /**
     * 下载图片
     * @param urlString url
     * @param filename 文件名
     * @param savePath 保存路径
     */
    static void download(String urlString, String filename, String savePath){
        StringBuilder cmd = new StringBuilder("wget ").append(urlString).append(" --output-document=");
        cmd.append(savePath).append(filename);
        BashExecutor.execute(cmd.toString());
    }
}
