package com.yuhao.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;




//import net.sf.json.JSONArray;

public class StringUtil {
 public HttpServletResponse res;
 public HttpServletResponse req;

 
public StringUtil(HttpServletResponse res,HttpServletResponse req){
	this.res=res;
	this.req=req;
	
}
public static String getUUID(){
	
	String uuid=UUID.randomUUID().toString().replaceAll("-", "");
	return uuid;
}

public static Integer getListStart(Integer page,Integer rows){
	Integer start=(page-1)*rows;
	return start;
}
//public  void toJsonString(Object obj,HttpServletResponse res){
// String json=JSONArray.fromObject(obj).toString();
//	res.setContentType("text/html; charset=utf-8");
//	try {
//		res.getWriter().write(json);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
public static void unionCode(HttpServletResponse response){
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
}

public static Map<String,Object> getMap(Object obj) throws IllegalArgumentException, IllegalAccessException{
	Map<String,Object> m=new HashMap<String, Object>();	
	Field[] fields=obj.getClass().getDeclaredFields();
	for (Field field : fields) {
		field.setAccessible(true);
		m.put(field.getName(), field.get(obj));
	}
	return m;
}
}
