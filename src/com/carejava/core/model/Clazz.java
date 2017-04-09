package com.carejava.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.carejava.core.Util;

public class Clazz {

	public static final int TYPE_CLASS = 1,TYPE_INTERFACE = 2;
	
	private Long id;
	
	private String name;
	
	private String cnName;
	
	private int type;
	
	private String pkg;
	
	private String extend;
	
	private List<String> impls = new ArrayList<String>();
	
	private List<String> imports = new ArrayList<String>();
	
	private List<String> annotations = new ArrayList<String>();
	
	private List<Property> props = new ArrayList<Property>();
	
	private List<Method> methods = new ArrayList<Method>();
	
	private List<Date> updateTime = new ArrayList<Date>();
	
	private List<String> updateName = new ArrayList<String>();
	
	public Clazz(String name, String cnName,int type, String pkg,String username) {
		super();
		this.name = name;
		this.cnName = cnName;
		this.type = type;
		this.pkg = pkg;
		this.updateTime.add(new Date());
		this.updateName.add(username);
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public List<String> getImpls() {
		return impls;
	}

	public void setImpls(List<String> impls) {
		this.impls = impls;
	}

	public List<String> getImports() {
		return imports;
	}

	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public List<String> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<String> annotations) {
		this.annotations = annotations;
	}

	public List<Property> getProps() {
		return props;
	}

	public void setProps(List<Property> props) {
		this.props = props;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public List<Date> getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(List<Date> updateTime) {
		this.updateTime = updateTime;
	}

	public List<String> getUpdateName() {
		return updateName;
	}

	public void setUpdateName(List<String> updateName) {
		this.updateName = updateName;
	}
	
	public void addImpl(String name){
		this.impls.add(name);
	}
	
	public void addImport(String name){
		if((!"java.lang".equals(name))&&(!this.pkg.equals(name))){
			boolean tag = true;
			for(String impt:this.imports){
				if(impt.equals(name)){
					tag = false;
					break;
				}
			}
			if(tag){
				this.imports.add(name);
			}
		}
	}
	
	public void addAnnotation(String annotation){
		if(!this.annotations.contains(annotation)){
			this.annotations.add(annotation);
		}
	}
	
	public void addProperty(Property prop) {
		if(!this.props.contains(prop)){
			this.props.add(prop);
		}
	}
	
	public void addProperty(String name,String cnName,String type){
		this.props.add(new Property(name, cnName, type));
	}
	
	public void addProperty(String name,String cnName,String type,boolean pblc,boolean sttc){
		this.props.add(new Property(name, cnName, type, pblc, sttc));
	}
	
	public void addMethod(Method method){
		if(!this.methods.contains(method)){
			method.setClassType(this.type);
			this.methods.add(method);
		}
	}

	public void initGetAndSet() {
		for(Property prop:this.props){
			if(prop.isSttc()){
				continue;
			}
			Method get;
			if("boolean".equals(prop.getType())||"Boolean".equals(prop.getType())){
				get = new Method("is"+Util.toUpperCaseFirstOne(prop.getName()), prop.getType(), null);
			}else{
				get = new Method("get"+Util.toUpperCaseFirstOne(prop.getName()), prop.getType(), null);
			}
			get.setContext("return "+prop.getName());
			this.addMethod(get);
			Method set = new Method("set"+Util.toUpperCaseFirstOne(prop.getName()),"void", null);
			set.addParam(prop.getName(), null, prop.getType());
			set.setContext("this."+prop.getName()+" = "+prop.getName());
			this.addMethod(set);
		}
	}
	
	public void initGet(String[] names){
		for(String name:names){
			for(Property prop:this.props){
				if(name.equals(prop.getName())){
					Method get;
					if("boolean".equals(prop.getType())||"Boolean".equals(prop.getType())){
						get = new Method("is"+Util.toUpperCaseFirstOne(prop.getName()), prop.getType(), null);
					}else{
						get = new Method("get"+Util.toUpperCaseFirstOne(prop.getName()), prop.getType(), null);
					}
					get.setContext("return "+prop.getName());
					this.addMethod(get);
					break;
				}
			}
		}
	}

	public void initSet(String[] names){
		for(String name:names){
			for(Property prop:this.props){
				if(name.equals(prop.getName())){
					Method set = new Method("set"+Util.toUpperCaseFirstOne(prop.getName()),"void", null);
					set.addParam(prop.getName(), null, prop.getType());
					set.setContext("this."+prop.getName()+" = "+prop.getName());
					this.addMethod(set);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("package ");
		sb.append(this.pkg);
		sb.append(";\t\n\t\n");
		for(String name:this.imports){
			sb.append("import ");
			sb.append(name);
			sb.append(";\t\n");
		}
		if(null!=this.cnName){
			sb.append("\t\n/**\t\n");
			sb.append(" * @name:");
			sb.append(this.cnName);
			sb.append("\t\n");
			sb.append(" * @author:\t\n");
			for(int i=0;i<this.updateName.size();i++){
				sb.append(" *		");
				sb.append(""+(i+1));
				sb.append(":");
				sb.append(this.updateName.get(i));
				sb.append("(");
				sb.append(this.updateTime.get(i).toLocaleString());
				sb.append(")\t\n");
			}
			sb.append(" */\t\n");
		}
		sb.append("\t\n");
		for(String name:this.annotations){
			sb.append(name);
			sb.append("\t\n");
		}
		sb.append("public ");
		if(this.type==TYPE_CLASS){
			sb.append("class ");
		}else if(this.type==TYPE_INTERFACE){
			sb.append("interface ");
		}
		sb.append(this.name);
		if(null!=this.extend){
			sb.append(" extends ");
			sb.append(this.extend);
		}
		if(this.impls.size()==1){
			sb.append(" implements ");
			sb.append(this.impls.get(0));
		}else if(this.impls.size()>1){
			sb.append(" implements ");
			for(String name:this.impls){
				sb.append(name);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append(" {\t\n\t\n");
		for(Property prop:this.props){
			sb.append(prop.toString());
		}
		for(Method method:this.methods){
			sb.append(method.toString());
		}
		sb.append("}");
		return sb.toString();
	}

	public void addImports(List<String> packages) {
		if(packages==null){
			return;
		}
		for(String pkg:packages){
			this.addImport(pkg);
		}
	}

	public void addPropertys(List<Property> property) {
		if(property==null){
			return;
		}
		for(Property p:property){
			this.addProperty(p);
		}
	}

	public void addMethods(List<Method> method) {
		if(method==null){
			return;
		}
		for(Method mtd:method){
			this.addMethod(mtd);
		}
	}

}
