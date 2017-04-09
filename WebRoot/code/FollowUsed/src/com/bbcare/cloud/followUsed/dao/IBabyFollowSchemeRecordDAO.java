package com.bbcare.cloud.followUsed.dao;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:会员随访记录	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeRecordDAO {	
	
    /**	
	 * Name:保存会员随访记录	
	 * Params:	
	 *		babyFollowSchemeRecord:会员随访记录实例	
	 * Return:	
	 *		String:新增会员随访记录ID	
	 */	
	public String save(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;
	
	/**	
	 * Name:删除会员随访记录	
	 * Params:	
	 *		id:会员随访记录ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改会员随访记录	
	 * Params:	
	 *		babyFollowSchemeRecord:会员随访记录实例		
	 */	
	public void update(BabyFollowSchemeRecord babyFollowSchemeRecord) throws Exception;	
	
	/**	
	 * Name:查询会员随访记录	
	 * Params:	
	 *		id:会员随访记录ID	
	 * Return:	
	 *		BabyFollowSchemeRecord:会员随访记录	
	 */	
	public BabyFollowSchemeRecord get(String id) throws Exception;
	
    /**	
	 * Name:查询会员随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<会员随访记录>:会员随访记录列表	
	 */	
	public List<BabyFollowSchemeRecord> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:会员随访记录数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:会员随访记录总数	
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