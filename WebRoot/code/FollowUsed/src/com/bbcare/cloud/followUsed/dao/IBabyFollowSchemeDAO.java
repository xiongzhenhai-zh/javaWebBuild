package com.bbcare.cloud.followUsed.dao;

import com.bbcare.cloud.followUsed.entry.BabyFollowScheme;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:宝宝随访方案	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeDAO {	
	
    /**	
	 * Name:保存宝宝随访方案	
	 * Params:	
	 *		babyFollowScheme:宝宝随访方案实例	
	 * Return:	
	 *		String:新增宝宝随访方案ID	
	 */	
	public String save(BabyFollowScheme babyFollowScheme) throws Exception;
	
	/**	
	 * Name:删除宝宝随访方案	
	 * Params:	
	 *		id:宝宝随访方案ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改宝宝随访方案	
	 * Params:	
	 *		babyFollowScheme:宝宝随访方案实例		
	 */	
	public void update(BabyFollowScheme babyFollowScheme) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访方案	
	 * Params:	
	 *		id:宝宝随访方案ID	
	 * Return:	
	 *		BabyFollowScheme:宝宝随访方案	
	 */	
	public BabyFollowScheme get(String id) throws Exception;
	
    /**	
	 * Name:查询宝宝随访方案列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访方案>:宝宝随访方案列表	
	 */	
	public List<BabyFollowScheme> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访方案数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访方案总数	
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