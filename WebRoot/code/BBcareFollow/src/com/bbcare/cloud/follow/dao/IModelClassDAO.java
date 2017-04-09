package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.ModelClass;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:模型分类	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IModelClassDAO {	
	
    /**	
	 * Name:保存模型分类	
	 * Params:	
	 *		modelClass:模型分类实例	
	 * Return:	
	 *		String:新增模型分类ID	
	 */	
	public String save(ModelClass modelClass) throws Exception;
	
	/**	
	 * Name:删除模型分类	
	 * Params:	
	 *		id:模型分类ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改模型分类	
	 * Params:	
	 *		modelClass:模型分类实例		
	 */	
	public void update(ModelClass modelClass) throws Exception;	
	
	/**	
	 * Name:查询模型分类	
	 * Params:	
	 *		id:模型分类ID	
	 * Return:	
	 *		ModelClass:模型分类	
	 */	
	public ModelClass get(String id) throws Exception;
	
    /**	
	 * Name:查询模型分类列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<模型分类>:模型分类列表	
	 */	
	public List<ModelClass> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:模型分类数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:模型分类总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}