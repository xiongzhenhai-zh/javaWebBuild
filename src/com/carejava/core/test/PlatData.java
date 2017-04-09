package com.carejava.core.test;

import java.util.ArrayList;
import java.util.List;

import com.carejava.core.entry.DataSource;
import com.carejava.core.entry.Frame;
import com.carejava.core.entry.Function;
import com.carejava.core.entry.Model;
import com.carejava.core.entry.ModelAttribute;
import com.carejava.core.entry.Navbar;
import com.carejava.core.entry.Page;
import com.carejava.core.entry.Panel;
import com.carejava.core.entry.PanelPerporty;
import com.carejava.core.entry.Project;
import com.carejava.core.entry.Relation;
import com.carejava.core.entry.Store;

public class PlatData {
private static List<Project> projects;
	
	private static List<Function> functions;
	
	public static List<Model> getModels(String projectId) {
		for(Project project:projects){
			if(project.getId().equals(projectId)){
				return project.getModels();
			}
		}
		return null;
	}
	
	public static List<Function> getFunctions() {
		functions = new ArrayList<Function>();
		Function add = new Function(getId(),"add", "添加", 1);
		functions.add(add);
		
		Function remove = new Function(getId(),"remove", "删除", 1);
		functions.add(remove);
		
		Function modify = new Function(getId(),"modify", "修改", 1);
		functions.add(modify);
		
		Function read = new Function(getId(),"read", "查看详情", 1);
		functions.add(read);
		
		Function list = new Function(getId(),"list", "查询列表", 1);
		functions.add(list);

		Function combo = new Function(getId(),"combo", "键值对查询", 1);
		functions.add(combo);

		return functions;
	}

