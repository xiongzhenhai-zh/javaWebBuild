package com.lechen.project.action;

import java.util.Map;
import com.lechen.project.entry.Auth;
import com.lechen.project.util.MyActionSupport;
import com.lechen.project.service.IAuthService;
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
 * @name:角色控制层实现
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.user,data.user"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.user,data.user"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.user,data.user"})	
})
public class AuthAction extends MyActionSupport implements ModelDriven<Auth> {	
	
	private static final long serialVersionUID = 1L;	
	
	private Auth auth;	
	
	@Autowired	
	private IAuthService authService;
	
    @Action("/private/auth/add")	
	public String add() throws Exception {
		String id = authService.add(auth);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/auth/remove")	
	public String remove() throws Exception {	
		authService.remove(auth);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/auth/modify")	
	public String modify() throws Exception {
		Auth data = authService.modify(auth);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/auth/read")	
	public String read() throws Exception {	
		Auth data = authService.read(auth);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/auth/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(Auth.class);
		dc.addOrder(Order.desc("id"));
		if(auth.getName()!=null){
			dc.add(Restrictions.like("name",auth.getName(),MatchMode.ANYWHERE));
		}
		if(auth.getUser()!=null&&auth.getUser().getId()!=null&&auth.getUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("user",auth.getUser()));
		}
		
		Long size = authService.getSize(dc);
		List<Auth> list = authService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/auth/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(Auth.class);
		if(auth.getName()!=null){
			dc.add(Restrictions.like("name",auth.getName(),MatchMode.ANYWHERE));
		}
		if(auth.getUser()!=null&&auth.getUser().getId()!=null&&auth.getUser().getId().trim().length()>0){
			dc.add(Restrictions.eq("user",auth.getUser()));
		}
		
		list = authService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public Auth getModel() {
		if(auth==null){
			auth = new Auth();
		}
		return auth;
	}
}