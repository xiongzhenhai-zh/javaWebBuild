package com.carejava.core;

import java.io.IOException;

import com.carejava.core.entry.Project;

public class BuildResouce {

	private Project project;
	
	public BuildResouce(Project project) {
		this.project = project;
	}

	public void init() {
		try {
			Util.copyFolder("WebRoot/resource/"+project.getClientFrame().getName()+"/", "WebRoot/code/"+project.getName()+"/WebRoot/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
