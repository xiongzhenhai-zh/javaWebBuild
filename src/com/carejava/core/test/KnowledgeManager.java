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

public class KnowledgeManager {

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
		
		Model admin = new Model(getId(), "Admin", "知识管理者", "uuid", project);
		admin.addAttribute(new ModelAttribute(getId(), "type","类型","String"));
		admin.addAttribute(new ModelAttribute(getId(), "status","状态","String"));
		admin.addAttribute(new ModelAttribute(getId(), "alias","别名","String"));
		admin.addAttribute(new ModelAttribute(getId(), "createTime","创建时间","Date"));
		admin.addAttribute(new ModelAttribute(getId(), "note","备注","String"));
		
		
		Model knowledge = new Model(getId(), "Knowledge", "知识", "uuid", project);
		knowledge.addAttribute(new ModelAttribute(getId(), "title","标题","String"));
		knowledge.addAttribute(new ModelAttribute(getId(), "context","内容","String"));
		knowledge.addAttribute(new ModelAttribute(getId(), "author","作者","String"));
		knowledge.addAttribute(new ModelAttribute(getId(), "type","类型","Integer"));
		knowledge.addAttribute(new ModelAttribute(getId(), "digest","整理人","String"));
		knowledge.addAttribute(new ModelAttribute(getId(), "sourceUrl","媒体地址","String"));
		knowledge.addAttribute(new ModelAttribute(getId(), "startAge","开始时间","Integer"));
		knowledge.addAttribute(new ModelAttribute(getId(), "endAge","结束时间","Integer"));
		knowledge.addAttribute(new ModelAttribute(getId(), "status","状态","String"));
		
		Model item = new Model(getId(), "Item", "频道", "uuid", project);
		item.addAttribute(new ModelAttribute(getId(), "status","状态","String"));
		item.addAttribute(new ModelAttribute(getId(), "name","名字","String"));
		item.addAttribute(new ModelAttribute(getId(), "order","排序","Integer"));
		item.addAttribute(new ModelAttribute(getId(), "icon","图标","String"));
		item.addAttribute(new ModelAttribute(getId(), "logo","Logo","String"));
		item.addAttribute(new ModelAttribute(getId(), "note","介绍","String"));
		item.addAttribute(new ModelAttribute(getId(), "author","作者","String"));
		
