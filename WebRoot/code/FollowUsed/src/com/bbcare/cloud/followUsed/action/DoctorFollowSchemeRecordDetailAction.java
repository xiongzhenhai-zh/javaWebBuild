package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.DoctorFollowSchemeRecordDetail;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IDoctorFollowSchemeRecordDetailService;
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
 * @name:会员随访记录内容控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class DoctorFollowSchemeRecordDetailAction extends BBcareControl<DoctorFollowSchemeRecordDetail> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IDoctorFollowSchemeRecordDetailService doctorFollowSchemeRecordDetailService;
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/add")	
    @ResponseBody
	public JsonResult<DoctorFollowSchemeRecordDetail> add(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();
		String id = doctorFollowSchemeRecordDetailService.add(doctorFollowSchemeRecordDetail);	
		doctorFollowSchemeRecordDetail.setId(id);
		result.setSuccess(true);
		result.setData(doctorFollowSchemeRecordDetail);
		return result;
	}	
	
	@RequestMapping("/private/doctorFollowSchemeRecordDetail/remove")	
	@ResponseBody
	public JsonResult<DoctorFollowSchemeRecordDetail> remove(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {	
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();
		doctorFollowSchemeRecordDetailService.remove(doctorFollowSchemeRecordDetail);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/modify")
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecordDetail> modify(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();
		DoctorFollowSchemeRecordDetail data = doctorFollowSchemeRecordDetailService.modify(doctorFollowSchemeRecordDetail);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/read")	
    @ResponseBody
	public JsonResult<DoctorFollowSchemeRecordDetail> read(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();	
		DoctorFollowSchemeRecordDetail data = followQueueService.read(doctorFollowSchemeRecordDetail);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/list")
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecordDetail> list(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail ,int page,int rows) throws Exception {	
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowSchemeRecordDetail.class);
		dc.addOrder(Order.desc("id"));
		if(doctorFollowSchemeRecordDetail.getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowSchemeRecordDetail.getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId()!=null){
			dc.add(Restrictions.like("babyFollowSchemeRecordDetailId",doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",doctorFollowSchemeRecordDetail.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getType()!=null){
			dc.add(Restrictions.like("type",doctorFollowSchemeRecordDetail.getType(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getAnswer()!=null){
			dc.add(Restrictions.like("answer",doctorFollowSchemeRecordDetail.getAnswer(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getStatus()!=null){
			dc.add(Restrictions.like("status",doctorFollowSchemeRecordDetail.getStatus(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",doctorFollowSchemeRecordDetail.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowSchemeRecordDetail.getCreateTime()));
		}
		if(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("doctorFollowSchemeRecord",doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()));
		}
		
		Long size = doctorFollowSchemeRecordDetailService.getSize(dc);
		List<DoctorFollowSchemeRecordDetail> list = doctorFollowSchemeRecordDetailService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail ,int page,int rows) throws Exception {
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();	
		DetachedCriteria dc = DetachedCriteria.forClass(DoctorFollowSchemeRecordDetail.class);
		if(doctorFollowSchemeRecordDetail.getName()!=null){
			dc.add(Restrictions.like("name",doctorFollowSchemeRecordDetail.getName(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId()!=null){
			dc.add(Restrictions.like("babyFollowSchemeRecordDetailId",doctorFollowSchemeRecordDetail.getBabyFollowSchemeRecordDetailId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",doctorFollowSchemeRecordDetail.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getType()!=null){
			dc.add(Restrictions.like("type",doctorFollowSchemeRecordDetail.getType(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getAnswer()!=null){
			dc.add(Restrictions.like("answer",doctorFollowSchemeRecordDetail.getAnswer(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getStatus()!=null){
			dc.add(Restrictions.like("status",doctorFollowSchemeRecordDetail.getStatus(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",doctorFollowSchemeRecordDetail.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(doctorFollowSchemeRecordDetail.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",doctorFollowSchemeRecordDetail.getCreateTime()));
		}
		if(doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId()!=null&&doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("doctorFollowSchemeRecord",doctorFollowSchemeRecordDetail.getDoctorFollowSchemeRecord()));
		}
		Long size = doctorFollowSchemeRecordDetailService.getSize(dc);
		List<Map<String, String>> list = doctorFollowSchemeRecordDetailService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/doctorFollowSchemeRecordDetail/review")	
    @ResponseBody	
	public JsonResult<DoctorFollowSchemeRecordDetail> review(DoctorFollowSchemeRecordDetail doctorFollowSchemeRecordDetail) throws Exception {
		JsonResult<DoctorFollowSchemeRecordDetail> result = new JsonResult<DoctorFollowSchemeRecordDetail>();
		Boolean success = doctorFollowSchemeRecordDetailService.review(doctorFollowSchemeRecordDetail);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}