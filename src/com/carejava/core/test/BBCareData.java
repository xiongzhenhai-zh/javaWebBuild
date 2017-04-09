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

public class BBCareData {

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
		Model account = new Model(getId(), "Account", "账号", "uuid", project);
		account.addAttribute(new ModelAttribute(getId(), "nickname", "用户昵称",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "accountId", "用户编号",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "iconPath", "用户头像",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "sign", "个性签名",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "status", "用户状态",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "accountType", "用户类型",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "level", "用户等级",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "startLevel", "用户星级",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "vipLevel", "VIP等级",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "channelId", "注册渠道",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "createTime", "注册时间",
				"Date"));
		account.addAttribute(new ModelAttribute(getId(), "accountName", "平台账号",
				"String"));
		account.addAttribute(new ModelAttribute(getId(), "password", "平台密码",
				"String"));

		Model baby = new Model(getId(), "Baby", "宝贝", "uuid", project);
		baby.addAttribute(new ModelAttribute(getId(), "babyId", "宝贝编码",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "babyName", "宝贝姓名",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "nickName", "宝贝昵称",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "gender", "宝贝性别",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "birthday", "宝贝生日",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "imageId", "宝贝头像",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "accountId", "用户编号",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "channelId", "绑定渠道",
				"String"));
		baby.addAttribute(new ModelAttribute(getId(), "groupId", "分组编号",
				"String"));
		baby
				.addAttribute(new ModelAttribute(getId(), "note", "宝贝备注",
						"Integer"));

		Model contact = new Model(getId(), "Contact", "联系人", "uuid", project);
		contact.addAttribute(new ModelAttribute(getId(), "uuid", "联系人编码",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "contactName",
				"联系人名称", "String"));
		contact.addAttribute(new ModelAttribute(getId(), "gender", "联系人性别",
				"Integer"));
		contact.addAttribute(new ModelAttribute(getId(), "status", "联系人状态",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "mobile", "联系人手机",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "provinceCode",
				"所在省份", "String"));
		contact.addAttribute(new ModelAttribute(getId(), "cityCode", "所在城市",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "cantonCode", "所在行政区",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "address", "具体地址",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "mobile2", "联系人电话2",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "note", "联系人备注",
				"String"));
		contact.addAttribute(new ModelAttribute(getId(), "relationship",
				"与宝宝关系", "String"));
		contact.addAttribute(new ModelAttribute(getId(), "accountId", "用户编号",
				"String"));

		Model user = new Model(getId(), "User", "用户", "uuid", project);
		user.addAttribute(new ModelAttribute(getId(), "accountId", "用户编号",
				"String"));
		user.addAttribute(new ModelAttribute(getId(), "channelId", "注册渠道",
				"String"));
		user.addAttribute(new ModelAttribute(getId(), "groupId", "分组编号",
				"String"));
		user.addAttribute(new ModelAttribute(getId(), "chaccountId", "渠道用户编号",
				"String"));

		Model channel = new Model(getId(), "Channel", "渠道", "uuid", project);
		channel.addAttribute(new ModelAttribute(getId(), "channelId", "渠道编码",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "channelName", "渠道名称",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "type", "渠道类型",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "status", "渠道状态",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "registerTime",
				"注册日期", "Date"));
		channel.addAttribute(new ModelAttribute(getId(), "startTime", "有效起始日期",
				"Date"));
		channel.addAttribute(new ModelAttribute(getId(), "endTime", "有效截止日期",
				"Date"));
		channel.addAttribute(new ModelAttribute(getId(), "channelKey", "渠道账号",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "channelPass", "渠道密码",
				"String"));
		channel.addAttribute(new ModelAttribute(getId(), "channelSecret",
				"渠道秘钥", "String"));
		channel.addAttribute(new ModelAttribute(getId(), "defaultGroup",
				"用户默认分组", "String"));
		
		

		Model permission = new Model(getId(), "Permission", "权限", "uuid",
				project);
		permission.addAttribute(new ModelAttribute(getId(), "permissionId",
				"权限编号", "String"));
		permission.addAttribute(new ModelAttribute(getId(), "permissionName",
				"权限名称", "String"));
		permission.addAttribute(new ModelAttribute(getId(), "permissionLevel",
				"权限等级", "String"));

		Model group = new Model(getId(), "Group", "分组", "uuid", project);
		group.addAttribute(new ModelAttribute(getId(), "groupId", "分组编号",
				"String"));
		group.addAttribute(new ModelAttribute(getId(), "groupName", "分组名称",
				"String"));
		group.addAttribute(new ModelAttribute(getId(), "parentGroup", "父分组",
				"String"));

