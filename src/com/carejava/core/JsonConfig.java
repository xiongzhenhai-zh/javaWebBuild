package com.carejava.core;

import java.lang.reflect.Type;

import com.carejava.core.entry.Project;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonConfig {

	private Project project;
	
	private int version;
	
	public JsonConfig(Project project,int version,String versionName){
		this.project = project;
		this.version = version;
	}

	public void build() {
		/**
		JsonObject projectObj = new JsonObject();
		projectObj.addProperty("name", project.getName());
		projectObj.addProperty("alies", project.getAlies());
		projectObj.addProperty("serverFrame", project.getServerFrame().getName());
		projectObj.addProperty("clientFrame", project.getClientFrame().getName());
		projectObj.addProperty("mobileFrame", project.getMobileFrame().getName());
		projectObj.addProperty("pkgName", project.getPkgName());
		projectObj.addProperty("versionCode", version);
		projectObj.addProperty("versionName", versionName);
		projectObj.addProperty("createTime", new Date().toLocaleString());
		projectObj.addProperty("author", project.getAuthor());
		
		JsonObject dataSourceObj = new JsonObject();
		dataSourceObj.addProperty("name", project.getDataSource().getName());
		dataSourceObj.addProperty("type", project.getDataSource().getType());
		dataSourceObj.addProperty("url", project.getDataSource().getUrl());
		dataSourceObj.addProperty("username", project.getDataSource().getUsername());
		dataSourceObj.addProperty("password", project.getDataSource().getPassword());
		projectObj.add("dataSource", dataSourceObj);
		*/
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Type type = new TypeToken<Project>(){}.getType();
		Util.createFile("src/com/lechen/core/test/", "config_v"+version+".json",Util.jsonFormatter(gson.toJson(project, type)));
	}
	
	
}
