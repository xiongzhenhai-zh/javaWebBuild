package com.carejava.core.entry;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Page {

	private String id;

	@Expose
	private String name;

	@Expose
	private String alies;

	@Expose
	private String template;

	@Expose
	private List<Panel> panels;

	public Page() {
		super();
	}

	public Page(String id, String name, String alies, String template) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
		this.template = template;
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

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<Panel> getPanels() {
		return panels;
	}

	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}

	public void addPanel(Panel panel) {
		if(panels==null){
			panels = new ArrayList<Panel>();
		}
		panels.add(panel);
	}
}
