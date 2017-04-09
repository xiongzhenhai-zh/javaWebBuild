package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecord;
import com.bbcare.cloud.followUsed.dao.IDoctorFollowSchemeRecordDAO;
import com.bbcare.cloud.followUsed.service.IDoctorFollowSchemeRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.followUsed.entry.BabyFollowScheme;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:会员随访记录	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class DoctorFollowSchemeRecordService implements IDoctorFollowSchemeRecordService {
	
	@Autowired
	private IDoctorFollowSchemeRecordDAO doctorFollowSchemeRecordDAO;	
	
	@Autowired
	private IBabyFollowSchemeDAO babyFollowSchemeDAO;
	
    public String add(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
    	DoctorFollowSchemeRecord tempDoctorFollowSchemeRecord = new DoctorFollowSchemeRecord();
		tempDoctorFollowSchemeRecord.setName(doctorFollowSchemeRecord.getName());
		tempDoctorFollowSchemeRecord.setType(doctorFollowSchemeRecord.getType());
		tempDoctorFollowSchemeRecord.setStatus(doctorFollowSchemeRecord.getStatus());
		tempDoctorFollowSchemeRecord.setBabyFollowSchemeRecordId(doctorFollowSchemeRecord.getBabyFollowSchemeRecordId());
		tempDoctorFollowSchemeRecord.setCompleteTime(doctorFollowSchemeRecord.getCompleteTime());
		tempDoctorFollowSchemeRecord.setCreateTime(doctorFollowSchemeRecord.getCreateTime());
		if(doctorFollowSchemeRecord.getBabyFollowScheme()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(doctorFollowSchemeRecord.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempDoctorFollowSchemeRecord.setBabyFollowScheme(babyFollowSchemeTemp);
				tempDoctorFollowSchemeRecord.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		return doctorFollowSchemeRecordDAO.save(tempDoctorFollowSchemeRecord);	
	}
	
    public void remove(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {	
		doctorFollowSchemeRecordDAO.delete(doctorFollowSchemeRecord.getId());	
	}
	
    public DoctorFollowSchemeRecord modify(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {	
		DoctorFollowSchemeRecord tempDoctorFollowSchemeRecord = doctorFollowSchemeRecordDAO.get(doctorFollowSchemeRecord.getId());
		
		if(doctorFollowSchemeRecord.getName()!=null){
			tempDoctorFollowSchemeRecord.setName(doctorFollowSchemeRecord.getName());
		}
		if(doctorFollowSchemeRecord.getType()!=null){
			tempDoctorFollowSchemeRecord.setType(doctorFollowSchemeRecord.getType());
		}
		if(doctorFollowSchemeRecord.getStatus()!=null){
			tempDoctorFollowSchemeRecord.setStatus(doctorFollowSchemeRecord.getStatus());
		}
		if(doctorFollowSchemeRecord.getBabyFollowSchemeRecordId()!=null){
			tempDoctorFollowSchemeRecord.setBabyFollowSchemeRecordId(doctorFollowSchemeRecord.getBabyFollowSchemeRecordId());
		}
		if(doctorFollowSchemeRecord.getCompleteTime()!=null){
			tempDoctorFollowSchemeRecord.setCompleteTime(doctorFollowSchemeRecord.getCompleteTime());
		}
		if(doctorFollowSchemeRecord.getCreateTime()!=null){
			tempDoctorFollowSchemeRecord.setCreateTime(doctorFollowSchemeRecord.getCreateTime());
		}
		if(doctorFollowSchemeRecord.getBabyFollowScheme()!=null&& doctorFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(doctorFollowSchemeRecord.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempDoctorFollowSchemeRecord.setBabyFollowScheme(babyFollowSchemeTemp);
				tempDoctorFollowSchemeRecord.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		doctorFollowSchemeRecordDAO.update(tempDoctorFollowSchemeRecord);	
		return tempDoctorFollowSchemeRecord;	
	}
	
    public DoctorFollowSchemeRecord read(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {	
		return doctorFollowSchemeRecordDAO.get(doctorFollowSchemeRecord.getId());	
	}	
	
    public List<DoctorFollowSchemeRecord> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return doctorFollowSchemeRecordDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return doctorFollowSchemeRecordDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<DoctorFollowSchemeRecord> doctorFollowSchemeRecords = doctorFollowSchemeRecordDAO.list(dc, page, rows);
		for(DoctorFollowSchemeRecord doctorFollowSchemeRecord:doctorFollowSchemeRecords){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",doctorFollowSchemeRecord.getId());
			obj.put("text",doctorFollowSchemeRecord.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
    	if(doctorFollowSchemeRecord.getStatus()==null){
    		return false;
    	}
		DoctorFollowSchemeRecord tempDoctorFollowSchemeRecord = doctorFollowSchemeRecordDAO.get(doctorFollowSchemeRecord.getId());
		if(tempDoctorFollowSchemeRecord!=null){
			tempDoctorFollowSchemeRecord.setStatus(doctorFollowSchemeRecord.getStatus());
			doctorFollowSchemeRecordDAO.update(tempDoctorFollowSchemeRecord);
			return true;
		}else{
			return false;
		}
	}
	
}