package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.BabyFollowDetailOption;
import com.bbcare.cloud.follow.dao.IBabyFollowDetailOptionDAO;
import com.bbcare.cloud.follow.service.IBabyFollowDetailOptionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.BabyFollowDetail;
import com.bbcare.cloud.follow.dao.IBabyFollowDetailDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:宝宝随访详情选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class BabyFollowDetailOptionService implements IBabyFollowDetailOptionService {
	
	@Autowired
	private IBabyFollowDetailOptionDAO babyFollowDetailOptionDAO;	
	
	@Autowired
	private IBabyFollowDetailDAO babyFollowDetailDAO;
	
    public String add(BabyFollowDetailOption babyFollowDetailOption) throws Exception {
    	BabyFollowDetailOption tempBabyFollowDetailOption = new BabyFollowDetailOption();
		tempBabyFollowDetailOption.setName(babyFollowDetailOption.getName());
		if(babyFollowDetailOption.getBabyFollowDetail()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId().trim().length()>0){
			BabyFollowDetail babyFollowDetailTemp = babyFollowDetailDAO.get(babyFollowDetailOption.getBabyFollowDetail().getId());
			if(babyFollowDetailTemp!=null){
				tempBabyFollowDetailOption.setBabyFollowDetail(babyFollowDetailTemp);
				tempBabyFollowDetailOption.setBabyFollowDetailName(babyFollowDetailTemp.getId());
			}
		}
		return babyFollowDetailOptionDAO.save(tempBabyFollowDetailOption);	
	}
	
    public void remove(BabyFollowDetailOption babyFollowDetailOption) throws Exception {	
		babyFollowDetailOptionDAO.delete(babyFollowDetailOption.getId());	
	}
	
    public BabyFollowDetailOption modify(BabyFollowDetailOption babyFollowDetailOption) throws Exception {	
		BabyFollowDetailOption tempBabyFollowDetailOption = babyFollowDetailOptionDAO.get(babyFollowDetailOption.getId());
		
		if(babyFollowDetailOption.getName()!=null){
			tempBabyFollowDetailOption.setName(babyFollowDetailOption.getName());
		}
		if(babyFollowDetailOption.getBabyFollowDetail()!=null&& babyFollowDetailOption.getBabyFollowDetail().getId()!=null&&babyFollowDetailOption.getBabyFollowDetail().getId().trim().length()>0){
			BabyFollowDetail babyFollowDetailTemp = babyFollowDetailDAO.get(babyFollowDetailOption.getBabyFollowDetail().getId());
			if(babyFollowDetailTemp!=null){
				tempBabyFollowDetailOption.setBabyFollowDetail(babyFollowDetailTemp);
				tempBabyFollowDetailOption.setBabyFollowDetailName(babyFollowDetailTemp.getId());
			}
		}
		babyFollowDetailOptionDAO.update(tempBabyFollowDetailOption);	
		return tempBabyFollowDetailOption;	
	}
	
    public BabyFollowDetailOption read(BabyFollowDetailOption babyFollowDetailOption) throws Exception {	
		return babyFollowDetailOptionDAO.get(babyFollowDetailOption.getId());	
	}	
	
    public List<BabyFollowDetailOption> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return babyFollowDetailOptionDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return babyFollowDetailOptionDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<BabyFollowDetailOption> babyFollowDetailOptions = babyFollowDetailOptionDAO.list(dc, page, rows);
		for(BabyFollowDetailOption babyFollowDetailOption:babyFollowDetailOptions){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",babyFollowDetailOption.getId());
			obj.put("text",babyFollowDetailOption.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}