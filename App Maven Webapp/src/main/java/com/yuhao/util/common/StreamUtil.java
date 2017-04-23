package com.yuhao.util.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
      public static byte[] streamToByte(InputStream is) throws IOException{
    	  byte[]buffer=new byte[1024];
    	  ByteArrayOutputStream bos=new ByteArrayOutputStream();
    	  int length;
    	  while((length=is.read(buffer))!=-1){
    		  bos.write(buffer,0,length);
    	  }
    	  bos.close();
    	  return bos.toByteArray();
      }
      
}
