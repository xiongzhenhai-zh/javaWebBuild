package com.carejava.core;

import java.util.HashMap;
import java.util.Map;

import com.carejava.core.entry.Project;

public class BuildConfig {

	private Project project;
	
	public BuildConfig(Project project) {
		this.project = project;
	}

	public void init() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", project);
		
		/** 环境配置文件 */
		//HTTL.initFile(parameters, "config/classpath.httl", "WebRoot/code/"+project.getName()+"/.classpath");
		//HTTL.initFile(parameters, "config/classpath.httl", "WebRoot/code/"+project.getName()+"/.classpath");
		//HTTL.initFile(parameters, "config/mymetadata.httl", "WebRoot/code/"+project.getName()+"/.mymetadata");
		//HTTL.initFile(parameters, "config/project.httl", "WebRoot/code/"+project.getName()+"/.project");
		HTTL.initFile(parameters, "config/build.xml.httl", "WebRoot/code/"+project.getName()+"/build.xml");
		
		/** 项目配置文件 */
		HTTL.initFile(parameters, "config/struts.xml.httl", "WebRoot/code/"+project.getName()+"/src/struts.xml");
		HTTL.initFile(parameters, "config/web.xml.httl", "WebRoot/code/"+project.getName()+"/WebRoot/WEB-INF/web.xml");
		HTTL.initFile(parameters, "config/applicationContext.xml.httl", "WebRoot/code/"+project.getName()+"/WebRoot/WEB-INF/applicationContext.xml");
	}

}
