package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.ExecutiveTemplate;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IExecutiveTemplateService;
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
 * @name:执行模版控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followTemplate,data.followTemplate,rows.*.triggers,data.triggers"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followTemplate,data.followTemplate,rows.*.triggers,data.triggers"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followTemplate,data.followTemplate,rows.*.triggers,data.triggers"})	
})
public class ExecutiveTemplateAction extends MyActionSupport implements ModelDriven<ExecutiveTemplate> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ExecutiveTemplate executiveTemplate;	
	
	@Autowired	
	private IExecutiveTemplateService executiveTemplateService;
	
    @Action("/private/executiveTemplate/add")	
	public String add() throws Exception {
		String id = executiveTemplateService.add(executiveTemplate);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/executiveTemplate/remove")	
	public String remove() throws Exception {	
		executiveTemplateService.remove(executiveTemplate);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/executiveTemplate/modify")	
	public String modify() throws Exception {
		ExecutiveTemplate data = executiveTemplateService.modify(executiveTemplate);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/executiveTemplate/read")	
	public String read() throws Exception {	
		ExecutiveTemplate data = executiveTemplateService.read(executiveTemplate);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/executiveTemplate/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ExecutiveTemplate.class);
		dc.addOrder(Order.desc("id"));
		if(executiveTemplate.getStartTime()!=null){
			dc.add(Restrictions.eq("startTime",executiveTemplate.getStartTime()));
		}
		if(executiveTemplate.getTimeOut()!=null){
			dc.add(Restrictions.eq("timeOut",executiveTemplate.getTimeOut()));
		}
		if(executiveTemplate.getType()!=null){
			dc.add(Restrictions.eq("type",executiveTemplate.getType()));
		}
		if(executiveTemplate.getFollowTemplate()!=null&&executiveTemplate.getFollowTemplate().getId()!=null&&executiveTemplate.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",executiveTemplate.getFollowTemplate()));
		}
		
		Long size = executiveTemplateService.getSize(dc);
		List<ExecutiveTemplate> list = executiveTemplateService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/executiveTemplate/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ExecutiveTemplate.class);
		if(executiveTemplate.getStartTime()!=null){
			dc.add(Restrictions.eq("startTime",executiveTemplate.getStartTime()));
		}
		if(executiveTemplate.getTimeOut()!=null){
			dc.add(Restrictions.eq("timeOut",executiveTemplate.getTimeOut()));
		}
		if(executiveTemplate.getType()!=null){
			dc.add(Restrictions.eq("type",executiveTemplate.getType()));
		}
		if(executiveTemplate.getFollowTemplate()!=null&&executiveTemplate.getFollowTemplate().getId()!=null&&executiveTemplate.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",executiveTemplate.getFollowTemplate()));
		}
		
		list = executiveTemplateService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public ExecutiveTemplate getModel() {
		if(executiveTemplate==null){
			executiveTemplate = new ExecutiveTemplate();
		}
		return executiveTemplate;
	}
}