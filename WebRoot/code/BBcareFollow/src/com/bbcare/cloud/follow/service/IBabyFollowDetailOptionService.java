package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.BabyFollowDetailOption;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:宝宝随访详情选项	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IBabyFollowDetailOptionService {	
	
    /**	
	 * Name:保存宝宝随访详情选项	
	 * Params:	
	 *		babyFollowDetailOption:宝宝随访详情选项实例	
	 * Return:	
	 *		String:新增宝宝随访详情选项ID	
	 */	
	public String add(BabyFollowDetailOption babyFollowDetailOption) throws Exception;
	
	/**	
	 * Name:删除宝宝随访详情选项	
	 * Params:	
	 *		id:宝宝随访详情选项ID	
	 */	
	public void remove(BabyFollowDetailOption babyFollowDetailOption) throws Exception;
	
	/**	
	 * Name:修改宝宝随访详情选项	
	 * Params:	
	 *		babyFollowDetailOption:宝宝随访详情选项实例		
	 */	
	public BabyFollowDetailOption modify(BabyFollowDetailOption babyFollowDetailOption) throws Exception;	
	
	/**	
	 * Name:查询宝宝随访详情选项	
	 * Params:	
	 *		babyFollowDetailOption:宝宝随访详情选项	
	 * Return:	
	 *		BabyFollowDetailOption:宝宝随访详情选项	
	 */	
	public BabyFollowDetailOption read(BabyFollowDetailOption babyFollowDetailOption) throws Exception;
	
    /**	
	 * Name:查询宝宝随访详情选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<宝宝随访详情选项>:宝宝随访详情选项列表	
	 */	
	public List<BabyFollowDetailOption> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:宝宝随访详情选项数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:宝宝随访详情选项总数	
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
	 * Name:查询宝宝随访详情选项列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:宝宝随访详情选项列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}