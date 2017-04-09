package com.carejava.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carejava.project.dao.IProjectDataDAO;
import com.carejava.project.entry.ProjectData;
import com.carejava.project.service.IProjectDataService;

/**
 * @name:项目数据	持久层接口
 * @author:	
 * @createTime: 2016-01-10 19:30:30
 */	
	
@Service
public class ProjectDataService implements IProjectDataService {
	
	@Autowired
	private IProjectDataDAO projectDataDAO;	
	
    public String add(ProjectData projectData) throws Exception {
    	ProjectData tempProjectData = new ProjectData();
		tempProjectData.setJson(projectData.getJson());
		tempProjectData.setProjectName(projectData.getProjectName());
		tempProjectData.setCreateTime(new Date());
		return projectDataDAO.save(tempProjectData);	
	}
	
    public void remove(ProjectData projectData) throws Exception {	
		projectDataDAO.delete(projectData.getId());	
	}
	
    public ProjectData modify(ProjectData projectData) throws Exception {	
		ProjectData tempProjectData = projectDataDAO.get(projectData.getId());
		
		if(projectData.getJson()!=null){
			tempProjectData.setJson(projectData.getJson());
		}
		if(projectData.getProjectName()!=null){
			tempProjectData.setProjectName(projectData.getProjectName());
		}
		projectDataDAO.update(tempProjectData);	
		return tempProjectData;	
	}
	
    public ProjectData read(ProjectData projectData) throws Exception {	
		return projectDataDAO.get(projectData.getId());	
	}	
	
    public List<ProjectData> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return projectDataDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return projectDataDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<ProjectData> projectDatas = projectDataDAO.list(dc, page, rows);
		for(ProjectData projectData:projectDatas){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",projectData.getId());
			obj.put("text",projectData.getId());
			list.add(obj);
		}
		return list;	
	}	
	
}