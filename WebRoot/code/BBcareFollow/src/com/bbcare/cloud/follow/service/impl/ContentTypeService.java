package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.ContentType;
import com.bbcare.cloud.follow.dao.IContentTypeDAO;
import com.bbcare.cloud.follow.service.IContentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:内容类型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class ContentTypeService implements IContentTypeService {
	
	@Autowired
	private IContentTypeDAO contentTypeDAO;	
	
    public String add(ContentType contentType) throws Exception {
    	ContentType tempContentType = new ContentType();
		tempContentType.setName(contentType.getName());
		tempContentType.setWriterId(contentType.getWriterId());
		return contentTypeDAO.save(tempContentType);	
	}
	
    public void remove(ContentType contentType) throws Exception {	
		contentTypeDAO.delete(contentType.getId());	
	}
	
    public ContentType modify(ContentType contentType) throws Exception {	
		ContentType tempContentType = contentTypeDAO.get(contentType.getId());
		
		if(contentType.getName()!=null){
			tempContentType.setName(contentType.getName());
		}
		if(contentType.getWriterId()!=null){
			tempContentType.setWriterId(contentType.getWriterId());
		}
		contentTypeDAO.update(tempContentType);	
		return tempContentType;	
	}
	
    public ContentType read(ContentType contentType) throws Exception {	
		return contentTypeDAO.get(contentType.getId());	
	}	
	
    public List<ContentType> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return contentTypeDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return contentTypeDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ContentType> contentTypes = contentTypeDAO.list(dc, page, rows);
		for(ContentType contentType:contentTypes){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",contentType.getId());
			obj.put("text",contentType.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}