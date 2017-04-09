package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.BabyFollowScheme;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeService;
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
 * @name:宝宝随访方案控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class BabyFollowSchemeAction extends BBcareControl<BabyFollowScheme> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IBabyFollowSchemeService babyFollowSchemeService;
	
    @RequestMapping("/private/babyFollowScheme/add")	
    @ResponseBody
	public JsonResult<BabyFollowScheme> add(BabyFollowScheme babyFollowScheme) throws Exception {
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();
		String id = babyFollowSchemeService.add(babyFollowScheme);	
		babyFollowScheme.setId(id);
		result.setSuccess(true);
		result.setData(babyFollowScheme);
		return result;
	}	
	
	@RequestMapping("/private/babyFollowScheme/remove")	
	@ResponseBody
	public JsonResult<BabyFollowScheme> remove(BabyFollowScheme babyFollowScheme) throws Exception {	
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();
		babyFollowSchemeService.remove(babyFollowScheme);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowScheme/modify")
    @ResponseBody	
	public JsonResult<BabyFollowScheme> modify(BabyFollowScheme babyFollowScheme) throws Exception {
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();
		BabyFollowScheme data = babyFollowSchemeService.modify(babyFollowScheme);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/babyFollowScheme/read")	
    @ResponseBody
	public JsonResult<BabyFollowScheme> read(BabyFollowScheme babyFollowScheme) throws Exception {
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();	
		BabyFollowScheme data = followQueueService.read(babyFollowScheme);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowScheme/list")
    @ResponseBody	
	public JsonResult<BabyFollowScheme> list(BabyFollowScheme babyFollowScheme ,int page,int rows) throws Exception {	
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowScheme.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowScheme.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowScheme.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getUserId()!=null){
			dc.add(Restrictions.like("userId",babyFollowScheme.getUserId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeId()!=null){
			dc.add(Restrictions.like("followSchemeId",babyFollowScheme.getFollowSchemeId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeVersion()!=null){
			dc.add(Restrictions.like("followSchemeVersion",babyFollowScheme.getFollowSchemeVersion(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",babyFollowScheme.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowScheme.getCreateTime()));
		}
		if(babyFollowScheme.getFollowUser()!=null&&babyFollowScheme.getFollowUser().getId()!=null&&babyFollowScheme.getFollowUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("followUser",babyFollowScheme.getFollowUser()));
		}
		
		Long size = babyFollowSchemeService.getSize(dc);
		List<BabyFollowScheme> list = babyFollowSchemeService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/babyFollowScheme/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(BabyFollowScheme babyFollowScheme ,int page,int rows) throws Exception {
		JsonResult<BabyFollowScheme> result = new JsonResult<BabyFollowScheme>();	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowScheme.class);
		if(babyFollowScheme.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowScheme.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getUserId()!=null){
			dc.add(Restrictions.like("userId",babyFollowScheme.getUserId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeId()!=null){
			dc.add(Restrictions.like("followSchemeId",babyFollowScheme.getFollowSchemeId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeVersion()!=null){
			dc.add(Restrictions.like("followSchemeVersion",babyFollowScheme.getFollowSchemeVersion(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getFollowSchemeVersionId()!=null){
			dc.add(Restrictions.like("followSchemeVersionId",babyFollowScheme.getFollowSchemeVersionId(),MatchMode.ANYWHERE));
		}
		if(babyFollowScheme.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowScheme.getCreateTime()));
		}
		if(babyFollowScheme.getFollowUser()!=null&&babyFollowScheme.getFollowUser().getId()!=null&&babyFollowScheme.getFollowUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("followUser",babyFollowScheme.getFollowUser()));
		}
		Long size = babyFollowSchemeService.getSize(dc);
		List<Map<String, String>> list = babyFollowSchemeService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
	
	
}