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

public class BBcareFollow {

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
		Model modelClass = new Model(getId(), "ModelClass", "模型分类", "uuid", project);
		modelClass.addAttribute(new ModelAttribute(getId(), "name", "分类名称", "String"));
		modelClass.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		
		Model followModel = new Model(getId(), "FollowModel", "随访模型", "uuid", project);
		followModel.addAttribute(new ModelAttribute(getId(), "hospitalId", "所属医院", "String"));
		followModel.addAttribute(new ModelAttribute(getId(), "doctorId", "所属医生", "String"));
		followModel.addAttribute(new ModelAttribute(getId(), "status", "模型状态", "Integer"));
		followModel.addAttribute(new ModelAttribute(getId(), "introduction", "模型状态", "String"));
		followModel.addAttribute(new ModelAttribute(getId(), "target", "随访目标", "String"));
		followModel.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		
		Model followTemplate = new Model(getId(), "FollowTemplate", "随访模版", "uuid", project);
		followTemplate.addAttribute(new ModelAttribute(getId(), "name", "模版名称", "String"));
		followTemplate.addAttribute(new ModelAttribute(getId(), "type", "模版类型", "String"));
		followTemplate.addAttribute(new ModelAttribute(getId(), "usedType", "适用者类型", "String"));
		followTemplate.addAttribute(new ModelAttribute(getId(), "usedLevel", "适用者等级", "String"));
		followTemplate.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		
		Model executiveTemplate = new Model(getId(), "ExecutiveTemplate", "执行模版", "uuid", project);
		executiveTemplate.addAttribute(new ModelAttribute(getId(), "startTime", "执行开始时间", "Date"));
		executiveTemplate.addAttribute(new ModelAttribute(getId(), "endTime", "执行结束时间", "Date"));
		executiveTemplate.addAttribute(new ModelAttribute(getId(), "frequency", "频率", "Integer"));
		executiveTemplate.addAttribute(new ModelAttribute(getId(), "num", "次数", "Integer"));
		
		Model followContent = new Model(getId(), "FollowContent", "随访内容", "uuid", project);
		followContent.addAttribute(new ModelAttribute(getId(), "name", "内容名称", "String"));
		followContent.addAttribute(new ModelAttribute(getId(), "isNull", "是否必填", "Boolean"));
		followContent.addAttribute(new ModelAttribute(getId(), "config", "配置信息", "String"));
		followContent.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		followContent.addAttribute(new ModelAttribute(getId(), "writerId", "所属人ID","String"));
		
		Model contentType = new Model(getId(), "ContentType", "内容类型", "uuid", project);
		contentType.addAttribute(new ModelAttribute(getId(), "name", "类型名称", "String"));
		contentType.addAttribute(new ModelAttribute(getId(), "writerId", "所属人ID","String"));
		
		Model contentClass = new Model(getId(), "ContentClass", "内容分类", "uuid", project);
		contentClass.addAttribute(new ModelAttribute(getId(), "name", "分类名称", "String"));
		contentClass.addAttribute(new ModelAttribute(getId(), "writerId", "所属人ID","String"));
		
		
		Model contentUnit = new Model(getId(), "ContentUnit", "内容单位", "uuid", project);
		contentUnit.addAttribute(new ModelAttribute(getId(), "name", "单位名称", "String"));
		contentUnit.addAttribute(new ModelAttribute(getId(), "symbol", "单位符号", "String"));
		contentUnit.addAttribute(new ModelAttribute(getId(), "note", "单位备注", "String"));
		contentUnit.addAttribute(new ModelAttribute(getId(), "type", "单位类别", "String"));
		contentUnit.addAttribute(new ModelAttribute(getId(), "writerId", "所属人ID", "String"));
		
		
		Model executivePlan = new Model(getId(), "ExecutivePlan", "执行计划", "uuid", project);
		executivePlan.addAttribute(new ModelAttribute(getId(), "startTime", "开始时间", "Date"));
		executivePlan.addAttribute(new ModelAttribute(getId(), "endTime", "结束时间", "Date"));
		executivePlan.addAttribute(new ModelAttribute(getId(), "frequency", "频率", "Integer"));
		executivePlan.addAttribute(new ModelAttribute(getId(), "num", "次数", "Integer"));
		
		Model followPlan = new Model(getId(), "FollowPlan", "随访计划", "uuid", project);
		followPlan.addAttribute(new ModelAttribute(getId(), "babyId", "随访宝宝", "Date"));
		followPlan.addAttribute(new ModelAttribute(getId(), "startTime", "开始时间", "Date"));
		followPlan.addAttribute(new ModelAttribute(getId(), "createDoctorId", "创建医生", "String"));
		followPlan.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		
		Model followTask = new Model(getId(), "FollowTask", "随访任务", "uuid", project);
		followTask.addAttribute(new ModelAttribute(getId(), "taskTime", "任务时间", "Date"));
		followTask.addAttribute(new ModelAttribute(getId(), "status", "任务状态", "String"));
		followTask.addAttribute(new ModelAttribute(getId(), "modelId", "执行模版", "String"));
		
