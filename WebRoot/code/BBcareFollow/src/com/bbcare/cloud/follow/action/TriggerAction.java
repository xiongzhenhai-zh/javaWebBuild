package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.Trigger;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.ITriggerService;
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
 * @name:触发器控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.executiveTemplate,data.executiveTemplate"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.executiveTemplate,data.executiveTemplate"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.executiveTemplate,data.executiveTemplate"})	
})
public class TriggerAction extends MyActionSupport implements ModelDriven<Trigger> {	
	
	private static final long serialVersionUID = 1L;	
	
	private Trigger trigger;	
	
	@Autowired	
	private ITriggerService triggerService;
	
    @Action("/private/trigger/add")	
	public String add() throws Exception {
		String id = triggerService.add(trigger);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/trigger/remove")	
	public String remove() throws Exception {	
		triggerService.remove(trigger);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/trigger/modify")	
	public String modify() throws Exception {
		Trigger data = triggerService.modify(trigger);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/trigger/read")	
	public String read() throws Exception {	
		Trigger data = triggerService.read(trigger);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/trigger/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(Trigger.class);
		dc.addOrder(Order.desc("id"));
		if(trigger.getName()!=null){
			dc.add(Restrictions.like("name",trigger.getName(),MatchMode.ANYWHERE));
		}
		if(trigger.getStatus()!=null){
			dc.add(Restrictions.eq("status",trigger.getStatus()));
		}
		if(trigger.getEvent()!=null){
			dc.add(Restrictions.like("event",trigger.getEvent(),MatchMode.ANYWHERE));
		}
		if(trigger.getType()!=null){
			dc.add(Restrictions.eq("type",trigger.getType()));
		}
		if(trigger.getCondition()!=null){
			dc.add(Restrictions.like("condition",trigger.getCondition(),MatchMode.ANYWHERE));
		}
		if(trigger.getExecutiveTemplate()!=null&&trigger.getExecutiveTemplate().getId()!=null&&trigger.getExecutiveTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("executiveTemplate",trigger.getExecutiveTemplate()));
		}
		
		Long size = triggerService.getSize(dc);
		List<Trigger> list = triggerService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/trigger/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(Trigger.class);
		if(trigger.getName()!=null){
			dc.add(Restrictions.like("name",trigger.getName(),MatchMode.ANYWHERE));
		}
		if(trigger.getStatus()!=null){
			dc.add(Restrictions.eq("status",trigger.getStatus()));
		}
		if(trigger.getEvent()!=null){
			dc.add(Restrictions.like("event",trigger.getEvent(),MatchMode.ANYWHERE));
		}
		if(trigger.getType()!=null){
			dc.add(Restrictions.eq("type",trigger.getType()));
		}
		if(trigger.getCondition()!=null){
			dc.add(Restrictions.like("condition",trigger.getCondition(),MatchMode.ANYWHERE));
		}
		if(trigger.getExecutiveTemplate()!=null&&trigger.getExecutiveTemplate().getId()!=null&&trigger.getExecutiveTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("executiveTemplate",trigger.getExecutiveTemplate()));
		}
		
		list = triggerService.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/trigger/review")	
	public String review() throws Exception {
		Boolean success = triggerService.review(trigger);	
		result.put("success", success);	
		return "json";	
	}
	
	
	@Override
	public Trigger getModel() {
		if(trigger==null){
			trigger = new Trigger();
		}
		return trigger;
	}
}