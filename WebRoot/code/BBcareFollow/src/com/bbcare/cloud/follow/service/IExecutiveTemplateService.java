package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.ExecutiveTemplate;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:执行模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IExecutiveTemplateService {	
	
    /**	
	 * Name:保存执行模版	
	 * Params:	
	 *		executiveTemplate:执行模版实例	
	 * Return:	
	 *		String:新增执行模版ID	
	 */	
	public String add(ExecutiveTemplate executiveTemplate) throws Exception;
	
	/**	
	 * Name:删除执行模版	
	 * Params:	
	 *		id:执行模版ID	
	 */	
	public void remove(ExecutiveTemplate executiveTemplate) throws Exception;
	
	/**	
	 * Name:修改执行模版	
	 * Params:	
	 *		executiveTemplate:执行模版实例		
	 */	
	public ExecutiveTemplate modify(ExecutiveTemplate executiveTemplate) throws Exception;	
	
	/**	
	 * Name:查询执行模版	
	 * Params:	
	 *		executiveTemplate:执行模版	
	 * Return:	
	 *		ExecutiveTemplate:执行模版	
	 */	
	public ExecutiveTemplate read(ExecutiveTemplate executiveTemplate) throws Exception;
	
    /**	
	 * Name:查询执行模版列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<执行模版>:执行模版列表	
	 */	
	public List<ExecutiveTemplate> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:执行模版数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:执行模版总数	
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
	 * Name:查询执行模版列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:执行模版列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}