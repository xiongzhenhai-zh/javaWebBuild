package com.carejava.core.entry;

import com.carejava.core.Util;
import com.google.gson.annotations.Expose;

public class ModelAttribute {

	private String id;

	@Expose
	private String name;

	@Expose
	private String alies;

	@Expose
	private String type;

	public ModelAttribute() {
		super();
	}

	public ModelAttribute(String id, String name, String alies, String type) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getUpName(){
		return Util.toUpperCaseFirstOne(this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAlies() {
		return alies;
	}

	public void setAlies(String alies) {
		this.alies = alies;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
