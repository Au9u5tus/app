package com.yuhao.token.baidu;

import java.io.IOException;
import java.util.Date;

import org.apache.http.ParseException;

import com.alibaba.fastjson.JSONObject;
import com.yuhao.util.common.ConfigUtil;
import com.yuhao.util.http.HttpUtil;

public class Token {
	private final static String GRANT_TYPE = "grant_type";
	private final static String API_KEY = "client_id";
	private final static String SECRET_KEY = "client_secret";
	private final static String TOKEN_URL = "TOKEN";
	private String tokenId;
	private Date createTime;
	private Long expires;
	
	public Token() throws ParseException, IOException{
		JSONObject res = HttpUtil.createJsonHttpRequest("POST",
				ConfigUtil.getProperty(TOKEN_URL), null,
				ConfigUtil.getMapProperty(GRANT_TYPE, API_KEY, SECRET_KEY),
				null);
		tokenId=res.get("access_token").toString();
		createTime=new Date();
		expires=Long.parseLong(res.get("expires_in").toString());
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Long getExpires() {
		return expires;
	}

	public void setExpires(Long expires) {
		this.expires = expires;
	}

	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", createTime=" + createTime
				+ ", expires=" + expires + "]";
	}



}
