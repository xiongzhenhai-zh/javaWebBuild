package com.bbcare.cloud.followConfig.service;

import com.bbcare.cloud.followConfig.entry.FollowLibrary;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访库	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
public interface IFollowLibraryService {	
	
    /**	
	 * Name:保存随访库	
	 * Params:	
	 *		followLibrary:随访库实例	
	 * Return:	
	 *		String:新增随访库ID	
	 */	
	public String add(FollowLibrary followLibrary) throws Exception;
	
	/**	
	 * Name:删除随访库	
	 * Params:	
	 *		id:随访库ID	
	 */	
	public void remove(FollowLibrary followLibrary) throws Exception;
	
	/**	
	 * Name:修改随访库	
	 * Params:	
	 *		followLibrary:随访库实例		
	 */	
	public FollowLibrary modify(FollowLibrary followLibrary) throws Exception;	
	
	/**	
	 * Name:查询随访库	
	 * Params:	
	 *		followLibrary:随访库	
	 * Return:	
	 *		FollowLibrary:随访库	
	 */	
	public FollowLibrary read(FollowLibrary followLibrary) throws Exception;
	
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
	 * Name:查询随访库列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访库列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}