package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.FollowUser;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IFollowUserService;
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
 * @name:随访用户控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class FollowUserAction extends BBcareControl<FollowUser> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IFollowUserService followUserService;
	
    @RequestMapping("/private/followUser/add")	
    @ResponseBody
	public JsonResult<FollowUser> add(FollowUser followUser) throws Exception {
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();
		String id = followUserService.add(followUser);	
		followUser.setId(id);
		result.setSuccess(true);
		result.setData(followUser);
		return result;
	}	
	
	@RequestMapping("/private/followUser/remove")	
	@ResponseBody
	public JsonResult<FollowUser> remove(FollowUser followUser) throws Exception {	
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();
		followUserService.remove(followUser);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/followUser/modify")
    @ResponseBody	
	public JsonResult<FollowUser> modify(FollowUser followUser) throws Exception {
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();
		FollowUser data = followUserService.modify(followUser);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/followUser/read")	
    @ResponseBody
	public JsonResult<FollowUser> read(FollowUser followUser) throws Exception {
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();	
		FollowUser data = followQueueService.read(followUser);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/followUser/list")
    @ResponseBody	
	public JsonResult<FollowUser> list(FollowUser followUser ,int page,int rows) throws Exception {	
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();
		DetachedCriteria dc = DetachedCriteria.forClass(FollowUser.class);
		dc.addOrder(Order.desc("id"));
		if(followUser.getAccountName()!=null){
			dc.add(Restrictions.like("accountName",followUser.getAccountName(),MatchMode.ANYWHERE));
		}
		if(followUser.getBabyId()!=null){
			dc.add(Restrictions.like("babyId",followUser.getBabyId(),MatchMode.ANYWHERE));
		}
		if(followUser.getBabyName()!=null){
			dc.add(Restrictions.like("babyName",followUser.getBabyName(),MatchMode.ANYWHERE));
		}
		if(followUser.getGender()!=null){
			dc.add(Restrictions.like("gender",followUser.getGender(),MatchMode.ANYWHERE));
		}
		if(followUser.getBirthday()!=null){
			dc.add(Restrictions.like("birthday",followUser.getBirthday(),MatchMode.ANYWHERE));
		}
		if(followUser.getPregnancyWeek()!=null){
			dc.add(Restrictions.like("pregnancyWeek",followUser.getPregnancyWeek(),MatchMode.ANYWHERE));
		}
		if(followUser.getInpatientNum()!=null){
			dc.add(Restrictions.like("inpatientNum",followUser.getInpatientNum(),MatchMode.ANYWHERE));
		}
		if(followUser.getIdCard()!=null){
			dc.add(Restrictions.like("idCard",followUser.getIdCard(),MatchMode.ANYWHERE));
		}
		if(followUser.getStatus()!=null){
			dc.add(Restrictions.like("status",followUser.getStatus(),MatchMode.ANYWHERE));
		}
		if(followUser.getType()!=null){
			dc.add(Restrictions.like("type",followUser.getType(),MatchMode.ANYWHERE));
		}
		if(followUser.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followUser.getCreateTime()));
		}
		
		Long size = followUserService.getSize(dc);
		List<FollowUser> list = followUserService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/followUser/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(FollowUser followUser ,int page,int rows) throws Exception {
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowUser.class);
		if(followUser.getAccountName()!=null){
			dc.add(Restrictions.like("accountName",followUser.getAccountName(),MatchMode.ANYWHERE));
		}
		if(followUser.getBabyId()!=null){
			dc.add(Restrictions.like("babyId",followUser.getBabyId(),MatchMode.ANYWHERE));
		}
		if(followUser.getBabyName()!=null){
			dc.add(Restrictions.like("babyName",followUser.getBabyName(),MatchMode.ANYWHERE));
		}
		if(followUser.getGender()!=null){
			dc.add(Restrictions.like("gender",followUser.getGender(),MatchMode.ANYWHERE));
		}
		if(followUser.getBirthday()!=null){
			dc.add(Restrictions.like("birthday",followUser.getBirthday(),MatchMode.ANYWHERE));
		}
		if(followUser.getPregnancyWeek()!=null){
			dc.add(Restrictions.like("pregnancyWeek",followUser.getPregnancyWeek(),MatchMode.ANYWHERE));
		}
		if(followUser.getInpatientNum()!=null){
			dc.add(Restrictions.like("inpatientNum",followUser.getInpatientNum(),MatchMode.ANYWHERE));
		}
		if(followUser.getIdCard()!=null){
			dc.add(Restrictions.like("idCard",followUser.getIdCard(),MatchMode.ANYWHERE));
		}
		if(followUser.getStatus()!=null){
			dc.add(Restrictions.like("status",followUser.getStatus(),MatchMode.ANYWHERE));
		}
		if(followUser.getType()!=null){
			dc.add(Restrictions.like("type",followUser.getType(),MatchMode.ANYWHERE));
		}
		if(followUser.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followUser.getCreateTime()));
		}
		Long size = followUserService.getSize(dc);
		List<Map<String, String>> list = followUserService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/followUser/review")	
    @ResponseBody	
	public JsonResult<FollowUser> review(FollowUser followUser) throws Exception {
		JsonResult<FollowUser> result = new JsonResult<FollowUser>();
		Boolean success = followUserService.review(followUser);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}