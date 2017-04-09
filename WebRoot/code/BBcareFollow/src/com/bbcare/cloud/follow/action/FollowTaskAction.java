package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowTask;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowTaskService;
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
 * @name:随访任务控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followPlan,data.followPlan,rows.*.followTaskType,data.followTaskType"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followPlan,data.followPlan,rows.*.followTaskType,data.followTaskType"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followPlan,data.followPlan,rows.*.followTaskType,data.followTaskType"})	
})
public class FollowTaskAction extends MyActionSupport implements ModelDriven<FollowTask> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowTask followTask;	
	
	@Autowired	
	private IFollowTaskService followTaskService;
	
    @Action("/private/followTask/add")	
	public String add() throws Exception {
		String id = followTaskService.add(followTask);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followTask/remove")	
	public String remove() throws Exception {	
		followTaskService.remove(followTask);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followTask/modify")	
	public String modify() throws Exception {
		FollowTask data = followTaskService.modify(followTask);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followTask/read")	
	public String read() throws Exception {	
		FollowTask data = followTaskService.read(followTask);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followTask/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTask.class);
		dc.addOrder(Order.desc("id"));
		if(followTask.getTaskTime()!=null){
			dc.add(Restrictions.eq("taskTime",followTask.getTaskTime()));
		}
		if(followTask.getStatus()!=null){
			dc.add(Restrictions.like("status",followTask.getStatus(),MatchMode.ANYWHERE));
		}
		if(followTask.getModelId()!=null){
			dc.add(Restrictions.like("modelId",followTask.getModelId(),MatchMode.ANYWHERE));
		}
		if(followTask.getFollowPlan()!=null&&followTask.getFollowPlan().getId()!=null&&followTask.getFollowPlan().getId().trim().length()>0){
			dc.add(Restrictions.eq("followPlan",followTask.getFollowPlan()));
		}
		if(followTask.getFollowTaskType()!=null&&followTask.getFollowTaskType().getId()!=null&&followTask.getFollowTaskType().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTaskType",followTask.getFollowTaskType()));
		}
		
		Long size = followTaskService.getSize(dc);
		List<FollowTask> list = followTaskService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followTask/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTask.class);
		if(followTask.getTaskTime()!=null){
			dc.add(Restrictions.eq("taskTime",followTask.getTaskTime()));
		}
		if(followTask.getStatus()!=null){
			dc.add(Restrictions.like("status",followTask.getStatus(),MatchMode.ANYWHERE));
		}
		if(followTask.getModelId()!=null){
			dc.add(Restrictions.like("modelId",followTask.getModelId(),MatchMode.ANYWHERE));
		}
		if(followTask.getFollowPlan()!=null&&followTask.getFollowPlan().getId()!=null&&followTask.getFollowPlan().getId().trim().length()>0){
			dc.add(Restrictions.eq("followPlan",followTask.getFollowPlan()));
		}
		if(followTask.getFollowTaskType()!=null&&followTask.getFollowTaskType().getId()!=null&&followTask.getFollowTaskType().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTaskType",followTask.getFollowTaskType()));
		}
		
		list = followTaskService.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/followTask/review")	
	public String review() throws Exception {
		Boolean success = followTaskService.review(followTask);	
		result.put("success", success);	
		return "json";	
	}
	
	
	@Override
	public FollowTask getModel() {
		if(followTask==null){
			followTask = new FollowTask();
		}
		return followTask;
	}
}