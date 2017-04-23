package com.yuhao.util.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class StringUtil {
    public static String genId(){
    	UUID id=UUID.randomUUID();
    	return id.toString().replaceAll("-", "");
    }
    
    public static boolean isEmpty(String value){
    	if(value==null||value.isEmpty()){
    		return true;
    	}
    	return false;
    }
    
    public static String Base64Image(InputStream is) throws IOException{
    	Base64 base64=new Base64();
    	return base64.encodeToString(StreamUtil.streamToByte(is));
    }
}
