package com.yuhao.structure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuhao.structure.dao.AdministrationDao;
import com.yuhao.structure.pojo.AdminTree;
import com.yuhao.structure.pojo.Administration;
import com.yuhao.structure.pojo.ResMsg;
import com.yuhao.structure.pojo.SendData;
import com.yuhao.util.StringUtil;

@Service
public class AdministrationService {
	@Autowired
	private AdministrationDao administrationDao;

	// private Logger logger=Logger.getLogger(AdministrationService.class);
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void add(List<Administration> admins) throws Exception {
		Integer count = admins.size();
		Integer successNum = administrationDao.batchAdd(admins);
		if (count.intValue() != successNum.intValue()) {
			throw new Exception("插入数据库！");
		}

	}

	public SendData<Administration> getAdmins(Administration admin) {
		admin.setPage(StringUtil.getListStart(admin.getPage(), admin.getRows()));
		SendData<Administration> sd = new SendData<Administration>();
		sd.setTotal(administrationDao.count());
		sd.setRows(administrationDao.getAdmins(admin));
		return sd;
	}
	
	public List<AdminTree> adminTree(AdminTree at){
		List<AdminTree> ats= administrationDao.adminTree(at);
		List<AdminTree> admins=new ArrayList<AdminTree>();
		for (AdminTree adminTree : ats) {
			if(administrationDao.isBottom(at)>0){
				adminTree.setState("closed");
			}
			admins.add(adminTree);
		}
		return admins;
	}
	
	public ResMsg addAdmin(Administration admin){
		admin.setStatus("1");
		ResMsg rm=new ResMsg();
		Integer flag=administrationDao.insert(admin);
		if(flag==1){
			rm.setResCode("000000");
			rm.setResMsg("添加成功！");
		}else{
			rm.setResCode("999999");
			rm.setResMsg("添加失败！");
		}
		return rm;
	}
	
	public ResMsg removeRows(List<String> ids){
		ResMsg rm=new ResMsg();
		Integer flag=administrationDao.removeRows(ids);
		if(flag>0){
			rm.setResCode("000000");
			rm.setResMsg("删除成功！");
		}else{
			rm.setResCode("999999");
			rm.setResMsg("删除失败！");
		}
		return rm;
	}
}
