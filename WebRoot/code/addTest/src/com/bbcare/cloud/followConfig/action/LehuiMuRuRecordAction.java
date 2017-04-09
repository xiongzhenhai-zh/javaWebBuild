package com.bbcare.cloud.followConfig.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followConfig.entry.LehuiMuRuRecord;
import com.bbcare.cloud.followConfig.util.MyActionSupport;
import com.bbcare.cloud.followConfig.service.ILehuiMuRuRecordService;
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
 * @name:乐慧母乳调查临时控制层实现
 * @author:	
 * @createTime: 2016-12-15 18:28:17
 */	

@Controller	
public class LehuiMuRuRecordAction extends BBcareControl<LehuiMuRuRecord> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private ILehuiMuRuRecordService lehuiMuRuRecordService;
	
    @RequestMapping("/private/lehuiMuRuRecord/add")	
    @ResponseBody
	public JsonResult<LehuiMuRuRecord> add(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {
		JsonResult<LehuiMuRuRecord> result = new JsonResult<LehuiMuRuRecord>();
		String id = lehuiMuRuRecordService.add(lehuiMuRuRecord);	
		lehuiMuRuRecord.setId(id);
		result.setSuccess(true);
		result.setData(lehuiMuRuRecord);
		return result;
	}	
	
	@RequestMapping("/private/lehuiMuRuRecord/remove")	
	@ResponseBody
	public JsonResult<LehuiMuRuRecord> remove(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {	
		JsonResult<LehuiMuRuRecord> result = new JsonResult<LehuiMuRuRecord>();
		lehuiMuRuRecordService.remove(lehuiMuRuRecord);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/lehuiMuRuRecord/modify")
    @ResponseBody	
	public JsonResult<LehuiMuRuRecord> modify(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {
		JsonResult<LehuiMuRuRecord> result = new JsonResult<LehuiMuRuRecord>();
		LehuiMuRuRecord data = lehuiMuRuRecordService.modify(lehuiMuRuRecord);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/lehuiMuRuRecord/read")	
    @ResponseBody
	public JsonResult<LehuiMuRuRecord> read(LehuiMuRuRecord lehuiMuRuRecord) throws Exception {
		JsonResult<LehuiMuRuRecord> result = new JsonResult<LehuiMuRuRecord>();	
		LehuiMuRuRecord data = lehuiMuRuRecordService.read(lehuiMuRuRecord);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/lehuiMuRuRecord/list")
    @ResponseBody	
	public JsonResult<LehuiMuRuRecord> list(LehuiMuRuRecord lehuiMuRuRecord ,int page,int rows) throws Exception {	
		JsonResult<LehuiMuRuRecord> result = new JsonResult<LehuiMuRuRecord>();
		DetachedCriteria dc = DetachedCriteria.forClass(LehuiMuRuRecord.class);
		dc.addOrder(Order.desc("id"));
		if(lehuiMuRuRecord.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",lehuiMuRuRecord.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getFollowTemplateId()!=null){
			dc.add(Restrictions.like("followTemplateId",lehuiMuRuRecord.getFollowTemplateId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",lehuiMuRuRecord.getCreateTime()));
		}
		if(lehuiMuRuRecord.getNote()!=null){
			dc.add(Restrictions.like("note",lehuiMuRuRecord.getNote(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getOpenId()!=null){
			dc.add(Restrictions.like("openId",lehuiMuRuRecord.getOpenId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getAnswer()!=null){
			dc.add(Restrictions.like("answer",lehuiMuRuRecord.getAnswer(),MatchMode.ANYWHERE));
		}
		
		Long size = lehuiMuRuRecordService.getSize(dc);
		List<LehuiMuRuRecord> list = lehuiMuRuRecordService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/lehuiMuRuRecord/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(LehuiMuRuRecord lehuiMuRuRecord ,int page,int rows) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(LehuiMuRuRecord.class);
		if(lehuiMuRuRecord.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",lehuiMuRuRecord.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getFollowTemplateId()!=null){
			dc.add(Restrictions.like("followTemplateId",lehuiMuRuRecord.getFollowTemplateId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",lehuiMuRuRecord.getCreateTime()));
		}
		if(lehuiMuRuRecord.getNote()!=null){
			dc.add(Restrictions.like("note",lehuiMuRuRecord.getNote(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getOpenId()!=null){
			dc.add(Restrictions.like("openId",lehuiMuRuRecord.getOpenId(),MatchMode.ANYWHERE));
		}
		if(lehuiMuRuRecord.getAnswer()!=null){
			dc.add(Restrictions.like("answer",lehuiMuRuRecord.getAnswer(),MatchMode.ANYWHERE));
		}
		Long size = lehuiMuRuRecordService.getSize(dc);
		List<Map<String, String>> list = lehuiMuRuRecordService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
	
	
}