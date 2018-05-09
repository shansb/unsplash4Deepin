package top.imshan.wallpaper;

import com.google.gson.JsonObject;
import top.imshan.wallpaper.os.BashExecutor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * bash命令执行类
 * @author Shansb
 */
public class BashUrlHandler {
    /**
     * 发起http请求并获取结果
     * @param requestUrl 请求地址
     * @param apiPath    API信息保存路径
     * @return 保存json内容的Map
     */
    public static Map<String,Object> getXpath(String requestUrl, String apiPath){
        StringBuilder cmd = new StringBuilder("wget ").append(requestUrl).append(" --output-document=");

        cmd.append(apiPath);
        BashExecutor.execute(cmd.toString());
        File apiFile = new File(apiPath);
        if (!apiFile.exists()){
            return new HashMap<>();
        }
        String  jsonString = IOHelper.readStringFromFile(apiFile);
        return IOHelper.json2Map(IOHelper.string2Json(jsonString));

    }

    /**
     * 下载图片
     * @param urlString url
     * @param filename 文件名
     * @param savePath 保存路径
     */
    public static void download(String urlString, String filename,String savePath){
        StringBuilder cmd = new StringBuilder("wget ").append(urlString).append(" --output-document=");
        cmd.append(savePath).append(filename);
        BashExecutor.execute(cmd.toString());
    }
}
