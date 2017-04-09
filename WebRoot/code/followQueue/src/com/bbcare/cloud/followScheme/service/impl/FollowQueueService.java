package com.bbcare.cloud.followScheme.service.impl;

import com.bbcare.cloud.followScheme.entry.FollowQueue;
import com.bbcare.cloud.followScheme.dao.IFollowQueueDAO;
import com.bbcare.cloud.followScheme.service.IFollowQueueService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访队列	持久层接口
 * @author:	
 * @createTime: 2016-11-15 10:46:05
 */	
	
@Service
public class FollowQueueService implements IFollowQueueService {
	
	@Autowired
	private IFollowQueueDAO followQueueDAO;	
	
    public String add(FollowQueue followQueue) throws Exception {
    	FollowQueue tempFollowQueue = new FollowQueue();
		tempFollowQueue.setName(followQueue.getName());
		tempFollowQueue.setMasterType(followQueue.getMasterType());
		tempFollowQueue.setMasterName(followQueue.getMasterName());
		tempFollowQueue.setMasterId(followQueue.getMasterId());
		tempFollowQueue.setIntroduction(followQueue.getIntroduction());
		tempFollowQueue.setNote(followQueue.getNote());
		tempFollowQueue.setStatus(followQueue.getStatus());
		tempFollowQueue.setTargerNumber(followQueue.getTargerNumber());
		tempFollowQueue.setUsedNumber(followQueue.getUsedNumber());
		tempFollowQueue.setCreateTime(followQueue.getCreateTime());
		return followQueueDAO.save(tempFollowQueue);	
	}
	
    public void remove(FollowQueue followQueue) throws Exception {	
		followQueueDAO.delete(followQueue.getId());	
	}
	
    public FollowQueue modify(FollowQueue followQueue) throws Exception {	
		FollowQueue tempFollowQueue = followQueueDAO.get(followQueue.getId());
		
		if(followQueue.getName()!=null){
			tempFollowQueue.setName(followQueue.getName());
		}
		if(followQueue.getMasterType()!=null){
			tempFollowQueue.setMasterType(followQueue.getMasterType());
		}
		if(followQueue.getMasterName()!=null){
			tempFollowQueue.setMasterName(followQueue.getMasterName());
		}
		if(followQueue.getMasterId()!=null){
			tempFollowQueue.setMasterId(followQueue.getMasterId());
		}
		if(followQueue.getIntroduction()!=null){
			tempFollowQueue.setIntroduction(followQueue.getIntroduction());
		}
		if(followQueue.getNote()!=null){
			tempFollowQueue.setNote(followQueue.getNote());
		}
		if(followQueue.getStatus()!=null){
			tempFollowQueue.setStatus(followQueue.getStatus());
		}
		if(followQueue.getTargerNumber()!=null){
			tempFollowQueue.setTargerNumber(followQueue.getTargerNumber());
		}
		if(followQueue.getUsedNumber()!=null){
			tempFollowQueue.setUsedNumber(followQueue.getUsedNumber());
		}
		if(followQueue.getCreateTime()!=null){
			tempFollowQueue.setCreateTime(followQueue.getCreateTime());
		}
		followQueueDAO.update(tempFollowQueue);	
		return tempFollowQueue;	
	}
	
    public FollowQueue read(FollowQueue followQueue) throws Exception {	
		return followQueueDAO.get(followQueue.getId());	
	}	
	
    public List<FollowQueue> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followQueueDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followQueueDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowQueue> followQueues = followQueueDAO.list(dc, page, rows);
		for(FollowQueue followQueue:followQueues){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followQueue.getId());
			obj.put("text",followQueue.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowQueue followQueue) throws Exception {
    	if(followQueue.getStatus()==null){
    		return false;
    	}
		FollowQueue tempFollowQueue = followQueueDAO.get(followQueue.getId());
		if(tempFollowQueue!=null){
			tempFollowQueue.setStatus(followQueue.getStatus());
			followQueueDAO.update(tempFollowQueue);
			return true;
		}else{
			return false;
		}
	}
	
}