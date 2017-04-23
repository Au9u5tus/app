package com.yuhao.webapi.baidu.face;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.yuhao.other.exception.WebInterfaceException;
import com.yuhao.token.baidu.Token;
import com.yuhao.util.common.ConfigUtil;
import com.yuhao.util.common.MessageUtil;
import com.yuhao.util.common.StringUtil;
import com.yuhao.util.http.HttpUtil;

public class FaceApi {
	public final static String FACE_MATCH_URL = "FACE_MATCH";

	public final static String FACE_ADD_URL = "FACE_ADD";

	public JSONObject faceRecognize(Token token,String images)
			throws ClientProtocolException, IOException, WebInterfaceException {
		Map<String, String> header = new HashMap<String, String>();
		Map<String, String> params = new HashMap<String, String>();
		if (StringUtil.isEmpty(images)) {
			return MessageUtil.returnMsg("-1", "参数不合法！");
		}
		header.put("Content-Type", "application/x-www-form-urlencoded");
		params.put("access_token", token.getTokenId());
		params.put("images", images);
		JSONObject json = HttpUtil.createJsonHttpRequest("POST",
				ConfigUtil.getProperty(FACE_MATCH_URL), header, params, null);
		return json;
	}
}
