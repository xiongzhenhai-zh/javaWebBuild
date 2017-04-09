package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.DoctorFollowDecord ;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:医生归档档案	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IDoctorFollowDecord Service {	
	
    /**	
	 * Name:保存医生归档档案	
	 * Params:	
	 *		doctorFollowDecord :医生归档档案实例	
	 * Return:	
	 *		String:新增医生归档档案ID	
	 */	
	public String add(DoctorFollowDecord  doctorFollowDecord ) throws Exception;
	
	/**	
	 * Name:删除医生归档档案	
	 * Params:	
	 *		id:医生归档档案ID	
	 */	
	public void remove(DoctorFollowDecord  doctorFollowDecord ) throws Exception;
	
	/**	
	 * Name:修改医生归档档案	
	 * Params:	
	 *		doctorFollowDecord :医生归档档案实例		
	 */	
	public DoctorFollowDecord  modify(DoctorFollowDecord  doctorFollowDecord ) throws Exception;	
	
	/**	
	 * Name:查询医生归档档案	
	 * Params:	
	 *		doctorFollowDecord :医生归档档案	
	 * Return:	
	 *		DoctorFollowDecord :医生归档档案	
	 */	
	public DoctorFollowDecord  read(DoctorFollowDecord  doctorFollowDecord ) throws Exception;
	
    /**	
	 * Name:查询医生归档档案列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<医生归档档案>:医生归档档案列表	
	 */	
	public List<DoctorFollowDecord > list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:医生归档档案数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:医生归档档案总数	
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
	 * Name:查询医生归档档案列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:医生归档档案列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:审核医生归档档案	
	 * Params:
	 *		doctorFollowDecord :医生归档档案实例		
	 */	
	public Boolean review(DoctorFollowDecord  doctorFollowDecord ) throws Exception;	
	
}