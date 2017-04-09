package com.carejava.core.test;
/*package com.lechen.core.test;

import java.util.ArrayList;
import java.util.List;

import com.lechen.core.entry.DataSource;
import com.lechen.core.entry.Frame;
import com.lechen.core.entry.Function;
import com.lechen.core.entry.Model;
import com.lechen.core.entry.ModelAttribute;
import com.lechen.core.entry.Navbar;
import com.lechen.core.entry.Page;
import com.lechen.core.entry.Panel;
import com.lechen.core.entry.PanelPerporty;
import com.lechen.core.entry.Project;
import com.lechen.core.entry.Relation;
import com.lechen.core.entry.Store;

public class Data1 {

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

		return functions;
	}

	private static List<Model> initModels(Project project) {
		List<Model> models = new ArrayList<Model>();
		Model user = new Model(getId(),"User","用户","uuid",project);
		user.addAttribute(new ModelAttribute(getId(), "username", "账号", "String"));
		user.addAttribute(new ModelAttribute(getId(), "password", "密码", "String"));
		user.addAttribute(new ModelAttribute(getId(), "alies", "昵称", "String"));
		
		Model account = new Model(getId(),"Account","企业账号","uuid",project);
		account.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		account.addAttribute(new ModelAttribute(getId(), "type", "账号类型", "Integer"));

		Model role = new Model(getId(),"Role","角色","uuid",project);
		role.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));

		Model order = new Model(getId(),"Order","订单","uuid",project);
		order.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));

		Model orderDetail = new Model(getId(),"OrderDetail","订单详情","uuid",project);
		orderDetail.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));

		Relation userAcc = new Relation(getId(),"account", "ManyToOne", user);
		Relation accUser = new Relation(getId(),"users", "OneToMany", account);
		Relation userRole = new Relation(getId(),"roles", "ManyToMany", user);
		Relation roleUser = new Relation(getId(),"users", "ManyToMany", role);
		Relation roleParent = new Relation(getId(),"parent", "ManyToOne", role);
		Relation roleChildren = new Relation(getId(),"children", "OneToMany", role);

		Relation orderPrent = new Relation(getId(),"order", "ManyToOne", order);
		Relation orderDeatilChildren = new Relation(getId(),"orderDetails", "OneToMany", orderDetail);
		
		roleUser.setPosition(1);
		userRole.setPosition(2);
		userAcc.setRelation(accUser);
		accUser.setRelation(userAcc);
		userRole.setRelation(roleUser);
		roleUser.setRelation(userRole);
		roleParent.setRelation(roleChildren);
		roleChildren.setRelation(roleParent);
		orderPrent.setRelation(orderDeatilChildren);
		orderDeatilChildren.setRelation(orderPrent);
		
		user.addRelation(userAcc);
		user.addRelation(userRole);
		account.addRelation(accUser);
		role.addRelation(roleUser);
		role.addRelation(roleParent);
		role.addRelation(roleChildren);
		order.addRelation(orderDeatilChildren);
		orderDetail.addRelation(orderPrent);
		
		models.add(account);
		models.add(user);
		models.add(role);
		models.add(order);
		models.add(orderDetail);
		
		return models;
	}
	
	public static List<Page> initPage(List<Model> models){
		List<Page> pages = new ArrayList<Page>();
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
			Store readStore = new Store(getId(),model,model.getFunctions().get(2));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);
			
			pages.add(page);
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
					Store readStore = new Store(getId(),model,model.getFunctions().get(2));
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
					Store readStore = new Store(getId(),model,model.getFunctions().get(2));
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
		Project project = new Project("123456", "test", "测试", new Frame(getId(), "ssh", "SSH"), new Frame(getId(), "jeasyui", "jeasyui"),new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.lechen.test");
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
			project.getModels().get(i).setFunctions(functions);
		}
		project.setNavbars(initNavbars(project.getModels()));
		project.setPages(initPage(project.getModels()));
		project.setDataSource(new DataSource(getId(), "mysql", "mysql", "mysql://lecbuild.mysql.rds.aliyuncs.com:3306/lctest?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true", "lechen", "cl123456"));
		return project;
	}
}
*/