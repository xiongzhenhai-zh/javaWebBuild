package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.FollowModel ;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访模型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowModel Service {	
	
    /**	
	 * Name:保存随访模型	
	 * Params:	
	 *		followModel :随访模型实例	
	 * Return:	
	 *		String:新增随访模型ID	
	 */	
	public String add(FollowModel  followModel ) throws Exception;
	
	/**	
	 * Name:删除随访模型	
	 * Params:	
	 *		id:随访模型ID	
	 */	
	public void remove(FollowModel  followModel ) throws Exception;
	
	/**	
	 * Name:修改随访模型	
	 * Params:	
	 *		followModel :随访模型实例		
	 */	
	public FollowModel  modify(FollowModel  followModel ) throws Exception;	
	
	/**	
	 * Name:查询随访模型	
	 * Params:	
	 *		followModel :随访模型	
	 * Return:	
	 *		FollowModel :随访模型	
	 */	
	public FollowModel  read(FollowModel  followModel ) throws Exception;
	
    /**	
	 * Name:查询随访模型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访模型>:随访模型列表	
	 */	
	public List<FollowModel > list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访模型数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访模型总数	
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
	 * Name:查询随访模型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访模型列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核随访模型	
	 * Params:
	 *		followModel :随访模型实例		
	 */	
	public Boolean review(FollowModel  followModel ) throws Exception;	
	
}