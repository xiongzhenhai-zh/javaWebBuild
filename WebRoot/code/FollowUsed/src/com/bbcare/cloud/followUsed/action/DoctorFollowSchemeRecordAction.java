package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecord;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IDoctorFollowSchemeRecordService;
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
public class DoctorFollowSchemeRecordAction extends BBcareControl<DoctorFollowSchemeRecord> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IDoctorFollowSchemeRecordService doctorFollowSchemeRecordService;
	
    @RequestMapping("/private/doctorFollowSchemeRecord/add")	
    @ResponseBody
	public JsonResult<DoctorFollowSchemeRecord> add(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();
		String id = doctorFollowSchemeRecordService.add(doctorFollowSchemeRecord);	
		doctorFollowSchemeRecord.setId(id);
		result.setSuccess(true);
		result.setData(doctorFollowSchemeRecord);
		return result;
	}	
	
	@RequestMapping("/private/doctorFollowSchemeRecord/remove")	
	@ResponseBody
	public JsonResult<DoctorFollowSchemeRecord> remove(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {	
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();
		doctorFollowSchemeRecordService.remove(doctorFollowSchemeRecord);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/doctorFollowSchemeRecord/modify")
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecord> modify(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();
		DoctorFollowSchemeRecord data = doctorFollowSchemeRecordService.modify(doctorFollowSchemeRecord);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecord/read")	
    @ResponseBody
	public JsonResult<DoctorFollowSchemeRecord> read(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();	
		DoctorFollowSchemeRecord data = followQueueService.read(doctorFollowSchemeRecord);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/doctorFollowSchemeRecord/list")
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecord> list(DoctorFollowSchemeRecord doctorFollowSchemeRecord ,int page,int rows) throws Exception {	
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowSchemeRecord.class);
		dc.addOrder(Order.desc("id"));
		if(doctorFollowSchemeRecord.getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowSchemeRecord.getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getType()!=null){
			dc.add(Restrictions.like("type",doctorFollowSchemeRecord.getType(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getStatus()!=null){
			dc.add(Restrictions.like("status",doctorFollowSchemeRecord.getStatus(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getBabyFollowSchemeRecordId()!=null){
			dc.add(Restrictions.like("babyFollowSchemeRecordId",doctorFollowSchemeRecord.getBabyFollowSchemeRecordId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getCompleteTime()!=null){
			dc.add(Restrictions.eq("completeTime",doctorFollowSchemeRecord.getCompleteTime()));
		}
		if(doctorFollowSchemeRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowSchemeRecord.getCreateTime()));
		}
		if(doctorFollowSchemeRecord.getBabyFollowScheme()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",doctorFollowSchemeRecord.getBabyFollowScheme()));
		}
		
		Long size = doctorFollowSchemeRecordService.getSize(dc);
		List<DoctorFollowSchemeRecord> list = doctorFollowSchemeRecordService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecord/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(DoctorFollowSchemeRecord doctorFollowSchemeRecord ,int page,int rows) throws Exception {
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowSchemeRecord.class);
		if(doctorFollowSchemeRecord.getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowSchemeRecord.getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getType()!=null){
			dc.add(Restrictions.like("type",doctorFollowSchemeRecord.getType(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getStatus()!=null){
			dc.add(Restrictions.like("status",doctorFollowSchemeRecord.getStatus(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getBabyFollowSchemeRecordId()!=null){
			dc.add(Restrictions.like("babyFollowSchemeRecordId",doctorFollowSchemeRecord.getBabyFollowSchemeRecordId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecord.getCompleteTime()!=null){
			dc.add(Restrictions.eq("completeTime",doctorFollowSchemeRecord.getCompleteTime()));
		}
		if(doctorFollowSchemeRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowSchemeRecord.getCreateTime()));
		}
		if(doctorFollowSchemeRecord.getBabyFollowScheme()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId()!=null&&doctorFollowSchemeRecord.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",doctorFollowSchemeRecord.getBabyFollowScheme()));
		}
		Long size = doctorFollowSchemeRecordService.getSize(dc);
		List<Map<String, String>> list = doctorFollowSchemeRecordService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecord/review")	
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecord> review(DoctorFollowSchemeRecord doctorFollowSchemeRecord) throws Exception {
		JsonResult<DoctorFollowSchemeRecord> result = new JsonResult<DoctorFollowSchemeRecord>();
		Boolean success = doctorFollowSchemeRecordService.review(doctorFollowSchemeRecord);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}