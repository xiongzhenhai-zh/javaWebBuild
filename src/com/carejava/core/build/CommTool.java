package com.carejava.core.build;

import com.carejava.core.Build;
import com.carejava.core.entry.Project;

public class CommTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Project project = TestConf.getProject();
		Build build = new Build(project);
		build.init();
	}
}