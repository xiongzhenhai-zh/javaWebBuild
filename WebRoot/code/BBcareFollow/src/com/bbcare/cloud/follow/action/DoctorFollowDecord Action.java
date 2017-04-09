package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.DoctorFollowDecord ;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IDoctorFollowDecord Service;
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
 * @name:医生归档档案控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.doctorFollowDecordDetails,data.doctorFollowDecordDetails"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.doctorFollowDecordDetails,data.doctorFollowDecordDetails"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class DoctorFollowDecord Action extends MyActionSupport implements ModelDriven<DoctorFollowDecord > {	
	
	private static final long serialVersionUID = 1L;	
	
	private DoctorFollowDecord  doctorFollowDecord ;	
	
	@Autowired	
	private IDoctorFollowDecord Service doctorFollowDecord Service;
	
    @Action("/private/doctorFollowDecord /add")	
	public String add() throws Exception {
		String id = doctorFollowDecord Service.add(doctorFollowDecord );	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/doctorFollowDecord /remove")	
	public String remove() throws Exception {	
		doctorFollowDecord Service.remove(doctorFollowDecord );	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/doctorFollowDecord /modify")	
	public String modify() throws Exception {
		DoctorFollowDecord  data = doctorFollowDecord Service.modify(doctorFollowDecord );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/doctorFollowDecord /read")	
	public String read() throws Exception {	
		DoctorFollowDecord  data = doctorFollowDecord Service.read(doctorFollowDecord );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/doctorFollowDecord /list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowDecord .class);
		dc.addOrder(Order.desc("id"));
		if(doctorFollowDecord .getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowDecord .getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getDoctorId()!=null){
			dc.add(Restrictions.like("doctorId",doctorFollowDecord .getDoctorId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getStatus()!=null){
			dc.add(Restrictions.eq("status",doctorFollowDecord .getStatus()));
		}
		if(doctorFollowDecord .getBabyId()!=null){
			dc.add(Restrictions.like("babyId",doctorFollowDecord .getBabyId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getBabyAge()!=null){
			dc.add(Restrictions.eq("babyAge",doctorFollowDecord .getBabyAge()));
		}
		if(doctorFollowDecord .getNote()!=null){
			dc.add(Restrictions.like("note",doctorFollowDecord .getNote(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowDecord .getCreateTime()));
		}
		
		Long size = doctorFollowDecord Service.getSize(dc);
		List<DoctorFollowDecord > list = doctorFollowDecord Service.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/doctorFollowDecord /combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowDecord .class);
		if(doctorFollowDecord .getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowDecord .getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getDoctorId()!=null){
			dc.add(Restrictions.like("doctorId",doctorFollowDecord .getDoctorId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getStatus()!=null){
			dc.add(Restrictions.eq("status",doctorFollowDecord .getStatus()));
		}
		if(doctorFollowDecord .getBabyId()!=null){
			dc.add(Restrictions.like("babyId",doctorFollowDecord .getBabyId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getBabyAge()!=null){
			dc.add(Restrictions.eq("babyAge",doctorFollowDecord .getBabyAge()));
		}
		if(doctorFollowDecord .getNote()!=null){
			dc.add(Restrictions.like("note",doctorFollowDecord .getNote(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecord .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowDecord .getCreateTime()));
		}
		
		list = doctorFollowDecord Service.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/doctorFollowDecord /review")	
	public String review() throws Exception {
		Boolean success = doctorFollowDecord Service.review(doctorFollowDecord );	
		result.put("success", success);	
		return "json";	
	}
	
	
	@Override
	public DoctorFollowDecord  getModel() {
		if(doctorFollowDecord ==null){
			doctorFollowDecord  = new DoctorFollowDecord ();
		}
		return doctorFollowDecord ;
	}
}