package com.lechen.project.dao;

import com.lechen.project.entry.Auth;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:角色	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
public interface IAuthDAO {	
	
    /**	
	 * Name:保存角色	
	 * Params:	
	 *		auth:角色实例	
	 * Return:	
	 *		String:新增角色ID	
	 */	
	public String save(Auth auth) throws Exception;
	
	/**	
	 * Name:删除角色	
	 * Params:	
	 *		id:角色ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改角色	
	 * Params:	
	 *		auth:角色实例		
	 */	
	public void update(Auth auth) throws Exception;	
	
	/**	
	 * Name:查询角色	
	 * Params:	
	 *		id:角色ID	
	 * Return:	
	 *		Auth:角色	
	 */	
	public Auth get(String id) throws Exception;
	
    /**	
	 * Name:查询角色列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<角色>:角色列表	
	 */	
	public List<Auth> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:角色数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:角色总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}