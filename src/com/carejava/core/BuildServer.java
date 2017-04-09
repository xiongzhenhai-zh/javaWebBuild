package com.carejava.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.carejava.core.entry.Function;
import com.carejava.core.entry.Model;
import com.carejava.core.entry.Project;

public class BuildServer {

	private Project project;
	
	public BuildServer(Project project) {
		this.project = project;
	}

	public void init() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("project", project);
		parameters.put("imports",new ArrayList<String>());
		parameters.put("props",new ArrayList<String>());
		parameters.put("methods",new ArrayList<String>());
		
		StringBuffer sb = new StringBuffer();
		sb.append("WebRoot/code/"+project.getName()+"/src/");
		for(String path:project.getPkgName().split("[.]")){
			sb.append(path);
			sb.append("/");
		}
		
		/** 生成实体 */
		for(Model model:project.getModels()){
			parameters.put("model", model);
			HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/entry.httl", sb.toString()+"/entry/"+model.getName()+".java");
	//		HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/vo.httl", sb.toString()+"/vo/V"+model.getName()+".java");
		}

	//	HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/vo_list_result.httl", sb.toString()+"/vo/VListResult.java");
		
		/** 生成持久层+业务层+控制层  */
		HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/action_support.httl", sb.toString()+"/util/BBcareAction.java");
		for(Model model:project.getModels()){
			for(Function function:model.getFunctions()){
				parameters.put("model", model);
				parameters.put("function", function);
				HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/idao.httl", sb.toString()+"/dao/I"+model.getName()+"DAO.java");
				HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/dao.httl", sb.toString()+"/dao/impl/"+model.getName()+"DAO.java");
				HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/iservice.httl", sb.toString()+"/service/I"+model.getName()+"Service.java");
				HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/service.httl", sb.toString()+"/service/impl/"+model.getName()+"Service.java");
				HTTL.initJava(parameters, "server/"+project.getServerFrame().getName()+"/action.httl", sb.toString()+"/action/"+model.getName()+"Action.java");
			}
		}
	}

}
