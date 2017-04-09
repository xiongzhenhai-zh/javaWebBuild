package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.Trigger;
import com.bbcare.cloud.follow.dao.ITriggerDAO;
import com.bbcare.cloud.follow.service.ITriggerService;
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
 * @name:触发器	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class TriggerService implements ITriggerService {
	
	@Autowired
	private ITriggerDAO triggerDAO;	
	
	@Autowired
	private IFollowTemplateDAO followTemplateDAO;
	
    public String add(Trigger trigger) throws Exception {
    	Trigger tempTrigger = new Trigger();
		tempTrigger.setName(trigger.getName());
		tempTrigger.setStatus(trigger.getStatus());
		tempTrigger.setEvent(trigger.getEvent());
		tempTrigger.setType(trigger.getType());
		tempTrigger.setCondition(trigger.getCondition());
		if(trigger.getExecutiveTemplate()!=null&&trigger.getExecutiveTemplate().getId()!=null&&trigger.getExecutiveTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(trigger.getExecutiveTemplate().getId());
			if(followTemplateTemp!=null){
				tempTrigger.setExecutiveTemplate(followTemplateTemp);
				tempTrigger.setExecutiveTemplateName(followTemplateTemp.getName());
			}
		}
		return triggerDAO.save(tempTrigger);	
	}
	
    public void remove(Trigger trigger) throws Exception {	
		triggerDAO.delete(trigger.getId());	
	}
	
    public Trigger modify(Trigger trigger) throws Exception {	
		Trigger tempTrigger = triggerDAO.get(trigger.getId());
		
		if(trigger.getName()!=null){
			tempTrigger.setName(trigger.getName());
		}
		if(trigger.getStatus()!=null){
			tempTrigger.setStatus(trigger.getStatus());
		}
		if(trigger.getEvent()!=null){
			tempTrigger.setEvent(trigger.getEvent());
		}
		if(trigger.getType()!=null){
			tempTrigger.setType(trigger.getType());
		}
		if(trigger.getCondition()!=null){
			tempTrigger.setCondition(trigger.getCondition());
		}
		if(trigger.getExecutiveTemplate()!=null&& trigger.getExecutiveTemplate().getId()!=null&&trigger.getExecutiveTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(trigger.getExecutiveTemplate().getId());
			if(followTemplateTemp!=null){
				tempTrigger.setExecutiveTemplate(followTemplateTemp);
				tempTrigger.setExecutiveTemplateName(followTemplateTemp.getName());
			}
		}
		triggerDAO.update(tempTrigger);	
		return tempTrigger;	
	}
	
    public Trigger read(Trigger trigger) throws Exception {	
		return triggerDAO.get(trigger.getId());	
	}	
	
    public List<Trigger> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return triggerDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return triggerDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<Trigger> triggers = triggerDAO.list(dc, page, rows);
		for(Trigger trigger:triggers){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",trigger.getId());
			obj.put("text",trigger.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(Trigger trigger) throws Exception {
    	if(trigger.getStatus()==null){
    		return false;
    	}
		Trigger tempTrigger = triggerDAO.get(trigger.getId());
		if(tempTrigger!=null){
			tempTrigger.setStatus(trigger.getStatus());
			triggerDAO.update(tempTrigger);
			return true;
		}else{
			return false;
		}
	}
	
}