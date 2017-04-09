package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecord;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeRecordService;
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
 * @name:会员随访记录控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class BabyFollowSchemeRecordAction extends BBcareControl<BabyFollowSchemeRecord> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IBabyFollowSchemeRecordService babyFollowSchemeRecordService;
	
    @RequestMapping("/private/babyFollowSchemeRecord/add")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeRecord> add(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();
		String id = babyFollowSchemeRecordService.add(babyFollowSchemeRecord);	
		babyFollowSchemeRecord.setId(id);
		result.setSuccess(true);
		result.setData(babyFollowSchemeRecord);
		return result;
	}	
	
	@RequestMapping("/private/babyFollowSchemeRecord/remove")	
	@ResponseBody
	public JsonResult<BabyFollowSchemeRecord> remove(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {	
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();
		babyFollowSchemeRecordService.remove(babyFollowSchemeRecord);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeRecord/modify")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecord> modify(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();
		BabyFollowSchemeRecord data = babyFollowSchemeRecordService.modify(babyFollowSchemeRecord);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeRecord/read")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeRecord> read(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();	
		BabyFollowSchemeRecord data = followQueueService.read(babyFollowSchemeRecord);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeRecord/list")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecord> list(BabyFollowSchemeRecord babyFollowSchemeRecord ,int page,int rows) throws Exception {	
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeRecord.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowSchemeRecord.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeRecord.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeRecord.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeRecord.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getDoctorFollowSchemeRecordId()!=null){
			dc.add(Restrictions.like("doctorFollowSchemeRecordId",babyFollowSchemeRecord.getDoctorFollowSchemeRecordId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getCompleteTime()!=null){
			dc.add(Restrictions.eq("completeTime",babyFollowSchemeRecord.getCompleteTime()));
		}
		if(babyFollowSchemeRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeRecord.getCreateTime()));
		}
		if(babyFollowSchemeRecord.getBabyFollowScheme()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",babyFollowSchemeRecord.getBabyFollowScheme()));
		}
		
		Long size = babyFollowSchemeRecordService.getSize(dc);
		List<BabyFollowSchemeRecord> list = babyFollowSchemeRecordService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/babyFollowSchemeRecord/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(BabyFollowSchemeRecord babyFollowSchemeRecord ,int page,int rows) throws Exception {
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeRecord.class);
		if(babyFollowSchemeRecord.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeRecord.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeRecord.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeRecord.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getDoctorFollowSchemeRecordId()!=null){
			dc.add(Restrictions.like("doctorFollowSchemeRecordId",babyFollowSchemeRecord.getDoctorFollowSchemeRecordId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecord.getCompleteTime()!=null){
			dc.add(Restrictions.eq("completeTime",babyFollowSchemeRecord.getCompleteTime()));
		}
		if(babyFollowSchemeRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeRecord.getCreateTime()));
		}
		if(babyFollowSchemeRecord.getBabyFollowScheme()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&babyFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",babyFollowSchemeRecord.getBabyFollowScheme()));
		}
		Long size = babyFollowSchemeRecordService.getSize(dc);
		List<Map<String, String>> list = babyFollowSchemeRecordService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeRecord/review")	
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecord> review(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception {
		JsonResult<BabyFollowSchemeRecord> result = new JsonResult<BabyFollowSchemeRecord>();
		Boolean success = babyFollowSchemeRecordService.review(babyFollowSchemeRecord);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}