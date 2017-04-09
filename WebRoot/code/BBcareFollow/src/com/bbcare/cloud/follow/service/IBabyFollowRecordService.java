package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.BabyFollowRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访记录	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IBabyFollowRecordService {	
	
    /**	
	 * Name:保存随访记录	
	 * Params:	
	 *		babyFollowRecord:随访记录实例	
	 * Return:	
	 *		String:新增随访记录ID	
	 */	
	public String add(BabyFollowRecord babyFollowRecord) throws Exception;
	
	/**	
	 * Name:删除随访记录	
	 * Params:	
	 *		id:随访记录ID	
	 */	
	public void remove(BabyFollowRecord babyFollowRecord) throws Exception;
	
	/**	
	 * Name:修改随访记录	
	 * Params:	
	 *		babyFollowRecord:随访记录实例		
	 */	
	public BabyFollowRecord modify(BabyFollowRecord babyFollowRecord) throws Exception;	
	
	/**	
	 * Name:查询随访记录	
	 * Params:	
	 *		babyFollowRecord:随访记录	
	 * Return:	
	 *		BabyFollowRecord:随访记录	
	 */	
	public BabyFollowRecord read(BabyFollowRecord babyFollowRecord) throws Exception;
	
    /**	
	 * Name:查询随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访记录>:随访记录列表	
	 */	
	public List<BabyFollowRecord> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访记录数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访记录总数	
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
	
    /**	
	 * Name:查询随访记录列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访记录列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}