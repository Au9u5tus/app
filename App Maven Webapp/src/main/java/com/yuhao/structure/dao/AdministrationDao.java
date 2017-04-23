package com.yuhao.structure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuhao.structure.pojo.AdminTree;
import com.yuhao.structure.pojo.Administration;



public interface AdministrationDao extends BaseDao<Administration>{
	  public Integer batchAdd(@Param(value="admins")List<Administration> admins);
	  
	  public List<Administration> getAdmins(Administration admin);
	  
	  public Integer count();
	  
	  public List<AdminTree> adminTree(AdminTree at);
	  
	  public Integer isBottom(AdminTree at);
	  
	  public Integer removeRows(@Param(value="ids")List<String> ids);
}
