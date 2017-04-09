package com.lechen.project.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class MyActionSupport extends ActionSupport {

	private static final long serialVersionUID = 1L;

	protected Map<String, Object> result = new HashMap<String, Object>();
	
	protected List<Map<String,String>> list;
	
	protected String callback;	
	
	protected int page;	
	
	protected int rows;	
	
	protected String sort;	
	
	protected String order;
	
	protected String userid;
	
	public Map<String, Object> getResult() {	
		return result;	
	}	
	
	public void setPage(int page) {	
		this.page = page;	
	}	
	
	public void setRows(int rows) {	
		this.rows = rows;	
	}	
	
	public void setSort(String sort) {	
		this.sort = sort;	
	}	
	
	public void setOrder(String order) {	
		this.order = order;	
	}	
	
	public void setCallback(String callback) {	
		this.callback = callback;	
	}	
	
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}
	
}