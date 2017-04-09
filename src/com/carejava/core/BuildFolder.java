package com.carejava.core;

import com.carejava.core.entry.Project;

public class BuildFolder {

	private Project project;
	
	public BuildFolder(Project project){
		this.project = project;
	}
	
	public void init(){
		Util.removeFolder("WebRoot/code/"+project.getName()+"/");
		
		Util.createFolder("WebRoot/code/"+project.getName()+"/");
		
		Util.createFolder("WebRoot/code/"+project.getName()+"/src/");
		StringBuffer sb = new StringBuffer();
		sb.append("WebRoot/code/"+project.getName()+"/src/");
		for(String path:project.getPkgName().split("[.]")){
			sb.append(path);
			sb.append("/");
			Util.createFolder(sb.toString());
		}

		Util.createFolder(sb.toString()+"entry/");
		Util.createFolder(sb.toString()+"vo/");
		Util.createFolder(sb.toString()+"action/");
		Util.createFolder(sb.toString()+"service/");
		Util.createFolder(sb.toString()+"service/impl/");
		Util.createFolder(sb.toString()+"dao/");
		Util.createFolder(sb.toString()+"dao/impl/");
		Util.createFolder(sb.toString()+"util/");
		
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/page/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/page/nav/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/js/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/css/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/css/images/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/META-INF/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/WEB-INF/");
		Util.createFolder("WebRoot/code/"+project.getName()+"/WebRoot/WEB-INF/lib/");
	}
}
