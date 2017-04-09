package com.bbcare.cloud.followUsed.action;

import java.util.Date;
import java.util.Map;
import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeContent;
import com.bbcare.cloud.followUsed.util.MyActionSupport;
import com.bbcare.cloud.followUsed.service.IBabyFollowSchemeContentService;
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
 * @name:宝宝随访任务内容控制层实现
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	

@Controller	
public class BabyFollowSchemeContentAction extends BBcareControl<BabyFollowSchemeContent> {	
	
	private static final long serialVersionUID = 1L;	
	
	@Autowired	
	private IBabyFollowSchemeContentService babyFollowSchemeContentService;
	
    @RequestMapping("/private/babyFollowSchemeContent/add")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeContent> add(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();
		String id = babyFollowSchemeContentService.add(babyFollowSchemeContent);	
		babyFollowSchemeContent.setId(id);
		result.setSuccess(true);
		result.setData(babyFollowSchemeContent);
		return result;
	}	
	
	@RequestMapping("/private/babyFollowSchemeContent/remove")	
	@ResponseBody
	public JsonResult<BabyFollowSchemeContent> remove(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {	
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();
		babyFollowSchemeContentService.remove(babyFollowSchemeContent);	
		result.setSuccess(true);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeContent/modify")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeContent> modify(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();
		BabyFollowSchemeContent data = babyFollowSchemeContentService.modify(babyFollowSchemeContent);	
		result.setSuccess(true);
		result.setData(data);	
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeContent/read")	
    @ResponseBody
	public JsonResult<BabyFollowSchemeContent> read(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();	
		BabyFollowSchemeContent data = followQueueService.read(babyFollowSchemeContent);	
		result.setSuccess(true);
		result.setData(data);
		return result;	
	}	
	
    @RequestMapping("/private/babyFollowSchemeContent/list")
    @ResponseBody	
	public JsonResult<BabyFollowSchemeContent> list(BabyFollowSchemeContent babyFollowSchemeContent ,int page,int rows) throws Exception {	
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeContent.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowSchemeContent.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeContent.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeContent.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowSchemeContent.getSort()));
		}
		if(babyFollowSchemeContent.getSourceId()!=null){
			dc.add(Restrictions.like("sourceId",babyFollowSchemeContent.getSourceId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getSourceType()!=null){
			dc.add(Restrictions.like("sourceType",babyFollowSchemeContent.getSourceType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getUserType()!=null){
			dc.add(Restrictions.like("userType",babyFollowSchemeContent.getUserType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeContent.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getData()!=null){
			dc.add(Restrictions.like("data",babyFollowSchemeContent.getData(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getFirstRecord()!=null){
			dc.add(Restrictions.like("firstRecord",babyFollowSchemeContent.getFirstRecord(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeContent.getCreateTime()));
		}
		if(babyFollowSchemeContent.getBabyFollowSchemeTask()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowSchemeTask",babyFollowSchemeContent.getBabyFollowSchemeTask()));
		}
		
		Long size = babyFollowSchemeContentService.getSize(dc);
		List<BabyFollowSchemeContent> list = babyFollowSchemeContentService.list(dc, page, rows);
		
		result.setSuccess(true);
		result.convtData(list,size);
		return result;		
	}
	
    @RequestMapping("/private/babyFollowSchemeContent/combo")	
    @ResponseBody
	public JsonResult<Map<String, String>> combo(BabyFollowSchemeContent babyFollowSchemeContent ,int page,int rows) throws Exception {
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowSchemeContent.class);
		if(babyFollowSchemeContent.getStatus()!=null){
			dc.add(Restrictions.like("status",babyFollowSchemeContent.getStatus(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowSchemeContent.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowSchemeContent.getSort()));
		}
		if(babyFollowSchemeContent.getSourceId()!=null){
			dc.add(Restrictions.like("sourceId",babyFollowSchemeContent.getSourceId(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getSourceType()!=null){
			dc.add(Restrictions.like("sourceType",babyFollowSchemeContent.getSourceType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getUserType()!=null){
			dc.add(Restrictions.like("userType",babyFollowSchemeContent.getUserType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getType()!=null){
			dc.add(Restrictions.like("type",babyFollowSchemeContent.getType(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getData()!=null){
			dc.add(Restrictions.like("data",babyFollowSchemeContent.getData(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getFirstRecord()!=null){
			dc.add(Restrictions.like("firstRecord",babyFollowSchemeContent.getFirstRecord(),MatchMode.ANYWHERE));
		}
		if(babyFollowSchemeContent.getCreateTime()!=null){
			dc.add(Restrictions.eq("createTime",babyFollowSchemeContent.getCreateTime()));
		}
		if(babyFollowSchemeContent.getBabyFollowSchemeTask()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId()!=null&&babyFollowSchemeContent.getBabyFollowSchemeTask().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowSchemeTask",babyFollowSchemeContent.getBabyFollowSchemeTask()));
		}
		Long size = babyFollowSchemeContentService.getSize(dc);
		List<Map<String, String>> list = babyFollowSchemeContentService.combo(dc, page, rows);
		JsonResult<Map<String, String>> result = new JsonResult<Map<String, String>>();
		result.setSuccess(true);
		result.convtData(list,size);
		return result;	
	}
	
    @RequestMapping("/private/babyFollowSchemeContent/review")	
    @ResponseBody	
	public JsonResult<BabyFollowSchemeContent> review(BabyFollowSchemeContent babyFollowSchemeContent) throws Exception {
		JsonResult<BabyFollowSchemeContent> result = new JsonResult<BabyFollowSchemeContent>();
		Boolean success = babyFollowSchemeContentService.review(babyFollowSchemeContent);	
		result.setSuccess(success);
		return result;	
	}
	
	
	
}