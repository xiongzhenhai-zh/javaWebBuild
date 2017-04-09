package com.bbcare.cloud.follow.service.impl;

import com.bbcare.cloud.follow.entry.ModelClass;
import com.bbcare.cloud.follow.dao.IModelClassDAO;
import com.bbcare.cloud.follow.service.IModelClassService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:模型分类	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Service
public class ModelClassService implements IModelClassService {
	
	@Autowired
	private IModelClassDAO modelClassDAO;	
	
    public String add(ModelClass modelClass) throws Exception {
    	ModelClass tempModelClass = new ModelClass();
		tempModelClass.setName(modelClass.getName());
		tempModelClass.setSort(modelClass.getSort());
		if(modelClass.getParent()!=null&&modelClass.getParent().getId()!=null&&modelClass.getParent().getId().trim().length()>0){
			ModelClass modelClassTemp = modelClassDAO.get(modelClass.getParent().getId());
			if(modelClassTemp!=null){
				tempModelClass.setParent(modelClassTemp);
				tempModelClass.setParentName(modelClassTemp.getName());
			}
		}
		return modelClassDAO.save(tempModelClass);	
	}
	
    public void remove(ModelClass modelClass) throws Exception {	
		modelClassDAO.delete(modelClass.getId());	
	}
	
    public ModelClass modify(ModelClass modelClass) throws Exception {	
		ModelClass tempModelClass = modelClassDAO.get(modelClass.getId());
		
		if(modelClass.getName()!=null){
			tempModelClass.setName(modelClass.getName());
		}
		if(modelClass.getSort()!=null){
			tempModelClass.setSort(modelClass.getSort());
		}
		if(modelClass.getParent()!=null&& modelClass.getParent().getId()!=null&&modelClass.getParent().getId().trim().length()>0){
			ModelClass modelClassTemp = modelClassDAO.get(modelClass.getParent().getId());
			if(modelClassTemp!=null){
				tempModelClass.setParent(modelClassTemp);
				tempModelClass.setParentName(modelClassTemp.getName());
			}
		}
		modelClassDAO.update(tempModelClass);	
		return tempModelClass;	
	}
	
    public ModelClass read(ModelClass modelClass) throws Exception {	
		return modelClassDAO.get(modelClass.getId());	
	}	
	
    public List<ModelClass> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return modelClassDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return modelClassDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ModelClass> modelClasss = modelClassDAO.list(dc, page, rows);
		for(ModelClass modelClass:modelClasss){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",modelClass.getId());
			obj.put("text",modelClass.getName());
			list.add(obj);
		}
		return list;	
	}	
	
}