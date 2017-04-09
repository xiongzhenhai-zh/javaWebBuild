package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeTask;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeTaskService;
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
 * @name:宝宝随访任务控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class BabyFollowSchemeTaskAction extends BBcareControl<BabyFollowSchemeTask> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IBabyFollowSchemeTaskService babyFollowSchemeTaskService;
	
    @RequestMapping("/private/babyFollowSchemeTask/add")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeTask> add(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();
		String id = babyFollowSchemeTaskService.add(babyFollowSchemeTask);	
		babyFollowSchemeTask.setId(id);
		result.setSuccess(true);
		result.setData(babyFollowSchemeTask);
		return result;
	}	
	
	@RequestMapping("/private/babyFollowSchemeTask/remove")	
	@ResponseBody
	public JsonResult<BabyFollowSchemeTask> remove(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {	
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();
		babyFollowSchemeTaskService.remove(babyFollowSchemeTask);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeTask/modify")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeTask> modify(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();
		BabyFollowSchemeTask data = babyFollowSchemeTaskService.modify(babyFollowSchemeTask);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeTask/read")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeTask> read(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();	
		BabyFollowSchemeTask data = followQueueService.read(babyFollowSchemeTask);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeTask/list")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeTask> list(BabyFollowSchemeTask babyFollowSchemeTask ,int page,int rows) throws Exception {	
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeTask.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowSchemeTask.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeTask.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeTask.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getExecuteStartTime()!=null){
			dc.add(Restrictions.like("executeStartTime",babyFollowSchemeTask.getExecuteStartTime(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getExecuteEndTime()!=null){
			dc.add(Restrictions.like("executeEndTime",babyFollowSchemeTask.getExecuteEndTime(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSendSms()!=null){
			dc.add(Restrictions.like("sendSms",babyFollowSchemeTask.getSendSms(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSendMsg()!=null){
			dc.add(Restrictions.like("sendMsg",babyFollowSchemeTask.getSendMsg(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowSchemeTask.getSort()));
		}
		if(babyFollowSchemeTask.getExecutePhase()!=null){
			dc.add(Restrictions.eq("executePhase",babyFollowSchemeTask.getExecutePhase()));
		}
		if(babyFollowSchemeTask.getExecuteType()!=null){
			dc.add(Restrictions.like("executeType",babyFollowSchemeTask.getExecuteType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getFirstRecord()!=null){
			dc.add(Restrictions.like("firstRecord",babyFollowSchemeTask.getFirstRecord(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getTotal()!=null){
			dc.add(Restrictions.eq("total",babyFollowSchemeTask.getTotal()));
		}
		if(babyFollowSchemeTask.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeTask.getCreateTime()));
		}
		if(babyFollowSchemeTask.getBabyFollowScheme()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",babyFollowSchemeTask.getBabyFollowScheme()));
		}
		
		Long size = babyFollowSchemeTaskService.getSize(dc);
		List<BabyFollowSchemeTask> list = babyFollowSchemeTaskService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/babyFollowSchemeTask/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(BabyFollowSchemeTask babyFollowSchemeTask ,int page,int rows) throws Exception {
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeTask.class);
		if(babyFollowSchemeTask.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeTask.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeTask.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getExecuteStartTime()!=null){
			dc.add(Restrictions.like("executeStartTime",babyFollowSchemeTask.getExecuteStartTime(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getExecuteEndTime()!=null){
			dc.add(Restrictions.like("executeEndTime",babyFollowSchemeTask.getExecuteEndTime(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSendSms()!=null){
			dc.add(Restrictions.like("sendSms",babyFollowSchemeTask.getSendSms(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSendMsg()!=null){
			dc.add(Restrictions.like("sendMsg",babyFollowSchemeTask.getSendMsg(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowSchemeTask.getSort()));
		}
		if(babyFollowSchemeTask.getExecutePhase()!=null){
			dc.add(Restrictions.eq("executePhase",babyFollowSchemeTask.getExecutePhase()));
		}
		if(babyFollowSchemeTask.getExecuteType()!=null){
			dc.add(Restrictions.like("executeType",babyFollowSchemeTask.getExecuteType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getFirstRecord()!=null){
			dc.add(Restrictions.like("firstRecord",babyFollowSchemeTask.getFirstRecord(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeTask.getTotal()!=null){
			dc.add(Restrictions.eq("total",babyFollowSchemeTask.getTotal()));
		}
		if(babyFollowSchemeTask.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeTask.getCreateTime()));
		}
		if(babyFollowSchemeTask.getBabyFollowScheme()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId()!=null&&babyFollowSchemeTask.getBabyFollowScheme().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowScheme",babyFollowSchemeTask.getBabyFollowScheme()));
		}
		Long size = babyFollowSchemeTaskService.getSize(dc);
		List<Map<String, String>> list = babyFollowSchemeTaskService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeTask/review")	
    @ResponseBody	
	public JsonResult<BabyFollowSchemeTask> review(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception {
		JsonResult<BabyFollowSchemeTask> result = new JsonResult<BabyFollowSchemeTask>();
		Boolean success = babyFollowSchemeTaskService.review(babyFollowSchemeTask);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}