package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.ModelClass;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IModelClassService;
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
 * @name:模型分类控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.children,data.children,rows.*.followModels,data.followModels,rows.*.parent,data.parent"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.children,data.children,rows.*.followModels,data.followModels,rows.*.parent,data.parent"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.parent,data.parent"})	
})
public class ModelClassAction extends MyActionSupport implements ModelDriven<ModelClass> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ModelClass modelClass;	
	
	@Autowired	
	private IModelClassService modelClassService;
	
	private List<ModelClass> tree;
	
    @Action("/private/modelClass/add")	
	public String add() throws Exception {
		String id = modelClassService.add(modelClass);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/modelClass/remove")	
	public String remove() throws Exception {	
		modelClassService.remove(modelClass);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/modelClass/modify")	
	public String modify() throws Exception {
		ModelClass data = modelClassService.modify(modelClass);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/modelClass/read")	
	public String read() throws Exception {	
		ModelClass data = modelClassService.read(modelClass);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/modelClass/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ModelClass.class);
		dc.addOrder(Order.desc("id"));
		if(modelClass.getName()!=null){
			dc.add(Restrictions.like("name",modelClass.getName(),MatchMode.ANYWHERE));
		}
		if(modelClass.getSort()!=null){
			dc.add(Restrictions.eq("sort",modelClass.getSort()));
		}
		if(modelClass.getParent()!=null&&modelClass.getParent().getId()!=null&&modelClass.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",modelClass.getParent()));
		}
		
		Long size = modelClassService.getSize(dc);
		List<ModelClass> list = modelClassService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/modelClass/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ModelClass.class);
		if(modelClass.getName()!=null){
			dc.add(Restrictions.like("name",modelClass.getName(),MatchMode.ANYWHERE));
		}
		if(modelClass.getSort()!=null){
			dc.add(Restrictions.eq("sort",modelClass.getSort()));
		}
		if(modelClass.getParent()!=null&&modelClass.getParent().getId()!=null&&modelClass.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",modelClass.getParent()));
		}
		
		list = modelClassService.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/modelClass/tree")	
	public String tree() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ModelClass.class);
		dc.addOrder(Order.desc("id"));
		if(modelClass.getName()!=null){
			dc.add(Restrictions.like("name",modelClass.getName(),MatchMode.ANYWHERE));
		}
		if(modelClass.getSort()!=null){
			dc.add(Restrictions.eq("sort",modelClass.getSort()));
		}
		if(modelClass.getParent()!=null){
			dc.add(Restrictions.eq("parent",modelClass.getParent()));
		}else{
			dc.add(Restrictions.isNull("parent"));
		}
		
		List<ModelClass> list = modelClassService.list(dc, page, rows);
		result.put("success", true);
		result.put("rows", list);
		return "tree";	
	}
	
    public List<ModelClass> getTree() {
		return tree;
	}
	
	
	@Override
	public ModelClass getModel() {
		if(modelClass==null){
			modelClass = new ModelClass();
		}
		return modelClass;
	}
}