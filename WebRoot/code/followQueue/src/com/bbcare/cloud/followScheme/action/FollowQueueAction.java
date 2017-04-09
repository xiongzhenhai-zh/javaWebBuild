package com.bbcare.cloud.followScheme.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followScheme.entry.FollowQueue;
import com.bbcare.cloud.followScheme.util.MyActionSupport;
import com.bbcare.cloud.followScheme.service.IFollowQueueService;
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
 * @name:随访队列控制层实现
 * @author:	
 * @createTime: 2016-11-15 10:46:05
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class FollowQueueAction extends MyActionSupport implements ModelDriven<FollowQueue> {	
	
	private static final long serialVersionUID = 1L;	
	
	private FollowQueue followQueue;	
	
	@Autowired	
	private IFollowQueueService followQueueService;
	
    @Action("/private/followQueue/add")	
	public String add() throws Exception {
		String id = followQueueService.add(followQueue);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/followQueue/remove")	
	public String remove() throws Exception {	
		followQueueService.remove(followQueue);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/followQueue/modify")	
	public String modify() throws Exception {
		FollowQueue data = followQueueService.modify(followQueue);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/followQueue/read")	
	public String read() throws Exception {	
		FollowQueue data = followQueueService.read(followQueue);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/followQueue/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQueue.class);
		dc.addOrder(Order.desc("id"));
		if(followQueue.getName()!=null){
			dc.add(Restrictions.like("name",followQueue.getName(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterType()!=null){
			dc.add(Restrictions.like("masterType",followQueue.getMasterType(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterName()!=null){
			dc.add(Restrictions.like("masterName",followQueue.getMasterName(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterId()!=null){
			dc.add(Restrictions.eq("masterId",followQueue.getMasterId()));
		}
		if(followQueue.getIntroduction()!=null){
			dc.add(Restrictions.like("introduction",followQueue.getIntroduction(),MatchMode.ANYWHERE));
		}
		if(followQueue.getNote()!=null){
			dc.add(Restrictions.like("note",followQueue.getNote(),MatchMode.ANYWHERE));
		}
		if(followQueue.getStatus()!=null){
			dc.add(Restrictions.like("status",followQueue.getStatus(),MatchMode.ANYWHERE));
		}
		if(followQueue.getTargerNumber()!=null){
			dc.add(Restrictions.eq("targerNumber",followQueue.getTargerNumber()));
		}
		if(followQueue.getUsedNumber()!=null){
			dc.add(Restrictions.eq("usedNumber",followQueue.getUsedNumber()));
		}
		if(followQueue.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQueue.getCreateTime()));
		}
		
		Long size = followQueueService.getSize(dc);
		List<FollowQueue> list = followQueueService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/followQueue/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowQueue.class);
		if(followQueue.getName()!=null){
			dc.add(Restrictions.like("name",followQueue.getName(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterType()!=null){
			dc.add(Restrictions.like("masterType",followQueue.getMasterType(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterName()!=null){
			dc.add(Restrictions.like("masterName",followQueue.getMasterName(),MatchMode.ANYWHERE));
		}
		if(followQueue.getMasterId()!=null){
			dc.add(Restrictions.eq("masterId",followQueue.getMasterId()));
		}
		if(followQueue.getIntroduction()!=null){
			dc.add(Restrictions.like("introduction",followQueue.getIntroduction(),MatchMode.ANYWHERE));
		}
		if(followQueue.getNote()!=null){
			dc.add(Restrictions.like("note",followQueue.getNote(),MatchMode.ANYWHERE));
		}
		if(followQueue.getStatus()!=null){
			dc.add(Restrictions.like("status",followQueue.getStatus(),MatchMode.ANYWHERE));
		}
		if(followQueue.getTargerNumber()!=null){
			dc.add(Restrictions.eq("targerNumber",followQueue.getTargerNumber()));
		}
		if(followQueue.getUsedNumber()!=null){
			dc.add(Restrictions.eq("usedNumber",followQueue.getUsedNumber()));
		}
		if(followQueue.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followQueue.getCreateTime()));
		}
		
		list = followQueueService.combo(dc, page, rows);
		return "list";	
	}
	
    @Action("/private/followQueue/review")	
	public String review() throws Exception {
		Boolean success = followQueueService.review(followQueue);	
		result.put("success", success);	
		return "json";	
	}
	
	
	@Override
	public FollowQueue getModel() {
		if(followQueue==null){
			followQueue = new FollowQueue();
		}
		return followQueue;
	}
}