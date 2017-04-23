package com.yuhao.structure.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("testVal")
	public String testVal(HttpServletRequest req,HttpServletResponse res,Model mod){
			return "bootstrap";
	}
}
