package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.FollowContent;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访内容	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowContentDAO {	
	
    /**	
	 * Name:保存随访内容	
	 * Params:	
	 *		followContent:随访内容实例	
	 * Return:	
	 *		String:新增随访内容ID	
	 */	
	public String save(FollowContent followContent) throws Exception;
	
	/**	
	 * Name:删除随访内容	
	 * Params:	
	 *		id:随访内容ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访内容	
	 * Params:	
	 *		followContent:随访内容实例		
	 */	
	public void update(FollowContent followContent) throws Exception;	
	
	/**	
	 * Name:查询随访内容	
	 * Params:	
	 *		id:随访内容ID	
	 * Return:	
	 *		FollowContent:随访内容	
	 */	
	public FollowContent get(String id) throws Exception;
	
    /**	
	 * Name:查询随访内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访内容>:随访内容列表	
	 */	
	public List<FollowContent> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访内容数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访内容总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}