package com.carejava.core.entry;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Project {
	
	private String id;
	
	@Expose
	private String name;

	@Expose
	private String alies;

	@Expose
	private Frame serverFrame;

	@Expose
	private Frame clientFrame;

	@Expose
	private Frame mobileFrame;

	@Expose
	private String pkgName;

	@Expose
	private String author;

	@Expose
	private DataSource dataSource;

	@Expose
	private List<Model> models;

	private List<Panel> panels;

	@Expose
	private List<Page> pages;

	@Expose
	private List<Role> roles;

	@Expose
	private List<User> user;

	@Expose
	private List<Navbar> navbars;

	public Project() {
		super();
	}

	public Project(String id, String name, String alies, Frame serverFrame,
			Frame clientFrame, Frame mobileFrame) {
		super();
		this.id = id;
		this.name = name;
		this.alies = alies;
		this.serverFrame = serverFrame;
		this.clientFrame = clientFrame;
		this.mobileFrame = mobileFrame;
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

	public Frame getServerFrame() {
		return serverFrame;
	}

	public void setServerFrame(Frame serverFrame) {
		this.serverFrame = serverFrame;
	}

	public Frame getClientFrame() {
		return clientFrame;
	}

	public void setClientFrame(Frame clientFrame) {
		this.clientFrame = clientFrame;
	}

	public Frame getMobileFrame() {
		return mobileFrame;
	}

	public void setMobileFrame(Frame mobileFrame) {
		this.mobileFrame = mobileFrame;
	}

	public List<Model> getModels() {
		return models;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public List<Panel> getPanels() {
		return panels;
	}

	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}

	public List<Page> getPages() {
		return pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Navbar> getNavbars() {
		return navbars;
	}

	public void setNavbars(List<Navbar> navbars) {
		this.navbars = navbars;
	}
	
}
