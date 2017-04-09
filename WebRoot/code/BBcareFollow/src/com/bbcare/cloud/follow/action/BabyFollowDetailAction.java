package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.BabyFollowDetail;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IBabyFollowDetailService;
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
 * @name:随访情况控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowRecord,data.babyFollowRecord,rows.*.babyFollowDetailOptions,data.babyFollowDetailOptions"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowRecord,data.babyFollowRecord,rows.*.babyFollowDetailOptions,data.babyFollowDetailOptions"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowRecord,data.babyFollowRecord"})	
})
public class BabyFollowDetailAction extends MyActionSupport implements ModelDriven<BabyFollowDetail> {	
	
	private static final long serialVersionUID = 1L;	
	
	private BabyFollowDetail babyFollowDetail;	
	
	@Autowired	
	private IBabyFollowDetailService babyFollowDetailService;
	
    @Action("/private/babyFollowDetail/add")	
	public String add() throws Exception {
		String id = babyFollowDetailService.add(babyFollowDetail);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/babyFollowDetail/remove")	
	public String remove() throws Exception {	
		babyFollowDetailService.remove(babyFollowDetail);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/babyFollowDetail/modify")	
	public String modify() throws Exception {
		BabyFollowDetail data = babyFollowDetailService.modify(babyFollowDetail);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/babyFollowDetail/read")	
	public String read() throws Exception {	
		BabyFollowDetail data = babyFollowDetailService.read(babyFollowDetail);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/babyFollowDetail/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowDetail.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowDetail.getFollowContenId()!=null){
			dc.add(Restrictions.like("followContenId",babyFollowDetail.getFollowContenId(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getNote()!=null){
			dc.add(Restrictions.like("note",babyFollowDetail.getNote(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentType()!=null){
			dc.add(Restrictions.like("contentType",babyFollowDetail.getContentType(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentClass()!=null){
			dc.add(Restrictions.like("contentClass",babyFollowDetail.getContentClass(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentUnit()!=null){
			dc.add(Restrictions.like("contentUnit",babyFollowDetail.getContentUnit(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowDetail.getSort()));
		}
		if(babyFollowDetail.getBabyFollowRecord()!=null&&babyFollowDetail.getBabyFollowRecord().getId()!=null&&babyFollowDetail.getBabyFollowRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowRecord",babyFollowDetail.getBabyFollowRecord()));
		}
		
		Long size = babyFollowDetailService.getSize(dc);
		List<BabyFollowDetail> list = babyFollowDetailService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/babyFollowDetail/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowDetail.class);
		if(babyFollowDetail.getFollowContenId()!=null){
			dc.add(Restrictions.like("followContenId",babyFollowDetail.getFollowContenId(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getNote()!=null){
			dc.add(Restrictions.like("note",babyFollowDetail.getNote(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentType()!=null){
			dc.add(Restrictions.like("contentType",babyFollowDetail.getContentType(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentClass()!=null){
			dc.add(Restrictions.like("contentClass",babyFollowDetail.getContentClass(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getContentUnit()!=null){
			dc.add(Restrictions.like("contentUnit",babyFollowDetail.getContentUnit(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetail.getSort()!=null){
			dc.add(Restrictions.eq("sort",babyFollowDetail.getSort()));
		}
		if(babyFollowDetail.getBabyFollowRecord()!=null&&babyFollowDetail.getBabyFollowRecord().getId()!=null&&babyFollowDetail.getBabyFollowRecord().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowRecord",babyFollowDetail.getBabyFollowRecord()));
		}
		
		list = babyFollowDetailService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public BabyFollowDetail getModel() {
		if(babyFollowDetail==null){
			babyFollowDetail = new BabyFollowDetail();
		}
		return babyFollowDetail;
	}
}