		Model subscribeHistory = new Model(getId(), "SubscribeHistory", "订阅历史", "uuid", project);
		subscribeHistory.addAttribute(new ModelAttribute(getId(), "createTime","创建时间","Date"));
		subscribeHistory.addAttribute(new ModelAttribute(getId(), "status","状态","String"));
		subscribeHistory.addAttribute(new ModelAttribute(getId(), "channeld","渠道编号","String"));
		
		
		Model subscriber = new Model(getId(), "Subscriber", "订阅者", "uuid", project);
		subscriber.addAttribute(new ModelAttribute(getId(), "userId","编号","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "clientType","客户端类型","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "clientId","客户端ID","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "status","状态","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "type","类型","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "note","备注","String"));
		subscriber.addAttribute(new ModelAttribute(getId(), "age","年龄","Integer"));
		subscriber.addAttribute(new ModelAttribute(getId(), "openId","访问应用标识","String"));
		
		Model channel = new Model(getId(), "Channel", "渠道", "uuid", project);
		channel.addAttribute(new ModelAttribute(getId(), "name","渠道名字","String"));
		channel.addAttribute(new ModelAttribute(getId(), "channelSecret","渠道秘钥","String"));
		channel.addAttribute(new ModelAttribute(getId(), "openlevel","开放等级","String"));
		
		Model pushSet = new Model(getId(), "PushSet", "推送设置", "uuid", project);
		pushSet.addAttribute(new ModelAttribute(getId(), "name","名字","String"));
		pushSet.addAttribute(new ModelAttribute(getId(), "startTime","开始时间","Date"));
		pushSet.addAttribute(new ModelAttribute(getId(), "endTime","结束时间","Date"));
		pushSet.addAttribute(new ModelAttribute(getId(), "frequency","频率","String"));
		pushSet.addAttribute(new ModelAttribute(getId(), "nextPushTime","下次推送时间","Date"));
		pushSet.addAttribute(new ModelAttribute(getId(), "pushRule","推送规则","String"));
		
		
		Model knowledgeType = new Model(getId(), "KnowledgeType", "类别", "uuid", project);
		knowledgeType.addAttribute(new ModelAttribute(getId(), "name","类别名字","String"));
		knowledgeType.addAttribute(new ModelAttribute(getId(), "icon","类别图标","String"));
		knowledgeType.addAttribute(new ModelAttribute(getId(), "order","类别排序","Integer"));
		
		Model mediaObject = new Model(getId(), "MediaObject", "媒体对象", "uuid", project);
		mediaObject.addAttribute(new ModelAttribute(getId(), "type","类别","String"));
		mediaObject.addAttribute(new ModelAttribute(getId(), "path","地址","String"));
		
		
		// 关系列表
		Relation itemKnowledge=new Relation(getId(),"knowledges","OneToMany",item);
		Relation knowledgeItem=new Relation(getId(),"item","ManyToOne",knowledge);
		
		Relation adminItem=new Relation(getId(),"items","ManyToMany",admin);
		Relation itemAdmin=new Relation(getId(),"admins","ManyToMany",item);

		Relation itemSubscribeHistory=new Relation(getId(),"subscribeHistorys","OneToMany",item);
		Relation subscribeHistoryItem=new Relation(getId(),"item","ManyToOne",subscribeHistory);
		
		Relation subscriberSubscribeHistory=new Relation(getId(),"subscribeHistorys","OneToMany",subscriber);
		Relation subscribeHistorySubscriber=new Relation(getId(),"subscriber","ManyToOne",subscribeHistory);
		
		Relation subscriberChannel=new Relation(getId(),"channels","OneToMany",subscriber);
		Relation channelSubscriber=new Relation(getId(),"subscriber","ManyToOne",channel);
		
		Relation channelPushSet=new Relation(getId(),"pushSets","OneToMany",channel);
		Relation pushSetChannel=new Relation(getId(),"channel","ManyToOne",pushSet);
		
		Relation itemPushSet=new Relation(getId(),"pushSets","OneToMany",item);
		Relation pushSetItem=new Relation(getId(),"item","ManyToOne",pushSet);
		
		Relation knowledgeMediaObject=new Relation(getId(),"mediaObjects","OneToMany",knowledge);
		Relation mediaObjectKnowledge=new Relation(getId(),"knowledge","ManyToOne",mediaObject);
		
		Relation knowledgeTypeKnowledge=new Relation(getId(),"knowledges","OneToMany",knowledgeType);
		Relation knowledgeKnowledgeType=new Relation(getId(),"knowledgeType","ManyToOne",knowledge);
		
		Relation knowledgeTypeOneKnowledgeType=new Relation(getId(),"children","OneToMany",knowledgeType);
		Relation knowledgeTypeManyKnowledgeType=new Relation(getId(),"parent","ManyToOne",knowledgeType);
		
		
		// 关系设置
		itemKnowledge.setRelation(knowledgeItem);
		knowledgeItem.setRelation(itemKnowledge);
		
		adminItem.setRelation(itemAdmin);
		itemAdmin.setRelation(adminItem);
		
		itemSubscribeHistory.setRelation(subscribeHistoryItem);
		subscribeHistoryItem.setRelation(itemSubscribeHistory);
		
		subscriberSubscribeHistory.setRelation(subscribeHistorySubscriber);
		subscribeHistorySubscriber.setRelation(subscriberSubscribeHistory);
		
		subscriberChannel.setRelation(channelSubscriber);
		channelSubscriber.setRelation(subscriberChannel);
		
		channelPushSet.setRelation(pushSetChannel);
		pushSetChannel.setRelation(channelPushSet);
		
		itemPushSet.setRelation(pushSetItem);
		pushSetItem.setRelation(itemPushSet);
		
		knowledgeMediaObject.setRelation(mediaObjectKnowledge);
		mediaObjectKnowledge.setRelation(knowledgeMediaObject);
		
		knowledgeTypeKnowledge.setRelation(knowledgeKnowledgeType);
		knowledgeKnowledgeType.setRelation(knowledgeTypeKnowledge);
		
		knowledgeTypeOneKnowledgeType.setRelation(knowledgeTypeManyKnowledgeType);
		knowledgeTypeManyKnowledgeType.setRelation(knowledgeTypeOneKnowledgeType);
		
		itemAdmin.setPosition(1);
		adminItem.setPosition(2);
		
		// 添加关系
		admin.addRelation(adminItem);
		
		item.addRelation(itemAdmin);
		item.addRelation(itemKnowledge);
		item.addRelation(itemPushSet);
		item.addRelation(itemSubscribeHistory);

		subscribeHistory.addRelation(subscribeHistorySubscriber);
		subscribeHistory.addRelation(subscribeHistoryItem);
		
		subscriber.addRelation(subscriberChannel);
		subscriber.addRelation(subscriberSubscribeHistory);
		
		channel.addRelation(channelPushSet);
		channel.addRelation(channelSubscriber);
		
		pushSet.addRelation(pushSetItem);
		pushSet.addRelation(pushSetChannel);

		knowledge.addRelation(knowledgeKnowledgeType);
		knowledge.addRelation(knowledgeMediaObject);
		knowledge.addRelation(knowledgeItem);
		
		mediaObject.addRelation(mediaObjectKnowledge);
		
		knowledgeType.addRelation(knowledgeTypeKnowledge);
		knowledgeType.addRelation(knowledgeTypeManyKnowledgeType);
		knowledgeType.addRelation(knowledgeTypeOneKnowledgeType);
		
		// 添加模型
		models.add(admin);
		models.add(knowledge);
		models.add(subscribeHistory);
		models.add(subscriber);
		models.add(channel);
		models.add(pushSet);
		models.add(knowledgeType);
		models.add(mediaObject);
		models.add(item);
	
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
	Project project = new Project("123456", "BBcareKnowledgeManager_v2",
		"BBcare知识库管理系统", new Frame(getId(), "ssh", "SSH"), new Frame(getId(),
			"smartadmin", "SmartAdmin"), new Frame(getId(),
			"jquerymobile", "jquerymobile"));
	project.setPkgName("com.bbcare.cloud.manager.knowledge");
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
	"mysql://localhost:3306/bbcare_mgr_knowledge?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
	"root", "cl123456"));
return project;
}
}
