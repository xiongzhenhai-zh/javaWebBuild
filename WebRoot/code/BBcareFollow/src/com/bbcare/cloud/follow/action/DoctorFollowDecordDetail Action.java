package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.DoctorFollowDecordDetail ;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IDoctorFollowDecordDetail Service;
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
 * @name:医生归档详情控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.doctorFollowDecord,data.doctorFollowDecord"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.doctorFollowDecord,data.doctorFollowDecord"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.doctorFollowDecord,data.doctorFollowDecord"})	
})
public class DoctorFollowDecordDetail Action extends MyActionSupport implements ModelDriven<DoctorFollowDecordDetail > {	
	
	private static final long serialVersionUID = 1L;	
	
	private DoctorFollowDecordDetail  doctorFollowDecordDetail ;	
	
	@Autowired	
	private IDoctorFollowDecordDetail Service doctorFollowDecordDetail Service;
	
    @Action("/private/doctorFollowDecordDetail /add")	
	public String add() throws Exception {
		String id = doctorFollowDecordDetail Service.add(doctorFollowDecordDetail );	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/doctorFollowDecordDetail /remove")	
	public String remove() throws Exception {	
		doctorFollowDecordDetail Service.remove(doctorFollowDecordDetail );	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/doctorFollowDecordDetail /modify")	
	public String modify() throws Exception {
		DoctorFollowDecordDetail  data = doctorFollowDecordDetail Service.modify(doctorFollowDecordDetail );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/doctorFollowDecordDetail /read")	
	public String read() throws Exception {	
		DoctorFollowDecordDetail  data = doctorFollowDecordDetail Service.read(doctorFollowDecordDetail );	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/doctorFollowDecordDetail /list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowDecordDetail .class);
		dc.addOrder(Order.desc("id"));
		if(doctorFollowDecordDetail .getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowDecordDetail .getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecordDetail .getQuestion()!=null){
			dc.add(Restrictions.like("question",doctorFollowDecordDetail .getQuestion(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecordDetail .getAnswer()!=null){
			dc.add(Restrictions.eq("answer",doctorFollowDecordDetail .getAnswer()));
		}
		if(doctorFollowDecordDetail .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowDecordDetail .getCreateTime()));
		}
		if(doctorFollowDecordDetail .getDoctorFollowDecord()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("doctorFollowDecord",doctorFollowDecordDetail .getDoctorFollowDecord()));
		}
		
		Long size = doctorFollowDecordDetail Service.getSize(dc);
		List<DoctorFollowDecordDetail > list = doctorFollowDecordDetail Service.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/doctorFollowDecordDetail /combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowDecordDetail .class);
		if(doctorFollowDecordDetail .getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowDecordDetail .getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecordDetail .getQuestion()!=null){
			dc.add(Restrictions.like("question",doctorFollowDecordDetail .getQuestion(),MatchMode.ANYWHERE));
		}
		if(doctorFollowDecordDetail .getAnswer()!=null){
			dc.add(Restrictions.eq("answer",doctorFollowDecordDetail .getAnswer()));
		}
		if(doctorFollowDecordDetail .getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowDecordDetail .getCreateTime()));
		}
		if(doctorFollowDecordDetail .getDoctorFollowDecord()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId()!=null&&doctorFollowDecordDetail .getDoctorFollowDecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("doctorFollowDecord",doctorFollowDecordDetail .getDoctorFollowDecord()));
		}
		
		list = doctorFollowDecordDetail Service.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public DoctorFollowDecordDetail  getModel() {
		if(doctorFollowDecordDetail ==null){
			doctorFollowDecordDetail  = new DoctorFollowDecordDetail ();
		}
		return doctorFollowDecordDetail ;
	}
}