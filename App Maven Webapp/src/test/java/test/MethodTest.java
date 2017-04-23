package test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.DateUtils;
import org.junit.Test;

import com.yuhao.other.exception.WebInterfaceException;
import com.yuhao.webapi.baidu.face.FaceApi;


public class MethodTest {

	@Test
	public void faceApiTest() throws ClientProtocolException, IOException, WebInterfaceException{
			FaceApi fa=new FaceApi();
	}
}
