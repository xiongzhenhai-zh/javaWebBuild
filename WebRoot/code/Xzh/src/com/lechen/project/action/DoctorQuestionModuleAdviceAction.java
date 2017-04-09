package com.lechen.project.action;

import java.util.Map;
import com.lechen.project.entry.DoctorQuestionModuleAdvice;
import com.lechen.project.util.MyActionSupport;
import com.lechen.project.service.IDoctorQuestionModuleAdviceService;
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
 * @name:医生模块建议控制层实现
 * @author:	
 * @createTime: 2016-01-20 13:13:59
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class DoctorQuestionModuleAdviceAction extends MyActionSupport implements ModelDriven<DoctorQuestionModuleAdvice> {	
	
	private static final long serialVersionUID = 1L;	
	
	private DoctorQuestionModuleAdvice doctorQuestionModuleAdvice;	
	
	@Autowired	
	private IDoctorQuestionModuleAdviceService doctorQuestionModuleAdviceService;
	
    @Action("/private/doctorQuestionModuleAdvice/add")	
	public String add() throws Exception {
		String id = doctorQuestionModuleAdviceService.add(doctorQuestionModuleAdvice);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/doctorQuestionModuleAdvice/remove")	
	public String remove() throws Exception {	
		doctorQuestionModuleAdviceService.remove(doctorQuestionModuleAdvice);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/doctorQuestionModuleAdvice/modify")	
	public String modify() throws Exception {
		DoctorQuestionModuleAdvice data = doctorQuestionModuleAdviceService.modify(doctorQuestionModuleAdvice);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/doctorQuestionModuleAdvice/read")	
	public String read() throws Exception {	
		DoctorQuestionModuleAdvice data = doctorQuestionModuleAdviceService.read(doctorQuestionModuleAdvice);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/doctorQuestionModuleAdvice/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorQuestionModuleAdvice.class);
		dc.addOrder(Order.desc("id"));
		if(doctorQuestionModuleAdvice.getCordon()!=null){
			dc.add(Restrictions.eq("cordon",doctorQuestionModuleAdvice.getCordon()));
		}
		if(doctorQuestionModuleAdvice.getAverage()!=null){
			dc.add(Restrictions.eq("average",doctorQuestionModuleAdvice.getAverage()));
		}
		if(doctorQuestionModuleAdvice.getScore()!=null){
			dc.add(Restrictions.eq("score",doctorQuestionModuleAdvice.getScore()));
		}
		if(doctorQuestionModuleAdvice.getQoctorQuestionRecordId()!=null){
			dc.add(Restrictions.like("qoctorQuestionRecordId",doctorQuestionModuleAdvice.getQoctorQuestionRecordId(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			dc.add(Restrictions.like("title",doctorQuestionModuleAdvice.getTitle(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			dc.add(Restrictions.like("title",doctorQuestionModuleAdvice.getTitle(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getNote()!=null){
			dc.add(Restrictions.like("note",doctorQuestionModuleAdvice.getNote(),MatchMode.ANYWHERE));
		}
		
		Long size = doctorQuestionModuleAdviceService.getSize(dc);
		List<DoctorQuestionModuleAdvice> list = doctorQuestionModuleAdviceService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/doctorQuestionModuleAdvice/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorQuestionModuleAdvice.class);
		if(doctorQuestionModuleAdvice.getCordon()!=null){
			dc.add(Restrictions.eq("cordon",doctorQuestionModuleAdvice.getCordon()));
		}
		if(doctorQuestionModuleAdvice.getAverage()!=null){
			dc.add(Restrictions.eq("average",doctorQuestionModuleAdvice.getAverage()));
		}
		if(doctorQuestionModuleAdvice.getScore()!=null){
			dc.add(Restrictions.eq("score",doctorQuestionModuleAdvice.getScore()));
		}
		if(doctorQuestionModuleAdvice.getQoctorQuestionRecordId()!=null){
			dc.add(Restrictions.like("qoctorQuestionRecordId",doctorQuestionModuleAdvice.getQoctorQuestionRecordId(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			dc.add(Restrictions.like("title",doctorQuestionModuleAdvice.getTitle(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getTitle()!=null){
			dc.add(Restrictions.like("title",doctorQuestionModuleAdvice.getTitle(),MatchMode.ANYWHERE));
		}
		if(doctorQuestionModuleAdvice.getNote()!=null){
			dc.add(Restrictions.like("note",doctorQuestionModuleAdvice.getNote(),MatchMode.ANYWHERE));
		}
		
		list = doctorQuestionModuleAdviceService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public DoctorQuestionModuleAdvice getModel() {
		if(doctorQuestionModuleAdvice==null){
			doctorQuestionModuleAdvice = new DoctorQuestionModuleAdvice();
		}
		return doctorQuestionModuleAdvice;
	}
}