	private static List<Model> initModels(Project project) {
		List<Model> models = new ArrayList<Model>();
		//模型列表
		Model pjt = new Model(getId(),"Project","项目","uuid",project);
		pjt.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		pjt.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		pjt.addAttribute(new ModelAttribute(getId(), "author", "作者", "String"));
		
		Model version = new Model(getId(),"Version","版本","uuid",project);
		version.addAttribute(new ModelAttribute(getId(), "name", "版本名称", "String"));
		version.addAttribute(new ModelAttribute(getId(), "code", "版本号", "String"));
		version.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		version.addAttribute(new ModelAttribute(getId(), "releaseTime", "发布时间", "Date"));

		Model navbar = new Model(getId(),"Navbar","导航","uuid",project);
		navbar.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		navbar.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		navbar.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		navbar.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));
		navbar.addAttribute(new ModelAttribute(getId(), "action", "链接", "String"));
		navbar.addAttribute(new ModelAttribute(getId(), "data", "数据", "String"));

		Model datasource = new Model(getId(),"DataSource","数据源","uuid",project);
		datasource.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		datasource.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		datasource.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));
		datasource.addAttribute(new ModelAttribute(getId(), "url", "地址", "String"));
		datasource.addAttribute(new ModelAttribute(getId(), "username", "账号", "String"));
		datasource.addAttribute(new ModelAttribute(getId(), "password", "密码", "String"));
		
		Model pkg = new Model(getId(),"BusinessPackage","业务包","uuid",project);
		pkg.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		pkg.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		pkg.addAttribute(new ModelAttribute(getId(), "pkgName", "包名", "String"));
		
		Model model = new Model(getId(),"Model","模型","uuid",project);
		model.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		model.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		model.addAttribute(new ModelAttribute(getId(), "idType", "ID类型", "String"));
		model.addAttribute(new ModelAttribute(getId(), "lowName", "LowName", "String"));

		Model attr = new Model(getId(),"ModelAttribute","模型属性","uuid",project);
		attr.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		attr.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		attr.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));
		attr.addAttribute(new ModelAttribute(getId(), "upName", "UpName", "String"));

		Model relation = new Model(getId(),"Relation","模型关系","uuid",project);
		relation.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		relation.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		relation.addAttribute(new ModelAttribute(getId(), "type", "关系类型", "String"));
		relation.addAttribute(new ModelAttribute(getId(), "position", "主次关系", "String"));
		relation.addAttribute(new ModelAttribute(getId(), "cascade", "缓存策略", "String"));
		relation.addAttribute(new ModelAttribute(getId(), "fetch", "抓取策略", "String"));
		
		Model frame = new Model(getId(),"Frame","框架","uuid",project);
		frame.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		frame.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		frame.addAttribute(new ModelAttribute(getId(), "note", "框架介绍", "String"));

		Model function = new Model(getId(),"Function","功能","uuid",project);
		function.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		function.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));

		Model file = new Model(getId(),"FileTemplate","文件模板","uuid",project);
		file.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		file.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		file.addAttribute(new ModelAttribute(getId(), "type", "文件类型", "String"));
		file.addAttribute(new ModelAttribute(getId(), "path", "模板路径", "String"));

		Model code = new Model(getId(),"CodeTemplate","代码模板","uuid",project);
		code.addAttribute(new ModelAttribute(getId(), "name", "英文名称", "String"));
		code.addAttribute(new ModelAttribute(getId(), "alias", "中文名称", "String"));
		code.addAttribute(new ModelAttribute(getId(), "type", "模板类型", "String"));
		code.addAttribute(new ModelAttribute(getId(), "path", "模板路径", "String"));
		
		Model modelFunction = new Model(getId(),"ModelFunction","模型方法","uuid",project);
		modelFunction.addAttribute(new ModelAttribute(getId(), "modelAlias", "模型别称", "String"));
		modelFunction.addAttribute(new ModelAttribute(getId(), "functionAlias", "方法别称", "String"));
		
		Model filter = new Model(getId(),"Filter","过滤器","uuid",project);
		filter.addAttribute(new ModelAttribute(getId(), "type", "过滤类型", "String"));
		filter.addAttribute(new ModelAttribute(getId(), "path", "过滤请求", "String"));
		filter.addAttribute(new ModelAttribute(getId(), "method", "过滤方法", "String"));
		filter.addAttribute(new ModelAttribute(getId(), "action", "过滤动作", "String"));
		
		
		//定义模型关系
		Relation pjtVersion = new Relation(getId(),"versions", "OneToMany", pjt);
		
		Relation versionPjt = new Relation(getId(),"project", "ManyToOne", version);		
		Relation versionNavbar = new Relation(getId(),"navbars", "OneToMany", version);
		Relation versionFrame = new Relation(getId(),"frame", "ManyToMany", version);
		Relation versionPkg = new Relation(getId(),"businessPackages", "OneToMany", version);
		Relation versionDatasource = new Relation(getId(),"dataSource", "OneToOne", version);

		Relation navbarVersion = new Relation(getId(),"version", "ManyToOne", navbar);

		Relation datasourceVersion = new Relation(getId(),"version", "OneToOne", datasource);
		
		Relation pkgVersion = new Relation(getId(),"version", "ManyToOne", pkg);
		Relation pkgModel = new Relation(getId(),"models", "OneToMany", pkg);
		
		Relation modelPkg = new Relation(getId(),"businessPackage", "ManyToOne", model);
		Relation modelAttr = new Relation(getId(),"attributes", "OneToMany", model);
		Relation modelRelation = new Relation(getId(),"relations", "OneToMany", model);
		Relation modelModelFunction = new Relation(getId(),"functions", "OneToMany", model);

		Relation attrModel = new Relation(getId(),"model", "ManyToOne", attr);
		
		Relation relationModel = new Relation(getId(),"model", "ManyToOne", relation);
		Relation relationA = new Relation(getId(),"relation", "OneToOne", relation);
		Relation relationB = new Relation(getId(),"relation", "OneToOne", relation);

		Relation modelFunctionModel = new Relation(getId(),"model", "ManyToOne", modelFunction);
		Relation modelFunctionFunction = new Relation(getId(),"function", "ManyToOne", modelFunction);
		Relation modelFunctionFilter = new Relation(getId(),"filters", "OneToMany", modelFunction);
		
		Relation filterModelFunction = new Relation(getId(),"modelFunction", "ManyToOne", filter);
		
		Relation functionModelFunction = new Relation(getId(),"modelFunctions", "OneToMany", function);
		Relation functionFile = new Relation(getId(),"files", "OneToMany", function);
		
		Relation fileCode = new Relation(getId(),"codes", "OneToMany", file);
		Relation fileFunction = new Relation(getId(),"function", "ManyToOne", file);
		Relation fileFrame = new Relation(getId(),"frame", "ManyToOne", file);
		
		Relation codeFile = new Relation(getId(),"file", "ManyToOne", code);
		
		Relation frameFile = new Relation(getId(),"files", "OneToMany", frame);
		Relation frameVersion = new Relation(getId(),"version", "ManyToMany", frame);
		
		//关系设置
		versionDatasource.setPosition(1);
		datasourceVersion.setPosition(2);
		frameVersion.setPosition(1);
		versionFrame.setPosition(2);
		relationA.setPosition(1);
		relationB.setPosition(2);
		
		pjtVersion.setRelation(versionPjt);
		
		versionPjt.setRelation(pjtVersion);
		versionNavbar.setRelation(navbarVersion);
		versionDatasource.setRelation(datasourceVersion);
		versionFrame.setRelation(frameVersion);
		versionPkg.setRelation(pkgVersion);

		navbarVersion.setRelation(versionNavbar);

		datasourceVersion.setRelation(versionDatasource);
		
		pkgModel.setRelation(modelPkg);
		pkgVersion.setRelation(versionPkg);
		
		modelAttr.setRelation(attrModel);
		modelPkg.setRelation(pkgModel);
		modelModelFunction.setRelation(modelFunctionModel);
		modelRelation.setRelation(relationModel);

		attrModel.setRelation(modelAttr);
		
		relationModel.setRelation(modelRelation);
		relationA.setRelation(relationB);
		relationB.setRelation(relationA);

		modelFunctionFilter.setRelation(filterModelFunction);
		modelFunctionFunction.setRelation(functionModelFunction);
		modelFunctionModel.setRelation(modelModelFunction);
		
		filterModelFunction.setRelation(modelFunctionFilter);
		
		functionModelFunction.setRelation(modelFunctionFunction);
		functionFile.setRelation(fileFunction);

		fileCode.setRelation(codeFile);
		fileFrame.setRelation(frameFile);
		fileFunction.setRelation(functionFile);
		
		codeFile.setRelation(fileCode);
		
		frameFile.setRelation(fileFrame);
		frameVersion.setRelation(versionFrame);
		
		//添加关系
		pjt.addRelation(pjtVersion);
		
		version.addRelation(versionPjt);
		version.addRelation(versionNavbar);
		version.addRelation(versionDatasource);
		version.addRelation(versionFrame);
		version.addRelation(versionPkg);
		
		navbar.addRelation(navbarVersion);
		
		datasource.addRelation(datasourceVersion);

		pkg.addRelation(pkgVersion);
		pkg.addRelation(pkgModel);
		
		model.addRelation(modelPkg);
		model.addRelation(modelAttr);
		model.addRelation(modelRelation);
		model.addRelation(modelModelFunction);
		
		attr.addRelation(attrModel);
		
		relation.addRelation(relationModel);
		relation.addRelation(relationA);
		relation.addRelation(relationB);
		
		modelFunction.addRelation(modelFunctionFilter);
		modelFunction.addRelation(modelFunctionFunction);
		modelFunction.addRelation(modelFunctionModel);
		
		filter.addRelation(filterModelFunction);
		
		function.addRelation(functionModelFunction);
		function.addRelation(functionFile);
		
		file.addRelation(fileCode);
		file.addRelation(fileFrame);
		file.addRelation(fileFunction);
		
		code.addRelation(codeFile);
		
		frame.addRelation(frameVersion);
		frame.addRelation(frameFile);

		//添加模型
		models.add(pjt);
		models.add(version);
		models.add(navbar);
		models.add(datasource);
		models.add(pkg);
		models.add(model);
		models.add(attr);
		models.add(relation);
		models.add(modelFunction);
		models.add(filter);
		models.add(function);
		models.add(file);
		models.add(code);
		models.add(frame);
		
		return models;
	}
	
	public static List<Page> initPage(List<Model> models){
		List<Page> pages = new ArrayList<Page>();
		for(Model model:models){
			Page page = new Page(getId(), model.getLowName()+"_list", model.getAlies()+"查询", "curd");
			
			Panel listPanel = new Panel(getId(), model.getLowName()+"_list", model.getAlies()+"列表", "list");
			for(ModelAttribute attr:model.getAttributes()){
				listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "read"));
			Store listStore = new Store(getId(),model,model.getFunctions().get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName()+"_search", "查询"+model.getAlies(), "search");
			for(ModelAttribute attr:model.getAttributes()){
				searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);
			
			Panel readPanel = new Panel(getId(), model.getLowName()+"_read", "查看"+model.getAlies()+"详情", "read");
			for(ModelAttribute attr:model.getAttributes()){
				readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(),model,model.getFunctions().get(3));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);
			
			pages.add(page);
		}
		for(Model model:models){
			Page page = new Page(getId(), model.getLowName(), model.getAlies()+"管理", "curd");
			
			Panel listPanel = new Panel(getId(), model.getLowName()+"_list", model.getAlies()+"列表", "list");
			for(ModelAttribute attr:model.getAttributes()){
				listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
			Store listStore = new Store(getId(),model,model.getFunctions().get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName()+"_search", "查询"+model.getAlies(), "search");
			for(ModelAttribute attr:model.getAttributes()){
				searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);
			
			Panel addPanel = new Panel(getId(), model.getLowName()+"_add", "添加"+model.getAlies(), "add");
			for(ModelAttribute attr:model.getAttributes()){
				addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store addStore = new Store(getId(),model,model.getFunctions().get(0));
			addPanel.setStore(addStore);
			page.addPanel(addPanel);
			
			Panel removePanel = new Panel(getId(), model.getLowName()+"_remove", "删除"+model.getAlies(), "remove");
			Store removeStore = new Store(getId(),model,model.getFunctions().get(1));
			removePanel.setStore(removeStore);
			page.addPanel(removePanel);
			
			Panel modifyPanel = new Panel(getId(), model.getLowName()+"_modify", "修改"+model.getAlies(), "modify");
			for(ModelAttribute attr:model.getAttributes()){
				modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store modifyStore = new Store(getId(),model,model.getFunctions().get(2));
			modifyPanel.setStore(modifyStore);
			page.addPanel(modifyPanel);
			
			Panel readPanel = new Panel(getId(), model.getLowName()+"_read", "查看"+model.getAlies()+"详情", "read");
			for(ModelAttribute attr:model.getAttributes()){
				readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(),model,model.getFunctions().get(3));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);
			
			pages.add(page);
		}
		for(Model model:models){
			List<ModelAttribute> attrs = model.getAttributes();
			boolean tag = false;
			for(ModelAttribute attr:attrs){
				if("status".equals(attr.getName())){
					tag = true;
					break;
				}
			}
			if(tag){
				Page page = new Page(getId(), model.getLowName()+"_review", model.getAlies()+"审核", "curd");
				
				Panel listPanel = new Panel(getId(), model.getLowName()+"_list", model.getAlies()+"列表", "list");
				for(ModelAttribute attr:model.getAttributes()){
					listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
				}
				listPanel.addPerporty(new PanelPerporty(getId(), "id", "审核", "grid", "review"));
				Store listStore = new Store(getId(),model,model.getFunctions().get(4));
				listPanel.setStore(listStore);
				page.addPanel(listPanel);
				
				Panel reviewPanel = new Panel(getId(), model.getLowName()+"_httl", "审核"+model.getAlies(), "review");
				Store reviewStore = new Store(getId(),model,model.getFunctions().get(1));
				reviewPanel.setStore(reviewStore);
				page.addPanel(reviewPanel);
				
				Panel readPanel = new Panel(getId(), model.getLowName()+"_read", "查看"+model.getAlies()+"详情", "read");
				for(ModelAttribute attr:model.getAttributes()){
					readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
				}
				Store readStore = new Store(getId(),model,model.getFunctions().get(3));
				readPanel.setStore(readStore);
				page.addPanel(readPanel);
				
				pages.add(page);
			}
		}
		for(Model model:models){
			for(Relation relation:model.getRelations()){
				if("children".equals(relation.getName())){
					Page page = new Page(getId(), model.getLowName()+"_tree", model.getAlies()+"管理", "tree_mgr");
					
					Panel treePanel = new Panel(getId(), model.getLowName()+"_tree", model.getAlies()+"列表", "tree_mgr");
					for(ModelAttribute attr:model.getAttributes()){
						treePanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store treeStore = new Store(getId(),model,new Function(getId(),"tree", "树查询", 1));
					treePanel.setStore(treeStore);
					page.addPanel(treePanel);
					
					Panel listPanel = new Panel(getId(), model.getLowName()+"_list", model.getAlies()+"列表", "list");
					for(ModelAttribute attr:model.getAttributes()){
						listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
					}
					listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store listStore = new Store(getId(),model,model.getFunctions().get(4));
					listPanel.setStore(listStore);
					page.addPanel(listPanel);

					Panel searchPanel = new Panel(getId(), model.getLowName()+"_search", "查询"+model.getAlies(), "search");
					for(ModelAttribute attr:model.getAttributes()){
						searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					page.addPanel(searchPanel);
					
					Panel addPanel = new Panel(getId(), model.getLowName()+"_add", "添加"+model.getAlies(), "tree_add");
					for(ModelAttribute attr:model.getAttributes()){
						addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store addStore = new Store(getId(),model,model.getFunctions().get(0));
					addPanel.setStore(addStore);
					page.addPanel(addPanel);
					
					Panel removePanel = new Panel(getId(), model.getLowName()+"_remove", "删除"+model.getAlies(), "remove");
					Store removeStore = new Store(getId(),model,model.getFunctions().get(1));
					removePanel.setStore(removeStore);
					page.addPanel(removePanel);
					
					Panel modifyPanel = new Panel(getId(), model.getLowName()+"_modify", "修改"+model.getAlies(), "modify");
					for(ModelAttribute attr:model.getAttributes()){
						modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store modifyStore = new Store(getId(),model,model.getFunctions().get(2));
					modifyPanel.setStore(modifyStore);
					page.addPanel(modifyPanel);
					
					Panel readPanel = new Panel(getId(), model.getLowName()+"_read", "查看"+model.getAlies()+"详情", "read");
					for(ModelAttribute attr:model.getAttributes()){
						readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store readStore = new Store(getId(),model,model.getFunctions().get(3));
					readPanel.setStore(readStore);
					page.addPanel(readPanel);
					
					pages.add(page);
				}
			}
		}
		for(Model model:models){
			for(Model detailModel:models){
				if((model.getName()+"Detail").equals(detailModel.getName())){
					List<Page> tempPage = new ArrayList<Page>();
					for(Page pg:pages){
						if(!(pg.getName().equals(model.getLowName())||pg.getName().equals(detailModel.getLowName()))){
							tempPage.add(pg);
						}
					}
					pages = tempPage;
					Page page = new Page(getId(), model.getLowName(), model.getAlies()+"管理", "curd");
					
					Panel listPanel = new Panel(getId(), model.getLowName()+"_list", model.getAlies()+"列表", "sub_list");
					for(ModelAttribute attr:model.getAttributes()){
						listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
					}
					listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store listStore = new Store(getId(),model,model.getFunctions().get(4));
					listPanel.setStore(listStore);
					page.addPanel(listPanel);

					Panel subListPanel = new Panel(getId(), detailModel.getLowName()+"_list", detailModel.getAlies()+"列表", "sub_list");
					for(ModelAttribute attr:detailModel.getAttributes()){
						subListPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
					}
					subListPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store subListStore = new Store(getId(),detailModel,detailModel.getFunctions().get(4));
					listPanel.setStore(subListStore);
					page.addPanel(subListPanel);

					Panel searchPanel = new Panel(getId(), model.getLowName()+"_search", "查询"+model.getAlies(), "search");
					for(ModelAttribute attr:model.getAttributes()){
						searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					page.addPanel(searchPanel);
					
					Panel addPanel = new Panel(getId(), model.getLowName()+"_add", "添加"+model.getAlies(), "sub_add");
					for(ModelAttribute attr:model.getAttributes()){
						addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store addStore = new Store(getId(),model,model.getFunctions().get(0));
					addPanel.setStore(addStore);
					page.addPanel(addPanel);
					
					Panel removePanel = new Panel(getId(), model.getLowName()+"_remove", "删除"+model.getAlies(), "sub_remove");
					Store removeStore = new Store(getId(),model,model.getFunctions().get(1));
					removePanel.setStore(removeStore);
					page.addPanel(removePanel);
					
					Panel modifyPanel = new Panel(getId(), model.getLowName()+"_modify", "修改"+model.getAlies(), "sub_modify");
					for(ModelAttribute attr:model.getAttributes()){
						modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store modifyStore = new Store(getId(),model,model.getFunctions().get(2));
					modifyPanel.setStore(modifyStore);
					page.addPanel(modifyPanel);
					
					Panel readPanel = new Panel(getId(), model.getLowName()+"_read", "查看"+model.getAlies()+"详情", "sub_read");
					for(ModelAttribute attr:model.getAttributes()){
						readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
					}
					Store readStore = new Store(getId(),model,model.getFunctions().get(3));
					readPanel.setStore(readStore);
					page.addPanel(readPanel);
					
					pages.add(page);
				}
			}
		}
		
		return pages;
	}
	
	public static List<Navbar> initNavbars(List<Model> models){
		List<Navbar> list = new ArrayList<Navbar>();
		Navbar nav = new Navbar(getId(), "workspace", "工作台", Navbar.TYPE_PAGE, "workspace.html");
		List<Navbar> children = new ArrayList<Navbar>();
		for(Model model:models){
			boolean tag = true;
			for(Relation relation:model.getRelations()){
				if("OneToMany".equals(relation.getType())&&model.equals(relation.getRelation().getModel())){
					tag = false;
					Navbar sub = new Navbar(getId(), model.getName(), model.getAlies()+"管理", Navbar.TYPE_PAGE, model.getLowName()+"_tree.html");
					children.add(sub);
				}
			}
			if(tag){
				Navbar sub = new Navbar(getId(), model.getName(), model.getAlies()+"管理", Navbar.TYPE_PAGE, model.getLowName()+".html");
				children.add(sub);
			}
		}
		nav.setChildren(children);
		list.add(nav);
		return list;
	}
	
	private static String getId(){
		return String.valueOf((long)Math.floor(Math.random()*100000000));
	}

	public static Project getProject() {
		Project project = new Project("123456", "plat", "乐橙云开发平台", new Frame(getId(), "ssh", "SSH"), new Frame(getId(), "jeasyui", "jeasyui"),new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.lechen.plat");
		project.setModels(initModels(project));
		for(int i=0;i<project.getModels().size();i++){
			List<Function> functions = getFunctions();
			for(int j=0;j<functions.size();j++){
				for(ModelAttribute attr:project.getModels().get(i).getAttributes()){
					functions.get(j).addInput(attr);
					functions.get(j).addOutput(attr);
				}
			}
			for(Relation relation:project.getModels().get(i).getRelations()){
				if("children".equals(relation.getName())){
					Function function = new Function(getId(), "tree", project.getModels().get(i).getAlies()+"树", 1);
					for(ModelAttribute attr:project.getModels().get(i).getAttributes()){
						function.addInput(attr);
						function.addOutput(attr);
					}
					functions.add(function);
				}
			}
			for(ModelAttribute mattr:project.getModels().get(i).getAttributes()){
				if("status".equals(mattr.getName())){
					Function function = new Function(getId(), "review", project.getModels().get(i).getAlies()+"审核", 1);
					for(ModelAttribute attr:project.getModels().get(i).getAttributes()){
						function.addInput(attr);
						function.addOutput(attr);
					}
					functions.add(function);
					break;
				}
			}
			project.getModels().get(i).setFunctions(functions);
		}
		project.setNavbars(initNavbars(project.getModels()));
		project.setPages(initPage(project.getModels()));
		project.setDataSource(new DataSource(getId(), "mysql", "mysql", "mysql://lecbuild.mysql.rds.aliyuncs.com:3306/plat?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true", "lechen", "cl123456"));
		return project;
	}
}
