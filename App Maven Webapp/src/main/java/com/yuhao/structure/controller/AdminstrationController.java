package com.yuhao.structure.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhao.structure.pojo.AdminTree;
import com.yuhao.structure.pojo.Administration;
import com.yuhao.structure.pojo.ResMsg;
import com.yuhao.structure.pojo.SendData;
import com.yuhao.structure.service.AdministrationService;


@Controller
@RequestMapping("/admin")
public class AdminstrationController {
	@Autowired
	private AdministrationService administrationService;
		@RequestMapping("/init")
		public String add(HttpServletRequest req,HttpServletResponse res,Administration admin){
			res.setHeader("Access-Control-Allow-Origin","*");
				return "admin";
		}
		
		@RequestMapping("/getAdmins")
		@ResponseBody
		public SendData<Administration> getAdmins(HttpServletRequest req,HttpServletResponse res,Administration admin){
			res.setCharacterEncoding("utf-8");
			return administrationService.getAdmins(admin);
		}
		
		@RequestMapping("/adminTree")
		@ResponseBody
		public List<AdminTree> adminTree(HttpServletRequest req,HttpServletResponse res,AdminTree at){
			return administrationService.adminTree(at);
		}
		
		@RequestMapping("/removeRows")
		@ResponseBody
		public ResMsg removeRows(HttpServletRequest req,HttpServletResponse res,String ids){
			List<String> rowIds=Arrays.asList(ids.split(","));
			return administrationService.removeRows(rowIds);
		}
		
		@RequestMapping("/addAdmin")
		@ResponseBody
		public ResMsg addAdmin(HttpServletRequest req,HttpServletResponse res,Administration admin) throws UnsupportedEncodingException{
			return administrationService.addAdmin(admin);
		}
}
