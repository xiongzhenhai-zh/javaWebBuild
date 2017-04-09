package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowTaskType;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowTaskTypeService;
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
 * @name:随访任务类型控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followTasks,data.followTasks"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followTasks,data.followTasks"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class FollowTaskTypeAction extends MyActionSupport implements ModelDriven<FollowTaskType> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowTaskType followTaskType;	
	
	@Autowired	
	private IFollowTaskTypeService followTaskTypeService;
	
    @Action("/private/followTaskType/add")	
	public String add() throws Exception {
		String id = followTaskTypeService.add(followTaskType);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followTaskType/remove")	
	public String remove() throws Exception {	
		followTaskTypeService.remove(followTaskType);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followTaskType/modify")	
	public String modify() throws Exception {
		FollowTaskType data = followTaskTypeService.modify(followTaskType);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followTaskType/read")	
	public String read() throws Exception {	
		FollowTaskType data = followTaskTypeService.read(followTaskType);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followTaskType/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTaskType.class);
		dc.addOrder(Order.desc("id"));
		if(followTaskType.getName()!=null){
			dc.add(Restrictions.like("name",followTaskType.getName(),MatchMode.ANYWHERE));
		}
		if(followTaskType.getContent()!=null){
			dc.add(Restrictions.like("content",followTaskType.getContent(),MatchMode.ANYWHERE));
		}
		
		Long size = followTaskTypeService.getSize(dc);
		List<FollowTaskType> list = followTaskTypeService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followTaskType/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTaskType.class);
		if(followTaskType.getName()!=null){
			dc.add(Restrictions.like("name",followTaskType.getName(),MatchMode.ANYWHERE));
		}
		if(followTaskType.getContent()!=null){
			dc.add(Restrictions.like("content",followTaskType.getContent(),MatchMode.ANYWHERE));
		}
		
		list = followTaskTypeService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public FollowTaskType getModel() {
		if(followTaskType==null){
			followTaskType = new FollowTaskType();
		}
		return followTaskType;
	}
}