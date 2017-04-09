package com.carejava.core;

import com.carejava.core.entry.Project;

public class Build {

	private Project project;
	
	public Build(Project project){
		this.project = project;
	}
	
	public void init(){
		initFolder();
		initConfig();
		initResouce();
		initServer();
		initClient();
	}
	
	private void initFolder(){
		BuildFolder bf = new BuildFolder(project);
		bf.init();
	}
	
	private void initConfig(){
		BuildConfig bc = new BuildConfig(project);
		bc.init();
	}
	
	private void initResouce(){
		BuildResouce br = new BuildResouce(project);
		br.init();
	}
	
	private void initServer(){
		BuildServer bs = new BuildServer(project);
		bs.init();
	}
	
	private void initClient(){
		BuildClient bc = new BuildClient(project);
		bc.init();
	}
}
