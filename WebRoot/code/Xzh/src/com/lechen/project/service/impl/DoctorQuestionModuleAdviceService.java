package com.lechen.project.service.impl;

import com.lechen.project.entry.DoctorQuestionModuleAdvice;
import com.lechen.project.dao.IDoctorQuestionModuleAdviceDAO;
import com.lechen.project.service.IDoctorQuestionModuleAdviceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:医生模块建议	持久层接口
 * @author:	
 * @createTime: 2016-01-20 13:13:59
 */	
	
@Service
public class DoctorQuestionModuleAdviceService implements IDoctorQuestionModuleAdviceService {
	
	@Autowired
	private IDoctorQuestionModuleAdviceDAO doctorQuestionModuleAdviceDAO;	
	
    public String add(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception {
    	DoctorQuestionModuleAdvice tempDoctorQuestionModuleAdvice = new DoctorQuestionModuleAdvice();
		tempDoctorQuestionModuleAdvice.setCordon(doctorQuestionModuleAdvice.getCordon());
		tempDoctorQuestionModuleAdvice.setAverage(doctorQuestionModuleAdvice.getAverage());
		tempDoctorQuestionModuleAdvice.setScore(doctorQuestionModuleAdvice.getScore());
		tempDoctorQuestionModuleAdvice.setQoctorQuestionRecordId(doctorQuestionModuleAdvice.getQoctorQuestionRecordId());
		tempDoctorQuestionModuleAdvice.setTitle(doctorQuestionModuleAdvice.getTitle());
		tempDoctorQuestionModuleAdvice.setTitle(doctorQuestionModuleAdvice.getTitle());
		tempDoctorQuestionModuleAdvice.setNote(doctorQuestionModuleAdvice.getNote());
		return doctorQuestionModuleAdviceDAO.save(tempDoctorQuestionModuleAdvice);	
	}
	
    public void remove(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception {	
		doctorQuestionModuleAdviceDAO.delete(doctorQuestionModuleAdvice.getId());	
	}
	
    public DoctorQuestionModuleAdvice modify(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception {	
		DoctorQuestionModuleAdvice tempDoctorQuestionModuleAdvice = doctorQuestionModuleAdviceDAO.get(doctorQuestionModuleAdvice.getId());
		
		if(doctorQuestionModuleAdvice.getCordon()!=null){
			tempDoctorQuestionModuleAdvice.setCordon(doctorQuestionModuleAdvice.getCordon());
		}
		if(doctorQuestionModuleAdvice.getAverage()!=null){
			tempDoctorQuestionModuleAdvice.setAverage(doctorQuestionModuleAdvice.getAverage());
		}
		if(doctorQuestionModuleAdvice.getScore()!=null){
			tempDoctorQuestionModuleAdvice.setScore(doctorQuestionModuleAdvice.getScore());
		}
		if(doctorQuestionModuleAdvice.getQoctorQuestionRecordId()!=null){
			tempDoctorQuestionModuleAdvice.setQoctorQuestionRecordId(doctorQuestionModuleAdvice.getQoctorQuestionRecordId());
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			tempDoctorQuestionModuleAdvice.setTitle(doctorQuestionModuleAdvice.getTitle());
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			tempDoctorQuestionModuleAdvice.setTitle(doctorQuestionModuleAdvice.getTitle());
		}
		if(doctorQuestionModuleAdvice.getNote()!=null){
			tempDoctorQuestionModuleAdvice.setNote(doctorQuestionModuleAdvice.getNote());
		}
		doctorQuestionModuleAdviceDAO.update(tempDoctorQuestionModuleAdvice);	
		return tempDoctorQuestionModuleAdvice;	
	}
	
    public DoctorQuestionModuleAdvice read(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice) throws Exception {	
		return doctorQuestionModuleAdviceDAO.get(doctorQuestionModuleAdvice.getId());	
	}	
	
    public List<DoctorQuestionModuleAdvice> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return doctorQuestionModuleAdviceDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return doctorQuestionModuleAdviceDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<DoctorQuestionModuleAdvice> doctorQuestionModuleAdvices = doctorQuestionModuleAdviceDAO.list(dc, page, rows);
		for(DoctorQuestionModuleAdvice doctorQuestionModuleAdvice:doctorQuestionModuleAdvices){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",doctorQuestionModuleAdvice.getId());
			obj.put("text",doctorQuestionModuleAdvice.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}