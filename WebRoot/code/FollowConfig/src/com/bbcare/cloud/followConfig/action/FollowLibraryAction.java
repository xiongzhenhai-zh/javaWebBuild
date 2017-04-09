package com.bbcare.cloud.followConfig.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followConfig.entry.FollowLibrary;
import com.bbcare.cloud.followConfig.util.MyActionSupport;
import com.bbcare.cloud.followConfig.service.IFollowLibraryService;
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
 * @name:随访库控制层实现
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	

@Controller	
public class FollowLibraryAction extends BBcareControl<FollowLibrary> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IFollowLibraryService followLibraryService;
	
	private List<FollowLibrary> tree;
	
    @RequestMapping("/private/followLibrary/add")	
    @ResponseBody
	public JsonResult<FollowLibrary> add(FollowLibrary followLibrary) throws Exception {
		String id = followLibraryService.add(followLibrary);	
		followLibrary.setId(id);
		result.setSuccess(true);
		result.setData(followLibrary);
		return result;
	}	
	
	@RequestMapping("/private/followLibrary/remove")	
	@ResponseBody
	public JsonResult<FollowLibrary> remove(FollowLibrary followLibrary) throws Exception {	
		followLibraryService.remove(followLibrary);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/followLibrary/modify")
    @ResponseBody	
	public JsonResult<FollowLibrary> modify(FollowLibrary followLibrary) throws Exception {
		FollowLibrary data = followLibraryService.modify(followLibrary);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/followLibrary/read")	
    @ResponseBody
	public JsonResult<FollowLibrary> read(FollowLibrary followLibrary) throws Exception {	
		FollowLibrary data = followQueueService.read(followLibrary);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/followLibrary/list")
    @ResponseBody	
	public JsonResult<FollowLibrary> list(FollowLibrary followLibrary ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowLibrary.class);
		dc.addOrder(Order.desc("id"));
		if(followLibrary.getName()!=null){
			dc.add(Restrictions.like("name",followLibrary.getName(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterType()!=null){
			dc.add(Restrictions.like("masterType",followLibrary.getMasterType(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterId()!=null){
			dc.add(Restrictions.eq("masterId",followLibrary.getMasterId()));
		}
		if(followLibrary.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followLibrary.getCreateTime()));
		}
		if(followLibrary.getParent()!=null&&followLibrary.getParent().getId()!=null&&followLibrary.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",followLibrary.getParent()));
		}
		
		Long size = followLibraryService.getSize(dc);
		List<FollowLibrary> list = followLibraryService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/followLibrary/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(FollowLibrary followLibrary ,int page,int rows) throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowLibrary.class);
		if(followLibrary.getName()!=null){
			dc.add(Restrictions.like("name",followLibrary.getName(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterType()!=null){
			dc.add(Restrictions.like("masterType",followLibrary.getMasterType(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterId()!=null){
			dc.add(Restrictions.eq("masterId",followLibrary.getMasterId()));
		}
		if(followLibrary.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followLibrary.getCreateTime()));
		}
		if(followLibrary.getParent()!=null&&followLibrary.getParent().getId()!=null&&followLibrary.getParent().getId().trim().length()>0){
			dc.add(Restrictions.eq("parent",followLibrary.getParent()));
		}
		Long size = followLibraryService.getSize(dc);
		List<Map<String, String>> list = followLibraryService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @Action("/private/followLibrary/tree")	
	public String tree() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(FollowLibrary.class);
		dc.addOrder(Order.desc("id"));
		if(followLibrary.getName()!=null){
			dc.add(Restrictions.like("name",followLibrary.getName(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterType()!=null){
			dc.add(Restrictions.like("masterType",followLibrary.getMasterType(),MatchMode.ANYWHERE));
		}
		if(followLibrary.getMasterId()!=null){
			dc.add(Restrictions.eq("masterId",followLibrary.getMasterId()));
		}
		if(followLibrary.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",followLibrary.getCreateTime()));
		}
		if(followLibrary.getParent()!=null){
			dc.add(Restrictions.eq("parent",followLibrary.getParent()));
		}else{
			dc.add(Restrictions.isNull("parent"));
		}
		
		List<FollowLibrary> list = followLibraryService.list(dc, page, rows);
		result.put("success", true);
		result.put("rows", list);
		return "tree";	
	}
	
    public List<FollowLibrary> getTree() {
		return tree;
	}
	
	
	
}