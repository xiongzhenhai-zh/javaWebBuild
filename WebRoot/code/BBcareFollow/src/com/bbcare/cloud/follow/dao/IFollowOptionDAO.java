package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.FollowOption;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowOptionDAO {	
	
    /**	
	 * Name:保存随访选项	
	 * Params:	
	 *		followOption:随访选项实例	
	 * Return:	
	 *		String:新增随访选项ID	
	 */	
	public String save(FollowOption followOption) throws Exception;
	
	/**	
	 * Name:删除随访选项	
	 * Params:	
	 *		id:随访选项ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访选项	
	 * Params:	
	 *		followOption:随访选项实例		
	 */	
	public void update(FollowOption followOption) throws Exception;	
	
	/**	
	 * Name:查询随访选项	
	 * Params:	
	 *		id:随访选项ID	
	 * Return:	
	 *		FollowOption:随访选项	
	 */	
	public FollowOption get(String id) throws Exception;
	
    /**	
	 * Name:查询随访选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访选项>:随访选项列表	
	 */	
	public List<FollowOption> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访选项数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访选项总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}