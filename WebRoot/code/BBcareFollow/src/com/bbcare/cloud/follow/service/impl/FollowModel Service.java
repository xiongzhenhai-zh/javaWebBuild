package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowModel ;
import com.bbcare.cloud.follow.dao.IFollowModel DAO;
import com.bbcare.cloud.follow.service.IFollowModel Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.ModelClass;
import com.bbcare.cloud.follow.dao.IModelClassDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访模型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowModel Service implements IFollowModel Service {
	
	@Autowired
	private IFollowModel DAO followModel DAO;	
	
	@Autowired
	private IModelClassDAO modelClassDAO;
	
    public String add(FollowModel  followModel ) throws Exception {
    	FollowModel  tempFollowModel  = new FollowModel ();
		tempFollowModel .setName(followModel .getName());
		tempFollowModel .setDoctorId(followModel .getDoctorId());
		tempFollowModel .setStatus(followModel .getStatus());
		tempFollowModel .setIntroduction(followModel .getIntroduction());
		tempFollowModel .setTarger(followModel .getTarger());
		tempFollowModel .setNote(followModel .getNote());
		tempFollowModel .setCreateTime(followModel .getCreateTime());
		if(followModel .getModelClass()!=null&&followModel .getModelClass().getId()!=null&&followModel .getModelClass().getId().trim().length()>0){
			ModelClass modelClassTemp = modelClassDAO.get(followModel .getModelClass().getId());
			if(modelClassTemp!=null){
				tempFollowModel .setModelClass(modelClassTemp);
				tempFollowModel .setModelClassName(modelClassTemp.getName());
			}
		}
		return followModel DAO.save(tempFollowModel );	
	}
	
    public void remove(FollowModel  followModel ) throws Exception {	
		followModel DAO.delete(followModel .getId());	
	}
	
    public FollowModel  modify(FollowModel  followModel ) throws Exception {	
		FollowModel  tempFollowModel  = followModel DAO.get(followModel .getId());
		
		if(followModel .getName()!=null){
			tempFollowModel .setName(followModel .getName());
		}
		if(followModel .getDoctorId()!=null){
			tempFollowModel .setDoctorId(followModel .getDoctorId());
		}
		if(followModel .getStatus()!=null){
			tempFollowModel .setStatus(followModel .getStatus());
		}
		if(followModel .getIntroduction()!=null){
			tempFollowModel .setIntroduction(followModel .getIntroduction());
		}
		if(followModel .getTarger()!=null){
			tempFollowModel .setTarger(followModel .getTarger());
		}
		if(followModel .getNote()!=null){
			tempFollowModel .setNote(followModel .getNote());
		}
		if(followModel .getCreateTime()!=null){
			tempFollowModel .setCreateTime(followModel .getCreateTime());
		}
		if(followModel .getModelClass()!=null&& followModel .getModelClass().getId()!=null&&followModel .getModelClass().getId().trim().length()>0){
			ModelClass modelClassTemp = modelClassDAO.get(followModel .getModelClass().getId());
			if(modelClassTemp!=null){
				tempFollowModel .setModelClass(modelClassTemp);
				tempFollowModel .setModelClassName(modelClassTemp.getName());
			}
		}
		followModel DAO.update(tempFollowModel );	
		return tempFollowModel ;	
	}
	
    public FollowModel  read(FollowModel  followModel ) throws Exception {	
		return followModel DAO.get(followModel .getId());	
	}	
	
    public List<FollowModel > list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followModel DAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followModel DAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowModel > followModel s = followModel DAO.list(dc, page, rows);
		for(FollowModel  followModel :followModel s){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followModel .getId());
			obj.put("text",followModel .getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowModel  followModel ) throws Exception {
    	if(followModel .getStatus()==null){
    		return false;
    	}
		FollowModel  tempFollowModel  = followModel DAO.get(followModel .getId());
		if(tempFollowModel !=null){
			tempFollowModel .setStatus(followModel .getStatus());
			followModel DAO.update(tempFollowModel );
			return true;
		}else{
			return false;
		}
	}
	
}