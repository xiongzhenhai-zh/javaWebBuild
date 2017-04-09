package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowTaskType;
import com.bbcare.cloud.follow.dao.IFollowTaskTypeDAO;
import com.bbcare.cloud.follow.service.IFollowTaskTypeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访任务类型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowTaskTypeService implements IFollowTaskTypeService {
	
	@Autowired
	private IFollowTaskTypeDAO followTaskTypeDAO;	
	
    public String add(FollowTaskType followTaskType) throws Exception {
    	FollowTaskType tempFollowTaskType = new FollowTaskType();
		tempFollowTaskType.setName(followTaskType.getName());
		tempFollowTaskType.setContent(followTaskType.getContent());
		return followTaskTypeDAO.save(tempFollowTaskType);	
	}
	
    public void remove(FollowTaskType followTaskType) throws Exception {	
		followTaskTypeDAO.delete(followTaskType.getId());	
	}
	
    public FollowTaskType modify(FollowTaskType followTaskType) throws Exception {	
		FollowTaskType tempFollowTaskType = followTaskTypeDAO.get(followTaskType.getId());
		
		if(followTaskType.getName()!=null){
			tempFollowTaskType.setName(followTaskType.getName());
		}
		if(followTaskType.getContent()!=null){
			tempFollowTaskType.setContent(followTaskType.getContent());
		}
		followTaskTypeDAO.update(tempFollowTaskType);	
		return tempFollowTaskType;	
	}
	
    public FollowTaskType read(FollowTaskType followTaskType) throws Exception {	
		return followTaskTypeDAO.get(followTaskType.getId());	
	}	
	
    public List<FollowTaskType> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followTaskTypeDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followTaskTypeDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowTaskType> followTaskTypes = followTaskTypeDAO.list(dc, page, rows);
		for(FollowTaskType followTaskType:followTaskTypes){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followTaskType.getId());
			obj.put("text",followTaskType.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}