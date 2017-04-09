package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.BabyFollowRecord;
import com.bbcare.cloud.follow.dao.IBabyFollowRecordDAO;
import com.bbcare.cloud.follow.service.IBabyFollowRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowPlan;
import com.bbcare.cloud.follow.dao.IFollowPlanDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访记录	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class BabyFollowRecordService implements IBabyFollowRecordService {
	
	@Autowired
	private IBabyFollowRecordDAO babyFollowRecordDAO;	
	
	@Autowired
	private IFollowPlanDAO followPlanDAO;
	
    public String add(BabyFollowRecord babyFollowRecord) throws Exception {
    	BabyFollowRecord tempBabyFollowRecord = new BabyFollowRecord();
		tempBabyFollowRecord.setFollowTemplateId(babyFollowRecord.getFollowTemplateId());
		tempBabyFollowRecord.setFollowTime(babyFollowRecord.getFollowTime());
		tempBabyFollowRecord.setBabyId(babyFollowRecord.getBabyId());
		if(babyFollowRecord.getFollowPlan()!=null&&babyFollowRecord.getFollowPlan().getId()!=null&&babyFollowRecord.getFollowPlan().getId().trim().length()>0){
			FollowPlan followPlanTemp = followPlanDAO.get(babyFollowRecord.getFollowPlan().getId());
			if(followPlanTemp!=null){
				tempBabyFollowRecord.setFollowPlan(followPlanTemp);
				tempBabyFollowRecord.setFollowPlanName(followPlanTemp.getId());
			}
		}
		return babyFollowRecordDAO.save(tempBabyFollowRecord);	
	}
	
    public void remove(BabyFollowRecord babyFollowRecord) throws Exception {	
		babyFollowRecordDAO.delete(babyFollowRecord.getId());	
	}
	
    public BabyFollowRecord modify(BabyFollowRecord babyFollowRecord) throws Exception {	
		BabyFollowRecord tempBabyFollowRecord = babyFollowRecordDAO.get(babyFollowRecord.getId());
		
		if(babyFollowRecord.getFollowTemplateId()!=null){
			tempBabyFollowRecord.setFollowTemplateId(babyFollowRecord.getFollowTemplateId());
		}
		if(babyFollowRecord.getFollowTime()!=null){
			tempBabyFollowRecord.setFollowTime(babyFollowRecord.getFollowTime());
		}
		if(babyFollowRecord.getBabyId()!=null){
			tempBabyFollowRecord.setBabyId(babyFollowRecord.getBabyId());
		}
		if(babyFollowRecord.getFollowPlan()!=null&& babyFollowRecord.getFollowPlan().getId()!=null&&babyFollowRecord.getFollowPlan().getId().trim().length()>0){
			FollowPlan followPlanTemp = followPlanDAO.get(babyFollowRecord.getFollowPlan().getId());
			if(followPlanTemp!=null){
				tempBabyFollowRecord.setFollowPlan(followPlanTemp);
				tempBabyFollowRecord.setFollowPlanName(followPlanTemp.getId());
			}
		}
		babyFollowRecordDAO.update(tempBabyFollowRecord);	
		return tempBabyFollowRecord;	
	}
	
    public BabyFollowRecord read(BabyFollowRecord babyFollowRecord) throws Exception {	
		return babyFollowRecordDAO.get(babyFollowRecord.getId());	
	}	
	
    public List<BabyFollowRecord> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowRecordDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowRecordDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowRecord> babyFollowRecords = babyFollowRecordDAO.list(dc, page, rows);
		for(BabyFollowRecord babyFollowRecord:babyFollowRecords){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowRecord.getId());
			obj.put("text",babyFollowRecord.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}