package com.bbcare.cloud.followConfig.service.impl;

import com.bbcare.cloud.followConfig.entry.LehuiMuRuRecord;
import com.bbcare.cloud.followConfig.dao.ILehuiMuRuRecordDAO;
import com.bbcare.cloud.followConfig.service.ILehuiMuRuRecordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:乐慧母乳调查临时	持久层接口
 * @author:	
 * @createTime: 2016-12-15 18:28:17
 */	
	
@Service
public class LehuiMuRuRecordService implements ILehuiMuRuRecordService {
	
	@Autowired
	private ILehuiMuRuRecordDAO lehuiMuRuRecordDAO;	
	
    public String add(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {
    	LehuiMuRuRecord tempLehuiMuRuRecord = new LehuiMuRuRecord();
		tempLehuiMuRuRecord.setQuestionId(lehuiMuRuRecord.getQuestionId());
		tempLehuiMuRuRecord.setFollowTemplateId(lehuiMuRuRecord.getFollowTemplateId());
		tempLehuiMuRuRecord.setCreateTime(lehuiMuRuRecord.getCreateTime());
		tempLehuiMuRuRecord.setNote(lehuiMuRuRecord.getNote());
		tempLehuiMuRuRecord.setOpenId(lehuiMuRuRecord.getOpenId());
		tempLehuiMuRuRecord.setAnswer(lehuiMuRuRecord.getAnswer());
		return lehuiMuRuRecordDAO.save(tempLehuiMuRuRecord);	
	}
	
    public void remove(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {	
		lehuiMuRuRecordDAO.delete(lehuiMuRuRecord.getId());	
	}
	
    public LehuiMuRuRecord modify(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {	
		LehuiMuRuRecord tempLehuiMuRuRecord = lehuiMuRuRecordDAO.get(lehuiMuRuRecord.getId());
		
		if(lehuiMuRuRecord.getQuestionId()!=null){
			tempLehuiMuRuRecord.setQuestionId(lehuiMuRuRecord.getQuestionId());
		}
		if(lehuiMuRuRecord.getFollowTemplateId()!=null){
			tempLehuiMuRuRecord.setFollowTemplateId(lehuiMuRuRecord.getFollowTemplateId());
		}
		if(lehuiMuRuRecord.getCreateTime()!=null){
			tempLehuiMuRuRecord.setCreateTime(lehuiMuRuRecord.getCreateTime());
		}
		if(lehuiMuRuRecord.getNote()!=null){
			tempLehuiMuRuRecord.setNote(lehuiMuRuRecord.getNote());
		}
		if(lehuiMuRuRecord.getOpenId()!=null){
			tempLehuiMuRuRecord.setOpenId(lehuiMuRuRecord.getOpenId());
		}
		if(lehuiMuRuRecord.getAnswer()!=null){
			tempLehuiMuRuRecord.setAnswer(lehuiMuRuRecord.getAnswer());
		}
		lehuiMuRuRecordDAO.update(tempLehuiMuRuRecord);	
		return tempLehuiMuRuRecord;	
	}
	
    public LehuiMuRuRecord read(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {	
		return lehuiMuRuRecordDAO.get(lehuiMuRuRecord.getId());	
	}	
	
    public List<LehuiMuRuRecord> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return lehuiMuRuRecordDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return lehuiMuRuRecordDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<LehuiMuRuRecord> lehuiMuRuRecords = lehuiMuRuRecordDAO.list(dc, page, rows);
		for(LehuiMuRuRecord lehuiMuRuRecord:lehuiMuRuRecords){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",lehuiMuRuRecord.getId());
			obj.put("text",lehuiMuRuRecord.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}