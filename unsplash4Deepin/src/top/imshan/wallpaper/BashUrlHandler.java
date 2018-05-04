package top.imshan.wallpaper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import top.imshan.wallpaper.os.BashExecutor;

import java.io.*;
import java.util.Map;

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
        String jsonString = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(apiFile));
            StringBuffer sb1 = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb1.append(line).append("\n");
            }
            jsonString = sb1.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParser parse =new JsonParser();
        return (JsonObject) parse.parse(jsonString);

    }

    /**
     * 简单的转换
     * @param json JsonObject
     * @return map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> json2Map(JsonObject json){
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(json, Map.class);
        return jsonMap;
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
