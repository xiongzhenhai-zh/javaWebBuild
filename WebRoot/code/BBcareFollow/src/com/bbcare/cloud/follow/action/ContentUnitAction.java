package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.ContentUnit;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IContentUnitService;
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
 * @name:内容单位控制层实现
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
public class ContentUnitAction extends MyActionSupport implements ModelDriven<ContentUnit> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ContentUnit contentUnit;	
	
	@Autowired	
	private IContentUnitService contentUnitService;
	
    @Action("/private/contentUnit/add")	
	public String add() throws Exception {
		String id = contentUnitService.add(contentUnit);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/contentUnit/remove")	
	public String remove() throws Exception {	
		contentUnitService.remove(contentUnit);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/contentUnit/modify")	
	public String modify() throws Exception {
		ContentUnit data = contentUnitService.modify(contentUnit);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/contentUnit/read")	
	public String read() throws Exception {	
		ContentUnit data = contentUnitService.read(contentUnit);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/contentUnit/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentUnit.class);
		dc.addOrder(Order.desc("id"));
		if(contentUnit.getName()!=null){
			dc.add(Restrictions.like("name",contentUnit.getName(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getSymbol()!=null){
			dc.add(Restrictions.like("symbol",contentUnit.getSymbol(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getNote()!=null){
			dc.add(Restrictions.like("note",contentUnit.getNote(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getType()!=null){
			dc.add(Restrictions.like("type",contentUnit.getType(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentUnit.getWriterId(),MatchMode.ANYWHERE));
		}
		
		Long size = contentUnitService.getSize(dc);
		List<ContentUnit> list = contentUnitService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/contentUnit/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ContentUnit.class);
		if(contentUnit.getName()!=null){
			dc.add(Restrictions.like("name",contentUnit.getName(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getSymbol()!=null){
			dc.add(Restrictions.like("symbol",contentUnit.getSymbol(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getNote()!=null){
			dc.add(Restrictions.like("note",contentUnit.getNote(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getType()!=null){
			dc.add(Restrictions.like("type",contentUnit.getType(),MatchMode.ANYWHERE));
		}
		if(contentUnit.getWriterId()!=null){
			dc.add(Restrictions.like("writerId",contentUnit.getWriterId(),MatchMode.ANYWHERE));
		}
		
		list = contentUnitService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public ContentUnit getModel() {
		if(contentUnit==null){
			contentUnit = new ContentUnit();
		}
		return contentUnit;
	}
}