package com.bbcare.cloud.followScheme.service;

import com.bbcare.cloud.followScheme.entry.FollowQueue;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访队列	持久层接口
 * @author:	
 * @createTime: 2016-11-15 10:46:05
 */	
	
public interface IFollowQueueService {	
	
    /**	
	 * Name:保存随访队列	
	 * Params:	
	 *		followQueue:随访队列实例	
	 * Return:	
	 *		String:新增随访队列ID	
	 */	
	public String add(FollowQueue followQueue) throws Exception;
	
	/**	
	 * Name:删除随访队列	
	 * Params:	
	 *		id:随访队列ID	
	 */	
	public void remove(FollowQueue followQueue) throws Exception;
	
	/**	
	 * Name:修改随访队列	
	 * Params:	
	 *		followQueue:随访队列实例		
	 */	
	public FollowQueue modify(FollowQueue followQueue) throws Exception;	
	
	/**	
	 * Name:查询随访队列	
	 * Params:	
	 *		followQueue:随访队列	
	 * Return:	
	 *		FollowQueue:随访队列	
	 */	
	public FollowQueue read(FollowQueue followQueue) throws Exception;
	
    /**	
	 * Name:查询随访队列列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访队列>:随访队列列表	
	 */	
	public List<FollowQueue> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访队列数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访队列总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
    /**	
	 * Name:查询随访队列列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访队列列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核随访队列	
	 * Params:
	 *		followQueue:随访队列实例		
	 */	
	public Boolean review(FollowQueue followQueue) throws Exception;	
	
}