package com.yuhao.other.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

import com.yuhao.structure.pojo.UploadStatus;

public class UploadListener implements ProgressListener {

	private HttpSession session;

	public UploadListener() {
	}

	public UploadListener(HttpSession session) {
		this.session = session;
		UploadStatus status = new UploadStatus();
		session.setAttribute("status", status);
	}

	@Override
	public void update(long bytesRead, long contentLength, int items) {
		// TODO Auto-generated method stub
		UploadStatus status = (UploadStatus) session.getAttribute("status");
		status.setBytesRead(bytesRead);
		status.setContentLength(contentLength);
		status.setItems(items);
		session.setAttribute("status", status);
	}

}
