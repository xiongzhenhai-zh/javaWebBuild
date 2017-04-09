package com.lechen.project.dao;

import com.lechen.project.entry.User;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:用户	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
public interface IUserDAO {	
	
    /**	
	 * Name:保存用户	
	 * Params:	
	 *		user:用户实例	
	 * Return:	
	 *		String:新增用户ID	
	 */	
	public String save(User user) throws Exception;
	
	/**	
	 * Name:删除用户	
	 * Params:	
	 *		id:用户ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改用户	
	 * Params:	
	 *		user:用户实例		
	 */	
	public void update(User user) throws Exception;	
	
	/**	
	 * Name:查询用户	
	 * Params:	
	 *		id:用户ID	
	 * Return:	
	 *		User:用户	
	 */	
	public User get(String id) throws Exception;
	
    /**	
	 * Name:查询用户列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<用户>:用户列表	
	 */	
	public List<User> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:用户数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:用户总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}