package com.carejava.core.entry;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Function {

	private String id;

	@Expose
	private String name;

	@Expose
	private String alies;

	@Expose
	private int level;
	
	public Function() {
		super();
	}

	//private List<Store> stores;
	
	private List<ModelAttribute> outputs;
	
	private List<ModelAttribute> inputs;
	
	private List<FilterAttribute> filters;

	public Function(String id, String name, String alies, int level) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
		this.level = level;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<ModelAttribute> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<ModelAttribute> outputs) {
		this.outputs = outputs;
	}

	public List<ModelAttribute> getInputs() {
		return inputs;
	}

	public void setInputs(List<ModelAttribute> inputs) {
		this.inputs = inputs;
	}

	public List<FilterAttribute> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterAttribute> filters) {
		this.filters = filters;
	}
	
	public void addOutput(ModelAttribute output) {
		if(outputs==null){
			outputs = new ArrayList<ModelAttribute>();
		}
		outputs.add(output);
	}
	
	public void addInput(ModelAttribute input) {
		if(inputs==null){
			inputs = new ArrayList<ModelAttribute>();
		}
		inputs.add(input);
	}

	public void addFilter(FilterAttribute filter) {
		if(filters==null){
			filters = new ArrayList<FilterAttribute>();
		}
		filters.add(filter);
	}
}
