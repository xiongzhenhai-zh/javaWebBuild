package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.FollowTemplate;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访模版	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IFollowTemplateDAO {	
	
    /**	
	 * Name:保存随访模版	
	 * Params:	
	 *		followTemplate:随访模版实例	
	 * Return:	
	 *		String:新增随访模版ID	
	 */	
	public String save(FollowTemplate followTemplate) throws Exception;
	
	/**	
	 * Name:删除随访模版	
	 * Params:	
	 *		id:随访模版ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访模版	
	 * Params:	
	 *		followTemplate:随访模版实例		
	 */	
	public void update(FollowTemplate followTemplate) throws Exception;	
	
	/**	
	 * Name:查询随访模版	
	 * Params:	
	 *		id:随访模版ID	
	 * Return:	
	 *		FollowTemplate:随访模版	
	 */	
	public FollowTemplate get(String id) throws Exception;
	
    /**	
	 * Name:查询随访模版列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访模版>:随访模版列表	
	 */	
	public List<FollowTemplate> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访模版数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访模版总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}