package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowTemplate;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowTemplateService {	
	
    /**	
	 * Name:保存随访模版	
	 * Params:	
	 *		followTemplate:随访模版实例	
	 * Return:	
	 *		String:新增随访模版ID	
	 */	
	public String add(FollowTemplate followTemplate) throws Exception;
	
	/**	
	 * Name:删除随访模版	
	 * Params:	
	 *		id:随访模版ID	
	 */	
	public void remove(FollowTemplate followTemplate) throws Exception;
	
	/**	
	 * Name:修改随访模版	
	 * Params:	
	 *		followTemplate:随访模版实例		
	 */	
	public FollowTemplate modify(FollowTemplate followTemplate) throws Exception;	
	
	/**	
	 * Name:查询随访模版	
	 * Params:	
	 *		followTemplate:随访模版	
	 * Return:	
	 *		FollowTemplate:随访模版	
	 */	
	public FollowTemplate read(FollowTemplate followTemplate) throws Exception;
	
    /**	
	 * Name:查询随访模版列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访模版>:随访模版列表	
	 */	
	public List<FollowTemplate> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访模版数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访模版总数	
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
	 * Name:查询随访模版列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访模版列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}