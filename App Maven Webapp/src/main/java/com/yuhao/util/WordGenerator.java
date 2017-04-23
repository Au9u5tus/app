package com.yuhao.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGenerator {
	private static Configuration configuration=null;
	private static Map<String,Template>allTemps=null;
	static{
		configuration=new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(WordGenerator.class, "/com/yuhao/model");
		allTemps=new HashMap<String,Template>();
		try {
			allTemps.put("model", configuration.getTemplate("model.ftl"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private WordGenerator(){
		throw new AssertionError();
	}
	
	public static File createDoc(Map<?,?>dataMap,String type){
		Double num=Math.random()*100000;
		String name="temp"+num.intValue()+".doc";
		File file=new File(name);
		Template t=allTemps.get(type);
		
		try {
			Writer w=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			t.process(dataMap, w);
			w.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
}
