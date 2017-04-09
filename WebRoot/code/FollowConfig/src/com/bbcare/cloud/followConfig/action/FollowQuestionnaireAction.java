package com.bbcare.cloud.followConfig.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followConfig.entry.FollowQuestionnaire;
import com.bbcare.cloud.followConfig.util.MyActionSupport;
import com.bbcare.cloud.followConfig.service.IFollowQuestionnaireService;
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
 * @name:随访问卷版本控制层实现
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	

@Controller	
public class FollowQuestionnaireAction extends BBcareControl<FollowQuestionnaire> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IFollowQuestionnaireService followQuestionnaireService;
	
    @RequestMapping("/private/followQuestionnaire/add")	
    @ResponseBody
	public JsonResult<FollowQuestionnaire> add(FollowQuestionnaire followQuestionnaire) throws Exception {
		String id = followQuestionnaireService.add(followQuestionnaire);	
		followQuestionnaire.setId(id);
		result.setSuccess(true);
		result.setData(followQuestionnaire);
		return result;
	}	
	
	@RequestMapping("/private/followQuestionnaire/remove")	
	@ResponseBody
	public JsonResult<FollowQuestionnaire> remove(FollowQuestionnaire followQuestionnaire) throws Exception {	
		followQuestionnaireService.remove(followQuestionnaire);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/followQuestionnaire/modify")
    @ResponseBody	
	public JsonResult<FollowQuestionnaire> modify(FollowQuestionnaire followQuestionnaire) throws Exception {
		FollowQuestionnaire data = followQuestionnaireService.modify(followQuestionnaire);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/followQuestionnaire/read")	
    @ResponseBody
	public JsonResult<FollowQuestionnaire> read(FollowQuestionnaire followQuestionnaire) throws Exception {	
		FollowQuestionnaire data = followQueueService.read(followQuestionnaire);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/followQuestionnaire/list")
    @ResponseBody	
	public JsonResult<FollowQuestionnaire> list(FollowQuestionnaire followQuestionnaire ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQuestionnaire.class);
		dc.addOrder(Order.desc("id"));
		if(followQuestionnaire.getType()!=null){
			dc.add(Restrictions.like("type",followQuestionnaire.getType(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaire.getStatus()!=null){
			dc.add(Restrictions.eq("status",followQuestionnaire.getStatus()));
		}
		if(followQuestionnaire.getName()!=null){
			dc.add(Restrictions.like("name",followQuestionnaire.getName(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaire.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQuestionnaire.getCreateTime()));
		}
		if(followQuestionnaire.getFollowLibrary()!=null&&followQuestionnaire.getFollowLibrary().getId()!=null&&followQuestionnaire.getFollowLibrary().getId().trim().length()>0){
			dc.add(Restrictions.eq("followLibrary",followQuestionnaire.getFollowLibrary()));
		}
		
		Long size = followQuestionnaireService.getSize(dc);
		List<FollowQuestionnaire> list = followQuestionnaireService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/followQuestionnaire/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(FollowQuestionnaire followQuestionnaire ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQuestionnaire.class);
		if(followQuestionnaire.getType()!=null){
			dc.add(Restrictions.like("type",followQuestionnaire.getType(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaire.getStatus()!=null){
			dc.add(Restrictions.eq("status",followQuestionnaire.getStatus()));
		}
		if(followQuestionnaire.getName()!=null){
			dc.add(Restrictions.like("name",followQuestionnaire.getName(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaire.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQuestionnaire.getCreateTime()));
		}
		if(followQuestionnaire.getFollowLibrary()!=null&&followQuestionnaire.getFollowLibrary().getId()!=null&&followQuestionnaire.getFollowLibrary().getId().trim().length()>0){
			dc.add(Restrictions.eq("followLibrary",followQuestionnaire.getFollowLibrary()));
		}
		Long size = followQuestionnaireService.getSize(dc);
		List<Map<String, String>> list = followQuestionnaireService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/followQuestionnaire/review")	
    @ResponseBody	
	public JsonResult<FollowQuestionnaire> review(FollowQuestionnaire followQuestionnaire) throws Exception {
		Boolean success = followQuestionnaireService.review(followQuestionnaire);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}