package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecord;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeRecordDAO;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeRecordService;
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
public class BabyFollowSchemeRecordService implements IBabyFollowSchemeRecordService {
	
	@Autowired
	private IBabyFollowSchemeRecordDAO babyFollowSchemeRecordDAO;	
	
	@Autowired
	private IBabyFollowSchemeDAO babyFollowSchemeDAO;
	
    public String add(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
    	BabyFollowSchemeRecord tempBabyFollowSchemeRecord = new BabyFollowSchemeRecord();
		tempBabyFollowSchemeRecord.setName(babyFollowSchemeRecord.getName());
		tempBabyFollowSchemeRecord.setType(babyFollowSchemeRecord.getType());
		tempBabyFollowSchemeRecord.setStatus(babyFollowSchemeRecord.getStatus());
		tempBabyFollowSchemeRecord.setDoctorFollowSchemeRecordId(babyFollowSchemeRecord.getDoctorFollowSchemeRecordId());
		tempBabyFollowSchemeRecord.setCompleteTime(babyFollowSchemeRecord.getCompleteTime());
		tempBabyFollowSchemeRecord.setCreateTime(babyFollowSchemeRecord.getCreateTime());
		if(babyFollowSchemeRecord.getBabyFollowScheme()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(babyFollowSchemeRecord.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempBabyFollowSchemeRecord.setBabyFollowScheme(babyFollowSchemeTemp);
				tempBabyFollowSchemeRecord.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		return babyFollowSchemeRecordDAO.save(tempBabyFollowSchemeRecord);	
	}
	
    public void remove(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {	
		babyFollowSchemeRecordDAO.delete(babyFollowSchemeRecord.getId());	
	}
	
    public BabyFollowSchemeRecord modify(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {	
		BabyFollowSchemeRecord tempBabyFollowSchemeRecord = babyFollowSchemeRecordDAO.get(babyFollowSchemeRecord.getId());
		
		if(babyFollowSchemeRecord.getName()!=null){
			tempBabyFollowSchemeRecord.setName(babyFollowSchemeRecord.getName());
		}
		if(babyFollowSchemeRecord.getType()!=null){
			tempBabyFollowSchemeRecord.setType(babyFollowSchemeRecord.getType());
		}
		if(babyFollowSchemeRecord.getStatus()!=null){
			tempBabyFollowSchemeRecord.setStatus(babyFollowSchemeRecord.getStatus());
		}
		if(babyFollowSchemeRecord.getDoctorFollowSchemeRecordId()!=null){
			tempBabyFollowSchemeRecord.setDoctorFollowSchemeRecordId(babyFollowSchemeRecord.getDoctorFollowSchemeRecordId());
		}
		if(babyFollowSchemeRecord.getCompleteTime()!=null){
			tempBabyFollowSchemeRecord.setCompleteTime(babyFollowSchemeRecord.getCompleteTime());
		}
		if(babyFollowSchemeRecord.getCreateTime()!=null){
			tempBabyFollowSchemeRecord.setCreateTime(babyFollowSchemeRecord.getCreateTime());
		}
		if(babyFollowSchemeRecord.getBabyFollowScheme()!=null&& babyFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(babyFollowSchemeRecord.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempBabyFollowSchemeRecord.setBabyFollowScheme(babyFollowSchemeTemp);
				tempBabyFollowSchemeRecord.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		babyFollowSchemeRecordDAO.update(tempBabyFollowSchemeRecord);	
		return tempBabyFollowSchemeRecord;	
	}
	
    public BabyFollowSchemeRecord read(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {	
		return babyFollowSchemeRecordDAO.get(babyFollowSchemeRecord.getId());	
	}	
	
    public List<BabyFollowSchemeRecord> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowSchemeRecordDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowSchemeRecordDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowSchemeRecord> babyFollowSchemeRecords = babyFollowSchemeRecordDAO.list(dc, page, rows);
		for(BabyFollowSchemeRecord babyFollowSchemeRecord:babyFollowSchemeRecords){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowSchemeRecord.getId());
			obj.put("text",babyFollowSchemeRecord.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
    	if(babyFollowSchemeRecord.getStatus()==null){
    		return false;
    	}
		BabyFollowSchemeRecord tempBabyFollowSchemeRecord = babyFollowSchemeRecordDAO.get(babyFollowSchemeRecord.getId());
		if(tempBabyFollowSchemeRecord!=null){
			tempBabyFollowSchemeRecord.setStatus(babyFollowSchemeRecord.getStatus());
			babyFollowSchemeRecordDAO.update(tempBabyFollowSchemeRecord);
			return true;
		}else{
			return false;
		}
	}
	
}