		Model babyFollowRecord = new Model(getId(), "BabyFollowRecord", "随访记录", "uuid", project);
		babyFollowRecord.addAttribute(new ModelAttribute(getId(), "followTemplateId", "随访模版", "String"));
		babyFollowRecord.addAttribute(new ModelAttribute(getId(), "followTime", "随访时间", "Date"));
		babyFollowRecord.addAttribute(new ModelAttribute(getId(), "babyId", "随访对象", "String"));
		
		
		Model babyFollowDetail = new Model(getId(), "BabyFollowDetail", "随访情况", "uuid", project);
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "followContenId", "所属随访内容", "String"));
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "note", "随访情况", "String"));
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "contentType", "内容类型", "String"));
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "contentClass", "内容类型", "String"));
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "contentUnit", "内容单位", "String"));
		babyFollowDetail.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		
		// 关系列表
		Relation modelClassParent = new Relation(getId(), "parent", "ManyToOne", modelClass);
		Relation modelClassChildren = new Relation(getId(), "children", "OneToMany", modelClass);
		Relation modelClassFollowModel = new Relation(getId(), "followModels", "OneToMany", modelClass);
		
		Relation followModelModelClass = new Relation(getId(), "modelClass", "ManyToOne", followModel);
		Relation followModelFollowPlan = new Relation(getId(), "followPlans", "OneToMany", followModel);
		Relation followModelFollowTemplate = new Relation(getId(), "followTemplates", "OneToMany", followModel);
		
		Relation followTemplateFollowModel = new Relation(getId(), "followModel", "ManyToOne",  followTemplate);
		Relation followTemplateExecutiveTemplate = new Relation(getId(), "executiveTemplates", "OneToMany",  followTemplate);
		Relation followTemplateFollowContent = new Relation(getId(), "followContents", "OneToMany",  followTemplate);
		Relation followTemplateContentClass  =new Relation(getId(), "ContentClasss", "OneToMany",  followTemplate);
		
		Relation executiveTemplateFollowTemplate = new Relation(getId(), "followTemplate", "ManyToOne",  executiveTemplate);
		
		Relation followContentFollowTemplate = new Relation(getId(), "followTemplate", "ManyToOne",  followContent);
		Relation followContentContentType = new Relation(getId(), "contentType", "ManyToOne",  followContent);
		Relation followContentContentClass = new Relation(getId(), "contentClass", "ManyToOne",  followContent);
		Relation followContentContentUnit = new Relation(getId(), "contentUnit", "ManyToOne",  followContent);
		
		Relation contentTypeFollowContent = new Relation(getId(), "followContents", "OneToMany", contentType);
		
		Relation contentClassFollowContent = new Relation(getId(), "followContents", "OneToMany", contentClass);
		Relation contentClassParent = new Relation(getId(), "parent", "ManyToOne", contentClass);
		Relation contentClassChildren = new Relation(getId(), "children", "OneToMany", contentClass);
		Relation contentClassFollowTemplate = new Relation(getId(), "followTemplate", "ManyToOne", contentClass);
		
		
		Relation contentUnitFollowContent = new Relation(getId(), "followContents", "OneToMany", contentUnit);
		
		Relation executivePlanFollowPlan = new Relation(getId(), "followPlan", "ManyToOne",  executivePlan);
		
		
		Relation followPlanFollowModel = new Relation(getId(), "followModel", "ManyToOne",  followPlan);
		Relation followPlanExecutivePlan = new Relation(getId(), "executivePlans", "OneToMany",  followPlan);
		Relation followPlanFollowTask = new Relation(getId(), "followTasks", "OneToMany",  followPlan);
		Relation followPlanBabyFollowRecord = new Relation(getId(), "babyFollowRecords", "OneToMany",  followPlan);
		
		Relation followTaskFollowPlan = new Relation(getId(), "followPlan", "ManyToOne",  followPlan);
		
		Relation babyFollowRecordFollowPlan = new Relation(getId(), "followPlan", "ManyToOne",  babyFollowRecord);
		Relation babyFollowRecordBabyFollowDetail = new Relation(getId(), "babyFollowDetails", "OneToMany",  babyFollowRecord);
		
		Relation babyFollowDetailBabyFollowRecord = new Relation(getId(), "babyFollowRecord", "ManyToOne",  babyFollowDetail);
		
		// 关系设置

		modelClassChildren.setRelation(modelClassParent);
		modelClassParent.setRelation(modelClassChildren);
		
		followModelModelClass.setRelation(modelClassFollowModel);
		modelClassFollowModel.setRelation(followModelModelClass);
		
		followModelFollowPlan.setRelation(followPlanFollowModel);
		followPlanFollowModel.setRelation(followModelFollowPlan);
		
		followModelFollowTemplate.setRelation(followTemplateFollowModel);
		followTemplateFollowModel.setRelation(followModelFollowTemplate);
		
		followTemplateExecutiveTemplate.setRelation(executiveTemplateFollowTemplate);
		executiveTemplateFollowTemplate.setRelation(followTemplateExecutiveTemplate);
		
		followTemplateContentClass.setRelation(contentClassFollowTemplate);
		contentClassFollowTemplate.setRelation(followTemplateContentClass);
		
		followTemplateFollowContent.setRelation(followContentFollowTemplate);
		followContentFollowTemplate.setRelation(followTemplateFollowContent);
		
		followContentContentClass.setRelation(contentClassFollowContent);
		contentClassFollowContent.setRelation(followContentContentClass);
		
		contentClassChildren.setRelation(contentClassParent);
		contentClassParent.setRelation(contentClassChildren);
		
		followContentContentType.setRelation(contentTypeFollowContent);
		contentTypeFollowContent.setRelation(followContentContentType);
		
		followContentContentUnit.setRelation(contentUnitFollowContent);
		contentUnitFollowContent.setRelation(followContentContentUnit);
		
		executivePlanFollowPlan.setRelation(followPlanExecutivePlan);
		followPlanExecutivePlan.setRelation(executivePlanFollowPlan);
		
		followPlanFollowTask.setRelation(followTaskFollowPlan);
		followTaskFollowPlan.setRelation(followPlanFollowTask);
		
		followPlanBabyFollowRecord.setRelation(babyFollowRecordFollowPlan);
		babyFollowRecordFollowPlan.setRelation(followPlanBabyFollowRecord);
		
		babyFollowRecordBabyFollowDetail.setRelation(babyFollowDetailBabyFollowRecord);
		babyFollowDetailBabyFollowRecord.setRelation(babyFollowRecordBabyFollowDetail);
		
		// 添加关系
		modelClass.addRelation(modelClassChildren);
		modelClass.addRelation(modelClassFollowModel);
		modelClass.addRelation(modelClassParent);
		
		followModel.addRelation(followModelFollowPlan);
		followModel.addRelation(followModelFollowTemplate);
		followModel.addRelation(followModelModelClass);
		
		followTemplate.addRelation(followTemplateExecutiveTemplate);
		followTemplate.addRelation(followTemplateFollowContent);
		followTemplate.addRelation(followTemplateFollowModel);
		followTemplate.addRelation(followTemplateContentClass);
		
		executiveTemplate.addRelation(executiveTemplateFollowTemplate);
		
		followContent.addRelation(followContentContentClass);
		followContent.addRelation(followContentContentType);
		followContent.addRelation(followContentContentUnit);
		followContent.addRelation(followContentFollowTemplate);
		
		contentClass.addRelation(contentClassFollowContent);
		contentClass.addRelation(contentClassChildren);
		contentClass.addRelation(contentClassParent);
		contentClass.addRelation(contentClassFollowTemplate);
		
		contentType.addRelation(contentTypeFollowContent);
		
		contentUnit.addRelation(contentUnitFollowContent);
		
		executivePlan.addRelation(executivePlanFollowPlan);
		
		followPlan.addRelation(followPlanBabyFollowRecord);
		followPlan.addRelation(followPlanExecutivePlan);
		followPlan.addRelation(followPlanFollowModel);
		followPlan.addRelation(followPlanFollowTask);
		
		followTask.addRelation(followTaskFollowPlan);
		
		babyFollowRecord.addRelation(babyFollowRecordBabyFollowDetail);
		babyFollowRecord.addRelation(babyFollowRecordFollowPlan);
		
		babyFollowDetail.addRelation(babyFollowDetailBabyFollowRecord);
		
		
		// 添加模型
		models.add(modelClass);
		models.add(followModel);
		models.add(followTemplate);
		models.add(executiveTemplate);
		models.add(followContent);
		models.add(contentClass);
		models.add(contentType);
		models.add(contentUnit);
		models.add(executivePlan);
		models.add(followPlan);
		models.add(babyFollowRecord);
		models.add(babyFollowDetail);
		models.add(followTask);
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
		Project project = new Project("123456", "BBcareFollow", "BBcare管理平台", new Frame(getId(), "sh", "SH"),
				new Frame(getId(), "smartadmin", "SmartAdmin"), new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.follow");
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
						"mysql://localhost:3306/test_follow_server?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"username", "password"));
		return project;
	}
}
