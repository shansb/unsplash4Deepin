package top.imshan.wallpaper;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UrlHandler {
    /**
     * 发起http请求并获取结果
     * @param requestUrl 请求地址
     */
    public JsonObject getXpath(String requestUrl){
        String res="";
        JsonObject object = null;
        StringBuffer buffer = new StringBuffer();
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection urlCon= (HttpURLConnection)url.openConnection();
            if(200==urlCon.getResponseCode()){
                BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream(),"utf-8"));

                String str = null;
                while((str = br.readLine())!=null){
                    buffer.append(str);
                }
                br.close();
                new InputStreamReader(urlCon.getInputStream(),"utf-8").close();
                urlCon.getInputStream().close();
                res = buffer.toString();
                JsonParser parse =new JsonParser();
                object = (JsonObject) parse.parse(res);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 简单的转换
     * @param json JsonObject
     * @return map
     */
    @SuppressWarnings("unchecked")
	public Map<String, Object> json2Map(JsonObject json){
    	Gson gson = new Gson();
    	Map<String, Object> jsonMap = gson.fromJson(json, Map.class);
    	return jsonMap;
    }
    
    public void download(String urlString, String filename,String savePath){ 
    	try {
			// 构造URL    
			URL url = new URL(urlString);    
			// 打开连接    
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
			//设置请求超时为5s    
			con.setConnectTimeout(5*1000);    
			// 输入流    
			int code=con.getResponseCode();  
			
			if(code == 200){  //响应成功  
			    BufferedImage image=ImageIO.read(con.getInputStream()); //读取图片文件流  
			    String path=savePath+filename;  //创建存储图片文件的路径  
			    File file=new File(path);  
			    ImageIO.write(image,"jpeg",  file);  //将图片写进创建的路径  
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
}
