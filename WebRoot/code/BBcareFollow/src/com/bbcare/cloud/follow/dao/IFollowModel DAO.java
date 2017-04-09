package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.FollowModel ;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访模型	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowModel DAO {	
	
    /**	
	 * Name:保存随访模型	
	 * Params:	
	 *		followModel :随访模型实例	
	 * Return:	
	 *		String:新增随访模型ID	
	 */	
	public String save(FollowModel  followModel ) throws Exception;
	
	/**	
	 * Name:删除随访模型	
	 * Params:	
	 *		id:随访模型ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访模型	
	 * Params:	
	 *		followModel :随访模型实例		
	 */	
	public void update(FollowModel  followModel ) throws Exception;	
	
	/**	
	 * Name:查询随访模型	
	 * Params:	
	 *		id:随访模型ID	
	 * Return:	
	 *		FollowModel :随访模型	
	 */	
	public FollowModel  get(String id) throws Exception;
	
    /**	
	 * Name:查询随访模型列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访模型>:随访模型列表	
	 */	
	public List<FollowModel > list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访模型数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访模型总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}