package com.careJava.code.dao;

import com.careJava.code.entry.User;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:用户表	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
public interface IUserDAO {	
	
    /**	
	 * Name:保存用户表	
	 * Params:	
	 *		user:用户表实例	
	 * Return:	
	 *		String:新增用户表ID	
	 */	
	public String save(User user) throws Exception;
	
	/**	
	 * Name:删除用户表	
	 * Params:	
	 *		id:用户表ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改用户表	
	 * Params:	
	 *		user:用户表实例		
	 */	
	public void update(User user) throws Exception;	
	
	/**	
	 * Name:查询用户表	
	 * Params:	
	 *		id:用户表ID	
	 * Return:	
	 *		User:用户表	
	 */	
	public User get(String id) throws Exception;
	
    /**	
	 * Name:查询用户表列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<用户表>:用户表列表	
	 */	
	public List<User> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:用户表数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:用户表总数	
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
	 * Name:根据sql返回List<Map>
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 * @throws Exception
	 */
	public List querySQLMap(final String sql,final Map<String, Object> value,final int page,final int rows)  throws Exception
	
	public List querySQL(final String sql,final Map<String, Object> value,final int page,final int rows) throws Exception;
	
	public int queryUpdateSQL( final String sql)throws Exception;
	
}