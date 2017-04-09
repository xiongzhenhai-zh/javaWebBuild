package com.bbcare.cloud.followConfig.dao;

import com.bbcare.cloud.followConfig.entry.LehuiMuRuRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:乐慧母乳调查临时	持久层接口
 * @author:	
 * @createTime: 2016-12-15 18:28:17
 */	
	
public interface ILehuiMuRuRecordDAO {	
	
    /**	
	 * Name:保存乐慧母乳调查临时	
	 * Params:	
	 *		lehuiMuRuRecord:乐慧母乳调查临时实例	
	 * Return:	
	 *		String:新增乐慧母乳调查临时ID	
	 */	
	public String save(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;
	
	/**	
	 * Name:删除乐慧母乳调查临时	
	 * Params:	
	 *		id:乐慧母乳调查临时ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改乐慧母乳调查临时	
	 * Params:	
	 *		lehuiMuRuRecord:乐慧母乳调查临时实例		
	 */	
	public void update(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;	
	
	/**	
	 * Name:查询乐慧母乳调查临时	
	 * Params:	
	 *		id:乐慧母乳调查临时ID	
	 * Return:	
	 *		LehuiMuRuRecord:乐慧母乳调查临时	
	 */	
	public LehuiMuRuRecord get(String id) throws Exception;
	
    /**	
	 * Name:查询乐慧母乳调查临时列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<乐慧母乳调查临时>:乐慧母乳调查临时列表	
	 */	
	public List<LehuiMuRuRecord> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:乐慧母乳调查临时数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:乐慧母乳调查临时总数	
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
	 * Name:根据sql返回List<Map>
	 * @param hql
	 * @param value
	 * @param rows 
	 * @param page 
	 * @return
	 * @throws Exception
	 */
	public List querySQLMap(final String sql,final Map<String, Object> value,final int page,final int rows)  throws Exception
	
	public List querySQL(final String sql,final Map<String, Object> value,final int page,final int rows) throws Exception;
	
	public int queryUpdateSQL( final String sql)throws Exception;
	
}