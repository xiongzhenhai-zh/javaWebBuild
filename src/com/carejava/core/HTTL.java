package com.carejava.core;

import httl.Engine;
import httl.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class HTTL {

	public static void initFile(Map<String, Object> parameters,String httlPath,String filePath){
		try {
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			Properties properties = new Properties();
			properties.setProperty("import.packages", "com.lechen.core.entry");
			properties.setProperty("template.directory", "com/lechen/templates");
			properties.setProperty("compiler", "httl.spi.compilers.JavassistCompiler");
			properties.setProperty("input.encoding", "UTF-8");
			properties.setProperty("output.encoding", "UTF-8");
			Engine engine = Engine.getEngine("file", properties); 
			Template template = engine.getTemplate(httlPath);
			template.render(parameters, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initJava(Map<String, Object> parameters,String httlPath,String filePath){
		try {
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			Properties properties = new Properties();
			properties.setProperty("import.packages", "com.lechen.core.entry");
			properties.setProperty("template.directory", "com/lechen/templates");
			properties.setProperty("compiler", "httl.spi.compilers.JavassistCompiler");
			properties.setProperty("input.encoding", "UTF-8");
			properties.setProperty("output.encoding", "UTF-8");
			Engine engine = Engine.getEngine("java", properties); 
			Template template = engine.getTemplate(httlPath);
			template.render(parameters, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
