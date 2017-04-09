package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.ContentClass;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IContentClassService;
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
 * @name:内容分类控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followContents,data.followContents,rows.*.children,data.children,rows.*.parent,data.parent,rows.*.followTemplate,data.followTemplate"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followContents,data.followContents,rows.*.children,data.children,rows.*.parent,data.parent,rows.*.followTemplate,data.followTemplate"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.parent,data.parent,rows.*.followTemplate,data.followTemplate"})	
})
public class ContentClassAction extends MyActionSupport implements ModelDriven<ContentClass> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ContentClass contentClass;	
	
	@Autowired	
	private IContentClassService contentClassService;
	
	private List<ContentClass> tree;
	
    @Action("/private/contentClass/add")	
	public String add() throws Exception {
		String id = contentClassService.add(contentClass);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/contentClass/remove")	
	public String remove() throws Exception {	
		contentClassService.remove(contentClass);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/contentClass/modify")	
	public String modify() throws Exception {
		ContentClass data = contentClassService.modify(contentClass);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/contentClass/read")	
	public String read() throws Exception {	
		ContentClass data = contentClassService.read(contentClass);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/contentClass/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentClass.class);
		dc.addOrder(Order.desc("id"));
		if(contentClass.getName()!=null){
			dc.add(Restrictions.like("name",contentClass.getName(),MatchMode.ANYWHERE));
		}
		if(contentClass.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentClass.getWriterId(),MatchMode.ANYWHERE));
		}
		if(contentClass.getParent()!=null&&contentClass.getParent().getId()!=null&&contentClass.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",contentClass.getParent()));
		}
		if(contentClass.getFollowTemplate()!=null&&contentClass.getFollowTemplate().getId()!=null&&contentClass.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",contentClass.getFollowTemplate()));
		}
		
		Long size = contentClassService.getSize(dc);
		List<ContentClass> list = contentClassService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/contentClass/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentClass.class);
		if(contentClass.getName()!=null){
			dc.add(Restrictions.like("name",contentClass.getName(),MatchMode.ANYWHERE));
		}
		if(contentClass.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentClass.getWriterId(),MatchMode.ANYWHERE));
		}
		if(contentClass.getParent()!=null&&contentClass.getParent().getId()!=null&&contentClass.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",contentClass.getParent()));
		}
		if(contentClass.getFollowTemplate()!=null&&contentClass.getFollowTemplate().getId()!=null&&contentClass.getFollowTemplate().getId().trim().length()>0){
			dc.add(Restrictions.eq("followTemplate",contentClass.getFollowTemplate()));
		}
		
		list = contentClassService.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/contentClass/tree")	
	public String tree() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentClass.class);
		dc.addOrder(Order.desc("id"));
		if(contentClass.getName()!=null){
			dc.add(Restrictions.like("name",contentClass.getName(),MatchMode.ANYWHERE));
		}
		if(contentClass.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentClass.getWriterId(),MatchMode.ANYWHERE));
		}
		if(contentClass.getParent()!=null){
			dc.add(Restrictions.eq("parent",contentClass.getParent()));
		}else{
			dc.add(Restrictions.isNull("parent"));
		}
		
		List<ContentClass> list = contentClassService.list(dc, page, rows);
		result.put("success", true);
		result.put("rows", list);
		return "tree";	
	}
	
    public List<ContentClass> getTree() {
		return tree;
	}
	
	
	@Override
	public ContentClass getModel() {
		if(contentClass==null){
			contentClass = new ContentClass();
		}
		return contentClass;
	}
}