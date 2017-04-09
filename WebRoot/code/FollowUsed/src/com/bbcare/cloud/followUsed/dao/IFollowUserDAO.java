package com.bbcare.cloud.followUsed.dao;

import com.bbcare.cloud.followUsed.entry.FollowUser;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访用户	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IFollowUserDAO {	
	
    /**	
	 * Name:保存随访用户	
	 * Params:	
	 *		followUser:随访用户实例	
	 * Return:	
	 *		String:新增随访用户ID	
	 */	
	public String save(FollowUser followUser) throws Exception;
	
	/**	
	 * Name:删除随访用户	
	 * Params:	
	 *		id:随访用户ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访用户	
	 * Params:	
	 *		followUser:随访用户实例		
	 */	
	public void update(FollowUser followUser) throws Exception;	
	
	/**	
	 * Name:查询随访用户	
	 * Params:	
	 *		id:随访用户ID	
	 * Return:	
	 *		FollowUser:随访用户	
	 */	
	public FollowUser get(String id) throws Exception;
	
    /**	
	 * Name:查询随访用户列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访用户>:随访用户列表	
	 */	
	public List<FollowUser> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访用户数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访用户总数	
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