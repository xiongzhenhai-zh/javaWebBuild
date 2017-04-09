package com.bbcare.cloud.followUsed.dao;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeTask;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:宝宝随访任务	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeTaskDAO {	
	
    /**	
	 * Name:保存宝宝随访任务	
	 * Params:	
	 *		babyFollowSchemeTask:宝宝随访任务实例	
	 * Return:	
	 *		String:新增宝宝随访任务ID	
	 */	
	public String save(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception;
	
	/**	
	 * Name:删除宝宝随访任务	
	 * Params:	
	 *		id:宝宝随访任务ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改宝宝随访任务	
	 * Params:	
	 *		babyFollowSchemeTask:宝宝随访任务实例		
	 */	
	public void update(BabyFollowSchemeTask babyFollowSchemeTask) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访任务	
	 * Params:	
	 *		id:宝宝随访任务ID	
	 * Return:	
	 *		BabyFollowSchemeTask:宝宝随访任务	
	 */	
	public BabyFollowSchemeTask get(String id) throws Exception;
	
    /**	
	 * Name:查询宝宝随访任务列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访任务>:宝宝随访任务列表	
	 */	
	public List<BabyFollowSchemeTask> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访任务数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访任务总数	
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
	
}