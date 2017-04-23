package com.yuhao.util.common;

import com.alibaba.fastjson.JSONObject;

public class MessageUtil {
  public static JSONObject returnMsg(String code,String message){
	  JSONObject json=new JSONObject();
	  json.put("code", code);
	  json.put("message", message);
	  return json;
  }
}
