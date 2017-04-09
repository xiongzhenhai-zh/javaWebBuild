package com.bbcare.cloud.followConfig.dao;

import com.bbcare.cloud.followConfig.entry.FollowLibrary;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访库	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
public interface IFollowLibraryDAO {	
	
    /**	
	 * Name:保存随访库	
	 * Params:	
	 *		followLibrary:随访库实例	
	 * Return:	
	 *		String:新增随访库ID	
	 */	
	public String save(FollowLibrary followLibrary) throws Exception;
	
	/**	
	 * Name:删除随访库	
	 * Params:	
	 *		id:随访库ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访库	
	 * Params:	
	 *		followLibrary:随访库实例		
	 */	
	public void update(FollowLibrary followLibrary) throws Exception;	
	
	/**	
	 * Name:查询随访库	
	 * Params:	
	 *		id:随访库ID	
	 * Return:	
	 *		FollowLibrary:随访库	
	 */	
	public FollowLibrary get(String id) throws Exception;
	
    /**	
	 * Name:查询随访库列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访库>:随访库列表	
	 */	
	public List<FollowLibrary> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访库数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访库总数	
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
	
}