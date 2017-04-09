package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowTaskType;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访任务类型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowTaskTypeService {	
	
    /**	
	 * Name:保存随访任务类型	
	 * Params:	
	 *		followTaskType:随访任务类型实例	
	 * Return:	
	 *		String:新增随访任务类型ID	
	 */	
	public String add(FollowTaskType followTaskType) throws Exception;
	
	/**	
	 * Name:删除随访任务类型	
	 * Params:	
	 *		id:随访任务类型ID	
	 */	
	public void remove(FollowTaskType followTaskType) throws Exception;
	
	/**	
	 * Name:修改随访任务类型	
	 * Params:	
	 *		followTaskType:随访任务类型实例		
	 */	
	public FollowTaskType modify(FollowTaskType followTaskType) throws Exception;	
	
	/**	
	 * Name:查询随访任务类型	
	 * Params:	
	 *		followTaskType:随访任务类型	
	 * Return:	
	 *		FollowTaskType:随访任务类型	
	 */	
	public FollowTaskType read(FollowTaskType followTaskType) throws Exception;
	
    /**	
	 * Name:查询随访任务类型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访任务类型>:随访任务类型列表	
	 */	
	public List<FollowTaskType> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访任务类型数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访任务类型总数	
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
	 * Name:查询随访任务类型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访任务类型列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}