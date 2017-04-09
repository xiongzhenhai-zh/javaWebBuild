package com.lechen.project.service;

import com.lechen.project.entry.Auth;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:角色	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
public interface IAuthService {	
	
    /**	
	 * Name:保存角色	
	 * Params:	
	 *		auth:角色实例	
	 * Return:	
	 *		String:新增角色ID	
	 */	
	public String add(Auth auth) throws Exception;
	
	/**	
	 * Name:删除角色	
	 * Params:	
	 *		id:角色ID	
	 */	
	public void remove(Auth auth) throws Exception;
	
	/**	
	 * Name:修改角色	
	 * Params:	
	 *		auth:角色实例		
	 */	
	public Auth modify(Auth auth) throws Exception;	
	
	/**	
	 * Name:查询角色	
	 * Params:	
	 *		auth:角色	
	 * Return:	
	 *		Auth:角色	
	 */	
	public Auth read(Auth auth) throws Exception;
	
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
	
    /**	
	 * Name:查询角色列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:角色列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}