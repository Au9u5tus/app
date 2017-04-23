package com.yuhao.structure.service.api.baidu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhao.structure.dao.api.baidu.FaceDao;
import com.yuhao.structure.pojo.api.baidu.Face;

@Service
public class FaceService {
	@Autowired
	private FaceDao faceDao;
	public void faceCount(Face face){
		faceDao.count(face);
	}

}
