package com.yuhao.structure.controller.api.baidu;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yuhao.structure.controller.api.BaseApiController;
import com.yuhao.token.baidu.Token;
import com.yuhao.util.common.ConfigUtil;
import com.yuhao.util.common.StringUtil;
import com.yuhao.webapi.baidu.face.FaceApi;

@Controller
@RequestMapping("api/baidu/face")
public class FaceApiController extends BaseApiController {
	@Autowired
	private Token token;

	@RequestMapping("/add")
	@ResponseBody
	public String faceAdd(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "file") MultipartFile file)
			throws ParseException, IOException {
//		String code=StringUtil.Base64Image(file.getInputStream());
//		return code;
		System.out.println(token);
		return null;
	}
}
