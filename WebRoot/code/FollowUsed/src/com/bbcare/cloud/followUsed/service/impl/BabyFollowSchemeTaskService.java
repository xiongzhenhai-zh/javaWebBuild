package com.bbcare.cloud.followUsed.service.impl;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeTask;
import com.bbcare.cloud.followUsed.dao.IBabyFollowSchemeTaskDAO;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeTaskService;
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
 * @name:宝宝随访任务	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Service
public class BabyFollowSchemeTaskService implements IBabyFollowSchemeTaskService {
	
	@Autowired
	private IBabyFollowSchemeTaskDAO babyFollowSchemeTaskDAO;	
	
	@Autowired
	private IBabyFollowSchemeDAO babyFollowSchemeDAO;
	
    public String add(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
    	BabyFollowSchemeTask tempBabyFollowSchemeTask = new BabyFollowSchemeTask();
		tempBabyFollowSchemeTask.setStatus(babyFollowSchemeTask.getStatus());
		tempBabyFollowSchemeTask.setName(babyFollowSchemeTask.getName());
		tempBabyFollowSchemeTask.setExecuteStartTime(babyFollowSchemeTask.getExecuteStartTime());
		tempBabyFollowSchemeTask.setExecuteEndTime(babyFollowSchemeTask.getExecuteEndTime());
		tempBabyFollowSchemeTask.setSendSms(babyFollowSchemeTask.getSendSms());
		tempBabyFollowSchemeTask.setSendMsg(babyFollowSchemeTask.getSendMsg());
		tempBabyFollowSchemeTask.setSort(babyFollowSchemeTask.getSort());
		tempBabyFollowSchemeTask.setExecutePhase(babyFollowSchemeTask.getExecutePhase());
		tempBabyFollowSchemeTask.setExecuteType(babyFollowSchemeTask.getExecuteType());
		tempBabyFollowSchemeTask.setFirstRecord(babyFollowSchemeTask.getFirstRecord());
		tempBabyFollowSchemeTask.setTotal(babyFollowSchemeTask.getTotal());
		tempBabyFollowSchemeTask.setCreateTime(babyFollowSchemeTask.getCreateTime());
		if(babyFollowSchemeTask.getBabyFollowScheme()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(babyFollowSchemeTask.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempBabyFollowSchemeTask.setBabyFollowScheme(babyFollowSchemeTemp);
				tempBabyFollowSchemeTask.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		return babyFollowSchemeTaskDAO.save(tempBabyFollowSchemeTask);	
	}
	
    public void remove(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {	
		babyFollowSchemeTaskDAO.delete(babyFollowSchemeTask.getId());	
	}
	
    public BabyFollowSchemeTask modify(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {	
		BabyFollowSchemeTask tempBabyFollowSchemeTask = babyFollowSchemeTaskDAO.get(babyFollowSchemeTask.getId());
		
		if(babyFollowSchemeTask.getStatus()!=null){
			tempBabyFollowSchemeTask.setStatus(babyFollowSchemeTask.getStatus());
		}
		if(babyFollowSchemeTask.getName()!=null){
			tempBabyFollowSchemeTask.setName(babyFollowSchemeTask.getName());
		}
		if(babyFollowSchemeTask.getExecuteStartTime()!=null){
			tempBabyFollowSchemeTask.setExecuteStartTime(babyFollowSchemeTask.getExecuteStartTime());
		}
		if(babyFollowSchemeTask.getExecuteEndTime()!=null){
			tempBabyFollowSchemeTask.setExecuteEndTime(babyFollowSchemeTask.getExecuteEndTime());
		}
		if(babyFollowSchemeTask.getSendSms()!=null){
			tempBabyFollowSchemeTask.setSendSms(babyFollowSchemeTask.getSendSms());
		}
		if(babyFollowSchemeTask.getSendMsg()!=null){
			tempBabyFollowSchemeTask.setSendMsg(babyFollowSchemeTask.getSendMsg());
		}
		if(babyFollowSchemeTask.getSort()!=null){
			tempBabyFollowSchemeTask.setSort(babyFollowSchemeTask.getSort());
		}
		if(babyFollowSchemeTask.getExecutePhase()!=null){
			tempBabyFollowSchemeTask.setExecutePhase(babyFollowSchemeTask.getExecutePhase());
		}
		if(babyFollowSchemeTask.getExecuteType()!=null){
			tempBabyFollowSchemeTask.setExecuteType(babyFollowSchemeTask.getExecuteType());
		}
		if(babyFollowSchemeTask.getFirstRecord()!=null){
			tempBabyFollowSchemeTask.setFirstRecord(babyFollowSchemeTask.getFirstRecord());
		}
		if(babyFollowSchemeTask.getTotal()!=null){
			tempBabyFollowSchemeTask.setTotal(babyFollowSchemeTask.getTotal());
		}
		if(babyFollowSchemeTask.getCreateTime()!=null){
			tempBabyFollowSchemeTask.setCreateTime(babyFollowSchemeTask.getCreateTime());
		}
		if(babyFollowSchemeTask.getBabyFollowScheme()!=null&& babyFollowSchemeTask.getBabyFollowScheme().getId()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId().trim().length()>0){
			BabyFollowScheme babyFollowSchemeTemp = babyFollowSchemeDAO.get(babyFollowSchemeTask.getBabyFollowScheme().getId());
			if(babyFollowSchemeTemp!=null){
				tempBabyFollowSchemeTask.setBabyFollowScheme(babyFollowSchemeTemp);
				tempBabyFollowSchemeTask.setBabyFollowSchemeName(babyFollowSchemeTemp.getName());
			}
		}
		babyFollowSchemeTaskDAO.update(tempBabyFollowSchemeTask);	
		return tempBabyFollowSchemeTask;	
	}
	
    public BabyFollowSchemeTask read(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {	
		return babyFollowSchemeTaskDAO.get(babyFollowSchemeTask.getId());	
	}	
	
    public List<BabyFollowSchemeTask> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowSchemeTaskDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowSchemeTaskDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowSchemeTask> babyFollowSchemeTasks = babyFollowSchemeTaskDAO.list(dc, page, rows);
		for(BabyFollowSchemeTask babyFollowSchemeTask:babyFollowSchemeTasks){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowSchemeTask.getId());
			obj.put("text",babyFollowSchemeTask.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
    	if(babyFollowSchemeTask.getStatus()==null){
    		return false;
    	}
		BabyFollowSchemeTask tempBabyFollowSchemeTask = babyFollowSchemeTaskDAO.get(babyFollowSchemeTask.getId());
		if(tempBabyFollowSchemeTask!=null){
			tempBabyFollowSchemeTask.setStatus(babyFollowSchemeTask.getStatus());
			babyFollowSchemeTaskDAO.update(tempBabyFollowSchemeTask);
			return true;
		}else{
			return false;
		}
	}
	
}