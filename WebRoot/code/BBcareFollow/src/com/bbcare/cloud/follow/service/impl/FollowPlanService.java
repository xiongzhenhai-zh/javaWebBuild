package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowPlan;
import com.bbcare.cloud.follow.dao.IFollowPlanDAO;
import com.bbcare.cloud.follow.service.IFollowPlanService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowModel ;
import com.bbcare.cloud.follow.dao.IFollowModel DAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访计划	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowPlanService implements IFollowPlanService {
	
	@Autowired
	private IFollowPlanDAO followPlanDAO;	
	
	@Autowired
	private IFollowModel DAO followModel DAO;
	
    public String add(FollowPlan followPlan) throws Exception {
    	FollowPlan tempFollowPlan = new FollowPlan();
		tempFollowPlan.setBabyId(followPlan.getBabyId());
		tempFollowPlan.setStartTime(followPlan.getStartTime());
		tempFollowPlan.setCreateDoctorId(followPlan.getCreateDoctorId());
		tempFollowPlan.setCreateTime(followPlan.getCreateTime());
		if(followPlan.getFollowModel()!=null&&followPlan.getFollowModel().getId()!=null&&followPlan.getFollowModel().getId().trim().length()>0){
			FollowModel  followModel Temp = followModel DAO.get(followPlan.getFollowModel().getId());
			if(followModel Temp!=null){
				tempFollowPlan.setFollowModel(followModel Temp);
				tempFollowPlan.setFollowModelName(followModel Temp.getName());
			}
		}
		return followPlanDAO.save(tempFollowPlan);	
	}
	
    public void remove(FollowPlan followPlan) throws Exception {	
		followPlanDAO.delete(followPlan.getId());	
	}
	
    public FollowPlan modify(FollowPlan followPlan) throws Exception {	
		FollowPlan tempFollowPlan = followPlanDAO.get(followPlan.getId());
		
		if(followPlan.getBabyId()!=null){
			tempFollowPlan.setBabyId(followPlan.getBabyId());
		}
		if(followPlan.getStartTime()!=null){
			tempFollowPlan.setStartTime(followPlan.getStartTime());
		}
		if(followPlan.getCreateDoctorId()!=null){
			tempFollowPlan.setCreateDoctorId(followPlan.getCreateDoctorId());
		}
		if(followPlan.getCreateTime()!=null){
			tempFollowPlan.setCreateTime(followPlan.getCreateTime());
		}
		if(followPlan.getFollowModel()!=null&& followPlan.getFollowModel().getId()!=null&&followPlan.getFollowModel().getId().trim().length()>0){
			FollowModel  followModel Temp = followModel DAO.get(followPlan.getFollowModel().getId());
			if(followModel Temp!=null){
				tempFollowPlan.setFollowModel(followModel Temp);
				tempFollowPlan.setFollowModelName(followModel Temp.getName());
			}
		}
		followPlanDAO.update(tempFollowPlan);	
		return tempFollowPlan;	
	}
	
    public FollowPlan read(FollowPlan followPlan) throws Exception {	
		return followPlanDAO.get(followPlan.getId());	
	}	
	
    public List<FollowPlan> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followPlanDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followPlanDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowPlan> followPlans = followPlanDAO.list(dc, page, rows);
		for(FollowPlan followPlan:followPlans){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followPlan.getId());
			obj.put("text",followPlan.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}