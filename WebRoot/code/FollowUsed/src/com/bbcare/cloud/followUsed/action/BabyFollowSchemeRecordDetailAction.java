package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecordDetail;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeRecordDetailService;
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
public class BabyFollowSchemeRecordDetailAction extends BBcareControl<BabyFollowSchemeRecordDetail> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IBabyFollowSchemeRecordDetailService babyFollowSchemeRecordDetailService;
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/add")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeRecordDetail> add(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();
		String id = babyFollowSchemeRecordDetailService.add(babyFollowSchemeRecordDetail);	
		babyFollowSchemeRecordDetail.setId(id);
		result.setSuccess(true);
		result.setData(babyFollowSchemeRecordDetail);
		return result;
	}	
	
	@RequestMapping("/private/babyFollowSchemeRecordDetail/remove")	
	@ResponseBody
	public JsonResult<BabyFollowSchemeRecordDetail> remove(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {	
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();
		babyFollowSchemeRecordDetailService.remove(babyFollowSchemeRecordDetail);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/modify")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecordDetail> modify(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();
		BabyFollowSchemeRecordDetail data = babyFollowSchemeRecordDetailService.modify(babyFollowSchemeRecordDetail);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/read")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeRecordDetail> read(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();	
		BabyFollowSchemeRecordDetail data = followQueueService.read(babyFollowSchemeRecordDetail);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/list")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecordDetail> list(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail ,int page,int rows) throws Exception {	
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeRecordDetail.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowSchemeRecordDetail.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeRecordDetail.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",babyFollowSchemeRecordDetail.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeRecordDetail.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getAnswer()!=null){
			dc.add(Restrictions.like("answer",babyFollowSchemeRecordDetail.getAnswer(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeRecordDetail.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",babyFollowSchemeRecordDetail.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeRecordDetail.getCreateTime()));
		}
		if(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowSchemeRecord",babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()));
		}
		
		Long size = babyFollowSchemeRecordDetailService.getSize(dc);
		List<BabyFollowSchemeRecordDetail> list = babyFollowSchemeRecordDetailService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail ,int page,int rows) throws Exception {
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeRecordDetail.class);
		if(babyFollowSchemeRecordDetail.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeRecordDetail.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getQuestionId()!=null){
			dc.add(Restrictions.like("questionId",babyFollowSchemeRecordDetail.getQuestionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeRecordDetail.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getAnswer()!=null){
			dc.add(Restrictions.like("answer",babyFollowSchemeRecordDetail.getAnswer(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeRecordDetail.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",babyFollowSchemeRecordDetail.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeRecordDetail.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeRecordDetail.getCreateTime()));
		}
		if(babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId()!=null&&babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowSchemeRecord",babyFollowSchemeRecordDetail.getBabyFollowSchemeRecord()));
		}
		Long size = babyFollowSchemeRecordDetailService.getSize(dc);
		List<Map<String, String>> list = babyFollowSchemeRecordDetailService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeRecordDetail/review")	
    @ResponseBody	
	public JsonResult<BabyFollowSchemeRecordDetail> review(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception {
		JsonResult<BabyFollowSchemeRecordDetail> result = new JsonResult<BabyFollowSchemeRecordDetail>();
		Boolean success = babyFollowSchemeRecordDetailService.review(babyFollowSchemeRecordDetail);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}