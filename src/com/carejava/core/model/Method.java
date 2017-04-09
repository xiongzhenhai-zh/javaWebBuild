package com.carejava.core.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Method {

	private Long id;
	
	private String name;
	
	private String cnName;
	
	private String type;
	
	private String cnReturn;
	
	private int classType;
	
	private List<String> annotations = new ArrayList<String>();
	
	private LinkedHashMap<String,String> params = new LinkedHashMap<String,String>();
	
	private LinkedHashMap<String,String> cnParams = new LinkedHashMap<String,String>();
	
	private List<String> exceptions = new ArrayList<String>();
	
	private String context;
	
	private boolean pblc = true;
	
	private boolean sttc = false;

	public Method(String name, String type, String cnName) {
		super();
		this.name = name;
		this.cnName = cnName;
		this.type = type;
	}

	public Method(String name, String type, String cnName, boolean pblc,
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

	public String getCnReturn() {
		return cnReturn;
	}

	public List<String> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}

	public void setCnReturn(String cnReturn) {
		this.cnReturn = cnReturn;
	}

	public LinkedHashMap<String, String> getParams() {
		return params;
	}

	public void setParams(LinkedHashMap<String, String> params) {
		this.params = params;
	}

	public LinkedHashMap<String,String> getCnParams() {
		return cnParams;
	}

	public void setCnParams(LinkedHashMap<String,String> cnParams) {
		this.cnParams = cnParams;
	}

	public List<String> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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
	
	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
	}

	public void addException(String name){
		this.exceptions.add(name);
	}
	
	public void addParam(String name,String cnName,String type){
		this.params.put(name, type);
		this.cnParams.put(name,cnName);
	}
	
	public void addAnnotation(String annotation){
		this.annotations.add(annotation);
	}
	
	public void removeParam(String name){
		this.params.remove(name);
		this.cnParams.remove(name);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(null!=this.cnName){
			sb.append("	/**\t\n");
			sb.append("	 * Name:");
			sb.append(this.cnName);
			sb.append("\t\n");
			if(this.cnParams.size()>0){
				sb.append("	 * Params:\t\n");
				for(String key:this.cnParams.keySet()){
					sb.append("	 *		");
					sb.append(key);
					sb.append(":");
					sb.append(this.cnParams.get(key));
					sb.append("\t\n");
				}
			}
			if(null!=this.cnReturn){
				sb.append("	 * Return:\t\n	 *		");
				sb.append(type);
				sb.append(":");
				sb.append(cnReturn);
				sb.append("\t\n");
			}
			sb.append("	 */\t\n");
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
		if(null!=this.type){
			sb.append(this.type);
			sb.append(" ");
		}
		sb.append(this.name);
		sb.append("(");
		for(String key:this.params.keySet()){
			sb.append(this.params.get(key));
			sb.append(" ");
			sb.append(key);
			sb.append(",");
		}
		if(",".equals(sb.substring(sb.length()-1))){
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append(")");
		if(this.exceptions.size()>0){
			sb.append(" throws ");
			for(String exception:this.exceptions){
				sb.append(exception);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		if(this.classType==Clazz.TYPE_CLASS){
			sb.append(" {\t\n");
			sb.append("		");
			sb.append(this.context);
			sb.append(";\t\n	}\t\n\t\n");
		}else if(this.classType==Clazz.TYPE_INTERFACE){
			sb.append(";\t\n\t\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Method method = (Method) obj;
		if(this.name.equals(method.name)&&this.type.equals(method.type)&&this.params.keySet().containsAll(method.params.keySet())){
			return true;
		}else{
			return false;
		}
	}
}
