package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.ContentUnit;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:内容单位	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IContentUnitService {	
	
    /**	
	 * Name:保存内容单位	
	 * Params:	
	 *		contentUnit:内容单位实例	
	 * Return:	
	 *		String:新增内容单位ID	
	 */	
	public String add(ContentUnit contentUnit) throws Exception;
	
	/**	
	 * Name:删除内容单位	
	 * Params:	
	 *		id:内容单位ID	
	 */	
	public void remove(ContentUnit contentUnit) throws Exception;
	
	/**	
	 * Name:修改内容单位	
	 * Params:	
	 *		contentUnit:内容单位实例		
	 */	
	public ContentUnit modify(ContentUnit contentUnit) throws Exception;	
	
	/**	
	 * Name:查询内容单位	
	 * Params:	
	 *		contentUnit:内容单位	
	 * Return:	
	 *		ContentUnit:内容单位	
	 */	
	public ContentUnit read(ContentUnit contentUnit) throws Exception;
	
    /**	
	 * Name:查询内容单位列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<内容单位>:内容单位列表	
	 */	
	public List<ContentUnit> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:内容单位数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:内容单位总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
	/**
	 * Name:根据hql查询
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 */
	 @SuppressWarnings("rawtypes")
	public List queryHQL(String hql,Map<String, Object> value, int page, int rows) throws Exception;
	
	/**
	 * Name:根据hql删除或更新
	 * @param hql
	 * @param value2
	 * @return
	 * @throws Exception
	 */
	public Integer queryUpdate(String hql, Map<String, Object> value) throws Exception;
	
    /**	
	 * Name:查询内容单位列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:内容单位列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}