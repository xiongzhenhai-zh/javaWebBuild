package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowContent;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowContentService;
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
 * @name:随访内容控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.contentClass,data.contentClass,rows.*.contentType,data.contentType,rows.*.contentUnit,data.contentUnit,rows.*.followTemplate,data.followTemplate,rows.*.followOptions,data.followOptions"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.contentClass,data.contentClass,rows.*.contentType,data.contentType,rows.*.contentUnit,data.contentUnit,rows.*.followTemplate,data.followTemplate,rows.*.followOptions,data.followOptions"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.contentClass,data.contentClass,rows.*.contentType,data.contentType,rows.*.contentUnit,data.contentUnit,rows.*.followTemplate,data.followTemplate"})	
})
public class FollowContentAction extends MyActionSupport implements ModelDriven<FollowContent> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowContent followContent;	
	
	@Autowired	
	private IFollowContentService followContentService;
	
    @Action("/private/followContent/add")	
	public String add() throws Exception {
		String id = followContentService.add(followContent);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followContent/remove")	
	public String remove() throws Exception {	
		followContentService.remove(followContent);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followContent/modify")	
	public String modify() throws Exception {
		FollowContent data = followContentService.modify(followContent);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followContent/read")	
	public String read() throws Exception {	
		FollowContent data = followContentService.read(followContent);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followContent/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowContent.class);
		dc.addOrder(Order.desc("id"));
		if(followContent.getName()!=null){
			dc.add(Restrictions.like("name",followContent.getName(),MatchMode.ANYWHERE));
		}
		if(followContent.getIsNull()!=null){
			dc.add(Restrictions.eq("isNull",followContent.getIsNull()));
		}
		if(followContent.getConfig()!=null){
			dc.add(Restrictions.like("config",followContent.getConfig(),MatchMode.ANYWHERE));
		}
		if(followContent.getSort()!=null){
			dc.add(Restrictions.eq("sort",followContent.getSort()));
		}
		if(followContent.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",followContent.getWriterId(),MatchMode.ANYWHERE));
		}
		if(followContent.getContentClass()!=null&&followContent.getContentClass().getId()!=null&&followContent.getContentClass().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentClass",followContent.getContentClass()));
		}
		if(followContent.getContentType()!=null&&followContent.getContentType().getId()!=null&&followContent.getContentType().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentType",followContent.getContentType()));
		}
		if(followContent.getContentUnit()!=null&&followContent.getContentUnit().getId()!=null&&followContent.getContentUnit().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentUnit",followContent.getContentUnit()));
		}
		if(followContent.getFollowTemplate()!=null&&followContent.getFollowTemplate().getId()!=null&&followContent.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",followContent.getFollowTemplate()));
		}
		
		Long size = followContentService.getSize(dc);
		List<FollowContent> list = followContentService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followContent/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowContent.class);
		if(followContent.getName()!=null){
			dc.add(Restrictions.like("name",followContent.getName(),MatchMode.ANYWHERE));
		}
		if(followContent.getIsNull()!=null){
			dc.add(Restrictions.eq("isNull",followContent.getIsNull()));
		}
		if(followContent.getConfig()!=null){
			dc.add(Restrictions.like("config",followContent.getConfig(),MatchMode.ANYWHERE));
		}
		if(followContent.getSort()!=null){
			dc.add(Restrictions.eq("sort",followContent.getSort()));
		}
		if(followContent.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",followContent.getWriterId(),MatchMode.ANYWHERE));
		}
		if(followContent.getContentClass()!=null&&followContent.getContentClass().getId()!=null&&followContent.getContentClass().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentClass",followContent.getContentClass()));
		}
		if(followContent.getContentType()!=null&&followContent.getContentType().getId()!=null&&followContent.getContentType().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentType",followContent.getContentType()));
		}
		if(followContent.getContentUnit()!=null&&followContent.getContentUnit().getId()!=null&&followContent.getContentUnit().getId().trim().length()>0){
			dc.add(Restrictions.eq("contentUnit",followContent.getContentUnit()));
		}
		if(followContent.getFollowTemplate()!=null&&followContent.getFollowTemplate().getId()!=null&&followContent.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",followContent.getFollowTemplate()));
		}
		
		list = followContentService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public FollowContent getModel() {
		if(followContent==null){
			followContent = new FollowContent();
		}
		return followContent;
	}
}