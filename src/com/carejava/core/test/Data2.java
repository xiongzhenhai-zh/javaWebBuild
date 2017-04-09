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

public class Data2 {

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
		Model account = new Model(getId(),"Account","机构","uuid",project);
		account.addAttribute(new ModelAttribute(getId(), "code", "机构编码", "String"));
		account.addAttribute(new ModelAttribute(getId(), "name", "机构名称", "String"));
		account.addAttribute(new ModelAttribute(getId(), "type", "机构类型", "Integer"));
		account.addAttribute(new ModelAttribute(getId(), "note", "机构简介", "String"));

		Model user = new Model(getId(),"User","用户","uuid",project);
		user.addAttribute(new ModelAttribute(getId(), "username", "账号", "String"));
		user.addAttribute(new ModelAttribute(getId(), "password", "密码", "String"));
		user.addAttribute(new ModelAttribute(getId(), "alies", "昵称", "String"));
		user.addAttribute(new ModelAttribute(getId(), "type", "类型", "Integer"));
		user.addAttribute(new ModelAttribute(getId(), "tel", "电话", "String"));
		user.addAttribute(new ModelAttribute(getId(), "mobile", "手机", "String"));
		user.addAttribute(new ModelAttribute(getId(), "email", "邮箱", "String"));
		user.addAttribute(new ModelAttribute(getId(), "address", "地址", "String"));
		user.addAttribute(new ModelAttribute(getId(), "note", "备注", "String"));

		Model role = new Model(getId(),"Role","角色","uuid",project);
		role.addAttribute(new ModelAttribute(getId(), "code", "角色编码", "String"));
		role.addAttribute(new ModelAttribute(getId(), "name", "角色名称", "String"));
		
		Model auth = new Model(getId(),"Auth","权限","uuid",project);
		auth.addAttribute(new ModelAttribute(getId(), "code", "权限编码", "String"));
		auth.addAttribute(new ModelAttribute(getId(), "name", "权限名称", "String"));
		auth.addAttribute(new ModelAttribute(getId(), "path", "访问地址", "String"));
		
		Model menu = new Model(getId(),"Menu","菜单","uuid",project);
		menu.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		menu.addAttribute(new ModelAttribute(getId(), "code", "编码", "String"));
		menu.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		menu.addAttribute(new ModelAttribute(getId(), "position", "位置", "String"));
		menu.addAttribute(new ModelAttribute(getId(), "type", "类型", "Integer"));
		menu.addAttribute(new ModelAttribute(getId(), "data", "数据", "String"));
		menu.addAttribute(new ModelAttribute(getId(), "order", "排序", "order"));

		Model company = new Model(getId(),"Company","农资经营户","uuid",project);
		company.addAttribute(new ModelAttribute(getId(), "code", "注册号", "String"));
		company.addAttribute(new ModelAttribute(getId(), "name", "企业名称", "String"));
		company.addAttribute(new ModelAttribute(getId(), "adminName", "负责人", "String"));
		company.addAttribute(new ModelAttribute(getId(), "tel", "联系电话", "String"));
		company.addAttribute(new ModelAttribute(getId(), "level", "信用级别", "String"));
		company.addAttribute(new ModelAttribute(getId(), "address", "地址", "String"));
		company.addAttribute(new ModelAttribute(getId(), "status", "企业状态", "Integer"));
		company.addAttribute(new ModelAttribute(getId(), "items", "经营范围", "String"));
		company.addAttribute(new ModelAttribute(getId(), "type", "连锁性质", "Integer"));
		company.addAttribute(new ModelAttribute(getId(), "brand", "连锁品牌", "String"));
		company.addAttribute(new ModelAttribute(getId(), "market", "所属市场", "String"));
		company.addAttribute(new ModelAttribute(getId(), "marketaddress", "市场地址", "String"));
		company.addAttribute(new ModelAttribute(getId(), "positionLat", "经度", "Float"));
		company.addAttribute(new ModelAttribute(getId(), "positionLng", "纬度", "Float"));

