package com.bbcare.cloud.follow.action;

import java.util.Map;
import com.bbcare.cloud.follow.entry.BabyFollowDetailOption;
import com.bbcare.cloud.follow.util.MyActionSupport;
import com.bbcare.cloud.follow.service.IBabyFollowDetailOptionService;
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
 * @name:宝宝随访详情选项控制层实现
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowDetail,data.babyFollowDetail"}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowDetail,data.babyFollowDetail"}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties","rows.*.babyFollowDetail,data.babyFollowDetail"})	
})
public class BabyFollowDetailOptionAction extends MyActionSupport implements ModelDriven<BabyFollowDetailOption> {	
	
	private static final long serialVersionUID = 1L;	
	
	private BabyFollowDetailOption babyFollowDetailOption;	
	
	@Autowired	
	private IBabyFollowDetailOptionService babyFollowDetailOptionService;
	
    @Action("/private/babyFollowDetailOption/add")	
	public String add() throws Exception {
		String id = babyFollowDetailOptionService.add(babyFollowDetailOption);	
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
	
	@Action("/private/babyFollowDetailOption/remove")	
	public String remove() throws Exception {	
		babyFollowDetailOptionService.remove(babyFollowDetailOption);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/babyFollowDetailOption/modify")	
	public String modify() throws Exception {
		BabyFollowDetailOption data = babyFollowDetailOptionService.modify(babyFollowDetailOption);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/babyFollowDetailOption/read")	
	public String read() throws Exception {	
		BabyFollowDetailOption data = babyFollowDetailOptionService.read(babyFollowDetailOption);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/babyFollowDetailOption/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowDetailOption.class);
		dc.addOrder(Order.desc("id"));
		if(babyFollowDetailOption.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowDetailOption.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetailOption.getBabyFollowDetail()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowDetail",babyFollowDetailOption.getBabyFollowDetail()));
		}
		
		Long size = babyFollowDetailOptionService.getSize(dc);
		List<BabyFollowDetailOption> list = babyFollowDetailOptionService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/babyFollowDetailOption/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(BabyFollowDetailOption.class);
		if(babyFollowDetailOption.getName()!=null){
			dc.add(Restrictions.like("name",babyFollowDetailOption.getName(),MatchMode.ANYWHERE));
		}
		if(babyFollowDetailOption.getBabyFollowDetail()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId().trim().length()>0){
			dc.add(Restrictions.eq("babyFollowDetail",babyFollowDetailOption.getBabyFollowDetail()));
		}
		
		list = babyFollowDetailOptionService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public BabyFollowDetailOption getModel() {
		if(babyFollowDetailOption==null){
			babyFollowDetailOption = new BabyFollowDetailOption();
		}
		return babyFollowDetailOption;
	}
}