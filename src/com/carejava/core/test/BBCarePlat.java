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

public class BBCarePlat {

	private static List<Project> projects;

	private static List<Function> functions;

	public static List<Model> getModels(String projectId) {
		for (Project project : projects) {
			if (project.getId().equals(projectId)) {
				return project.getModels();
			}
		}
		return null;
	}

	public static List<Function> getFunctions() {
		functions = new ArrayList<Function>();
		Function add = new Function(getId(), "add", "添加", 1);
		functions.add(add);

		Function remove = new Function(getId(), "remove", "删除", 1);
		functions.add(remove);

		Function modify = new Function(getId(), "modify", "修改", 1);
		functions.add(modify);

		Function read = new Function(getId(), "read", "查看详情", 1);
		functions.add(read);

		Function list = new Function(getId(), "list", "查询列表", 1);
		functions.add(list);

		Function combo = new Function(getId(), "combo", "键值对查询", 1);
		functions.add(combo);

		return functions;
	}

	private static List<Model> initModels(Project project) {
		List<Model> models = new ArrayList<Model>();
		// 模型列表
		Model group = new Model(getId(), "Group", "机构", "uuid", project);
		group.addAttribute(new ModelAttribute(getId(), "code", "机构代码", "String"));
		group.addAttribute(new ModelAttribute(getId(), "apiKey", "API KEY", "String"));
		group.addAttribute(new ModelAttribute(getId(), "secretKey", "秘钥", "String"));
		group.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		group.addAttribute(new ModelAttribute(getId(), "type", "类型", "Integer"));
		group.addAttribute(new ModelAttribute(getId(), "status", "状态", "Integer"));
		group.addAttribute(new ModelAttribute(getId(), "level", "级别", "String"));
		group.addAttribute(new ModelAttribute(getId(), "star", "星级", "Integer"));
		group.addAttribute(new ModelAttribute(getId(), "superAdminId", "管理员ID", "String"));
		group.addAttribute(new ModelAttribute(getId(), "superAdminName", "管理员名称", "String"));
		group.addAttribute(new ModelAttribute(getId(), "netsite", "网站", "String"));
		group.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		group.addAttribute(new ModelAttribute(getId(), "minIcon", "小图标", "String"));
		group.addAttribute(new ModelAttribute(getId(), "bigIcon", "大图标", "String"));
		group.addAttribute(new ModelAttribute(getId(), "logo", "Logo", "String"));
		group.addAttribute(new ModelAttribute(getId(), "detail", "介绍", "String"));
		group.addAttribute(new ModelAttribute(getId(), "note", "备注", "String"));
		group.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		group.addAttribute(new ModelAttribute(getId(), "createName", "创建人", "String"));

		Model groupType = new Model(getId(), "GroupType", "机构类型", "uuid", project);
		groupType.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		groupType.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		groupType.addAttribute(new ModelAttribute(getId(), "note", "说明", "String"));
		
		Model department = new Model(getId(), "Department", "部门", "uuid", project);
		department.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		department.addAttribute(new ModelAttribute(getId(), "adminId", "管理员ID", "String"));
		department.addAttribute(new ModelAttribute(getId(), "adminName", "管理员名称", "String"));
		department.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		
		Model role = new Model(getId(), "Role", "角色", "uuid", project);
		role.addAttribute(new ModelAttribute(getId(), "code", "编号", "String"));
		role.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		
		Model account = new Model(getId(), "Account", "账号", "uuid", project);
		account.addAttribute(new ModelAttribute(getId(), "accountId", "账号ID", "String"));
		account.addAttribute(new ModelAttribute(getId(), "alias", "昵称", "String"));
		account.addAttribute(new ModelAttribute(getId(), "title", "职位", "String"));
		account.addAttribute(new ModelAttribute(getId(), "gender", "性别", "String"));

		Model module = new Model(getId(), "Module", "模块", "uuid", project);
		module.addAttribute(new ModelAttribute(getId(), "code", "编号", "String"));
		module.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		module.addAttribute(new ModelAttribute(getId(), "alias", "别称", "String"));
		module.addAttribute(new ModelAttribute(getId(), "status", "状态", "Integer"));
		module.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		module.addAttribute(new ModelAttribute(getId(), "logo", "Logo", "String"));
		module.addAttribute(new ModelAttribute(getId(), "detail", "介绍", "String"));
		module.addAttribute(new ModelAttribute(getId(), "homeUrl", "模块主页", "String"));
		module.addAttribute(new ModelAttribute(getId(), "toolsUrl", "模块工具页", "String"));
		module.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		module.addAttribute(new ModelAttribute(getId(), "createUser", "创建人", "String"));
		
		Model roleModule = new Model(getId(), "RoleModule", "角色模块", "uuid", project);
		roleModule.addAttribute(new ModelAttribute(getId(), "createTime", "名称", "String"));
		
		Model auth = new Model(getId(), "Auth", "权限", "uuid", project);
		auth.addAttribute(new ModelAttribute(getId(), "code", "编号", "String"));
		auth.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));

		Model navMenu = new Model(getId(), "NavMenu", "导航菜单", "uuid", project);
		navMenu.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		navMenu.addAttribute(new ModelAttribute(getId(), "icon", "图标", "String"));
		navMenu.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));
		navMenu.addAttribute(new ModelAttribute(getId(), "url", "URL", "String"));
		navMenu.addAttribute(new ModelAttribute(getId(), "params", "参数", "String"));
		
		Model mRelation = new Model(getId(), "Relation", "关系", "uuid", project);
		mRelation.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		mRelation.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));
		
		// 关系列表
		Relation groupDepartment = new Relation(getId(), "departments", "OneToMany", group);
		Relation groupGroupType = new Relation(getId(), "types", "ManyToOne", group);
		
		Relation groupTypeRole = new Relation(getId(), "roles", "OneToMany", groupType);
		Relation groupTypeGroup = new Relation(getId(), "groups", "OneToMany", groupType);

		Relation departmentGroup = new Relation(getId(), "group", "ManyToOne", department);
		Relation departmentAccount = new Relation(getId(), "accounts", "OneToMany", department);
		
		Relation roleGroupType = new Relation(getId(), "groupType", "ManyToOne", role);
		Relation roleRoleModule = new Relation(getId(), "roleModules", "OneToMany", role);
		Relation roleAuth = new Relation(getId(), "auths", "ManyToMany", role);
		Relation roleAccount = new Relation(getId(), "accounts", "OneToMany", role);
		
		Relation roleModuleRole = new Relation(getId(), "role", "ManyToOne", roleModule);
		Relation roleModuleModule = new Relation(getId(), "module", "ManyToOne", roleModule);
		Relation roleModuleNavMenu = new Relation(getId(), "navMenus", "OneToMany", roleModule);

		Relation accountRole = new Relation(getId(), "role", "ManyToOne", account);
		Relation accountDepartment = new Relation(getId(), "department", "ManyToOne", account);
		
		Relation moduleRoleModule = new Relation(getId(), "roleModules", "OneToMany", module);
		Relation moduleNavMenu = new Relation(getId(), "navMenus", "OneToMany", module);

		Relation navMenuModule = new Relation(getId(), "module", "ManyToOne", navMenu);
		Relation navMenuRoleModule = new Relation(getId(), "roleModules", "ManyToOne", navMenu);

		Relation authRole = new Relation(getId(), "roles", "ManyToMany", auth);
		
		Relation departmentParent = new Relation(getId(), "parent", "ManyToOne", department);
		Relation departmentChildren = new Relation(getId(), "children", "OneToMany", department);
		
		Relation authParent = new Relation(getId(), "parent", "ManyToOne", auth);
		Relation authChildren = new Relation(getId(), "children", "OneToMany", auth);

		Relation navMenuParent = new Relation(getId(), "parent", "ManyToOne", navMenu);
		Relation navMenuChildren = new Relation(getId(), "children", "OneToMany", navMenu);
		
		Relation accountOwner = new Relation(getId(), "owners", "OneToMany", account);
		Relation ownerAccount = new Relation(getId(), "owner", "ManyToOne", mRelation);
		
		Relation accountAffiliated = new Relation(getId(), "affiliateds", "OneToMany", account);
		Relation affiliatedAccount = new Relation(getId(), "affiliated", "ManyToOne", mRelation);
		
		// 关系设置
		authRole.setPosition(1);
		roleAuth.setPosition(2);
		
		accountOwner.setRelation(ownerAccount);
		ownerAccount.setRelation(accountOwner);
		
		accountAffiliated.setRelation(affiliatedAccount);
		affiliatedAccount.setRelation(accountAffiliated);
		
		groupDepartment.setRelation(departmentGroup);
		departmentGroup.setRelation(groupDepartment);

		groupGroupType.setRelation(groupTypeGroup);
		groupTypeGroup.setRelation(groupGroupType);

		groupTypeRole.setRelation(roleGroupType);
		roleGroupType.setRelation(groupTypeRole);

		roleRoleModule.setRelation(roleModuleRole);
		roleModuleRole.setRelation(roleRoleModule);
		
		roleModuleModule.setRelation(moduleRoleModule);
		moduleRoleModule.setRelation(roleModuleModule);
		
		roleModuleNavMenu.setRelation(navMenuRoleModule);
		navMenuRoleModule.setRelation(roleModuleNavMenu);
		
		roleAuth.setRelation(authRole);
		authRole.setRelation(roleAuth);
		
		roleAccount.setRelation(accountRole);
		accountRole.setRelation(roleAccount);
		
		navMenuModule.setRelation(moduleNavMenu);
		moduleNavMenu.setRelation(navMenuModule);
		
		departmentParent.setRelation(departmentChildren);
		departmentChildren.setRelation(departmentParent);
		
		authParent.setRelation(authChildren);
		authChildren.setRelation(authParent);
		
		navMenuParent.setRelation(navMenuChildren);
		navMenuChildren.setRelation(navMenuParent);
		
		departmentAccount.setRelation(accountDepartment);
		accountDepartment.setRelation(departmentAccount);
		// 添加关系
		group.addRelation(groupDepartment);
		group.addRelation(groupGroupType);

		department.addRelation(departmentGroup);
		department.addRelation(departmentAccount);
		department.addRelation(departmentParent);
		department.addRelation(departmentChildren);

		groupType.addRelation(groupTypeGroup);
		groupType.addRelation(groupTypeRole);
		
		role.addRelation(roleAuth);
		role.addRelation(roleAccount);
		role.addRelation(roleGroupType);
		role.addRelation(roleRoleModule);

		roleModule.addRelation(roleModuleModule);
		roleModule.addRelation(roleModuleNavMenu);
		roleModule.addRelation(roleModuleRole);
		
		account.addRelation(accountRole);
		account.addRelation(accountDepartment);
		account.addRelation(accountOwner);
		account.addRelation(accountAffiliated);
		
		auth.addRelation(authRole);
		auth.addRelation(authParent);
		auth.addRelation(authChildren);
		
		module.addRelation(moduleRoleModule);
		module.addRelation(moduleNavMenu);
		
		navMenu.addRelation(navMenuRoleModule);
		navMenu.addRelation(navMenuModule);
		navMenu.addRelation(navMenuParent);
		navMenu.addRelation(navMenuChildren);

		mRelation.addRelation(ownerAccount);
		mRelation.addRelation(affiliatedAccount);
		
		// 添加模型
		models.add(group);
		models.add(department);
		models.add(groupType);
		models.add(role);
		models.add(account);
		models.add(auth);
		models.add(module);
		models.add(roleModule);
		models.add(navMenu);
		models.add(mRelation);

		return models;
	}

	public static List<Page> initPage(List<Model> models) {
		List<Page> pages = new ArrayList<Page>();
		for (Model model : models) {
			Page page = new Page(getId(), model.getLowName() + "_list", model.getAlies() + "查询", "curd");

			Panel listPanel = new Panel(getId(), model.getLowName() + "_list", model.getAlies() + "列表", "list");
			for (ModelAttribute attr : model.getAttributes()) {
				listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "read"));
			Store listStore = new Store(getId(), model, model.getFunctions().get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName() + "_search", "查询" + model.getAlies(), "search");
			for (ModelAttribute attr : model.getAttributes()) {
				searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);

			Panel readPanel = new Panel(getId(), model.getLowName() + "_read", "查看" + model.getAlies() + "详情", "read");
			for (ModelAttribute attr : model.getAttributes()) {
				readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(), model, model.getFunctions().get(3));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);

			pages.add(page);
		}
		for (Model model : models) {
			Page page = new Page(getId(), model.getLowName(), model.getAlies() + "管理", "curd");

			Panel listPanel = new Panel(getId(), model.getLowName() + "_list", model.getAlies() + "列表", "list");
			for (ModelAttribute attr : model.getAttributes()) {
				listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
			Store listStore = new Store(getId(), model, model.getFunctions().get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName() + "_search", "查询" + model.getAlies(), "search");
			for (ModelAttribute attr : model.getAttributes()) {
				searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);

			Panel addPanel = new Panel(getId(), model.getLowName() + "_add", "添加" + model.getAlies(), "add");
			for (ModelAttribute attr : model.getAttributes()) {
				addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store addStore = new Store(getId(), model, model.getFunctions().get(0));
			addPanel.setStore(addStore);
			page.addPanel(addPanel);

			Panel removePanel = new Panel(getId(), model.getLowName() + "_remove", "删除" + model.getAlies(), "remove");
			Store removeStore = new Store(getId(), model, model.getFunctions().get(1));
			removePanel.setStore(removeStore);
			page.addPanel(removePanel);

			Panel modifyPanel = new Panel(getId(), model.getLowName() + "_modify", "修改" + model.getAlies(), "modify");
			for (ModelAttribute attr : model.getAttributes()) {
				modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store modifyStore = new Store(getId(), model, model.getFunctions().get(2));
			modifyPanel.setStore(modifyStore);
			page.addPanel(modifyPanel);

			Panel readPanel = new Panel(getId(), model.getLowName() + "_read", "查看" + model.getAlies() + "详情", "read");
			for (ModelAttribute attr : model.getAttributes()) {
				readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(), model, model.getFunctions().get(3));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);

			pages.add(page);
		}
		for (Model model : models) {
			List<ModelAttribute> attrs = model.getAttributes();
			boolean tag = false;
			for (ModelAttribute attr : attrs) {
				if ("status".equals(attr.getName())) {
					tag = true;
					break;
				}
			}
			if (tag) {
				Page page = new Page(getId(), model.getLowName() + "_review", model.getAlies() + "审核", "curd");

				Panel listPanel = new Panel(getId(), model.getLowName() + "_list", model.getAlies() + "列表", "list");
				for (ModelAttribute attr : model.getAttributes()) {
					listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid", "text"));
				}
				listPanel.addPerporty(new PanelPerporty(getId(), "id", "审核", "grid", "review"));
				Store listStore = new Store(getId(), model, model.getFunctions().get(4));
				listPanel.setStore(listStore);
				page.addPanel(listPanel);

				Panel reviewPanel = new Panel(getId(), model.getLowName() + "_httl", "审核" + model.getAlies(), "review");
				Store reviewStore = new Store(getId(), model, model.getFunctions().get(1));
				reviewPanel.setStore(reviewStore);
				page.addPanel(reviewPanel);

				Panel readPanel = new Panel(getId(), model.getLowName() + "_read", "查看" + model.getAlies() + "详情",
						"read");
				for (ModelAttribute attr : model.getAttributes()) {
					readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form", "input"));
				}
				Store readStore = new Store(getId(), model, model.getFunctions().get(3));
				readPanel.setStore(readStore);
				page.addPanel(readPanel);

				pages.add(page);
			}
		}
		for (Model model : models) {
			for (Relation relation : model.getRelations()) {
				if ("children".equals(relation.getName())) {
					Page page = new Page(getId(), model.getLowName() + "_tree", model.getAlies() + "管理", "tree_mgr");

					Panel treePanel = new Panel(getId(), model.getLowName() + "_tree", model.getAlies() + "列表",
							"tree_mgr");
					for (ModelAttribute attr : model.getAttributes()) {
						treePanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store treeStore = new Store(getId(), model, new Function(getId(), "tree", "树查询", 1));
					treePanel.setStore(treeStore);
					page.addPanel(treePanel);

					Panel listPanel = new Panel(getId(), model.getLowName() + "_list", model.getAlies() + "列表", "list");
					for (ModelAttribute attr : model.getAttributes()) {
						listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid",
								"text"));
					}
					listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store listStore = new Store(getId(), model, model.getFunctions().get(4));
					listPanel.setStore(listStore);
					page.addPanel(listPanel);

					Panel searchPanel = new Panel(getId(), model.getLowName() + "_search", "查询" + model.getAlies(),
							"search");
					for (ModelAttribute attr : model.getAttributes()) {
						searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					page.addPanel(searchPanel);

					Panel addPanel = new Panel(getId(), model.getLowName() + "_add", "添加" + model.getAlies(),
							"tree_add");
					for (ModelAttribute attr : model.getAttributes()) {
						addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store addStore = new Store(getId(), model, model.getFunctions().get(0));
					addPanel.setStore(addStore);
					page.addPanel(addPanel);

					Panel removePanel = new Panel(getId(), model.getLowName() + "_remove", "删除" + model.getAlies(),
							"remove");
					Store removeStore = new Store(getId(), model, model.getFunctions().get(1));
					removePanel.setStore(removeStore);
					page.addPanel(removePanel);

					Panel modifyPanel = new Panel(getId(), model.getLowName() + "_modify", "修改" + model.getAlies(),
							"modify");
					for (ModelAttribute attr : model.getAttributes()) {
						modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store modifyStore = new Store(getId(), model, model.getFunctions().get(2));
					modifyPanel.setStore(modifyStore);
					page.addPanel(modifyPanel);

					Panel readPanel = new Panel(getId(), model.getLowName() + "_read", "查看" + model.getAlies() + "详情",
							"read");
					for (ModelAttribute attr : model.getAttributes()) {
						readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store readStore = new Store(getId(), model, model.getFunctions().get(3));
					readPanel.setStore(readStore);
					page.addPanel(readPanel);

					pages.add(page);
				}
			}
		}
		for (Model model : models) {
			for (Model detailModel : models) {
				if ((model.getName() + "Detail").equals(detailModel.getName())) {
					List<Page> tempPage = new ArrayList<Page>();
					for (Page pg : pages) {
						if (!(pg.getName().equals(model.getLowName()) || pg.getName().equals(detailModel.getLowName()))) {
							tempPage.add(pg);
						}
					}
					pages = tempPage;
					Page page = new Page(getId(), model.getLowName(), model.getAlies() + "管理", "curd");

					Panel listPanel = new Panel(getId(), model.getLowName() + "_list", model.getAlies() + "列表",
							"sub_list");
					for (ModelAttribute attr : model.getAttributes()) {
						listPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid",
								"text"));
					}
					listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store listStore = new Store(getId(), model, model.getFunctions().get(4));
					listPanel.setStore(listStore);
					page.addPanel(listPanel);

					Panel subListPanel = new Panel(getId(), detailModel.getLowName() + "_list", detailModel.getAlies()
							+ "列表", "sub_list");
					for (ModelAttribute attr : detailModel.getAttributes()) {
						subListPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "grid",
								"text"));
					}
					subListPanel.addPerporty(new PanelPerporty(getId(), "id", "操作", "grid", "rud"));
					Store subListStore = new Store(getId(), detailModel, detailModel.getFunctions().get(4));
					listPanel.setStore(subListStore);
					page.addPanel(subListPanel);

					Panel searchPanel = new Panel(getId(), model.getLowName() + "_search", "查询" + model.getAlies(),
							"search");
					for (ModelAttribute attr : model.getAttributes()) {
						searchPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					page.addPanel(searchPanel);

					Panel addPanel = new Panel(getId(), model.getLowName() + "_add", "添加" + model.getAlies(), "sub_add");
					for (ModelAttribute attr : model.getAttributes()) {
						addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store addStore = new Store(getId(), model, model.getFunctions().get(0));
					addPanel.setStore(addStore);
					page.addPanel(addPanel);

					Panel removePanel = new Panel(getId(), model.getLowName() + "_remove", "删除" + model.getAlies(),
							"sub_remove");
					Store removeStore = new Store(getId(), model, model.getFunctions().get(1));
					removePanel.setStore(removeStore);
					page.addPanel(removePanel);

					Panel modifyPanel = new Panel(getId(), model.getLowName() + "_modify", "修改" + model.getAlies(),
							"sub_modify");
					for (ModelAttribute attr : model.getAttributes()) {
						modifyPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store modifyStore = new Store(getId(), model, model.getFunctions().get(2));
					modifyPanel.setStore(modifyStore);
					page.addPanel(modifyPanel);

					Panel readPanel = new Panel(getId(), model.getLowName() + "_read", "查看" + model.getAlies() + "详情",
							"sub_read");
					for (ModelAttribute attr : model.getAttributes()) {
						readPanel.addPerporty(new PanelPerporty(getId(), attr.getName(), attr.getAlies(), "form",
								"input"));
					}
					Store readStore = new Store(getId(), model, model.getFunctions().get(3));
					readPanel.setStore(readStore);
					page.addPanel(readPanel);

					pages.add(page);
				}
			}
		}

		return pages;
	}

	public static List<Navbar> initNavbars(List<Model> models) {
		List<Navbar> list = new ArrayList<Navbar>();
		Navbar nav = new Navbar(getId(), "workspace", "工作台", Navbar.TYPE_PAGE, "workspace.html");
		List<Navbar> children = new ArrayList<Navbar>();
		for (Model model : models) {
			boolean tag = true;
			for (Relation relation : model.getRelations()) {
				if ("OneToMany".equals(relation.getType()) && model.equals(relation.getRelation().getModel())) {
					tag = false;
					Navbar sub = new Navbar(getId(), model.getName(), model.getAlies() + "管理", Navbar.TYPE_PAGE, model
							.getLowName()
							+ "_tree.html");
					children.add(sub);
				}
			}
			if (tag) {
				Navbar sub = new Navbar(getId(), model.getName(), model.getAlies() + "管理", Navbar.TYPE_PAGE, model
						.getLowName()
						+ ".html");
				children.add(sub);
			}
		}
		nav.setChildren(children);
		list.add(nav);
		return list;
	}

	private static String getId() {
		return String.valueOf((long) Math.floor(Math.random() * 100000000));
	}

	public static Project getProject() {
		Project project = new Project("123456", "BBcarePlat", "BBcare管理平台", new Frame(getId(), "sh", "SH"),
				new Frame(getId(), "smartadmin", "SmartAdmin"), new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.plat");
		project.setModels(initModels(project));
		for (int i = 0; i < project.getModels().size(); i++) {
			List<Function> functions = getFunctions();
			for (int j = 0; j < functions.size(); j++) {
				for (ModelAttribute attr : project.getModels().get(i).getAttributes()) {
					functions.get(j).addInput(attr);
					functions.get(j).addOutput(attr);
				}
			}
			for (Relation relation : project.getModels().get(i).getRelations()) {
				if ("children".equals(relation.getName())) {
					Function function = new Function(getId(), "tree", project.getModels().get(i).getAlies() + "树", 1);
					for (ModelAttribute attr : project.getModels().get(i).getAttributes()) {
						function.addInput(attr);
						function.addOutput(attr);
					}
					functions.add(function);
				}
			}
			for (ModelAttribute mattr : project.getModels().get(i).getAttributes()) {
				if ("status".equals(mattr.getName())) {
					Function function = new Function(getId(), "review", project.getModels().get(i).getAlies() + "审核", 1);
					for (ModelAttribute attr : project.getModels().get(i).getAttributes()) {
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
		project.setDataSource(new DataSource(
						getId(),
						"mysql",
						"mysql",
						"mysql://lecbuild.mysql.rds.aliyuncs.com:3306/bbcare_cloud_plat?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"username", "password"));
		return project;
	}
}
