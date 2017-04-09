package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowTemplate;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowTemplateService;
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
 * @name:随访模版控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.executiveTemplates,data.executiveTemplates,rows.*.followContents,data.followContents,rows.*.followModel,data.followModel,rows.*.ContentClasss,data.ContentClasss"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.executiveTemplates,data.executiveTemplates,rows.*.followContents,data.followContents,rows.*.followModel,data.followModel,rows.*.ContentClasss,data.ContentClasss"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.followModel,data.followModel"})	
})
public class FollowTemplateAction extends MyActionSupport implements ModelDriven<FollowTemplate> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowTemplate followTemplate;	
	
	@Autowired	
	private IFollowTemplateService followTemplateService;
	
    @Action("/private/followTemplate/add")	
	public String add() throws Exception {
		String id = followTemplateService.add(followTemplate);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followTemplate/remove")	
	public String remove() throws Exception {	
		followTemplateService.remove(followTemplate);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followTemplate/modify")	
	public String modify() throws Exception {
		FollowTemplate data = followTemplateService.modify(followTemplate);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followTemplate/read")	
	public String read() throws Exception {	
		FollowTemplate data = followTemplateService.read(followTemplate);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followTemplate/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTemplate.class);
		dc.addOrder(Order.desc("id"));
		if(followTemplate.getName()!=null){
			dc.add(Restrictions.like("name",followTemplate.getName(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getType()!=null){
			dc.add(Restrictions.like("type",followTemplate.getType(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getUsedType()!=null){
			dc.add(Restrictions.like("usedType",followTemplate.getUsedType(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getUsedLevel()!=null){
			dc.add(Restrictions.like("usedLevel",followTemplate.getUsedLevel(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getSort()!=null){
			dc.add(Restrictions.eq("sort",followTemplate.getSort()));
		}
		if(followTemplate.getFollowModel()!=null&&followTemplate.getFollowModel().getId()!=null&&followTemplate.getFollowModel().getId().trim().length()>0){
			dc.add(Restrictions.eq("followModel",followTemplate.getFollowModel()));
		}
		
		Long size = followTemplateService.getSize(dc);
		List<FollowTemplate> list = followTemplateService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followTemplate/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowTemplate.class);
		if(followTemplate.getName()!=null){
			dc.add(Restrictions.like("name",followTemplate.getName(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getType()!=null){
			dc.add(Restrictions.like("type",followTemplate.getType(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getUsedType()!=null){
			dc.add(Restrictions.like("usedType",followTemplate.getUsedType(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getUsedLevel()!=null){
			dc.add(Restrictions.like("usedLevel",followTemplate.getUsedLevel(),MatchMode.ANYWHERE));
		}
		if(followTemplate.getSort()!=null){
			dc.add(Restrictions.eq("sort",followTemplate.getSort()));
		}
		if(followTemplate.getFollowModel()!=null&&followTemplate.getFollowModel().getId()!=null&&followTemplate.getFollowModel().getId().trim().length()>0){
			dc.add(Restrictions.eq("followModel",followTemplate.getFollowModel()));
		}
		
		list = followTemplateService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public FollowTemplate getModel() {
		if(followTemplate==null){
			followTemplate = new FollowTemplate();
		}
		return followTemplate;
	}
}