package com.carejava.core.model;

import java.util.ArrayList;
import java.util.List;

public class Property {

	private Long id;
	
	private String name;
	
	private String cnName;
	
	private String type;
	
	private String defaultValue;
	
	private List<String> annotations = new ArrayList<String>();
	
	private boolean pblc = false;
	
	private boolean sttc = false;

	public Property(String name, String cnName, String type) {
		super();
		this.name = name;
		this.cnName = cnName;
		this.type = type;
	}

	public Property(String name, String cnName, String type, boolean pblc,
			boolean sttc) {
		super();
		this.name = name;
		this.cnName = cnName;
		this.type = type;
		this.pblc = pblc;
		this.sttc = sttc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public List<String> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}

	public boolean isPblc() {
		return pblc;
	}

	public void setPblc(boolean pblc) {
		this.pblc = pblc;
	}

	public boolean isSttc() {
		return sttc;
	}

	public void setSttc(boolean sttc) {
		this.sttc = sttc;
	}
	
	public void addAnnotation(String annotation){
		this.annotations.add(annotation);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(null!=this.cnName){
			sb.append("	");
			sb.append("//");
			sb.append(this.cnName);
			sb.append("\t\n");
		}
		for(String name:this.annotations){
			sb.append("	");
			sb.append(name);
			sb.append("\t\n");
		}
		sb.append("	");
		if(this.pblc){
			sb.append("public ");
		}else{
			sb.append("private ");
		}
		if(this.sttc){
			sb.append("static ");
		}
		sb.append(this.type);
		sb.append(" ");
		sb.append(this.name);
		if(null!=this.defaultValue){
			sb.append(" = ");
			sb.append(this.defaultValue);
		}
		sb.append(";");
		sb.append("\t\n\t\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Property prop = (Property) obj;
		if(this.name.equals(prop.name)){
			return true;
		}else{
			return false;
		}
	}
}
