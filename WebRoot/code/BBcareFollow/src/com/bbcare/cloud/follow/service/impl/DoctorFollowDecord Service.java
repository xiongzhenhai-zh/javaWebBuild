package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.DoctorFollowDecord ;
import com.bbcare.cloud.follow.dao.IDoctorFollowDecord DAO;
import com.bbcare.cloud.follow.service.IDoctorFollowDecord Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:医生归档档案	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class DoctorFollowDecord Service implements IDoctorFollowDecord Service {
	
	@Autowired
	private IDoctorFollowDecord DAO doctorFollowDecord DAO;	
	
    public String add(DoctorFollowDecord  doctorFollowDecord ) throws Exception {
    	DoctorFollowDecord  tempDoctorFollowDecord  = new DoctorFollowDecord ();
		tempDoctorFollowDecord .setName(doctorFollowDecord .getName());
		tempDoctorFollowDecord .setDoctorId(doctorFollowDecord .getDoctorId());
		tempDoctorFollowDecord .setStatus(doctorFollowDecord .getStatus());
		tempDoctorFollowDecord .setBabyId(doctorFollowDecord .getBabyId());
		tempDoctorFollowDecord .setBabyAge(doctorFollowDecord .getBabyAge());
		tempDoctorFollowDecord .setNote(doctorFollowDecord .getNote());
		tempDoctorFollowDecord .setCreateTime(doctorFollowDecord .getCreateTime());
		return doctorFollowDecord DAO.save(tempDoctorFollowDecord );	
	}
	
    public void remove(DoctorFollowDecord  doctorFollowDecord ) throws Exception {	
		doctorFollowDecord DAO.delete(doctorFollowDecord .getId());	
	}
	
    public DoctorFollowDecord  modify(DoctorFollowDecord  doctorFollowDecord ) throws Exception {	
		DoctorFollowDecord  tempDoctorFollowDecord  = doctorFollowDecord DAO.get(doctorFollowDecord .getId());
		
		if(doctorFollowDecord .getName()!=null){
			tempDoctorFollowDecord .setName(doctorFollowDecord .getName());
		}
		if(doctorFollowDecord .getDoctorId()!=null){
			tempDoctorFollowDecord .setDoctorId(doctorFollowDecord .getDoctorId());
		}
		if(doctorFollowDecord .getStatus()!=null){
			tempDoctorFollowDecord .setStatus(doctorFollowDecord .getStatus());
		}
		if(doctorFollowDecord .getBabyId()!=null){
			tempDoctorFollowDecord .setBabyId(doctorFollowDecord .getBabyId());
		}
		if(doctorFollowDecord .getBabyAge()!=null){
			tempDoctorFollowDecord .setBabyAge(doctorFollowDecord .getBabyAge());
		}
		if(doctorFollowDecord .getNote()!=null){
			tempDoctorFollowDecord .setNote(doctorFollowDecord .getNote());
		}
		if(doctorFollowDecord .getCreateTime()!=null){
			tempDoctorFollowDecord .setCreateTime(doctorFollowDecord .getCreateTime());
		}
		doctorFollowDecord DAO.update(tempDoctorFollowDecord );	
		return tempDoctorFollowDecord ;	
	}
	
    public DoctorFollowDecord  read(DoctorFollowDecord  doctorFollowDecord ) throws Exception {	
		return doctorFollowDecord DAO.get(doctorFollowDecord .getId());	
	}	
	
    public List<DoctorFollowDecord > list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return doctorFollowDecord DAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return doctorFollowDecord DAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<DoctorFollowDecord > doctorFollowDecord s = doctorFollowDecord DAO.list(dc, page, rows);
		for(DoctorFollowDecord  doctorFollowDecord :doctorFollowDecord s){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",doctorFollowDecord .getId());
			obj.put("text",doctorFollowDecord .getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(DoctorFollowDecord  doctorFollowDecord ) throws Exception {
    	if(doctorFollowDecord .getStatus()==null){
    		return false;
    	}
		DoctorFollowDecord  tempDoctorFollowDecord  = doctorFollowDecord DAO.get(doctorFollowDecord .getId());
		if(tempDoctorFollowDecord !=null){
			tempDoctorFollowDecord .setStatus(doctorFollowDecord .getStatus());
			doctorFollowDecord DAO.update(tempDoctorFollowDecord );
			return true;
		}else{
			return false;
		}
	}
	
}