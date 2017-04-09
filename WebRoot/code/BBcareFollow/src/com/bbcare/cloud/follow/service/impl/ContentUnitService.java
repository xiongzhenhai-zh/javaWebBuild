package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.ContentUnit;
import com.bbcare.cloud.follow.dao.IContentUnitDAO;
import com.bbcare.cloud.follow.service.IContentUnitService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:内容单位	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class ContentUnitService implements IContentUnitService {
	
	@Autowired
	private IContentUnitDAO contentUnitDAO;	
	
    public String add(ContentUnit contentUnit) throws Exception {
    	ContentUnit tempContentUnit = new ContentUnit();
		tempContentUnit.setName(contentUnit.getName());
		tempContentUnit.setSymbol(contentUnit.getSymbol());
		tempContentUnit.setNote(contentUnit.getNote());
		tempContentUnit.setType(contentUnit.getType());
		tempContentUnit.setWriterId(contentUnit.getWriterId());
		return contentUnitDAO.save(tempContentUnit);	
	}
	
    public void remove(ContentUnit contentUnit) throws Exception {	
		contentUnitDAO.delete(contentUnit.getId());	
	}
	
    public ContentUnit modify(ContentUnit contentUnit) throws Exception {	
		ContentUnit tempContentUnit = contentUnitDAO.get(contentUnit.getId());
		
		if(contentUnit.getName()!=null){
			tempContentUnit.setName(contentUnit.getName());
		}
		if(contentUnit.getSymbol()!=null){
			tempContentUnit.setSymbol(contentUnit.getSymbol());
		}
		if(contentUnit.getNote()!=null){
			tempContentUnit.setNote(contentUnit.getNote());
		}
		if(contentUnit.getType()!=null){
			tempContentUnit.setType(contentUnit.getType());
		}
		if(contentUnit.getWriterId()!=null){
			tempContentUnit.setWriterId(contentUnit.getWriterId());
		}
		contentUnitDAO.update(tempContentUnit);	
		return tempContentUnit;	
	}
	
    public ContentUnit read(ContentUnit contentUnit) throws Exception {	
		return contentUnitDAO.get(contentUnit.getId());	
	}	
	
    public List<ContentUnit> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return contentUnitDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return contentUnitDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ContentUnit> contentUnits = contentUnitDAO.list(dc, page, rows);
		for(ContentUnit contentUnit:contentUnits){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",contentUnit.getId());
			obj.put("text",contentUnit.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}