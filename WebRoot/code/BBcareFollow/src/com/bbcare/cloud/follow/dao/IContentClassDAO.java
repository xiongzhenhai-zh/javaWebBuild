package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.ContentClass;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:内容分类	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IContentClassDAO {	
	
    /**	
	 * Name:保存内容分类	
	 * Params:	
	 *		contentClass:内容分类实例	
	 * Return:	
	 *		String:新增内容分类ID	
	 */	
	public String save(ContentClass contentClass) throws Exception;
	
	/**	
	 * Name:删除内容分类	
	 * Params:	
	 *		id:内容分类ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改内容分类	
	 * Params:	
	 *		contentClass:内容分类实例		
	 */	
	public void update(ContentClass contentClass) throws Exception;	
	
	/**	
	 * Name:查询内容分类	
	 * Params:	
	 *		id:内容分类ID	
	 * Return:	
	 *		ContentClass:内容分类	
	 */	
	public ContentClass get(String id) throws Exception;
	
    /**	
	 * Name:查询内容分类列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<内容分类>:内容分类列表	
	 */	
	public List<ContentClass> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:内容分类数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:内容分类总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}