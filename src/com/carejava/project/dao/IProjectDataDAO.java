package com.carejava.project.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

import com.carejava.project.entry.ProjectData;

/**
 * @name:项目数据	持久层接口
 * @author:	
 * @createTime: 2016-01-10 19:30:30
 */	
	
public interface IProjectDataDAO {	
	
    /**	
	 * Name:保存项目数据	
	 * Params:	
	 *		projectData:项目数据实例	
	 * Return:	
	 *		String:新增项目数据ID	
	 */	
	public String save(ProjectData projectData) throws Exception;
	
	/**	
	 * Name:删除项目数据	
	 * Params:	
	 *		id:项目数据ID	
	 */	
	public void delete(String id) throws Exception;
	/**	
	 * Name:修改项目数据	
	 * Params:	
	 *		projectData:项目数据实例		
	 */	
	public void update(ProjectData projectData) throws Exception;	
	
	/**	
	 * Name:查询项目数据	
	 * Params:	
	 *		id:项目数据ID	
	 * Return:	
	 *		ProjectData:项目数据	
	 */	
	public ProjectData get(String id) throws Exception;
	
    /**	
	 * Name:查询项目数据列表	
	 * Params:	
	 *		dc:离线查询器	
	 *		page:页码	
	 *		rows:每页行数	
	 * Return:	
	 *		List<项目数据>:项目数据列表	
	 */	
	public List<ProjectData> list(DetachedCriteria dc,int page,int rows) throws Exception;
	
	/**	
	 * Name:项目数据数量查询	
	 * Params:	
	 *		dc:离线查询器	
	 * Return:	
	 *		Long:项目数据总数	
	 */	
	public Long getSize(DetachedCriteria dc) throws Exception;	
	
}