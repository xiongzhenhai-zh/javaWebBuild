package com.bbcare.cloud.followUsed.dao;

import com.bbcare.cloud.followUsed.entry.BabyFollowSchemeRecordDetail;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:会员随访记录内容	持久层接口
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
public interface IBabyFollowSchemeRecordDetailDAO {	
	
    /**	
	 * Name:保存会员随访记录内容	
	 * Params:	
	 *		babyFollowSchemeRecordDetail:会员随访记录内容实例	
	 * Return:	
	 *		String:新增会员随访记录内容ID	
	 */	
	public String save(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception;
	
	/**	
	 * Name:删除会员随访记录内容	
	 * Params:	
	 *		id:会员随访记录内容ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改会员随访记录内容	
	 * Params:	
	 *		babyFollowSchemeRecordDetail:会员随访记录内容实例		
	 */	
	public void update(BabyFollowSchemeRecordDetail babyFollowSchemeRecordDetail) throws Exception;	
	
	/**	
	 * Name:查询会员随访记录内容	
	 * Params:	
	 *		id:会员随访记录内容ID	
	 * Return:	
	 *		BabyFollowSchemeRecordDetail:会员随访记录内容	
	 */	
	public BabyFollowSchemeRecordDetail get(String id) throws Exception;
	
    /**	
	 * Name:查询会员随访记录内容列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<会员随访记录内容>:会员随访记录内容列表	
	 */	
	public List<BabyFollowSchemeRecordDetail> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:会员随访记录内容数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:会员随访记录内容总数	
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