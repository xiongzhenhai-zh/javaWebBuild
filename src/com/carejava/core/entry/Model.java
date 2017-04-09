package com.carejava.core.entry;

import java.util.ArrayList;
import java.util.List;

import com.carejava.core.Util;
import com.google.gson.annotations.Expose;

public class Model {

	private String id;

	@Expose
	private String name;

	@Expose
	private String alies;

	@Expose
	private String idType;

	@Expose
	private List<ModelAttribute> attributes;

	@Expose
	private List<Function> functions;

	@Expose
	private List<Relation> relations;
	
	public Model() {
		super();
		attributes = new ArrayList<ModelAttribute>();
		functions = new ArrayList<Function>();
		relations = new ArrayList<Relation>();
	}

	public Model(String id, String name, String alies, String idType,Project project) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
		this.idType = idType;
		attributes = new ArrayList<ModelAttribute>();
		functions = new ArrayList<Function>();
		relations = new ArrayList<Relation>();
	}

	public void addAttribute(ModelAttribute attr) {
		if(attributes==null){
			attributes = new ArrayList<ModelAttribute>();
		}
		attributes.add(attr);
	}

	public void addRelation(Relation relation) {
		if(relations==null){
			relations = new ArrayList<Relation>();
		}
		relations.add(relation);
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
	
	public String getLowName(){
		return Util.toLowerCaseFirstOne(this.name);
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

	public List<ModelAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ModelAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

}
