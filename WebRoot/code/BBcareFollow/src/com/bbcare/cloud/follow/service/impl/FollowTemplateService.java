package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowTemplate;
import com.bbcare.cloud.follow.dao.IFollowTemplateDAO;
import com.bbcare.cloud.follow.service.IFollowTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowModel ;
import com.bbcare.cloud.follow.dao.IFollowModel DAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowTemplateService implements IFollowTemplateService {
	
	@Autowired
	private IFollowTemplateDAO followTemplateDAO;	
	
	@Autowired
	private IFollowModel DAO followModel DAO;
	
    public String add(FollowTemplate followTemplate) throws Exception {
    	FollowTemplate tempFollowTemplate = new FollowTemplate();
		tempFollowTemplate.setName(followTemplate.getName());
		tempFollowTemplate.setType(followTemplate.getType());
		tempFollowTemplate.setUsedType(followTemplate.getUsedType());
		tempFollowTemplate.setUsedLevel(followTemplate.getUsedLevel());
		tempFollowTemplate.setSort(followTemplate.getSort());
		if(followTemplate.getFollowModel()!=null&&followTemplate.getFollowModel().getId()!=null&&followTemplate.getFollowModel().getId().trim().length()>0){
			FollowModel  followModel Temp = followModel DAO.get(followTemplate.getFollowModel().getId());
			if(followModel Temp!=null){
				tempFollowTemplate.setFollowModel(followModel Temp);
				tempFollowTemplate.setFollowModelName(followModel Temp.getName());
			}
		}
		return followTemplateDAO.save(tempFollowTemplate);	
	}
	
    public void remove(FollowTemplate followTemplate) throws Exception {	
		followTemplateDAO.delete(followTemplate.getId());	
	}
	
    public FollowTemplate modify(FollowTemplate followTemplate) throws Exception {	
		FollowTemplate tempFollowTemplate = followTemplateDAO.get(followTemplate.getId());
		
		if(followTemplate.getName()!=null){
			tempFollowTemplate.setName(followTemplate.getName());
		}
		if(followTemplate.getType()!=null){
			tempFollowTemplate.setType(followTemplate.getType());
		}
		if(followTemplate.getUsedType()!=null){
			tempFollowTemplate.setUsedType(followTemplate.getUsedType());
		}
		if(followTemplate.getUsedLevel()!=null){
			tempFollowTemplate.setUsedLevel(followTemplate.getUsedLevel());
		}
		if(followTemplate.getSort()!=null){
			tempFollowTemplate.setSort(followTemplate.getSort());
		}
		if(followTemplate.getFollowModel()!=null&& followTemplate.getFollowModel().getId()!=null&&followTemplate.getFollowModel().getId().trim().length()>0){
			FollowModel  followModel Temp = followModel DAO.get(followTemplate.getFollowModel().getId());
			if(followModel Temp!=null){
				tempFollowTemplate.setFollowModel(followModel Temp);
				tempFollowTemplate.setFollowModelName(followModel Temp.getName());
			}
		}
		followTemplateDAO.update(tempFollowTemplate);	
		return tempFollowTemplate;	
	}
	
    public FollowTemplate read(FollowTemplate followTemplate) throws Exception {	
		return followTemplateDAO.get(followTemplate.getId());	
	}	
	
    public List<FollowTemplate> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followTemplateDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followTemplateDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowTemplate> followTemplates = followTemplateDAO.list(dc, page, rows);
		for(FollowTemplate followTemplate:followTemplates){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followTemplate.getId());
			obj.put("text",followTemplate.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}