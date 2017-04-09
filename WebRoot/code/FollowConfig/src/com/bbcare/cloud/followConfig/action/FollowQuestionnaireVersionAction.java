package com.bbcare.cloud.followConfig.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followConfig.entry.FollowQuestionnaireVersion;
import com.bbcare.cloud.followConfig.util.MyActionSupport;
import com.bbcare.cloud.followConfig.service.IFollowQuestionnaireVersionService;
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
public class FollowQuestionnaireVersionAction extends BBcareControl<FollowQuestionnaireVersion> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IFollowQuestionnaireVersionService followQuestionnaireVersionService;
	
    @RequestMapping("/private/followQuestionnaireVersion/add")	
    @ResponseBody
	public JsonResult<FollowQuestionnaireVersion> add(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {
		String id = followQuestionnaireVersionService.add(followQuestionnaireVersion);	
		followQuestionnaireVersion.setId(id);
		result.setSuccess(true);
		result.setData(followQuestionnaireVersion);
		return result;
	}	
	
	@RequestMapping("/private/followQuestionnaireVersion/remove")	
	@ResponseBody
	public JsonResult<FollowQuestionnaireVersion> remove(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {	
		followQuestionnaireVersionService.remove(followQuestionnaireVersion);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/followQuestionnaireVersion/modify")
    @ResponseBody	
	public JsonResult<FollowQuestionnaireVersion> modify(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {
		FollowQuestionnaireVersion data = followQuestionnaireVersionService.modify(followQuestionnaireVersion);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/followQuestionnaireVersion/read")	
    @ResponseBody
	public JsonResult<FollowQuestionnaireVersion> read(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {	
		FollowQuestionnaireVersion data = followQueueService.read(followQuestionnaireVersion);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/followQuestionnaireVersion/list")
    @ResponseBody	
	public JsonResult<FollowQuestionnaireVersion> list(FollowQuestionnaireVersion followQuestionnaireVersion ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQuestionnaireVersion.class);
		dc.addOrder(Order.desc("id"));
		if(followQuestionnaireVersion.getNote()!=null){
			dc.add(Restrictions.like("note",followQuestionnaireVersion.getNote(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaireVersion.getStatus()!=null){
			dc.add(Restrictions.eq("status",followQuestionnaireVersion.getStatus()));
		}
		if(followQuestionnaireVersion.getJson()!=null){
			dc.add(Restrictions.like("json",followQuestionnaireVersion.getJson(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaireVersion.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQuestionnaireVersion.getCreateTime()));
		}
		if(followQuestionnaireVersion.getFollowQuestionnaire()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId().trim().length()>0){
			dc.add(Restrictions.eq("followQuestionnaire",followQuestionnaireVersion.getFollowQuestionnaire()));
		}
		
		Long size = followQuestionnaireVersionService.getSize(dc);
		List<FollowQuestionnaireVersion> list = followQuestionnaireVersionService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/followQuestionnaireVersion/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(FollowQuestionnaireVersion followQuestionnaireVersion ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQuestionnaireVersion.class);
		if(followQuestionnaireVersion.getNote()!=null){
			dc.add(Restrictions.like("note",followQuestionnaireVersion.getNote(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaireVersion.getStatus()!=null){
			dc.add(Restrictions.eq("status",followQuestionnaireVersion.getStatus()));
		}
		if(followQuestionnaireVersion.getJson()!=null){
			dc.add(Restrictions.like("json",followQuestionnaireVersion.getJson(),MatchMode.ANYWHERE));
		}
		if(followQuestionnaireVersion.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQuestionnaireVersion.getCreateTime()));
		}
		if(followQuestionnaireVersion.getFollowQuestionnaire()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId()!=null&&followQuestionnaireVersion.getFollowQuestionnaire().getId().trim().length()>0){
			dc.add(Restrictions.eq("followQuestionnaire",followQuestionnaireVersion.getFollowQuestionnaire()));
		}
		Long size = followQuestionnaireVersionService.getSize(dc);
		List<Map<String, String>> list = followQuestionnaireVersionService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/followQuestionnaireVersion/review")	
    @ResponseBody	
	public JsonResult<FollowQuestionnaireVersion> review(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception {
		Boolean success = followQuestionnaireVersionService.review(followQuestionnaireVersion);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}