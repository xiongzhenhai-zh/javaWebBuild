package com.careJava.code.action;

import java.util.Date;
import java.util.Map;
import com.careJava.code.entry.User;
import com.careJava.code.util.MyActionSupport;
import com.careJava.code.service.IUserService;
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
 * @name:用户表控制层实现
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	

@Controller	
public class UserAction extends BBcareControl<User> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IUserService userService;
	
    @RequestMapping("/private/user/add")	
    @ResponseBody
	public JsonResult<User> add(User user) throws Exception {
		JsonResult<User> result = new JsonResult<User>();
		String id = userService.add(user);	
		user.setId(id);
		result.setSuccess(true);
		result.setData(user);
		return result;
	}	
	
	@RequestMapping("/private/user/remove")	
	@ResponseBody
	public JsonResult<User> remove(User user) throws Exception {	
		JsonResult<User> result = new JsonResult<User>();
		userService.remove(user);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/user/modify")
    @ResponseBody	
	public JsonResult<User> modify(User user) throws Exception {
		JsonResult<User> result = new JsonResult<User>();
		User data = userService.modify(user);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/user/read")	
    @ResponseBody
	public JsonResult<User> read(User user) throws Exception {
		JsonResult<User> result = new JsonResult<User>();	
		User data = userService.read(user);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/user/list")
    @ResponseBody	
	public JsonResult<User> list(User user ,int page,int rows) throws Exception {	
		JsonResult<User> result = new JsonResult<User>();
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.addOrder(Order.desc("id"));
		if(user.getName()!=null){
			dc.add(Restrictions.like("name",user.getName(),MatchMode.ANYWHERE));
		}
		if(user.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",user.getCreateTime()));
		}
		if(user.getUserName()!=null){
			dc.add(Restrictions.like("userName",user.getUserName(),MatchMode.ANYWHERE));
		}
		if(user.getPassword()!=null){
			dc.add(Restrictions.like("password",user.getPassword(),MatchMode.ANYWHERE));
		}
		if(user.getStatus()!=null){
			dc.add(Restrictions.like("status",user.getStatus(),MatchMode.ANYWHERE));
		}
		if(user.getType()!=null){
			dc.add(Restrictions.like("type",user.getType(),MatchMode.ANYWHERE));
		}
		
		Long size = userService.getSize(dc);
		List<User> list = userService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/user/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(User user ,int page,int rows) throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(user.getName()!=null){
			dc.add(Restrictions.like("name",user.getName(),MatchMode.ANYWHERE));
		}
		if(user.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",user.getCreateTime()));
		}
		if(user.getUserName()!=null){
			dc.add(Restrictions.like("userName",user.getUserName(),MatchMode.ANYWHERE));
		}
		if(user.getPassword()!=null){
			dc.add(Restrictions.like("password",user.getPassword(),MatchMode.ANYWHERE));
		}
		if(user.getStatus()!=null){
			dc.add(Restrictions.like("status",user.getStatus(),MatchMode.ANYWHERE));
		}
		if(user.getType()!=null){
			dc.add(Restrictions.like("type",user.getType(),MatchMode.ANYWHERE));
		}
		Long size = userService.getSize(dc);
		List<Map<String, String>> list = userService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/user/review")	
    @ResponseBody	
	public JsonResult<User> review(User user) throws Exception {
		JsonResult<User> result = new JsonResult<User>();
		Boolean success = userService.review(user);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}