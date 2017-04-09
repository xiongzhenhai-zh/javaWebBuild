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

public class BBcareNewDoctor {

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
		List<Model> models= new ArrayList<Model>();
		
		Model adminDoctorItem = new Model(getId(),"AdminDoctorItem","首页用团队","uuid",project);
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"name","团队名称","String"));
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"features","服务特色","String"));
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"note","说明","String"));
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"icon","图标","String"));
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"type","规格","String"));
		adminDoctorItem.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","String"));
		
		Model adminDoctor = new Model(getId(),"AdminDoctor","首页用医生","uuid",project);
		adminDoctor.addAttribute(new ModelAttribute(getId(),"doctorId","医生Id","String"));
		
		Model adminProduct = new Model(getId(),"AdminProduct","首页用产品","uuid",project);
		adminProduct.addAttribute(new ModelAttribute(getId(),"productId","产品Id","String"));
		adminProduct.addAttribute(new ModelAttribute(getId(),"name","产品名称","String"));
		adminProduct.addAttribute(new ModelAttribute(getId(),"price","价格","String"));
		adminProduct.addAttribute(new ModelAttribute(getId(),"cycle","服务周期","String"));
		adminProduct.addAttribute(new ModelAttribute(getId(),"send","赠品","String"));

		Relation adminDoctorItemAdminDoctor = new Relation(getId(),"adminDoctors", "OneToMany", adminDoctorItem);
		Relation adminDoctorAdminDoctorItem = new Relation(getId(),"adminDoctorItem", "ManyToOne", adminDoctor);
		
		Relation adminDoctorItemAdminProduct = new Relation(getId(),"adminProducts", "OneToMany", adminDoctorItem);
		Relation adminProductAdminDoctorItem = new Relation(getId(),"adminDoctorItem", "ManyToOne", adminProduct);
		
		adminDoctorItemAdminDoctor.setRelation(adminDoctorAdminDoctorItem);
		adminDoctorAdminDoctorItem.setRelation(adminDoctorItemAdminDoctor);
		
		
		adminDoctorItemAdminProduct.setRelation(adminProductAdminDoctorItem);
		adminProductAdminDoctorItem.setRelation(adminDoctorItemAdminProduct);
		
		adminDoctorItem.addRelation(adminDoctorItemAdminProduct);
		adminDoctorItem.addRelation(adminDoctorItemAdminDoctor);
		
		adminProduct.addRelation(adminProductAdminDoctorItem);
		
		adminDoctor.addRelation(adminDoctorAdminDoctorItem);
		
		// 添加模型
		models.add(adminDoctorItem);
		models.add(adminDoctor);
		models.add(adminProduct);
		return models;
	}

	public static List<Page> initPage(List<Model> models) {
		List<Page> pages = new ArrayList<Page>();
		for (Model model : models) {
			Page page = new Page(getId(), model.getLowName() + "_list", model
				.getAlies()
				+ "查询", "curd");

			Panel listPanel = new Panel(getId(), model.getLowName() + "_list",
				model.getAlies() + "列表", "list");
			for (ModelAttribute attr : model.getAttributes()) {
				listPanel.addPerporty(new PanelPerporty(getId(),
					attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作",
				"grid", "read"));
			Store listStore = new Store(getId(), model, model.getFunctions()
				.get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName()
				+ "_search", "查询" + model.getAlies(), "search");
			for (ModelAttribute attr : model.getAttributes()) {
				searchPanel.addPerporty(new PanelPerporty(getId(), attr
					.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);

			Panel readPanel = new Panel(getId(), model.getLowName() + "_read",
				"查看" + model.getAlies() + "详情", "read");
			for (ModelAttribute attr : model.getAttributes()) {
				readPanel.addPerporty(new PanelPerporty(getId(),
					attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(), model, model.getFunctions()
				.get(3));
			readPanel.setStore(readStore);
			page.addPanel(readPanel);

			pages.add(page);
		}
		for (Model model : models) {
			Page page = new Page(getId(), model.getLowName(), model.getAlies()
				+ "管理", "curd");

			Panel listPanel = new Panel(getId(), model.getLowName() + "_list",
				model.getAlies() + "列表", "list");
			for (ModelAttribute attr : model.getAttributes()) {
				listPanel.addPerporty(new PanelPerporty(getId(),
					attr.getName(), attr.getAlies(), "grid", "text"));
			}
			listPanel.addPerporty(new PanelPerporty(getId(), "id", "操作",
				"grid", "rud"));
			Store listStore = new Store(getId(), model, model.getFunctions()
				.get(4));
			listPanel.setStore(listStore);
			page.addPanel(listPanel);

			Panel searchPanel = new Panel(getId(), model.getLowName()
				+ "_search", "查询" + model.getAlies(), "search");
			for (ModelAttribute attr : model.getAttributes()) {
				searchPanel.addPerporty(new PanelPerporty(getId(), attr
					.getName(), attr.getAlies(), "form", "input"));
			}
			page.addPanel(searchPanel);

			Panel addPanel = new Panel(getId(), model.getLowName() + "_add",
				"添加" + model.getAlies(), "add");
			for (ModelAttribute attr : model.getAttributes()) {
				addPanel.addPerporty(new PanelPerporty(getId(), attr.getName(),
					attr.getAlies(), "form", "input"));
			}
			Store addStore = new Store(getId(), model, model.getFunctions()
				.get(0));
			addPanel.setStore(addStore);
			page.addPanel(addPanel);

			Panel removePanel = new Panel(getId(), model.getLowName()
				+ "_remove", "删除" + model.getAlies(), "remove");
			Store removeStore = new Store(getId(), model, model.getFunctions()
				.get(1));
			removePanel.setStore(removeStore);
			page.addPanel(removePanel);

			Panel modifyPanel = new Panel(getId(), model.getLowName()
				+ "_modify", "修改" + model.getAlies(), "modify");
			for (ModelAttribute attr : model.getAttributes()) {
				modifyPanel.addPerporty(new PanelPerporty(getId(), attr
					.getName(), attr.getAlies(), "form", "input"));
			}
			Store modifyStore = new Store(getId(), model, model.getFunctions()
				.get(2));
			modifyPanel.setStore(modifyStore);
			page.addPanel(modifyPanel);

			Panel readPanel = new Panel(getId(), model.getLowName() + "_read",
				"查看" + model.getAlies() + "详情", "read");
			for (ModelAttribute attr : model.getAttributes()) {
				readPanel.addPerporty(new PanelPerporty(getId(),
					attr.getName(), attr.getAlies(), "form", "input"));
			}
			Store readStore = new Store(getId(), model, model.getFunctions()
				.get(3));
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
				Page page = new Page(getId(), model.getLowName() + "_review",
					model.getAlies() + "审核", "curd");

				Panel listPanel = new Panel(getId(), model.getLowName()
					+ "_list", model.getAlies() + "列表", "list");
				for (ModelAttribute attr : model.getAttributes()) {
					listPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "grid", "text"));
				}
				listPanel.addPerporty(new PanelPerporty(getId(), "id", "审核",
					"grid", "review"));
				Store listStore = new Store(getId(), model, model
					.getFunctions().get(4));
				listPanel.setStore(listStore);
				page.addPanel(listPanel);

				Panel reviewPanel = new Panel(getId(), model.getLowName()
					+ "_httl", "审核" + model.getAlies(), "review");
				Store reviewStore = new Store(getId(), model, model
					.getFunctions().get(1));
				reviewPanel.setStore(reviewStore);
				page.addPanel(reviewPanel);

				Panel readPanel = new Panel(getId(), model.getLowName()
					+ "_read", "查看" + model.getAlies() + "详情", "read");
				for (ModelAttribute attr : model.getAttributes()) {
					readPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "form", "input"));
				}
				Store readStore = new Store(getId(), model, model
					.getFunctions().get(3));
				readPanel.setStore(readStore);
				page.addPanel(readPanel);

				pages.add(page);
			}
		}
		for (Model model : models) {
			for (Relation relation : model.getRelations()) {
				if ("children".equals(relation.getName())) {
					Page page = new Page(getId(), model.getLowName() + "_tree",
						model.getAlies() + "管理", "tree_mgr");

					Panel treePanel = new Panel(getId(), model.getLowName()
						+ "_tree", model.getAlies() + "列表", "tree_mgr");
					for (ModelAttribute attr : model.getAttributes()) {
						treePanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "form", "input"));
					}
					Store treeStore = new Store(getId(), model, new Function(
						getId(), "tree", "树查询", 1));
					treePanel.setStore(treeStore);
					page.addPanel(treePanel);

					Panel listPanel = new Panel(getId(), model.getLowName()
						+ "_list", model.getAlies() + "列表", "list");
					for (ModelAttribute attr : model.getAttributes()) {
						listPanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "grid", "text"));
					}
					listPanel.addPerporty(new PanelPerporty(getId(), "id",
						"操作", "grid", "rud"));
					Store listStore = new Store(getId(), model, model
						.getFunctions().get(4));
					listPanel.setStore(listStore);
					page.addPanel(listPanel);

					Panel searchPanel = new Panel(getId(), model.getLowName()
						+ "_search", "查询" + model.getAlies(), "search");
					for (ModelAttribute attr : model.getAttributes()) {
						searchPanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "form", "input"));
					}
					page.addPanel(searchPanel);

					Panel addPanel = new Panel(getId(), model.getLowName()
						+ "_add", "添加" + model.getAlies(), "tree_add");
					for (ModelAttribute attr : model.getAttributes()) {
						addPanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "form", "input"));
					}
					Store addStore = new Store(getId(), model, model
						.getFunctions().get(0));
					addPanel.setStore(addStore);
					page.addPanel(addPanel);

					Panel removePanel = new Panel(getId(), model.getLowName()
						+ "_remove", "删除" + model.getAlies(), "remove");
					Store removeStore = new Store(getId(), model, model
						.getFunctions().get(1));
					removePanel.setStore(removeStore);
					page.addPanel(removePanel);

					Panel modifyPanel = new Panel(getId(), model.getLowName()
						+ "_modify", "修改" + model.getAlies(), "modify");
					for (ModelAttribute attr : model.getAttributes()) {
						modifyPanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "form", "input"));
					}
					Store modifyStore = new Store(getId(), model, model
						.getFunctions().get(2));
					modifyPanel.setStore(modifyStore);
					page.addPanel(modifyPanel);

					Panel readPanel = new Panel(getId(), model.getLowName()
						+ "_read", "查看" + model.getAlies() + "详情", "read");
					for (ModelAttribute attr : model.getAttributes()) {
						readPanel.addPerporty(new PanelPerporty(getId(), attr
							.getName(), attr.getAlies(), "form", "input"));
					}
					Store readStore = new Store(getId(), model, model
						.getFunctions().get(3));
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
						if (!(pg.getName().equals(model.getLowName()) || pg
							.getName().equals(detailModel.getLowName()))) {
							tempPage.add(pg);
					}
				}
				pages = tempPage;
				Page page = new Page(getId(), model.getLowName(), model
					.getAlies()
					+ "管理", "curd");

				Panel listPanel = new Panel(getId(), model.getLowName()
					+ "_list", model.getAlies() + "列表", "sub_list");
				for (ModelAttribute attr : model.getAttributes()) {
					listPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "grid", "text"));
				}
				listPanel.addPerporty(new PanelPerporty(getId(), "id",
					"操作", "grid", "rud"));
				Store listStore = new Store(getId(), model, model
					.getFunctions().get(4));
				listPanel.setStore(listStore);
				page.addPanel(listPanel);

				Panel subListPanel = new Panel(getId(), detailModel
					.getLowName()
					+ "_list", detailModel.getAlies() + "列表",
					"sub_list");
				for (ModelAttribute attr : detailModel.getAttributes()) {
					subListPanel
					.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "grid",
						"text"));
				}
				subListPanel.addPerporty(new PanelPerporty(getId(), "id",
					"操作", "grid", "rud"));
				Store subListStore = new Store(getId(), detailModel,
					detailModel.getFunctions().get(4));
				listPanel.setStore(subListStore);
				page.addPanel(subListPanel);

				Panel searchPanel = new Panel(getId(), model.getLowName()
					+ "_search", "查询" + model.getAlies(), "search");
				for (ModelAttribute attr : model.getAttributes()) {
					searchPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "form", "input"));
				}
				page.addPanel(searchPanel);

				Panel addPanel = new Panel(getId(), model.getLowName()
					+ "_add", "添加" + model.getAlies(), "sub_add");
				for (ModelAttribute attr : model.getAttributes()) {
					addPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "form", "input"));
				}
				Store addStore = new Store(getId(), model, model
					.getFunctions().get(0));
				addPanel.setStore(addStore);
				page.addPanel(addPanel);

				Panel removePanel = new Panel(getId(), model.getLowName()
					+ "_remove", "删除" + model.getAlies(), "sub_remove");
				Store removeStore = new Store(getId(), model, model
					.getFunctions().get(1));
				removePanel.setStore(removeStore);
				page.addPanel(removePanel);

				Panel modifyPanel = new Panel(getId(), model.getLowName()
					+ "_modify", "修改" + model.getAlies(), "sub_modify");
				for (ModelAttribute attr : model.getAttributes()) {
					modifyPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "form", "input"));
				}
				Store modifyStore = new Store(getId(), model, model
					.getFunctions().get(2));
				modifyPanel.setStore(modifyStore);
				page.addPanel(modifyPanel);

				Panel readPanel = new Panel(getId(), model.getLowName()
					+ "_read", "查看" + model.getAlies() + "详情",
					"sub_read");
				for (ModelAttribute attr : model.getAttributes()) {
					readPanel.addPerporty(new PanelPerporty(getId(), attr
						.getName(), attr.getAlies(), "form", "input"));
				}
				Store readStore = new Store(getId(), model, model
					.getFunctions().get(3));
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
	Navbar nav = new Navbar(getId(), "workspace", "工作台", Navbar.TYPE_PAGE,
		"workspace.html");
	List<Navbar> children = new ArrayList<Navbar>();
	for (Model model : models) {
		boolean tag = true;
		for (Relation relation : model.getRelations()) {
			if ("OneToMany".equals(relation.getType())
				&& model.equals(relation.getRelation().getModel())) {
				tag = false;
			Navbar sub = new Navbar(getId(), model.getName(), model
				.getAlies()
				+ "管理", Navbar.TYPE_PAGE, model.getLowName()
				+ "_tree.html");
			children.add(sub);
		}
	}
	if (tag) {
		Navbar sub = new Navbar(getId(), model.getName(), model
			.getAlies()
			+ "管理", Navbar.TYPE_PAGE, model.getLowName() + ".html");
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
	Project project = new Project("123456", "BBcareNewDoctor",
		"BBcare服务管理系统", new Frame(getId(), "ssh", "SSH"), new Frame(getId(),
			"smartadmin", "SmartAdmin"), new Frame(getId(),
			"jquerymobile", "jquerymobile"));
	project.setPkgName("com.bbcare.cloud.server");
	project.setModels(initModels(project));
	for (int i = 0; i < project.getModels().size(); i++) {
		List<Function> functions = getFunctions();
		for (int j = 0; j < functions.size(); j++) {
			for (ModelAttribute attr : project.getModels().get(i)
				.getAttributes()) {
				functions.get(j).addInput(attr);
			functions.get(j).addOutput(attr);
		}
	}
	for (Relation relation : project.getModels().get(i).getRelations()) {
		if ("children".equals(relation.getName())) {
			Function function = new Function(getId(), "tree", project
				.getModels().get(i).getAlies()
				+ "树", 1);
			for (ModelAttribute attr : project.getModels().get(i)
				.getAttributes()) {
				function.addInput(attr);
			function.addOutput(attr);
		}
		functions.add(function);
	}
}
for (ModelAttribute mattr : project.getModels().get(i)
	.getAttributes()) {
	if ("status".equals(mattr.getName())) {
		Function function = new Function(getId(), "review", project
			.getModels().get(i).getAlies()
			+ "审核", 1);
		for (ModelAttribute attr : project.getModels().get(i)
			.getAttributes()) {
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
project
.setDataSource(new DataSource(
	getId(),
	"mysql",
	"mysql",
	"mysql://localhost:3306/xzh_test?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
	"root", ""));
return project;
}
}
