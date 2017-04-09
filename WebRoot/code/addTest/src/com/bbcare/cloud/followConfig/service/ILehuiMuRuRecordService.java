package com.bbcare.cloud.followConfig.service;

import com.bbcare.cloud.followConfig.entry.LehuiMuRuRecord;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:乐慧母乳调查临时	持久层接口
 * @author:	
 * @createTime: 2016-12-15 18:28:17
 */	
	
public interface ILehuiMuRuRecordService {	
	
    /**	
	 * Name:保存乐慧母乳调查临时	
	 * Params:	
	 *		lehuiMuRuRecord:乐慧母乳调查临时实例	
	 * Return:	
	 *		String:新增乐慧母乳调查临时ID	
	 */	
	public String add(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;
	
	/**	
	 * Name:删除乐慧母乳调查临时	
	 * Params:	
	 *		id:乐慧母乳调查临时ID	
	 */	
	public void remove(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;
	
	/**	
	 * Name:修改乐慧母乳调查临时	
	 * Params:	
	 *		lehuiMuRuRecord:乐慧母乳调查临时实例		
	 */	
	public LehuiMuRuRecord modify(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;	
	
	/**	
	 * Name:查询乐慧母乳调查临时	
	 * Params:	
	 *		lehuiMuRuRecord:乐慧母乳调查临时	
	 * Return:	
	 *		LehuiMuRuRecord:乐慧母乳调查临时	
	 */	
	public LehuiMuRuRecord read(LehuiMuRuRecord lehuiMuRuRecord) throws Exception;
	
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
	 * Name:查询乐慧母乳调查临时列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:乐慧母乳调查临时列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}