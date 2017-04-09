package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.ExecutiveTemplate;
import com.bbcare.cloud.follow.dao.IExecutiveTemplateDAO;
import com.bbcare.cloud.follow.service.IExecutiveTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.FollowTemplate;
import com.bbcare.cloud.follow.dao.IFollowTemplateDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:执行模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class ExecutiveTemplateService implements IExecutiveTemplateService {
	
	@Autowired
	private IExecutiveTemplateDAO executiveTemplateDAO;	
	
	@Autowired
	private IFollowTemplateDAO followTemplateDAO;
	
    public String add(ExecutiveTemplate executiveTemplate) throws Exception {
    	ExecutiveTemplate tempExecutiveTemplate = new ExecutiveTemplate();
		tempExecutiveTemplate.setStartTime(executiveTemplate.getStartTime());
		tempExecutiveTemplate.setTimeOut(executiveTemplate.getTimeOut());
		tempExecutiveTemplate.setType(executiveTemplate.getType());
		if(executiveTemplate.getFollowTemplate()!=null&&executiveTemplate.getFollowTemplate().getId()!=null&&executiveTemplate.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(executiveTemplate.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempExecutiveTemplate.setFollowTemplate(followTemplateTemp);
				tempExecutiveTemplate.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		return executiveTemplateDAO.save(tempExecutiveTemplate);	
	}
	
    public void remove(ExecutiveTemplate executiveTemplate) throws Exception {	
		executiveTemplateDAO.delete(executiveTemplate.getId());	
	}
	
    public ExecutiveTemplate modify(ExecutiveTemplate executiveTemplate) throws Exception {	
		ExecutiveTemplate tempExecutiveTemplate = executiveTemplateDAO.get(executiveTemplate.getId());
		
		if(executiveTemplate.getStartTime()!=null){
			tempExecutiveTemplate.setStartTime(executiveTemplate.getStartTime());
		}
		if(executiveTemplate.getTimeOut()!=null){
			tempExecutiveTemplate.setTimeOut(executiveTemplate.getTimeOut());
		}
		if(executiveTemplate.getType()!=null){
			tempExecutiveTemplate.setType(executiveTemplate.getType());
		}
		if(executiveTemplate.getFollowTemplate()!=null&& executiveTemplate.getFollowTemplate().getId()!=null&&executiveTemplate.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(executiveTemplate.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempExecutiveTemplate.setFollowTemplate(followTemplateTemp);
				tempExecutiveTemplate.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		executiveTemplateDAO.update(tempExecutiveTemplate);	
		return tempExecutiveTemplate;	
	}
	
    public ExecutiveTemplate read(ExecutiveTemplate executiveTemplate) throws Exception {	
		return executiveTemplateDAO.get(executiveTemplate.getId());	
	}	
	
    public List<ExecutiveTemplate> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return executiveTemplateDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return executiveTemplateDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ExecutiveTemplate> executiveTemplates = executiveTemplateDAO.list(dc, page, rows);
		for(ExecutiveTemplate executiveTemplate:executiveTemplates){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",executiveTemplate.getId());
			obj.put("text",executiveTemplate.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}