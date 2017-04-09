package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowTask;
import com.bbcare.cloud.follow.dao.IFollowTaskDAO;
import com.bbcare.cloud.follow.service.IFollowTaskService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowPlan;
import com.bbcare.cloud.follow.dao.IFollowPlanDAO;
import com.bbcare.cloud.follow.entry.FollowTaskType;
import com.bbcare.cloud.follow.dao.IFollowTaskTypeDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访任务	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowTaskService implements IFollowTaskService {
	
	@Autowired
	private IFollowTaskDAO followTaskDAO;	
	
	@Autowired
	private IFollowPlanDAO followPlanDAO;
	
	@Autowired
	private IFollowTaskTypeDAO followTaskTypeDAO;
	
    public String add(FollowTask followTask) throws Exception {
    	FollowTask tempFollowTask = new FollowTask();
		tempFollowTask.setTaskTime(followTask.getTaskTime());
		tempFollowTask.setStatus(followTask.getStatus());
		tempFollowTask.setModelId(followTask.getModelId());
		if(followTask.getFollowPlan()!=null&&followTask.getFollowPlan().getId()!=null&&followTask.getFollowPlan().getId().trim().length()>0){
			FollowPlan followPlanTemp = followPlanDAO.get(followTask.getFollowPlan().getId());
			if(followPlanTemp!=null){
				tempFollowTask.setFollowPlan(followPlanTemp);
				tempFollowTask.setFollowPlanName(followPlanTemp.getId());
			}
		}
		if(followTask.getFollowTaskType()!=null&&followTask.getFollowTaskType().getId()!=null&&followTask.getFollowTaskType().getId().trim().length()>0){
			FollowTaskType followTaskTypeTemp = followTaskTypeDAO.get(followTask.getFollowTaskType().getId());
			if(followTaskTypeTemp!=null){
				tempFollowTask.setFollowTaskType(followTaskTypeTemp);
				tempFollowTask.setFollowTaskTypeName(followTaskTypeTemp.getName());
			}
		}
		return followTaskDAO.save(tempFollowTask);	
	}
	
    public void remove(FollowTask followTask) throws Exception {	
		followTaskDAO.delete(followTask.getId());	
	}
	
    public FollowTask modify(FollowTask followTask) throws Exception {	
		FollowTask tempFollowTask = followTaskDAO.get(followTask.getId());
		
		if(followTask.getTaskTime()!=null){
			tempFollowTask.setTaskTime(followTask.getTaskTime());
		}
		if(followTask.getStatus()!=null){
			tempFollowTask.setStatus(followTask.getStatus());
		}
		if(followTask.getModelId()!=null){
			tempFollowTask.setModelId(followTask.getModelId());
		}
		if(followTask.getFollowPlan()!=null&& followTask.getFollowPlan().getId()!=null&&followTask.getFollowPlan().getId().trim().length()>0){
			FollowPlan followPlanTemp = followPlanDAO.get(followTask.getFollowPlan().getId());
			if(followPlanTemp!=null){
				tempFollowTask.setFollowPlan(followPlanTemp);
				tempFollowTask.setFollowPlanName(followPlanTemp.getId());
			}
		}
		if(followTask.getFollowTaskType()!=null&& followTask.getFollowTaskType().getId()!=null&&followTask.getFollowTaskType().getId().trim().length()>0){
			FollowTaskType followTaskTypeTemp = followTaskTypeDAO.get(followTask.getFollowTaskType().getId());
			if(followTaskTypeTemp!=null){
				tempFollowTask.setFollowTaskType(followTaskTypeTemp);
				tempFollowTask.setFollowTaskTypeName(followTaskTypeTemp.getName());
			}
		}
		followTaskDAO.update(tempFollowTask);	
		return tempFollowTask;	
	}
	
    public FollowTask read(FollowTask followTask) throws Exception {	
		return followTaskDAO.get(followTask.getId());	
	}	
	
    public List<FollowTask> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followTaskDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followTaskDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowTask> followTasks = followTaskDAO.list(dc, page, rows);
		for(FollowTask followTask:followTasks){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followTask.getId());
			obj.put("text",followTask.getId());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(FollowTask followTask) throws Exception {
    	if(followTask.getStatus()==null){
    		return false;
    	}
		FollowTask tempFollowTask = followTaskDAO.get(followTask.getId());
		if(tempFollowTask!=null){
			tempFollowTask.setStatus(followTask.getStatus());
			followTaskDAO.update(tempFollowTask);
			return true;
		}else{
			return false;
		}
	}
	
}