		Model privateDatafield = new Model(getId(), "PrivateDatafield",
				"私有数据字段", "uuid", project);
		privateDatafield.addAttribute(new ModelAttribute(getId(), "fieldId",
				"私有数据字段编号", "String"));
		privateDatafield.addAttribute(new ModelAttribute(getId(), "fieldName",
				"私有数据字段名", "String"));
		privateDatafield.addAttribute(new ModelAttribute(getId(), "channelId",
				"渠道编号", "String"));

		Model privateDataValue = new Model(getId(), "PrivateDataValue",
				"私有数据字段值", "uuid", project);
		privateDataValue.addAttribute(new ModelAttribute(getId(), "valueId",
				"私有数据字段编号", "String"));
		privateDataValue.addAttribute(new ModelAttribute(getId(), "value",
				"私有数据字段值", "String"));
		privateDataValue.addAttribute(new ModelAttribute(getId(), "babyId",
				"宝贝编号", "String"));

		Model contactPermission = new Model(getId(), "ContactPermission",
				"联系人权限", "uuid", project);
		contactPermission.addAttribute(new ModelAttribute(getId(),
				"contactPermissionId", "联系人权限编号", "String"));
		contactPermission.addAttribute(new ModelAttribute(getId(),
				"contactPermissionName", "联系人权限名", "String"));

		Model contactAndpermission = new Model(getId(), "ContactAndPermission",
				"联系人权限关系", "uuid", project);
		contactAndpermission.addAttribute(new ModelAttribute(getId(), "babyId",
				"宝宝编号", "String"));
		contactAndpermission.addAttribute(new ModelAttribute(getId(),
				"contactPermissionId", "权限编号", "String"));
		contactAndpermission.addAttribute(new ModelAttribute(getId(),
				"permissionId", "联系人编号", "String"));

		Model province = new Model(getId(), "Province", "省份", "uuid", project);
		province.addAttribute(new ModelAttribute(getId(), "provinceId", "省份编号",
				"String"));
		province.addAttribute(new ModelAttribute(getId(), "provinceName",
				"省份名称", "String"));

		Model city = new Model(getId(), "City", "城市", "uuid", project);
		city.addAttribute(new ModelAttribute(getId(), "cityId", "城市编号",
				"String"));
		city.addAttribute(new ModelAttribute(getId(), "cityName", "城市名称",
				"String"));
		city.addAttribute(new ModelAttribute(getId(), "provinceId", "省份编号",
				"String"));

		Model canton = new Model(getId(), "Canton", "行政区域", "uuid", project);
		canton.addAttribute(new ModelAttribute(getId(), "cantonId", "行政区编号",
				"String"));
		canton.addAttribute(new ModelAttribute(getId(), "cantonName", "行政区名称",
				"String"));
		canton.addAttribute(new ModelAttribute(getId(), "cityId", "城市编号",
				"String"));

		Model accountStatistics = new Model(getId(), "AccountStatistics",
				"帐号统计", "uuid", project);
		accountStatistics.addAttribute(new ModelAttribute(getId(), "accountId",
				"用户编号", "String"));
		accountStatistics.addAttribute(new ModelAttribute(getId(), "lastLogin",
				"最后登录时间", "Date"));
		accountStatistics.addAttribute(new ModelAttribute(getId(), "regTime",
				"注册时间", "Date"));
		accountStatistics.addAttribute(new ModelAttribute(getId(),
				"loginTotal", "登录总次数", "String"));
		accountStatistics.addAttribute(new ModelAttribute(getId(), "avgTotal",
				"日均登录次数", "String"));
		accountStatistics.addAttribute(new ModelAttribute(getId(),
				"avglogintime", "日均登录时长", "String"));

		Model channelStatistics = new Model(getId(), "ChannelStatistics",
				"渠道统计", "uuid", project);
		channelStatistics.addAttribute(new ModelAttribute(getId(), "channelId",
				"渠道编号", "String"));
		channelStatistics.addAttribute(new ModelAttribute(getId(),
				"firstLogin", "初次使用时间", "Date"));
		channelStatistics.addAttribute(new ModelAttribute(getId(), "lastTime",
				"最后使用时间", "Date"));
		channelStatistics.addAttribute(new ModelAttribute(getId(), "useTotal",
				"使用总次数", "String"));
		channelStatistics.addAttribute(new ModelAttribute(getId(), "avgTotal",
				"日均使用次数", "String"));
		channelStatistics.addAttribute(new ModelAttribute(getId(),
				"avgUsetime", "日均使用时长", "String"));

