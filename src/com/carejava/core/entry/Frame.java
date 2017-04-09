package com.carejava.core.entry;

public class Frame {

	private String id;
	
	private String name;
	
	private String alies;

	public Frame() {
		super();
	}

	public Frame(String id, String name, String alies) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getAlies() {
		return alies;
	}

	public void setAlies(String alies) {
		this.alies = alies;
	}
	
}
