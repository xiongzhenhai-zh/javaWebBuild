package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowOption;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowOptionService {	
	
    /**	
	 * Name:保存随访选项	
	 * Params:	
	 *		followOption:随访选项实例	
	 * Return:	
	 *		String:新增随访选项ID	
	 */	
	public String add(FollowOption followOption) throws Exception;
	
	/**	
	 * Name:删除随访选项	
	 * Params:	
	 *		id:随访选项ID	
	 */	
	public void remove(FollowOption followOption) throws Exception;
	
	/**	
	 * Name:修改随访选项	
	 * Params:	
	 *		followOption:随访选项实例		
	 */	
	public FollowOption modify(FollowOption followOption) throws Exception;	
	
	/**	
	 * Name:查询随访选项	
	 * Params:	
	 *		followOption:随访选项	
	 * Return:	
	 *		FollowOption:随访选项	
	 */	
	public FollowOption read(FollowOption followOption) throws Exception;
	
    /**	
	 * Name:查询随访选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访选项>:随访选项列表	
	 */	
	public List<FollowOption> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访选项数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访选项总数	
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
	 * Name:查询随访选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访选项列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}