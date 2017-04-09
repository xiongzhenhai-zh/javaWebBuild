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
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class UsedFollowScheme {

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
		// 应用随访列表
		Model followUser  = new Model(getId(), "FollowUser", "随访用户", "uuid", project);
		followUser.addAttribute(new ModelAttribute(getId(),"accountName","注册号码","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"babyId","宝宝Id","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"babyName","宝宝名称","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"gender","性别","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"birthday","出生日期","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"pregnancyWeek","孕周","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"inpatientNum","住院号","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"idCard","身份证号","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"type","用户类型","String"));
		followUser.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model babyFollowScheme  = new Model(getId(), "BabyFollowScheme", "宝宝随访方案", "uuid", project);
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"name", "方案名称", "String"));
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"userId","宝宝Id","String"));
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"followSchemeId","方案Id","String"));
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"followSchemeVersion","方案版本","String"));
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"followSchemeVersionId","方案版本Id","String"));
		babyFollowScheme.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model babyFollowSchemeTask  = new Model(getId(), "BabyFollowSchemeTask", "宝宝随访任务", "uuid", project);
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"name","任务名称","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"executeStartTime","开始执行时间","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"executeEndTime","结束执行时间","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"sendSms","发送短信","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"sendMsg","发送应用内消息","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"executePhase","执行窗口期","Integer"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"executeType","执行类型","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"firstRecord","建档信息","String"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"total","任务总数","Integer"));
		babyFollowSchemeTask.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model babyFollowSchemeContent  = new Model(getId(), "BabyFollowSchemeContent", "宝宝随访任务内容", "uuid", project);
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(),"name","任务名称","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "sourceId","来源Id","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "sourceType", "来源类型", "String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "userType","使用者类型","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "type","类型","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "data","数据","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "firstRecord","建档信息","String"));
		babyFollowSchemeContent.addAttribute(new ModelAttribute(getId(), "createTime","创建时间","Date"));
		
		Model babyFollowSchemeRecord  = new Model(getId(), "BabyFollowSchemeRecord", "会员随访记录", "uuid", project);
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"name", "计划名称", "String"));
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"type","记录类型","String"));
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"doctorFollowSchemeRecordId","医生记录Id","String"));
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"completeTime","完成时间","Date"));
		babyFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model babyFollowSchemeRecordDetail  = new Model(getId(), "BabyFollowSchemeRecordDetail", "会员随访记录内容", "uuid", project);
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"name", "名称", "String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"questionId", "问题id", "String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"type","内容类型","String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"answer","答案","String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"followSchemeVersionId","方案版本Id","String"));
		babyFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model doctorFollowSchemeRecord  = new Model(getId(), "DoctorFollowSchemeRecord", "会员随访记录", "uuid", project);
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"name", "计划名称", "String"));
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"type","记录类型","String"));
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"babyFollowSchemeRecordId","宝宝记录Id","String"));
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"completeTime","完成时间","Date"));
		doctorFollowSchemeRecord.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model doctorFollowSchemeRecordDetail  = new Model(getId(), "DoctorFollowSchemeRecordDetail", "会员随访记录内容", "uuid", project);
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"name", "名称", "String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"babyFollowSchemeRecordDetailId", "会员详情id", "String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"questionId", "问题id", "String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"type","内容类型","String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"answer","答案","String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"followSchemeVersionId","方案版本Id","String"));
		doctorFollowSchemeRecordDetail.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
			
		// 关系列表
		Relation doctorFollowSchemeRecordDoctorFollowSchemeRecordDetail = new Relation(getId(), "doctorFollowSchemeRecordDetails", "OneToMany", doctorFollowSchemeRecord);
		Relation doctorFollowSchemeRecordDetailDoctorFollowSchemeRecord = new Relation(getId(), "doctorFollowSchemeRecord", "ManyToOne", doctorFollowSchemeRecordDetail);
		
		Relation babyFollowSchemeRecordBabyFollowSchemeRecordDetail = new Relation(getId(), "babyFollowSchemeRecordDetails", "OneToMany", babyFollowSchemeRecord);
		Relation babyFollowSchemeRecordDetailBabyFollowSchemeRecord = new Relation(getId(), "babyFollowSchemeRecord", "ManyToOne", babyFollowSchemeRecordDetail);
		
		Relation followUserBabyFollowScheme = new Relation(getId(), "babyFollowSchemes", "OneToMany", followUser);
		Relation babyFollowSchemeFollowUser = new Relation(getId(), "followUser", "ManyToOne", babyFollowScheme);
		
		Relation babyFollowSchemeTaskBabyFollowSchemeContent = new Relation(getId(), "babyFollowSchemeContents", "OneToMany", babyFollowSchemeTask);
		Relation babyFollowSchemeContentBabyFollowSchemeTask = new Relation(getId(), "babyFollowSchemeTask", "ManyToOne", babyFollowSchemeContent);
		
		Relation babyFollowSchemeBabyFollowSchemeTask = new Relation(getId(), "babyFollowSchemeTasks", "OneToMany", babyFollowScheme);
		Relation babyFollowSchemeTaskBabyFollowScheme = new Relation(getId(), "babyFollowScheme", "ManyToOne", babyFollowSchemeTask);
		
		Relation babyFollowSchemeDoctorFollowSchemeRecord = new Relation(getId(), "doctorFollowSchemeRecords", "OneToMany", babyFollowScheme);
		Relation doctorFollowSchemeRecordBabyFollowScheme = new Relation(getId(), "babyFollowScheme", "ManyToOne", doctorFollowSchemeRecord);
		
		Relation babyFollowSchemeBabyFollowSchemeRecord = new Relation(getId(), "babyFollowSchemeRecords", "OneToMany", babyFollowScheme);
		Relation babyFollowSchemeRecordBabyFollowScheme = new Relation(getId(), "babyFollowScheme", "ManyToOne", babyFollowSchemeRecord);
		
		
		
		// 关系设置
		doctorFollowSchemeRecordDoctorFollowSchemeRecordDetail.setRelation(doctorFollowSchemeRecordDetailDoctorFollowSchemeRecord);
		doctorFollowSchemeRecordDetailDoctorFollowSchemeRecord.setRelation(doctorFollowSchemeRecordDoctorFollowSchemeRecordDetail);
		
		babyFollowSchemeRecordBabyFollowSchemeRecordDetail.setRelation(babyFollowSchemeRecordDetailBabyFollowSchemeRecord);
		babyFollowSchemeRecordDetailBabyFollowSchemeRecord.setRelation(babyFollowSchemeRecordBabyFollowSchemeRecordDetail);
		
		followUserBabyFollowScheme.setRelation(babyFollowSchemeFollowUser);
		babyFollowSchemeFollowUser.setRelation(followUserBabyFollowScheme);
		
		babyFollowSchemeTaskBabyFollowSchemeContent.setRelation(babyFollowSchemeContentBabyFollowSchemeTask);
		babyFollowSchemeContentBabyFollowSchemeTask.setRelation(babyFollowSchemeTaskBabyFollowSchemeContent);
		
		babyFollowSchemeBabyFollowSchemeTask.setRelation(babyFollowSchemeTaskBabyFollowScheme);
		babyFollowSchemeTaskBabyFollowScheme.setRelation(babyFollowSchemeBabyFollowSchemeTask);
		
		babyFollowSchemeDoctorFollowSchemeRecord.setRelation(doctorFollowSchemeRecordBabyFollowScheme);
		doctorFollowSchemeRecordBabyFollowScheme.setRelation(babyFollowSchemeDoctorFollowSchemeRecord);
		
		babyFollowSchemeBabyFollowSchemeRecord.setRelation(babyFollowSchemeRecordBabyFollowScheme);
		babyFollowSchemeRecordBabyFollowScheme.setRelation(babyFollowSchemeBabyFollowSchemeRecord);
		
		followUser.addRelation(followUserBabyFollowScheme);
		
		
		babyFollowScheme.addRelation(babyFollowSchemeBabyFollowSchemeTask);
		babyFollowScheme.addRelation(babyFollowSchemeDoctorFollowSchemeRecord);
		babyFollowScheme.addRelation(babyFollowSchemeFollowUser);
		babyFollowScheme.addRelation(babyFollowSchemeBabyFollowSchemeRecord);
		
		
		babyFollowSchemeTask.addRelation(babyFollowSchemeTaskBabyFollowScheme);
		babyFollowSchemeTask.addRelation(babyFollowSchemeTaskBabyFollowSchemeContent);
		
		
		babyFollowSchemeContent.addRelation(babyFollowSchemeContentBabyFollowSchemeTask);
		
		babyFollowSchemeRecord.addRelation(babyFollowSchemeRecordBabyFollowScheme);
		babyFollowSchemeRecord.addRelation(babyFollowSchemeRecordBabyFollowSchemeRecordDetail);
		
		babyFollowSchemeRecordDetail.addRelation(babyFollowSchemeRecordDetailBabyFollowSchemeRecord);
		
		doctorFollowSchemeRecord.addRelation(doctorFollowSchemeRecordBabyFollowScheme);
		doctorFollowSchemeRecord.addRelation(doctorFollowSchemeRecordDoctorFollowSchemeRecordDetail);
		
		
		doctorFollowSchemeRecordDetail.addRelation(doctorFollowSchemeRecordDetailDoctorFollowSchemeRecord);
		
		
		// 添加模型
		models.add(babyFollowScheme);
		models.add(followUser);
		models.add(babyFollowScheme);
		
		models.add(babyFollowSchemeTask);
		
		models.add(babyFollowSchemeContent);
		
		models.add(babyFollowSchemeRecord);
		
		models.add(babyFollowSchemeRecordDetail);
		models.add(doctorFollowSchemeRecord);
		
		models.add(doctorFollowSchemeRecordDetail);
			
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
				System.out.println(model.getName());
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
		Project project = new Project("123456", "FollowUsed", "BBcare管理平台", new Frame(getId(), "springmvc", "SPRINGMVC"),
				new Frame(getId(), "smartadmin", "SmartAdmin"), new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.followUsed");
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
						"mysql://localhost:3306/test_followScheme_server?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"root", "123456"));
		return project;
	}
}
