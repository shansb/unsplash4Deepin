package top.imshan.wallpaper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Map;

/**
 * 参数配置
 * @author Shansb
 */
public class IOHelper {

    /**
     * 参数文件地址
     */
    public static final String settingPathName
            = new StringBuilder(System.getProperty("user.home")).append("/.config/unplash4deepin/setting.json").toString();

    /**
     * 从文件中读取内容生成string
     * @param file 已存在的文件
     * @return 内容字符串
     */
    public static String readStringFromFile(File file) {
        String content = "{}";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer sb1 = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb1.append(line).append("\n");
            }
            content = sb1.toString();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
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
     * 字符串解析为json对象
     * @param jsonString 字符串
     * @return json对象
     */
    public static JsonObject string2Json(String jsonString) {
        JsonParser parse =new JsonParser();
        return (JsonObject) parse.parse(jsonString);
    }

    /**
     * 从文本格式中的json转换为Map
     * @param file
     * @return
     */
    public static Map<String, Object> getJsonMapFromFile(File file) {
        String settings = readStringFromFile(file);
        JsonObject settingsJson = string2Json(settings);
        return json2Map(settingsJson);
    }
}
