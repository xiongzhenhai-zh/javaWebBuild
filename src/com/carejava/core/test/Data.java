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

public class Data {

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
		Model company = new Model(getId(),"Company","公司信息","uuid",project);
		company.addAttribute(new ModelAttribute(getId(), "name", "公司名称", "String"));
		company.addAttribute(new ModelAttribute(getId(), "note", "公司简介", "String"));
		company.addAttribute(new ModelAttribute(getId(), "address", "公司地址", "String"));
		company.addAttribute(new ModelAttribute(getId(), "position", "公司坐标", "String"));
		company.addAttribute(new ModelAttribute(getId(), "tel", "公司电话", "String"));
		

		Model account = new Model(getId(),"Account","账号","uuid",project);
		account.addAttribute(new ModelAttribute(getId(), "username", "账号", "String"));
		account.addAttribute(new ModelAttribute(getId(), "password", "密码", "String"));
		account.addAttribute(new ModelAttribute(getId(), "alias", "昵称", "String"));

		Model news = new Model(getId(),"News","新闻","uuid",project);
		news.addAttribute(new ModelAttribute(getId(), "type", "新闻类型", "Integer"));
		news.addAttribute(new ModelAttribute(getId(), "title", "新闻标题", "String"));
		news.addAttribute(new ModelAttribute(getId(), "note", "新闻简介", "String"));
		news.addAttribute(new ModelAttribute(getId(), "detail", "新闻详情", "Integer"));
		news.addAttribute(new ModelAttribute(getId(), "author", "作者", "String"));
		news.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model productItem = new Model(getId(),"ProductItem","产品类型","uuid",project);
		productItem.addAttribute(new ModelAttribute(getId(), "name", "类型名称", "String"));
		productItem.addAttribute(new ModelAttribute(getId(), "note", "类型描述", "String"));
		productItem.addAttribute(new ModelAttribute(getId(), "order", "类型排序", "String"));
		
		Model product = new Model(getId(),"Product","产品","uuid",project);
		product.addAttribute(new ModelAttribute(getId(), "code", "权限编码", "String"));
		product.addAttribute(new ModelAttribute(getId(), "name", "权限名称", "String"));
		product.addAttribute(new ModelAttribute(getId(), "images", "介绍图片", "String"));
		product.addAttribute(new ModelAttribute(getId(), "order", "产品排序", "String"));
		product.addAttribute(new ModelAttribute(getId(), "note", "产品简介", "String"));
		product.addAttribute(new ModelAttribute(getId(), "detail", "产品详情", "String"));
		product.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		
		Model hiring = new Model(getId(),"Hiring","招聘信息","uuid",project);
		hiring.addAttribute(new ModelAttribute(getId(), "name", "职位名称", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "type", "职位类型", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "jingyan", "工作经验", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "xueli", "学历要求", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "number", "招聘人数", "Integer"));
		hiring.addAttribute(new ModelAttribute(getId(), "detail", "职位描述", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "yaoqiu", "招聘要求", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "content", "联系人", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "contentTel", "联系人电话", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "contentEmail", "联系人邮箱", "String"));
		hiring.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model partner = new Model(getId(),"Partner","合作伙伴","uuid",project);
		partner.addAttribute(new ModelAttribute(getId(), "name", "伙伴名称", "String"));
		partner.addAttribute(new ModelAttribute(getId(), "detail", "伙伴介绍", "String"));
		partner.addAttribute(new ModelAttribute(getId(), "icon", "伙伴图标", "String"));
		partner.addAttribute(new ModelAttribute(getId(), "href", "伙伴链接", "String"));
		partner.addAttribute(new ModelAttribute(getId(), "type", "伙伴类型", "Integer"));
		
		//添加模型
		models.add(company);
		models.add(news);
		models.add(productItem);
		models.add(product);
		models.add(hiring);
		models.add(partner);
		models.add(account);
		
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
			if(model.getRelations()!=null){
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
				if(model.getRelations()!=null){
				for(Relation relation:model.getRelations()){
					if("OneToMany".equals(relation.getType())&&model.equals(relation.getRelation().getModel())){
						tag = false;
						Navbar sub = new Navbar(getId(), model.getName(), model.getAlies()+"管理", Navbar.TYPE_PAGE, model.getLowName()+"_tree.html");
						children.add(sub);
					}
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
		Project project = new Project("123865", "site", "BBcare官网", new Frame(getId(), "ssh", "SSH"), new Frame(getId(), "jeasyui", "jeasyui"),new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.site");
		project.setModels(initModels(project));
		for(int i=0;i<project.getModels().size();i++){
			List<Function> functions = getFunctions();
			for(int j=0;j<functions.size();j++){
				for(ModelAttribute attr:project.getModels().get(i).getAttributes()){
					functions.get(j).addInput(attr);
					functions.get(j).addOutput(attr);
				}
			}
			if(project.getModels().get(i).getRelations()!=null){
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
		project.setDataSource(new DataSource(getId(), "mysql", "mysql", "mysql://url:3306/name?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true", "username", "password"));
		return project;
	}
}
