package com.carejava.project.action;

import java.util.Map;

import com.carejava.core.entry.Project;
import com.carejava.core.test.XzhTest;
import com.carejava.project.entry.ProjectData;
import com.carejava.project.service.IProjectDataService;
import com.carejava.project.util.MyActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.DetachedCriteria;

/**
 * @name:项目数据控制层实现
 * @author:	
 * @createTime: 2016-01-10 19:30:30
 */	

@Controller	
@ParentPackage("base")	
@SuppressWarnings("unused")	
@Results({	
	@Result(name = "json",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "list",type="json", params={"root","list","callbackParameter","callback",
		"excludeProperties",""}),	
	@Result(name = "tree",type="json", params={"root","result","callbackParameter","callback",
		"excludeProperties",""})	
})
public class ProjectDataAction extends MyActionSupport implements ModelDriven<ProjectData> {	
	
	private static final long serialVersionUID = 1L;	
	
	private ProjectData projectData;	
	
	@Autowired	
	private IProjectDataService projectDataService;
	
    @Action("/private/projectData/add")	
	public String add() throws Exception {
		String id = projectDataService.add(projectData);
	//	String data="{\"Model\":[{\"modelName\":\"User\",\"Attribute\":[{\"attributeName\":\"name\",\"name\":\"名字\",\"type\":\"Strng\"}],\"OneToMany\":[{\"many\":\"\"},{\"many\":\"\"},{\"many\":\"\"}],\"ManyToOne\":[{\"one\":\"\"},{\"one\":\"\"},{\"one\":\"\"}]},{\"modelName\":\"User\",\"Attribute\":[{\"attributeName\":\"name\",\"name\":\"名字\",\"type\":\"Strng\"}],\"OneToMany\":[{\"many\":\"\"},{\"many\":\"\"},{\"many\":\"\"}],\"ManyToOne\":[{\"one\":\"\"},{\"one\":\"\"},{\"one\":\"\"}]},{\"modelName\":\"User\",\"Attribute\":[{\"attributeName\":\"name\",\"name\":\"名字\",\"type\":\"Strng\"}],\"OneToMany\":[{\"many\":\"\"},{\"many\":\"\"},{\"many\":\"\"}],\"ManyToOne\":[{\"one\":\"\"},{\"one\":\"\"},{\"one\":\"\"}]}]}";
	//	projectData.setJson(data);
		System.out.println(projectData.getJson());
		Project project = XzhTest.getProject(projectData.getProjectName(),projectData.getJson());
		result.put("success", true);	
		result.put("id", id);
		return "json";
	}	
    
    @Action("/private/projectData/test")	
	public String test() throws Exception {
    	ProjectData temProjectData = projectDataService.read(projectData);
		System.out.println(projectData.getJson());
		Project project = XzhTest.getProject(projectData.getProjectName(),projectData.getJson());
		result.put("success", true);	
		return "json";
	}	
	
	@Action("/private/projectData/remove")	
	public String remove() throws Exception {	
		projectDataService.remove(projectData);	
		result.put("success", true);	
		return "json";	
	}	
	
    @Action("/private/projectData/modify")	
	public String modify() throws Exception {
		ProjectData data = projectDataService.modify(projectData);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}
	
    @Action("/private/projectData/read")	
	public String read() throws Exception {	
		ProjectData data = projectDataService.read(projectData);	
		result.put("success", true);	
		result.put("data", data);	
		return "json";	
	}	
	
    @Action("/private/projectData/list")	
	public String list() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ProjectData.class);
		dc.addOrder(Order.desc("id"));
		if(projectData.getJson()!=null){
			dc.add(Restrictions.like("cszk",projectData.getJson(),MatchMode.ANYWHERE));
		}
		if(projectData.getProjectName()!=null){
			dc.add(Restrictions.like("cszk",projectData.getProjectName(),MatchMode.ANYWHERE));
		}
		
		Long size = projectDataService.getSize(dc);
		List<ProjectData> list = projectDataService.list(dc, page, rows);
		
		result.put("success", true);
		result.put("total", size);
		result.put("rows", list);
		return "json";	
	}
	
    @Action("/private/projectData/combo")	
	public String combo() throws Exception {	
		DetachedCriteria dc = DetachedCriteria.forClass(ProjectData.class);
		if(projectData.getJson()!=null){
			dc.add(Restrictions.like("cszk",projectData.getJson(),MatchMode.ANYWHERE));
		}
		
		list = projectDataService.combo(dc, page, rows);
		return "list";	
	}
	
	
	@Override
	public ProjectData getModel() {
		if(projectData==null){
			projectData = new ProjectData();
		}
		return projectData;
	}
}