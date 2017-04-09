package com.bbcare.cloud.follow.dao;

import com.bbcare.cloud.follow.entry.Trigger;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:触发器	持久层接口
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
public interface ITriggerDAO {	
	
    /**	
	 * Name:保存触发器	
	 * Params:	
	 *		trigger:触发器实例	
	 * Return:	
	 *		String:新增触发器ID	
	 */	
	public String save(Trigger trigger) throws Exception;
	
	/**	
	 * Name:删除触发器	
	 * Params:	
	 *		id:触发器ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改触发器	
	 * Params:	
	 *		trigger:触发器实例		
	 */	
	public void update(Trigger trigger) throws Exception;	
	
	/**	
	 * Name:查询触发器	
	 * Params:	
	 *		id:触发器ID	
	 * Return:	
	 *		Trigger:触发器	
	 */	
	public Trigger get(String id) throws Exception;
	
    /**	
	 * Name:查询触发器列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<触发器>:触发器列表	
	 */	
	public List<Trigger> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:触发器数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:触发器总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}