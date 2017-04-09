package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.ContentClass;
import com.bbcare.cloud.follow.dao.IContentClassDAO;
import com.bbcare.cloud.follow.service.IContentClassService;
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
 * @name:内容分类	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class ContentClassService implements IContentClassService {
	
	@Autowired
	private IContentClassDAO contentClassDAO;	
	
	@Autowired
	private IFollowTemplateDAO followTemplateDAO;
	
    public String add(ContentClass contentClass) throws Exception {
    	ContentClass tempContentClass = new ContentClass();
		tempContentClass.setName(contentClass.getName());
		tempContentClass.setWriterId(contentClass.getWriterId());
		if(contentClass.getParent()!=null&&contentClass.getParent().getId()!=null&&contentClass.getParent().getId().trim().length()>0){
			ContentClass contentClassTemp = contentClassDAO.get(contentClass.getParent().getId());
			if(contentClassTemp!=null){
				tempContentClass.setParent(contentClassTemp);
				tempContentClass.setParentName(contentClassTemp.getName());
			}
		}
		if(contentClass.getFollowTemplate()!=null&&contentClass.getFollowTemplate().getId()!=null&&contentClass.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(contentClass.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempContentClass.setFollowTemplate(followTemplateTemp);
				tempContentClass.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		return contentClassDAO.save(tempContentClass);	
	}
	
    public void remove(ContentClass contentClass) throws Exception {	
		contentClassDAO.delete(contentClass.getId());	
	}
	
    public ContentClass modify(ContentClass contentClass) throws Exception {	
		ContentClass tempContentClass = contentClassDAO.get(contentClass.getId());
		
		if(contentClass.getName()!=null){
			tempContentClass.setName(contentClass.getName());
		}
		if(contentClass.getWriterId()!=null){
			tempContentClass.setWriterId(contentClass.getWriterId());
		}
		if(contentClass.getParent()!=null&& contentClass.getParent().getId()!=null&&contentClass.getParent().getId().trim().length()>0){
			ContentClass contentClassTemp = contentClassDAO.get(contentClass.getParent().getId());
			if(contentClassTemp!=null){
				tempContentClass.setParent(contentClassTemp);
				tempContentClass.setParentName(contentClassTemp.getName());
			}
		}
		if(contentClass.getFollowTemplate()!=null&& contentClass.getFollowTemplate().getId()!=null&&contentClass.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(contentClass.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempContentClass.setFollowTemplate(followTemplateTemp);
				tempContentClass.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		contentClassDAO.update(tempContentClass);	
		return tempContentClass;	
	}
	
    public ContentClass read(ContentClass contentClass) throws Exception {	
		return contentClassDAO.get(contentClass.getId());	
	}	
	
    public List<ContentClass> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return contentClassDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return contentClassDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ContentClass> contentClasss = contentClassDAO.list(dc, page, rows);
		for(ContentClass contentClass:contentClasss){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",contentClass.getId());
			obj.put("text",contentClass.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}