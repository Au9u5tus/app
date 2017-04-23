package com.yuhao.structure.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhao.structure.pojo.UploadStatus;

@Controller()
@RequestMapping("/progress")
public class ProgressController {
	
	@ResponseBody
	@RequestMapping("getStatus")
	public UploadStatus getStatus(HttpServletRequest req) {
		UploadStatus uploadStatus = (UploadStatus) req.getSession()
				.getAttribute("status");
		if (uploadStatus == null) {
			return null;
		}
		return uploadStatus;
	}
}
