package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.ContentType;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:内容类型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IContentTypeService {	
	
    /**	
	 * Name:保存内容类型	
	 * Params:	
	 *		contentType:内容类型实例	
	 * Return:	
	 *		String:新增内容类型ID	
	 */	
	public String add(ContentType contentType) throws Exception;
	
	/**	
	 * Name:删除内容类型	
	 * Params:	
	 *		id:内容类型ID	
	 */	
	public void remove(ContentType contentType) throws Exception;
	
	/**	
	 * Name:修改内容类型	
	 * Params:	
	 *		contentType:内容类型实例		
	 */	
	public ContentType modify(ContentType contentType) throws Exception;	
	
	/**	
	 * Name:查询内容类型	
	 * Params:	
	 *		contentType:内容类型	
	 * Return:	
	 *		ContentType:内容类型	
	 */	
	public ContentType read(ContentType contentType) throws Exception;
	
    /**	
	 * Name:查询内容类型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<内容类型>:内容类型列表	
	 */	
	public List<ContentType> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:内容类型数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:内容类型总数	
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
	 * Name:查询内容类型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:内容类型列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}