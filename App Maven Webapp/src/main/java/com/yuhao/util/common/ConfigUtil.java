package com.yuhao.util.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.http.ParseException;

import com.yuhao.token.baidu.Token;

public class ConfigUtil {
	private final static String CONFIG_NAME = "/config.properties";
	private static ConfigUtil cu=new ConfigUtil();
	public String read(String name) throws IOException {
		Properties properties = new Properties();
		InputStream is = this.getClass().getResourceAsStream(CONFIG_NAME);
		properties.load(is);
		return properties.getProperty(name);
	}
	public static String getProperty(String key) throws IOException{
		return cu.read(key);
	}
	public static Map<String,String> getMapProperty(String...keys) throws IOException{
		Map<String,String> map=new HashMap<String,String>();
		for (String key : keys) {
			map.put(key, cu.read(key));	
		}
		return map;
	}
	
	public static Token checkToken(Token token) throws ParseException, IOException{
		Date date=new Date();
		Long now=date.getTime()/1000;
		Long created=token.getCreateTime().getTime()/1000;
		if((now-created)>=token.getExpires()){
			return new Token();
		}
		return token;
	}
	
}
