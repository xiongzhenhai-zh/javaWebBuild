package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowPlan;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowPlanService;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访计划控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowRecords,data.babyFollowRecords,rows.*.followModel,data.followModel,rows.*.followTasks,data.followTasks"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowRecords,data.babyFollowRecords,rows.*.followModel,data.followModel,rows.*.followTasks,data.followTasks"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.followModel,data.followModel"})	
})
public class FollowPlanAction extends MyActionSupport implements ModelDriven<FollowPlan> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowPlan followPlan;	
	
	@Autowired	
	private IFollowPlanService followPlanService;
	
    @Action("/private/followPlan/add")	
	public String add() throws Exception {
		String id = followPlanService.add(followPlan);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followPlan/remove")	
	public String remove() throws Exception {	
		followPlanService.remove(followPlan);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followPlan/modify")	
	public String modify() throws Exception {
		FollowPlan data = followPlanService.modify(followPlan);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followPlan/read")	
	public String read() throws Exception {	
		FollowPlan data = followPlanService.read(followPlan);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followPlan/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowPlan.class);
		dc.addOrder(Order.desc("id"));
		if(followPlan.getBabyId()!=null){
			dc.add(Restrictions.eq("babyId",followPlan.getBabyId()));
		}
		if(followPlan.getStartTime()!=null){
			dc.add(Restrictions.eq("startTime",followPlan.getStartTime()));
		}
		if(followPlan.getCreateDoctorId()!=null){
			dc.add(Restrictions.like("createDoctorId",followPlan.getCreateDoctorId(),MatchMode.ANYWHERE));
		}
		if(followPlan.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followPlan.getCreateTime()));
		}
		if(followPlan.getFollowModel()!=null&&followPlan.getFollowModel().getId()!=null&&followPlan.getFollowModel().getId().trim().length()>0){
			dc.add(Restrictions.eq("followModel",followPlan.getFollowModel()));
		}
		
		Long size = followPlanService.getSize(dc);
		List<FollowPlan> list = followPlanService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followPlan/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowPlan.class);
		if(followPlan.getBabyId()!=null){
			dc.add(Restrictions.eq("babyId",followPlan.getBabyId()));
		}
		if(followPlan.getStartTime()!=null){
			dc.add(Restrictions.eq("startTime",followPlan.getStartTime()));
		}
		if(followPlan.getCreateDoctorId()!=null){
			dc.add(Restrictions.like("createDoctorId",followPlan.getCreateDoctorId(),MatchMode.ANYWHERE));
		}
		if(followPlan.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followPlan.getCreateTime()));
		}
		if(followPlan.getFollowModel()!=null&&followPlan.getFollowModel().getId()!=null&&followPlan.getFollowModel().getId().trim().length()>0){
			dc.add(Restrictions.eq("followModel",followPlan.getFollowModel()));
		}
		
		list = followPlanService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public FollowPlan getModel() {
		if(followPlan==null){
			followPlan = new FollowPlan();
		}
		return followPlan;
	}
}