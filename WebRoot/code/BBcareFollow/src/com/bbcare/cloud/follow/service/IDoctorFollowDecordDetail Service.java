package com.bbcare.cloud.follow.service;

import com.bbcare.cloud.follow.entry.DoctorFollowDecordDetail ;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Map;

/**
 * @name:医生归档详情	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface IDoctorFollowDecordDetail Service {	
	
    /**	
	 * Name:保存医生归档详情	
	 * Params:	
	 *		doctorFollowDecordDetail :医生归档详情实例	
	 * Return:	
	 *		String:新增医生归档详情ID	
	 */	
	public String add(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception;
	
	/**	
	 * Name:删除医生归档详情	
	 * Params:	
	 *		id:医生归档详情ID	
	 */	
	public void remove(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception;
	
	/**	
	 * Name:修改医生归档详情	
	 * Params:	
	 *		doctorFollowDecordDetail :医生归档详情实例		
	 */	
	public DoctorFollowDecordDetail  modify(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception;	
	
	/**	
	 * Name:查询医生归档详情	
	 * Params:	
	 *		doctorFollowDecordDetail :医生归档详情	
	 * Return:	
	 *		DoctorFollowDecordDetail :医生归档详情	
	 */	
	public DoctorFollowDecordDetail  read(DoctorFollowDecordDetail  doctorFollowDecordDetail ) throws Exception;
	
    /**	
	 * Name:查询医生归档详情列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<医生归档详情>:医生归档详情列表	
	 */	
	public List<DoctorFollowDecordDetail > list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:医生归档详情数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:医生归档详情总数	
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
	 * Name:查询医生归档详情列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<Map<String,String>>:医生归档详情列表	
	 */
	public List<Map<String,String>> combo(DetachedCriteria dc,int page,int rows) throws Exception;
	
}