package com.carejava.core;

import java.util.HashMap;
import java.util.Map;

import com.carejava.core.entry.Navbar;
import com.carejava.core.entry.Page;
import com.carejava.core.entry.Project;

public class BuildClient {

	private Project project;
	
	public BuildClient(Project project) {
		this.project = project;
	}

	public void init() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", project);
		StringBuffer sb = new StringBuffer();
		sb.append("WebRoot/code/"+project.getName()+"/WebRoot/");

		/** 生成主页 */
		HTTL.initFile(parameters, "client/"+project.getClientFrame().getName()+"/page/home.httl", sb.toString()+"home.html");
		
		/** 生成业务页面 */
		sb.append("page/");
		for(Page page:project.getPages()){
			parameters.put("page", page);
			HTTL.initFile(parameters, "client/"+project.getClientFrame().getName()+"/page/"+page.getTemplate()+".httl", sb.toString()+page.getName()+".html");
		}

		/** 生成左栏导航页 */
		sb.append("nav/");
		for(Navbar navbar:project.getNavbars()){
			parameters.put("navbar", navbar);
			System.out.println("------------>>>"+sb.toString()+navbar.getName());
			HTTL.initFile(parameters, "client/"+project.getClientFrame().getName()+"/page/navbar.httl", sb.toString()+navbar.getName()+".html");
		}
		
	}

}
