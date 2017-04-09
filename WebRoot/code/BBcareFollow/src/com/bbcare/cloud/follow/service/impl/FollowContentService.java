package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.FollowContent;
import com.bbcare.cloud.follow.dao.IFollowContentDAO;
import com.bbcare.cloud.follow.service.IFollowContentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbcare.cloud.follow.entry.ContentClass;
import com.bbcare.cloud.follow.dao.IContentClassDAO;
import com.bbcare.cloud.follow.entry.ContentType;
import com.bbcare.cloud.follow.dao.IContentTypeDAO;
import com.bbcare.cloud.follow.entry.ContentUnit;
import com.bbcare.cloud.follow.dao.IContentUnitDAO;
import com.bbcare.cloud.follow.entry.FollowTemplate;
import com.bbcare.cloud.follow.dao.IFollowTemplateDAO;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:随访内容	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class FollowContentService implements IFollowContentService {
	
	@Autowired
	private IFollowContentDAO followContentDAO;	
	
	@Autowired
	private IContentClassDAO contentClassDAO;
	
	@Autowired
	private IContentTypeDAO contentTypeDAO;
	
	@Autowired
	private IContentUnitDAO contentUnitDAO;
	
	@Autowired
	private IFollowTemplateDAO followTemplateDAO;
	
    public String add(FollowContent followContent) throws Exception {
    	FollowContent tempFollowContent = new FollowContent();
		tempFollowContent.setName(followContent.getName());
		tempFollowContent.setIsNull(followContent.getIsNull());
		tempFollowContent.setConfig(followContent.getConfig());
		tempFollowContent.setSort(followContent.getSort());
		tempFollowContent.setWriterId(followContent.getWriterId());
		if(followContent.getContentClass()!=null&&followContent.getContentClass().getId()!=null&&followContent.getContentClass().getId().trim().length()>0){
			ContentClass contentClassTemp = contentClassDAO.get(followContent.getContentClass().getId());
			if(contentClassTemp!=null){
				tempFollowContent.setContentClass(contentClassTemp);
				tempFollowContent.setContentClassName(contentClassTemp.getName());
			}
		}
		if(followContent.getContentType()!=null&&followContent.getContentType().getId()!=null&&followContent.getContentType().getId().trim().length()>0){
			ContentType contentTypeTemp = contentTypeDAO.get(followContent.getContentType().getId());
			if(contentTypeTemp!=null){
				tempFollowContent.setContentType(contentTypeTemp);
				tempFollowContent.setContentTypeName(contentTypeTemp.getName());
			}
		}
		if(followContent.getContentUnit()!=null&&followContent.getContentUnit().getId()!=null&&followContent.getContentUnit().getId().trim().length()>0){
			ContentUnit contentUnitTemp = contentUnitDAO.get(followContent.getContentUnit().getId());
			if(contentUnitTemp!=null){
				tempFollowContent.setContentUnit(contentUnitTemp);
				tempFollowContent.setContentUnitName(contentUnitTemp.getName());
			}
		}
		if(followContent.getFollowTemplate()!=null&&followContent.getFollowTemplate().getId()!=null&&followContent.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(followContent.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempFollowContent.setFollowTemplate(followTemplateTemp);
				tempFollowContent.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		return followContentDAO.save(tempFollowContent);	
	}
	
    public void remove(FollowContent followContent) throws Exception {	
		followContentDAO.delete(followContent.getId());	
	}
	
    public FollowContent modify(FollowContent followContent) throws Exception {	
		FollowContent tempFollowContent = followContentDAO.get(followContent.getId());
		
		if(followContent.getName()!=null){
			tempFollowContent.setName(followContent.getName());
		}
		if(followContent.getIsNull()!=null){
			tempFollowContent.setIsNull(followContent.getIsNull());
		}
		if(followContent.getConfig()!=null){
			tempFollowContent.setConfig(followContent.getConfig());
		}
		if(followContent.getSort()!=null){
			tempFollowContent.setSort(followContent.getSort());
		}
		if(followContent.getWriterId()!=null){
			tempFollowContent.setWriterId(followContent.getWriterId());
		}
		if(followContent.getContentClass()!=null&& followContent.getContentClass().getId()!=null&&followContent.getContentClass().getId().trim().length()>0){
			ContentClass contentClassTemp = contentClassDAO.get(followContent.getContentClass().getId());
			if(contentClassTemp!=null){
				tempFollowContent.setContentClass(contentClassTemp);
				tempFollowContent.setContentClassName(contentClassTemp.getName());
			}
		}
		if(followContent.getContentType()!=null&& followContent.getContentType().getId()!=null&&followContent.getContentType().getId().trim().length()>0){
			ContentType contentTypeTemp = contentTypeDAO.get(followContent.getContentType().getId());
			if(contentTypeTemp!=null){
				tempFollowContent.setContentType(contentTypeTemp);
				tempFollowContent.setContentTypeName(contentTypeTemp.getName());
			}
		}
		if(followContent.getContentUnit()!=null&& followContent.getContentUnit().getId()!=null&&followContent.getContentUnit().getId().trim().length()>0){
			ContentUnit contentUnitTemp = contentUnitDAO.get(followContent.getContentUnit().getId());
			if(contentUnitTemp!=null){
				tempFollowContent.setContentUnit(contentUnitTemp);
				tempFollowContent.setContentUnitName(contentUnitTemp.getName());
			}
		}
		if(followContent.getFollowTemplate()!=null&& followContent.getFollowTemplate().getId()!=null&&followContent.getFollowTemplate().getId().trim().length()>0){
			FollowTemplate followTemplateTemp = followTemplateDAO.get(followContent.getFollowTemplate().getId());
			if(followTemplateTemp!=null){
				tempFollowContent.setFollowTemplate(followTemplateTemp);
				tempFollowContent.setFollowTemplateName(followTemplateTemp.getName());
			}
		}
		followContentDAO.update(tempFollowContent);	
		return tempFollowContent;	
	}
	
    public FollowContent read(FollowContent followContent) throws Exception {	
		return followContentDAO.get(followContent.getId());	
	}	
	
    public List<FollowContent> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return followContentDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return followContentDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<FollowContent> followContents = followContentDAO.list(dc, page, rows);
		for(FollowContent followContent:followContents){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",followContent.getId());
			obj.put("text",followContent.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}