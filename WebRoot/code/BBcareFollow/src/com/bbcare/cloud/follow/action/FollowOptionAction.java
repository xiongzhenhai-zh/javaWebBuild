package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.FollowOption;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IFollowOptionService;
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
 * @name:随访选项控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followContent,data.followContent"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.followContent,data.followContent"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.followContent,data.followContent"})	
})
public class FollowOptionAction extends MyActionSupport implements ModelDriven<FollowOption> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowOption followOption;	
	
	@Autowired	
	private IFollowOptionService followOptionService;
	
    @Action("/private/followOption/add")	
	public String add() throws Exception {
		String id = followOptionService.add(followOption);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followOption/remove")	
	public String remove() throws Exception {	
		followOptionService.remove(followOption);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followOption/modify")	
	public String modify() throws Exception {
		FollowOption data = followOptionService.modify(followOption);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followOption/read")	
	public String read() throws Exception {	
		FollowOption data = followOptionService.read(followOption);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followOption/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowOption.class);
		dc.addOrder(Order.desc("id"));
		if(followOption.getName()!=null){
			dc.add(Restrictions.like("name",followOption.getName(),MatchMode.ANYWHERE));
		}
		if(followOption.getFollowContent()!=null&&followOption.getFollowContent().getId()!=null&&followOption.getFollowContent().getId().trim().length()>0){
			dc.add(Restrictions.eq("followContent",followOption.getFollowContent()));
		}
		
		Long size = followOptionService.getSize(dc);
		List<FollowOption> list = followOptionService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followOption/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowOption.class);
		if(followOption.getName()!=null){
			dc.add(Restrictions.like("name",followOption.getName(),MatchMode.ANYWHERE));
		}
		if(followOption.getFollowContent()!=null&&followOption.getFollowContent().getId()!=null&&followOption.getFollowContent().getId().trim().length()>0){
			dc.add(Restrictions.eq("followContent",followOption.getFollowContent()));
		}
		
		list = followOptionService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public FollowOption getModel() {
		if(followOption==null){
			followOption = new FollowOption();
		}
		return followOption;
	}
}