package com.yuhao.util.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;


public class HttpUtil {

	public static String createStringHttpRequest(String type, String url,
			Map<String, String> headers, Map<String, String> urlParams,
			Map<String, String> entityParams) throws ParseException,
			IOException {
		RequestBuilder builder = null;
		HttpUriRequest request = null;
		switch (type) {
		case "POST":
			builder = RequestBuilder.post();
			break;

		case "GET":
			builder = RequestBuilder.get();
			break;
		}
		builder.setUri(url);
		if (headers != null && headers.size() > 0) {
			for (String header : headers.keySet()) {
				builder.addParameter(header, headers.get(header));
			}
		}
		if (urlParams != null && urlParams.size() > 0) {
			for (String param : urlParams.keySet()) {
				builder.addParameter(param, urlParams.get(param));
			}
		}
		HttpEntity entity = null;
		if (entityParams != null && entityParams.size() > 0) {
			List<NameValuePair> keyValuePairs = new ArrayList<NameValuePair>();
			for (String entityParam : entityParams.keySet()) {
				keyValuePairs.add(new BasicNameValuePair(entityParam,
						entityParams.get(entityParam)));
			}
			entity = new UrlEncodedFormEntity(keyValuePairs, "utf-8");
		}
		request = builder.setEntity(entity).build();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = null;
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity resEntity = response.getEntity();
			result = EntityUtils.toString(resEntity);
		}
		return result;
	}

	public static JSONObject createJsonHttpRequest(String type, String url,
			Map<String, String> headers, Map<String, String> urlParams,
			Map<String, String> entityParams) throws ParseException,
			IOException {
		return JSONObject.parseObject(createStringHttpRequest(type, url,
				headers, urlParams, entityParams));

	}

}