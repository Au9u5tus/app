package com.yuhao.structure.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yuhao.util.WordGenerator;


@Controller
@RequestMapping("/file")
public class FileController {
	 private final static String URLHEAD="http://localhost:8080/StudentApp/upload/";
		@RequestMapping("upload")
		public String upload(HttpServletRequest req,HttpServletResponse res,@RequestParam(value="file")MultipartFile file,Model mod) throws IOException{
			String filepath=req.getSession().getServletContext().getRealPath("upload");
			String fileName=file.getOriginalFilename();
			File target=new File(filepath,fileName);
			if(!target.exists()){
				target.mkdirs();
			}
			file.transferTo(target);
			System.out.println(URLHEAD+fileName);
			mod.addAttribute("fileUrl", URLHEAD+fileName);
			return "upload";
			
		}
		@RequestMapping("download")
		public String upload(String fileName,HttpServletRequest req,HttpServletResponse res){
			res.setCharacterEncoding("utf-8");
			res.setContentType("multipart/form-data");
			res.setHeader("Content-Disposition", "attachment;fileName="+fileName);
			try {
				String filepath=req.getSession().getServletContext().getRealPath("upload");
				InputStream is=new FileInputStream(new File(filepath+File.separator+fileName));
				OutputStream os=res.getOutputStream();
				byte[] b=new byte[2048];
				int length;
				while((length=is.read(b))>0){
					os.write(b, 0, length);
				}
				os.close();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		@RequestMapping("genarateMod")
		public void genarateMod(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException ,IOException {
			 req.setCharacterEncoding("utf-8");  
	         Map<String, Object> map = new HashMap<String, Object>();  
	         Enumeration<String> paramNames = req.getParameterNames();  
	         // 通过循环将表单参数放入键值对映射中  
	         while(paramNames.hasMoreElements()) {  
	             String key = paramNames.nextElement();  
	             String value = req.getParameter(key);  
	             map.put(key, value);  
	         }  
	       
	         // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整  
	         // 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了  
	         File file = null;  
	         InputStream fin = null;  
	         ServletOutputStream out = null;  
	         try {  
	             // 调用工具类WordGenerator的createDoc方法生成Word文档  
	             file = WordGenerator.createDoc(map, "model");  
	             fin = new FileInputStream(file);  
	               
	             res.setCharacterEncoding("utf-8");  
	             res.setContentType("application/msword");  
	             // 设置浏览器以下载的方式处理该文件默认名为resume.doc  
	             res.addHeader("Content-Disposition", "attachment;filename=model.doc");  
	               
	             out = res.getOutputStream();  
	             byte[] buffer = new byte[512];  // 缓冲区  
	             int bytesToRead = -1;  
	             // 通过循环将读入的Word文件的内容输出到浏览器中  
	             while((bytesToRead = fin.read(buffer)) != -1) {  
	                 out.write(buffer, 0, bytesToRead);  
	             }  
	         } finally {  
	             if(fin != null) fin.close();  
	             if(out != null) out.close();  
	             if(file != null) file.delete(); // 删除临时文件  
	         }  
		};
		
		@RequestMapping("start")
		public String start(HttpServletRequest req,HttpServletResponse res){
			return "upload";
		}
		
}
