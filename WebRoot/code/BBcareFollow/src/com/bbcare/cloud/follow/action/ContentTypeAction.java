package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.ContentType;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IContentTypeService;
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
 * @name:内容类型控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followContents,data.followContents"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followContents,data.followContents"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class ContentTypeAction extends MyActionSupport implements ModelDriven<ContentType> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ContentType contentType;	
	
	@Autowired	
	private IContentTypeService contentTypeService;
	
    @Action("/private/contentType/add")	
	public String add() throws Exception {
		String id = contentTypeService.add(contentType);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/contentType/remove")	
	public String remove() throws Exception {	
		contentTypeService.remove(contentType);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/contentType/modify")	
	public String modify() throws Exception {
		ContentType data = contentTypeService.modify(contentType);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/contentType/read")	
	public String read() throws Exception {	
		ContentType data = contentTypeService.read(contentType);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/contentType/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentType.class);
		dc.addOrder(Order.desc("id"));
		if(contentType.getName()!=null){
			dc.add(Restrictions.like("name",contentType.getName(),MatchMode.ANYWHERE));
		}
		if(contentType.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentType.getWriterId(),MatchMode.ANYWHERE));
		}
		
		Long size = contentTypeService.getSize(dc);
		List<ContentType> list = contentTypeService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/contentType/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentType.class);
		if(contentType.getName()!=null){
			dc.add(Restrictions.like("name",contentType.getName(),MatchMode.ANYWHERE));
		}
		if(contentType.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentType.getWriterId(),MatchMode.ANYWHERE));
		}
		
		list = contentTypeService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public ContentType getModel() {
		if(contentType==null){
			contentType = new ContentType();
		}
		return contentType;
	}
}