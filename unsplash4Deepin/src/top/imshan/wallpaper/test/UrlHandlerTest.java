package top.imshan.wallpaper.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.JsonObject;

import top.imshan.wallpaper.UrlHandler;

public class UrlHandlerTest {
	
//	private String json = "{\"id\":\"qANdy1dYvAU\",\"created_at\":\"2014-11-18T20:15:34-05:00\",\"updated_at\":\"2017-10-31T17:18:41-04:00\",\"width\":3872,\"height\":2592,\"color\":\"#464646\",\"description\":\"Stars form spirals across the night sky\",\"categories\":[],\"urls\":{\"raw\":\"https://images.unsplash.com/photo-1416359658663-73a3834895eb?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjE2NTU3fQ&s=aafbd7b1a97aa951b59f650d5759674e\",\"full\":\"https://images.unsplash.com/photo-1416359658663-73a3834895eb?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE2NTU3fQ&s=9baa1d28c3a410d48e7a6b78b448fe7c\",\"regular\":\"https://images.unsplash.com/photo-1416359658663-73a3834895eb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjE2NTU3fQ&s=6ba2178a12f0b106a54127d594ad91bc\",\"small\":\"https://images.unsplash.com/photo-1416359658663-73a3834895eb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE2NTU3fQ&s=213f2a9c1dc45c1337ef1a5465b66e6c\",\"thumb\":\"https://images.unsplash.com/photo-1416359658663-73a3834895eb?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE2NTU3fQ&s=157787fb7b1cca114a3b9d0caf74fab1\"},\"links\":{\"self\":\"https://api.unsplash.com/photos/qANdy1dYvAU\",\"html\":\"https://unsplash.com/photos/qANdy1dYvAU\",\"download\":\"https://unsplash.com/photos/qANdy1dYvAU/download\",\"download_location\":\"https://api.unsplash.com/photos/qANdy1dYvAU/download\"},\"liked_by_user\":false,\"sponsored\":false,\"likes\":96,\"user\":{\"id\":\"vP5PMINlDTA\",\"updated_at\":\"2018-02-22T14:46:26-05:00\",\"username\":\"warlengvasco\",\"name\":\"Warlen G Vasco\",\"first_name\":\"Warlen\",\"last_name\":\"G Vasco\",\"twitter_username\":null,\"portfolio_url\":\"http://www.gvascosolucoes.com.br/\",\"bio\":null,\"location\":null,\"links\":{\"self\":\"https://api.unsplash.com/users/warlengvasco\",\"html\":\"https://unsplash.com/@warlengvasco\",\"photos\":\"https://api.unsplash.com/users/warlengvasco/photos\",\"likes\":\"https://api.unsplash.com/users/warlengvasco/likes\",\"portfolio\":\"https://api.unsplash.com/users/warlengvasco/portfolio\",\"following\":\"https://api.unsplash.com/users/warlengvasco/following\",\"followers\":\"https://api.unsplash.com/users/warlengvasco/followers\"},\"profile_image\":{\"small\":\"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc\",\"medium\":\"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358\",\"large\":\"https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d\"},\"total_collections\":0,\"instagram_username\":null,\"total_likes\":0,\"total_photos\":10},\"current_user_collections\":[],\"slug\":null,\"exif\":{\"make\":\"Sony\",\"model\":\"DSLR-A200\",\"exposure_time\":\"1814/1\",\"aperture\":null,\"focal_length\":\"20\",\"iso\":100},\"views\":2464441,\"downloads\":7740}";
    @Ignore
    public void getXpath() {
        UrlHandler handler = new UrlHandler();
        JsonObject json = handler.getXpath("https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c");
        System.out.println(json);
        assertNotNull(json);
    }
    @SuppressWarnings("unchecked")
	@Test
    public void json2Map() {
    	UrlHandler handler = new UrlHandler();
    	JsonObject json = handler.getXpath("https://api.unsplash.com/photos/random?client_id=19aada4dabad279cf21e37342f6277d865e58b1336ba7d6f5a2038793d35ea7c");
    	Map<String, Object> map = handler.json2Map(json);
    	Map<String, Object> jsonmap = (Map<String, Object>) map.get("urls");
    	System.out.println(jsonmap.get("full"));
    	assertNotNull(map.get("id"));
    }
}