		// 关系列表

		Relation accountBaby = new Relation(getId(), "babies", "OneToMany",
				account);
		Relation babyAccount = new Relation(getId(), "accoount", "ManyToOne",
				baby);

		Relation accountContact = new Relation(getId(), "contacts",
				"OneToMany", account);
		Relation contactAccount = new Relation(getId(), "account", "ManyToOne",
				contact);

		Relation babyContact = new Relation(getId(), "contacts", "OneToMany",
				baby);
		Relation contactBaby = new Relation(getId(), "baby", "ManyToOne",
				contact);

		Relation userBaby = new Relation(getId(), "babies", "OneToMany", user);
		Relation babyUser = new Relation(getId(), "user", "ManyToOne", baby);

		Relation userChannel = new Relation(getId(), "channels", "OneToMany",
				user);
		Relation channelUser = new Relation(getId(), "users", "OneToMany",
				channel);

		Relation channelGroup = new Relation(getId(), "groups", "OneToMany",
				channel);
		Relation groupChannel = new Relation(getId(), "channel", "ManyToOne",
				group);

		Relation babyGroup = new Relation(getId(), "group", "ManyToOne", baby);
		Relation groupBaby = new Relation(getId(), "babies", "OneToMany", group);

		Relation channelPermission = new Relation(getId(), "permissions",
				"OneToMany", channel);
		Relation permissionChannel = new Relation(getId(), "channel",
				"ManyToOne", permission);

		Relation channelPrivateDatafield = new Relation(getId(),
				"privateDatafields", "OneToMany", channel);
		Relation privateDatafieldChannel = new Relation(getId(), "channel",
				"ManyToOne", privateDatafield);

		Relation babyPrivateDatavalue = new Relation(getId(),
				"privateDatavalues", "OneToMany", baby);
		Relation privateDatavalueBaby = new Relation(getId(), "baby",
				"ManyToOne", privateDataValue);

		// 关系设置

		accountBaby.setRelation(babyAccount);
		babyAccount.setRelation(accountBaby);

		accountContact.setRelation(contactAccount);
		contactAccount.setRelation(accountContact);

		babyContact.setRelation(contactBaby);
		contactBaby.setRelation(babyContact);

		userBaby.setRelation(babyUser);
		babyUser.setRelation(userBaby);

		userChannel.setRelation(channelUser);
		channelUser.setRelation(userChannel);

		channelGroup.setRelation(groupChannel);
		groupChannel.setRelation(channelGroup);

		babyGroup.setRelation(groupBaby);
		groupBaby.setRelation(babyGroup);

		channelPermission.setRelation(permissionChannel);
		permissionChannel.setRelation(channelPermission);

		channelPrivateDatafield.setRelation(privateDatafieldChannel);
		privateDatafieldChannel.setRelation(channelPrivateDatafield);

		babyPrivateDatavalue.setRelation(privateDatavalueBaby);
		privateDatavalueBaby.setRelation(babyPrivateDatavalue);

		// 添加关系

		account.addRelation(accountBaby);
		account.addRelation(accountContact);

		baby.addRelation(babyContact);
		baby.addRelation(babyGroup);
		baby.addRelation(babyPrivateDatavalue);

		user.addRelation(userBaby);
		user.addRelation(userChannel);

		channel.addRelation(channelGroup);
		channel.addRelation(channelPermission);
		channel.addRelation(channelPrivateDatafield);

		// 添加模型
		models.add(account);
		models.add(baby);
		models.add(contact);
		models.add(user);
		models.add(channel);
		models.add(permission);
		models.add(group);
		models.add(privateDatafield);
		models.add(privateDataValue);
		models.add(contactPermission);
		models.add(contactAndpermission);
		models.add(province);
		models.add(city);
		models.add(canton);
		models.add(accountStatistics);
		models.add(channelStatistics);

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
		Project project = new Project("123456", "BBcareUserCloud_v2",
				"BBcare用户云", new Frame(getId(), "ssh", "SSH"), new Frame(getId(),
						"smartadmin", "SmartAdmin"), new Frame(getId(),
								"jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.user");
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
						"mysql://lecbuild.mysql.rds.aliyuncs.com:3306/bbcare_cloud_user?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"username", "password"));
		return project;
	}
}
