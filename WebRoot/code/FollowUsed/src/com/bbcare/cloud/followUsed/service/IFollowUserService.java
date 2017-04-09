package com.bbcare.cloud.followUsed.service;

import com.bbcare.cloud.followUsed.entry.FollowUser;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访用户	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IFollowUserService {	
	
    /**	
	 * Name:保存随访用户	
	 * Params:	
	 *		followUser:随访用户实例	
	 * Return:	
	 *		String:新增随访用户ID	
	 */	
	public String add(FollowUser followUser) throws Exception;
	
	/**	
	 * Name:删除随访用户	
	 * Params:	
	 *		id:随访用户ID	
	 */	
	public void remove(FollowUser followUser) throws Exception;
	
	/**	
	 * Name:修改随访用户	
	 * Params:	
	 *		followUser:随访用户实例		
	 */	
	public FollowUser modify(FollowUser followUser) throws Exception;	
	
	/**	
	 * Name:查询随访用户	
	 * Params:	
	 *		followUser:随访用户	
	 * Return:	
	 *		FollowUser:随访用户	
	 */	
	public FollowUser read(FollowUser followUser) throws Exception;
	
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
	 * Name:查询随访用户列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访用户列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核随访用户	
	 * Params:
	 *		followUser:随访用户实例		
	 */	
	public Boolean review(FollowUser followUser) throws Exception;	
	
}