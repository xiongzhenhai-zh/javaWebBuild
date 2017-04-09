package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.BabyFollowDetail;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:随访情况	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IBabyFollowDetailService {	
	
    /**	
	 * Name:保存随访情况	
	 * Params:	
	 *		babyFollowDetail:随访情况实例	
	 * Return:	
	 *		String:新增随访情况ID	
	 */	
	public String add(BabyFollowDetail babyFollowDetail) throws Exception;
	
	/**	
	 * Name:删除随访情况	
	 * Params:	
	 *		id:随访情况ID	
	 */	
	public void remove(BabyFollowDetail babyFollowDetail) throws Exception;
	
	/**	
	 * Name:修改随访情况	
	 * Params:	
	 *		babyFollowDetail:随访情况实例		
	 */	
	public BabyFollowDetail modify(BabyFollowDetail babyFollowDetail) throws Exception;	
	
	/**	
	 * Name:查询随访情况	
	 * Params:	
	 *		babyFollowDetail:随访情况	
	 * Return:	
	 *		BabyFollowDetail:随访情况	
	 */	
	public BabyFollowDetail read(BabyFollowDetail babyFollowDetail) throws Exception;
	
    /**	
	 * Name:查询随访情况列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<随访情况>:随访情况列表	
	 */	
	public List<BabyFollowDetail> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:随访情况数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:随访情况总数	
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
	 * Name:查询随访情况列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:随访情况列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}