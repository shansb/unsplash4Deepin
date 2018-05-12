package top.imshan.wallpaper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 参数配置
 * @author Shansb
 */
public class IOHelper {

    /**
     * 参数文件地址
     */
    public static final String SETTING_PATH
            = System.getProperty("user.home") + "/.config/unplash4deepin/";
    /**
     * 参数文档
     */
    public static final String SETTING_FILE = SETTING_PATH + "setting";

    /**
     * 加载property
     * @param filePath 文件路径
     * @return 配置
     */
    private static Properties readPropertyFromFile(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 加载参数
     * @return 参数Map
     */
    public static Map<String, Object> loadSettings() {
        Map<String, Object> settingMap = new HashMap<>();
        Properties properties = readPropertyFromFile(SETTING_FILE);
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = properties.getProperty(key);
            if (value != null) {
                if (value.contains("#")) {
                    value = value.substring(0, value.indexOf("#"));
                }
                value = value.trim();
            }
            settingMap.put(key,value);
        }
        return settingMap;
    }
}
