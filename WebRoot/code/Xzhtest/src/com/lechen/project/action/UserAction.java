package com.lechen.project.action;

import java.util.Map;
import com.lechen.project.entry.User;
import com.lechen.project.util.MyActionSupport;
import com.lechen.project.service.IUserService;
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
 * @name:用户控制层实现
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.auths,data.auths"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.auths,data.auths"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class UserAction extends MyActionSupport implements ModelDriven<User> {	
	
	private static final long serialVersionUID = 1L;	
	
	private User user;	
	
	@Autowired	
	private IUserService userService;
	
    @Action("/private/user/add")	
	public String add() throws Exception {
		String id = userService.add(user);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/user/remove")	
	public String remove() throws Exception {	
		userService.remove(user);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/user/modify")	
	public String modify() throws Exception {
		User data = userService.modify(user);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/user/read")	
	public String read() throws Exception {	
		User data = userService.read(user);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/user/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.addOrder(Order.desc("id"));
		if(user.getName()!=null){
			dc.add(Restrictions.like("name",user.getName(),MatchMode.ANYWHERE));
		}
		
		Long size = userService.getSize(dc);
		List<User> list = userService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/user/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		if(user.getName()!=null){
			dc.add(Restrictions.like("name",user.getName(),MatchMode.ANYWHERE));
		}
		
		list = userService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public User getModel() {
		if(user==null){
			user = new User();
		}
		return user;
	}
}