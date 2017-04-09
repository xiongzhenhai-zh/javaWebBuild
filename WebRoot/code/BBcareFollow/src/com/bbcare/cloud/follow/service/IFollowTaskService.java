package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowTask;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访任务	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowTaskService {	
	
    /**	
	 * Name:保存随访任务	
	 * Params:	
	 *		followTask:随访任务实例	
	 * Return:	
	 *		String:新增随访任务ID	
	 */	
	public String add(FollowTask followTask) throws Exception;
	
	/**	
	 * Name:删除随访任务	
	 * Params:	
	 *		id:随访任务ID	
	 */	
	public void remove(FollowTask followTask) throws Exception;
	
	/**	
	 * Name:修改随访任务	
	 * Params:	
	 *		followTask:随访任务实例		
	 */	
	public FollowTask modify(FollowTask followTask) throws Exception;	
	
	/**	
	 * Name:查询随访任务	
	 * Params:	
	 *		followTask:随访任务	
	 * Return:	
	 *		FollowTask:随访任务	
	 */	
	public FollowTask read(FollowTask followTask) throws Exception;
	
    /**	
	 * Name:查询随访任务列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访任务>:随访任务列表	
	 */	
	public List<FollowTask> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访任务数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访任务总数	
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
	 * Name:查询随访任务列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访任务列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核随访任务	
	 * Params:
	 *		followTask:随访任务实例		
	 */	
	public Boolean review(FollowTask followTask) throws Exception;	
	
}