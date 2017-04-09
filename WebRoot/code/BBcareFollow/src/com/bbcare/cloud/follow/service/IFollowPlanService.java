package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowPlan;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访计划	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowPlanService {	
	
    /**	
	 * Name:保存随访计划	
	 * Params:	
	 *		followPlan:随访计划实例	
	 * Return:	
	 *		String:新增随访计划ID	
	 */	
	public String add(FollowPlan followPlan) throws Exception;
	
	/**	
	 * Name:删除随访计划	
	 * Params:	
	 *		id:随访计划ID	
	 */	
	public void remove(FollowPlan followPlan) throws Exception;
	
	/**	
	 * Name:修改随访计划	
	 * Params:	
	 *		followPlan:随访计划实例		
	 */	
	public FollowPlan modify(FollowPlan followPlan) throws Exception;	
	
	/**	
	 * Name:查询随访计划	
	 * Params:	
	 *		followPlan:随访计划	
	 * Return:	
	 *		FollowPlan:随访计划	
	 */	
	public FollowPlan read(FollowPlan followPlan) throws Exception;
	
    /**	
	 * Name:查询随访计划列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访计划>:随访计划列表	
	 */	
	public List<FollowPlan> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访计划数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访计划总数	
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
	 * Name:查询随访计划列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访计划列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}