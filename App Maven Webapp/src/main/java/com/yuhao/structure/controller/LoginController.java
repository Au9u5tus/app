package com.yuhao.structure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuhao.other.listener.myHttpSessionListener;

@Controller
@RequestMapping("login")
public class LoginController {
		@RequestMapping("init")
		public String init(HttpServletRequest request){
			System.out.println(request.getHeader("host"));
			System.out.println(request.getRemoteAddr());
			return "login";
		}
		
		@RequestMapping("go")
		public String go(HttpServletRequest request){
//			request.getSession().invalidate();
			System.out.println(myHttpSessionListener.getCount());
			return "show";
		}
}
