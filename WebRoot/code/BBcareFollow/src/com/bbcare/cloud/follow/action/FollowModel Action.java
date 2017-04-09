package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowModel ;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowModel Service;
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
 * @name:随访模型控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followPlans,data.followPlans,rows.*.followTemplates,data.followTemplates,rows.*.modelClass,data.modelClass"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followPlans,data.followPlans,rows.*.followTemplates,data.followTemplates,rows.*.modelClass,data.modelClass"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.modelClass,data.modelClass"})	
})
public class FollowModel Action extends MyActionSupport implements ModelDriven<FollowModel > {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowModel  followModel ;	
	
	@Autowired	
	private IFollowModel Service followModel Service;
	
    @Action("/private/followModel /add")	
	public String add() throws Exception {
		String id = followModel Service.add(followModel );	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followModel /remove")	
	public String remove() throws Exception {	
		followModel Service.remove(followModel );	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followModel /modify")	
	public String modify() throws Exception {
		FollowModel  data = followModel Service.modify(followModel );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followModel /read")	
	public String read() throws Exception {	
		FollowModel  data = followModel Service.read(followModel );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followModel /list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowModel .class);
		dc.addOrder(Order.desc("id"));
		if(followModel .getName()!=null){
			dc.add(Restrictions.like("name",followModel .getName(),MatchMode.ANYWHERE));
		}
		if(followModel .getDoctorId()!=null){
			dc.add(Restrictions.like("doctorId",followModel .getDoctorId(),MatchMode.ANYWHERE));
		}
		if(followModel .getStatus()!=null){
			dc.add(Restrictions.eq("status",followModel .getStatus()));
		}
		if(followModel .getIntroduction()!=null){
			dc.add(Restrictions.like("introduction",followModel .getIntroduction(),MatchMode.ANYWHERE));
		}
		if(followModel .getTarger()!=null){
			dc.add(Restrictions.like("targer",followModel .getTarger(),MatchMode.ANYWHERE));
		}
		if(followModel .getNote()!=null){
			dc.add(Restrictions.like("note",followModel .getNote(),MatchMode.ANYWHERE));
		}
		if(followModel .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followModel .getCreateTime()));
		}
		if(followModel .getModelClass()!=null&&followModel .getModelClass().getId()!=null&&followModel .getModelClass().getId().trim().length()>0){
			dc.add(Restrictions.eq("modelClass",followModel .getModelClass()));
		}
		
		Long size = followModel Service.getSize(dc);
		List<FollowModel > list = followModel Service.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followModel /combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowModel .class);
		if(followModel .getName()!=null){
			dc.add(Restrictions.like("name",followModel .getName(),MatchMode.ANYWHERE));
		}
		if(followModel .getDoctorId()!=null){
			dc.add(Restrictions.like("doctorId",followModel .getDoctorId(),MatchMode.ANYWHERE));
		}
		if(followModel .getStatus()!=null){
			dc.add(Restrictions.eq("status",followModel .getStatus()));
		}
		if(followModel .getIntroduction()!=null){
			dc.add(Restrictions.like("introduction",followModel .getIntroduction(),MatchMode.ANYWHERE));
		}
		if(followModel .getTarger()!=null){
			dc.add(Restrictions.like("targer",followModel .getTarger(),MatchMode.ANYWHERE));
		}
		if(followModel .getNote()!=null){
			dc.add(Restrictions.like("note",followModel .getNote(),MatchMode.ANYWHERE));
		}
		if(followModel .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followModel .getCreateTime()));
		}
		if(followModel .getModelClass()!=null&&followModel .getModelClass().getId()!=null&&followModel .getModelClass().getId().trim().length()>0){
			dc.add(Restrictions.eq("modelClass",followModel .getModelClass()));
		}
		
		list = followModel Service.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/followModel /review")	
	public String review() throws Exception {
		Boolean success = followModel Service.review(followModel );	
		result.put("success", success);	
		return "json";	
	}
	
	
	@Override
	public FollowModel  getModel() {
		if(followModel ==null){
			followModel  = new FollowModel ();
		}
		return followModel ;
	}
}