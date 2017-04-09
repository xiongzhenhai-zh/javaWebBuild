package com.carejava.core.entry;

import com.carejava.core.Util;
import com.google.gson.annotations.Expose;

public class Relation {

	private String id;

	@Expose
	private String name;

	@Expose
	private String type;
	
	//1:主，2，附
	@Expose
	private int position;

	@Expose
	private String cascade;

	@Expose
	private String fetch;

	private Model model;

	private Relation relation;

	public Relation() {
		super();
	}

	public Relation(String id,String name, String type, Model model) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.model = model;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getCascade() {
		return cascade;
	}

	public void setCascade(String cascade) {
		this.cascade = cascade;
	}

	public String getFetch() {
		return fetch;
	}

	public void setFetch(String fetch) {
		this.fetch = fetch;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
}
