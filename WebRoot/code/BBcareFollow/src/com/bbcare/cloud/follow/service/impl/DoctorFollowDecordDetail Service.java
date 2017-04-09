package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.DoctorFollowDecordDetail ;
import com.bbcare.cloud.follow.dao.IDoctorFollowDecordDetail DAO;
import com.bbcare.cloud.follow.service.IDoctorFollowDecordDetail Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.DoctorFollowDecord ;
import com.bbcare.cloud.follow.dao.IDoctorFollowDecord DAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:医生归档详情	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class DoctorFollowDecordDetail Service implements IDoctorFollowDecordDetail Service {
	
	@Autowired
	private IDoctorFollowDecordDetail DAO doctorFollowDecordDetail DAO;	
	
	@Autowired
	private IDoctorFollowDecord DAO doctorFollowDecord DAO;
	
    public String add(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception {
    	DoctorFollowDecordDetail  tempDoctorFollowDecordDetail  = new DoctorFollowDecordDetail ();
		tempDoctorFollowDecordDetail .setName(doctorFollowDecordDetail .getName());
		tempDoctorFollowDecordDetail .setQuestion(doctorFollowDecordDetail .getQuestion());
		tempDoctorFollowDecordDetail .setAnswer(doctorFollowDecordDetail .getAnswer());
		tempDoctorFollowDecordDetail .setCreateTime(doctorFollowDecordDetail .getCreateTime());
		if(doctorFollowDecordDetail .getDoctorFollowDecord()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId().trim().length()>0){
			DoctorFollowDecord  doctorFollowDecord Temp = doctorFollowDecord DAO.get(doctorFollowDecordDetail .getDoctorFollowDecord().getId());
			if(doctorFollowDecord Temp!=null){
				tempDoctorFollowDecordDetail .setDoctorFollowDecord(doctorFollowDecord Temp);
				tempDoctorFollowDecordDetail .setDoctorFollowDecordName(doctorFollowDecord Temp.getName());
			}
		}
		return doctorFollowDecordDetail DAO.save(tempDoctorFollowDecordDetail );	
	}
	
    public void remove(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception {	
		doctorFollowDecordDetail DAO.delete(doctorFollowDecordDetail .getId());	
	}
	
    public DoctorFollowDecordDetail  modify(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception {	
		DoctorFollowDecordDetail  tempDoctorFollowDecordDetail  = doctorFollowDecordDetail DAO.get(doctorFollowDecordDetail .getId());
		
		if(doctorFollowDecordDetail .getName()!=null){
			tempDoctorFollowDecordDetail .setName(doctorFollowDecordDetail .getName());
		}
		if(doctorFollowDecordDetail .getQuestion()!=null){
			tempDoctorFollowDecordDetail .setQuestion(doctorFollowDecordDetail .getQuestion());
		}
		if(doctorFollowDecordDetail .getAnswer()!=null){
			tempDoctorFollowDecordDetail .setAnswer(doctorFollowDecordDetail .getAnswer());
		}
		if(doctorFollowDecordDetail .getCreateTime()!=null){
			tempDoctorFollowDecordDetail .setCreateTime(doctorFollowDecordDetail .getCreateTime());
		}
		if(doctorFollowDecordDetail .getDoctorFollowDecord()!=null&& doctorFollowDecordDetail .getDoctorFollowDecord().getId()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId().trim().length()>0){
			DoctorFollowDecord  doctorFollowDecord Temp = doctorFollowDecord DAO.get(doctorFollowDecordDetail .getDoctorFollowDecord().getId());
			if(doctorFollowDecord Temp!=null){
				tempDoctorFollowDecordDetail .setDoctorFollowDecord(doctorFollowDecord Temp);
				tempDoctorFollowDecordDetail .setDoctorFollowDecordName(doctorFollowDecord Temp.getName());
			}
		}
		doctorFollowDecordDetail DAO.update(tempDoctorFollowDecordDetail );	
		return tempDoctorFollowDecordDetail ;	
	}
	
    public DoctorFollowDecordDetail  read(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception {	
		return doctorFollowDecordDetail DAO.get(doctorFollowDecordDetail .getId());	
	}	
	
    public List<DoctorFollowDecordDetail > list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return doctorFollowDecordDetail DAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return doctorFollowDecordDetail DAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<DoctorFollowDecordDetail > doctorFollowDecordDetail s = doctorFollowDecordDetail DAO.list(dc, page, rows);
		for(DoctorFollowDecordDetail  doctorFollowDecordDetail :doctorFollowDecordDetail s){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",doctorFollowDecordDetail .getId());
			obj.put("text",doctorFollowDecordDetail .getName());
			list.add(obj);
		}
		return list;	
	}	
	
}