		Model product = new Model(getId(),"Product","农资产品","uuid",project);
		product.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		product.addAttribute(new ModelAttribute(getId(), "type", "类别", "Integer"));
		product.addAttribute(new ModelAttribute(getId(), "brand", "商标", "String"));
		product.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));

		Model supplier = new Model(getId(),"Supplier","供应商","uuid",project);
		supplier.addAttribute(new ModelAttribute(getId(), "code", "供应商编码", "String"));
		supplier.addAttribute(new ModelAttribute(getId(), "name", "供应商名称", "String"));
		supplier.addAttribute(new ModelAttribute(getId(), "type", "供应商类型", "Integer"));
		supplier.addAttribute(new ModelAttribute(getId(), "tel", "联系电话", "String"));
		supplier.addAttribute(new ModelAttribute(getId(), "address", "供应商地址", "String"));
		supplier.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));

		Model ledgerOut = new Model(getId(),"LedgerOut","销售台账","uuid",project);
		ledgerOut.addAttribute(new ModelAttribute(getId(), "num", "数量", "String"));
		ledgerOut.addAttribute(new ModelAttribute(getId(), "time", "时间", "Date"));
		ledgerOut.addAttribute(new ModelAttribute(getId(), "note", "备注", "String"));
		ledgerOut.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));

		Model ledgerIn = new Model(getId(),"LedgerIn","采购台账","uuid",project);
		ledgerIn.addAttribute(new ModelAttribute(getId(), "num", "数量", "String"));
		ledgerIn.addAttribute(new ModelAttribute(getId(), "time", "时间", "Date"));
		ledgerIn.addAttribute(new ModelAttribute(getId(), "note", "备注", "String"));
		ledgerIn.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));

		Model monitor = new Model(getId(),"Monitor","监测记录","uuid",project);
		monitor.addAttribute(new ModelAttribute(getId(), "name", "监测名称", "String"));
		monitor.addAttribute(new ModelAttribute(getId(), "context", "监测内容", "String"));
		monitor.addAttribute(new ModelAttribute(getId(), "status", "监测状态", "Integer"));
		monitor.addAttribute(new ModelAttribute(getId(), "rst", "监测结果", "String"));
		monitor.addAttribute(new ModelAttribute(getId(), "punish", "处罚决定", "String"));
		
		//关系列表
		Relation roleAuth = new Relation(getId(),"auths", "ManyToMany", role);
		Relation roleUser = new Relation(getId(),"users", "OneToMany", role);
		Relation roleMenu = new Relation(getId(),"menus", "OneToMany", role);

		Relation authRole = new Relation(getId(),"roles", "ManyToMany", auth);
		Relation authParent = new Relation(getId(),"parent", "ManyToOne", auth);
		Relation authChildren = new Relation(getId(),"children", "OneToMany", auth);

		Relation menuRole = new Relation(getId(),"role", "ManyToOne", menu);
		Relation menuParent = new Relation(getId(),"parent", "ManyToOne", menu);
		Relation menuChildren = new Relation(getId(),"children", "OneToMany", menu);
		
		Relation userAcc = new Relation(getId(),"account", "ManyToOne", user);
		Relation userRole = new Relation(getId(),"role", "ManyToOne", user);

		Relation accUser = new Relation(getId(),"users", "OneToMany", account);
		Relation accCompany = new Relation(getId(),"company", "OneToOne", account);
		Relation accParent = new Relation(getId(),"parent", "ManyToOne", account);
		Relation accChildren = new Relation(getId(),"children", "OneToMany", account);

		Relation companyAccount = new Relation(getId(),"account", "OneToOne", company);
		Relation companyProduct = new Relation(getId(),"products", "OneToMany", company);
		Relation companySupplier = new Relation(getId(),"suppliers", "OneToMany", company);
		Relation companyLedgerOut = new Relation(getId(),"ledgerOuts", "OneToMany", company);
		Relation companyLedgerIn = new Relation(getId(),"ledgerIns", "OneToMany", company);
		Relation companyMonitor = new Relation(getId(),"monitors", "OneToMany", company);

		Relation productCompnay = new Relation(getId(),"company", "ManyToOne", product);
		Relation productSupplier = new Relation(getId(),"supplier", "ManyToOne", product);
		Relation productLedgerOut = new Relation(getId(),"ledgerOut", "OneToMany", product);
		Relation productLedgerIn = new Relation(getId(),"ledgerIn", "OneToMany", product);
		Relation productMonitor = new Relation(getId(),"monitors", "OneToMany", product);
		
		Relation supplierCompany = new Relation(getId(),"company", "ManyToOne", supplier);
		Relation supplierProduct = new Relation(getId(),"products", "OneToMany", supplier);

		Relation ledgerOutProduct = new Relation(getId(),"product", "ManyToOne", ledgerOut);
		Relation ledgerOutCompany = new Relation(getId(),"company", "ManyToOne", ledgerOut);
		Relation ledgerInProduct = new Relation(getId(),"product", "ManyToOne", ledgerIn);
		Relation ledgerInCompany = new Relation(getId(),"company", "ManyToOne", ledgerIn);

		Relation monitorProduct = new Relation(getId(),"product", "ManyToOne", monitor);
		Relation monitorCompany = new Relation(getId(),"company", "ManyToOne", monitor);
		
		//关系设置
		authRole.setPosition(1);
		roleAuth.setPosition(2);
		companyAccount.setPosition(1);
		accCompany.setPosition(2);
		
		roleAuth.setRelation(authRole);
		roleUser.setRelation(userRole);
		roleMenu.setRelation(menuRole);

		authRole.setRelation(roleAuth);
		authParent.setRelation(authChildren);
		authChildren.setRelation(authParent);

		menuRole.setRelation(roleMenu);
		menuParent.setRelation(menuChildren);
		menuChildren.setRelation(menuParent);
		
		userAcc.setRelation(accUser);
		userRole.setRelation(roleUser);

		accUser.setRelation(userAcc);
		accCompany.setRelation(companyAccount);
		accParent.setRelation(accChildren);
		accChildren.setRelation(accParent);

		companyAccount.setRelation(accCompany);
		companyProduct.setRelation(productCompnay);
		companySupplier.setRelation(supplierCompany);
		companyLedgerOut.setRelation(ledgerOutCompany);
		companyLedgerIn.setRelation(ledgerInCompany);
		companyMonitor.setRelation(monitorCompany);

		productCompnay.setRelation(companyProduct);
		productSupplier.setRelation(supplierProduct);
		productLedgerOut.setRelation(ledgerOutProduct);
		productLedgerIn.setRelation(ledgerInProduct);
		productMonitor.setRelation(monitorProduct);
		
		supplierCompany.setRelation(companySupplier);
		supplierProduct.setRelation(productSupplier);

		ledgerOutProduct.setRelation(productLedgerOut);
		ledgerOutCompany.setRelation(companyLedgerOut);
		ledgerInProduct.setRelation(productLedgerIn);
		ledgerInCompany.setRelation(companyLedgerIn);

		monitorProduct.setRelation(productMonitor);
		monitorCompany.setRelation(companyMonitor);
		
		//添加关系
		role.addRelation(roleAuth);
		role.addRelation(roleUser);
		role.addRelation(roleMenu);

		auth.addRelation(authRole);
		auth.addRelation(authParent);
		auth.addRelation(authChildren);

		menu.addRelation(menuRole);
		menu.addRelation(menuParent);
		menu.addRelation(menuChildren);
		
		user.addRelation(userAcc);
		user.addRelation(userRole);

		account.addRelation(accUser);
		account.addRelation(accCompany);
		account.addRelation(accParent);
		account.addRelation(accChildren);

		company.addRelation(companyAccount);
		company.addRelation(companyProduct);
		company.addRelation(companySupplier);
		company.addRelation(companyLedgerOut);
		company.addRelation(companyLedgerIn);
		company.addRelation(companyMonitor);

		product.addRelation(productCompnay);
		product.addRelation(productSupplier);
		product.addRelation(productLedgerOut);
		product.addRelation(productLedgerIn);
		product.addRelation(productMonitor);
		
		supplier.addRelation(supplierCompany);
		supplier.addRelation(supplierProduct);

		ledgerOut.addRelation(ledgerOutProduct);
		ledgerOut.addRelation(ledgerOutCompany);
		ledgerIn.addRelation(ledgerInProduct);
		ledgerIn.addRelation(ledgerInCompany);

		monitor.addRelation(monitorProduct);
		monitor.addRelation(monitorCompany);
		
		//添加模型
		models.add(account);
		models.add(user);
		models.add(role);
		models.add(menu);
		models.add(auth);
		models.add(company);
		models.add(product);
		models.add(supplier);
		models.add(ledgerOut);
		models.add(ledgerIn);
		models.add(monitor);
		
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
		Project project = new Project("123456", "nzlcjg", "农资流通与监控系统", new Frame(getId(), "ssh", "SSH"), new Frame(getId(), "jeasyui", "jeasyui"),new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.lechen.nz");
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
		project.setDataSource(new DataSource(getId(), "mysql", "mysql", "mysql://lecbuild.mysql.rds.aliyuncs.com:3306/lctest?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true", "lechen", "cl123456"));
		return project;
	}
}
