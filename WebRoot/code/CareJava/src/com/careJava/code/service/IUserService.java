package com.careJava.code.service;

import com.careJava.code.entry.User;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:用户表	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
public interface IUserService {	
	
    /**	
	 * Name:保存用户表	
	 * Params:	
	 *		user:用户表实例	
	 * Return:	
	 *		String:新增用户表ID	
	 */	
	public String add(User user) throws Exception;
	
	/**	
	 * Name:删除用户表	
	 * Params:	
	 *		id:用户表ID	
	 */	
	public void remove(User user) throws Exception;
	
	/**	
	 * Name:修改用户表	
	 * Params:	
	 *		user:用户表实例		
	 */	
	public User modify(User user) throws Exception;	
	
	/**	
	 * Name:查询用户表	
	 * Params:	
	 *		user:用户表	
	 * Return:	
	 *		User:用户表	
	 */	
	public User read(User user) throws Exception;
	
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
	 * Name:查询用户表列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:用户表列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核用户表	
	 * Params:
	 *		user:用户表实例		
	 */	
	public Boolean review(User user) throws Exception;	
	
}