package com.bbcare.cloud.followConfig.dao;

import com.bbcare.cloud.followConfig.entry.FollowQuestionnaireVersion;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:随访问卷版本	持久层接口
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
public interface IFollowQuestionnaireVersionDAO {	
	
    /**	
	 * Name:保存随访问卷版本	
	 * Params:	
	 *		followQuestionnaireVersion:随访问卷版本实例	
	 * Return:	
	 *		String:新增随访问卷版本ID	
	 */	
	public String save(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception;
	
	/**	
	 * Name:删除随访问卷版本	
	 * Params:	
	 *		id:随访问卷版本ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改随访问卷版本	
	 * Params:	
	 *		followQuestionnaireVersion:随访问卷版本实例		
	 */	
	public void update(FollowQuestionnaireVersion followQuestionnaireVersion) throws Exception;	
	
	/**	
	 * Name:查询随访问卷版本	
	 * Params:	
	 *		id:随访问卷版本ID	
	 * Return:	
	 *		FollowQuestionnaireVersion:随访问卷版本	
	 */	
	public FollowQuestionnaireVersion get(String id) throws Exception;
	
    /**	
	 * Name:查询随访问卷版本列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访问卷版本>:随访问卷版本列表	
	 */	
	public List<FollowQuestionnaireVersion> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访问卷版本数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访问卷版本总数	
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