package com.bbcare.cloud.follow.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.follow.entry.BabyFollowRecord;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IBabyFollowRecordService;
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
 * @name:随访记录控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowDetails,data.babyFollowDetails,rows.*.followPlan,data.followPlan"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowDetails,data.babyFollowDetails,rows.*.followPlan,data.followPlan"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",",rows.*.followPlan,data.followPlan"})	
})
public class BabyFollowRecordAction extends MyActionSupport implements ModelDriven<BabyFollowRecord> {	
	
	private static final long serialVersionUID = 1L;	
	
	private BabyFollowRecord babyFollowRecord;	
	
	@Autowired	
	private IBabyFollowRecordService babyFollowRecordService;
	
    @Action("/private/babyFollowRecord/add")	
	public String add() throws Exception {
		String id = babyFollowRecordService.add(babyFollowRecord);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/babyFollowRecord/remove")	
	public String remove() throws Exception {	
		babyFollowRecordService.remove(babyFollowRecord);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/babyFollowRecord/modify")	
	public String modify() throws Exception {
		BabyFollowRecord data = babyFollowRecordService.modify(babyFollowRecord);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/babyFollowRecord/read")	
	public String read() throws Exception {	
		BabyFollowRecord data = babyFollowRecordService.read(babyFollowRecord);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/babyFollowRecord/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowRecord.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowRecord.getFollowTemplateId()!=null){
			dc.add(Restrictions.like("followTemplateId",babyFollowRecord.getFollowTemplateId(),MatchMode.ANYWHERE));
		}
		if(babyFollowRecord.getFollowTime()!=null){
			dc.add(Restrictions.eq("followTime",babyFollowRecord.getFollowTime()));
		}
		if(babyFollowRecord.getBabyId()!=null){
			dc.add(Restrictions.like("babyId",babyFollowRecord.getBabyId(),MatchMode.ANYWHERE));
		}
		if(babyFollowRecord.getFollowPlan()!=null&&babyFollowRecord.getFollowPlan().getId()!=null&&babyFollowRecord.getFollowPlan().getId().trim().length()>0){
			dc.add(Restrictions.eq("followPlan",babyFollowRecord.getFollowPlan()));
		}
		
		Long size = babyFollowRecordService.getSize(dc);
		List<BabyFollowRecord> list = babyFollowRecordService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/babyFollowRecord/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowRecord.class);
		if(babyFollowRecord.getFollowTemplateId()!=null){
			dc.add(Restrictions.like("followTemplateId",babyFollowRecord.getFollowTemplateId(),MatchMode.ANYWHERE));
		}
		if(babyFollowRecord.getFollowTime()!=null){
			dc.add(Restrictions.eq("followTime",babyFollowRecord.getFollowTime()));
		}
		if(babyFollowRecord.getBabyId()!=null){
			dc.add(Restrictions.like("babyId",babyFollowRecord.getBabyId(),MatchMode.ANYWHERE));
		}
		if(babyFollowRecord.getFollowPlan()!=null&&babyFollowRecord.getFollowPlan().getId()!=null&&babyFollowRecord.getFollowPlan().getId().trim().length()>0){
			dc.add(Restrictions.eq("followPlan",babyFollowRecord.getFollowPlan()));
		}
		
		list = babyFollowRecordService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public BabyFollowRecord getModel() {
		if(babyFollowRecord==null){
			babyFollowRecord = new BabyFollowRecord();
		}
		return babyFollowRecord;
	}
}