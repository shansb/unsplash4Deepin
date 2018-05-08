package top.imshan.wallpaper;

import com.google.gson.JsonObject;
import top.imshan.wallpaper.os.BashExecutor;

import java.io.*;

/**
 * bash命令执行类
 * @author Shansb
 */
public class BashUrlHandler {
    /**
     * 发起http请求并获取结果
     * @param requestUrl 请求地址
     */
    public static JsonObject getXpath(String requestUrl,String apiPath){
        StringBuilder cmd = new StringBuilder("wget " + requestUrl + " --output-document=");

        cmd.append(apiPath);
        BashExecutor.execute(cmd.toString());
        File apiFile = new File(apiPath);
        if (!apiFile.exists()){
            return new JsonObject();
        }
        String  jsonString = IOHelper.readStringFromFile(apiFile);
        return IOHelper.string2Json(jsonString);

    }

    /**
     * 下载图片
     * @param urlString url
     * @param filename 文件名
     * @param savePath 保存路径
     */
    public static void download(String urlString, String filename,String savePath){
        StringBuilder cmd = new StringBuilder("wget " + urlString + " --output-document=");
        cmd.append(savePath).append(filename);
        BashExecutor.execute(cmd.toString());
    }
}
