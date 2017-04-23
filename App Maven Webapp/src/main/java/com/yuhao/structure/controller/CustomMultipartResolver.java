package com.yuhao.structure.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuhao.other.listener.UploadListener;

public class CustomMultipartResolver extends CommonsMultipartResolver {

	private HttpServletRequest req;

	@Override
	public MultipartHttpServletRequest resolveMultipart(HttpServletRequest req)
			throws MultipartException {
		// TODO Auto-generated method stub
		this.req = req;
		return super.resolveMultipart(req);
	}

	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest req)
			throws MultipartException {
		HttpSession session = req.getSession();
		String encoding = determineEncoding(req);
		FileUpload upload = prepareFileUpload(encoding);
		UploadListener progressListener=new UploadListener(session);
		upload.setProgressListener(progressListener);  
		try {
			List<FileItem> fileItems = ((ServletFileUpload) upload).parseRequest(req);
			return parseFileItems(fileItems, encoding);
		} catch (FileUploadBase.SizeLimitExceededException ex) {
			throw new MaxUploadSizeExceededException(upload.getSizeMax(), ex);
		} catch (FileUploadException ex) {
			throw new MultipartException("Could not parse multipart servlet request", ex);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	protected FileUpload newFileUpload(FileItemFactory fileItemFactory) {
		// TODO Auto-generated method stub
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		upload.setSizeMax(-1);
		if (req != null) {
			HttpSession session = req.getSession();
			UploadListener progressListener = new UploadListener(session);
			upload.setProgressListener(progressListener);
		}
		return upload;
	}

}
