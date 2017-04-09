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

public class BBCareHealthyCenter {

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
		Model oxygenPulserate = new Model(getId(), "OxygenPulserate", "血氧脉率", "_oxygenPulserateId", project);
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_oxygenPulserateId", "血氧脉率检测编号", "String"));
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_startTime", "检测开始时间", "Timestamp"));
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_endTime", "检测结束时间", "Timestamp"));
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_timeLong", "检测时长", "Integer"));
		oxygenPulserate.addAttribute(new ModelAttribute(getId(), "_type", "类型", "String"));

		Model oxygenPulserateDetail = new Model(getId(), "OxygenPulserateDetail", "血氧脉率详情 ", "_id", project);
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_id", "编号", "String"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_oxygenPulserateId", "血氧脉率检测编号", "String"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_oxygensaturation", "血氧饱和度", "Double"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_pulserateWave", "脉率波值", "Double"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_pulseRate", "脉率磅值", "Double"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_signalStrength", "信号强度", "Double"));
		oxygenPulserateDetail.addAttribute(new ModelAttribute(getId(), "_testTime", "检测时间", "Timestamp"));

		Model bodyTemperatureDetail = new Model(getId(), "BodyTemperatureDetail", "体温检测明细", "_id", project);
		bodyTemperatureDetail.addAttribute(new ModelAttribute(getId(), "_id", "编号", "String"));
		bodyTemperatureDetail.addAttribute(new ModelAttribute(getId(), "_oxygenPulserateId", "体温检测编号", "String"));
		bodyTemperatureDetail.addAttribute(new ModelAttribute(getId(), "_bodyTemperature", "体温值", "Double"));
		bodyTemperatureDetail.addAttribute(new ModelAttribute(getId(), "_testTime", "检测时间", "Timestamp"));

		Model oxygenPulserateAnalysis = new Model(getId(), "OxygenPulserateAnalysis", "氧饱脉率体温分析报告 ", "_id", project);
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_id", "编号", "String"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_maxValue", "最高值", "Double"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_minValue", "最低值", "Double"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_finalValue", "最终值", "Double"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_complianceRate", "达标率", "Double"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_noncomplianceRate", "不达标率", "Double"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_oxygenPulserateId", "氧饱脉率检测编号", "String"));
		oxygenPulserateAnalysis.addAttribute(new ModelAttribute(getId(), "_type", "类型", "String"));

		Model bodyTemperature = new Model(getId(), "BodyTemperature", "体温检测", "_bodytemperatureId", project);
		bodyTemperature.addAttribute(new ModelAttribute(getId(), "_bodytemperatureId", "体温检测编号", "String"));
		bodyTemperature.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		bodyTemperature.addAttribute(new ModelAttribute(getId(), "_startTime", "检测开始时间", "Timestamp"));
		bodyTemperature.addAttribute(new ModelAttribute(getId(), "_endTime", "检测结束时间", "Timestamp"));
		bodyTemperature.addAttribute(new ModelAttribute(getId(), "_timeLong", "检测时长", "Integer"));

		Model bodyTemperatureAnalysis = new Model(getId(), "BodyTemperatureAnalysis", "体温检测分析报告",
				"_bodyTemperatureAnalysisId", project);
		bodyTemperatureAnalysis.addAttribute(new ModelAttribute(getId(), "_bodyTemperatureAnalysisId", "体温分析报告编号",
				"String"));
		bodyTemperatureAnalysis.addAttribute(new ModelAttribute(getId(), "_finalValue", "最终值", "Double"));
		bodyTemperatureAnalysis.addAttribute(new ModelAttribute(getId(), "_result", "结果判定", "Integer"));
		bodyTemperatureAnalysis.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		bodyTemperatureAnalysis.addAttribute(new ModelAttribute(getId(), "_bodytemperatureId", "体温检测编号", "String"));

		Model weight = new Model(getId(), "Weight", "体重检测", "_weightId", project);
		weight.addAttribute(new ModelAttribute(getId(), "_weightId", "体重检测编号", "String"));
		weight.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		weight.addAttribute(new ModelAttribute(getId(), "_startTime", "检测开始时间", "Timestamp"));
		weight.addAttribute(new ModelAttribute(getId(), "_endTime", "检测结束时间", "Timestamp"));
		weight.addAttribute(new ModelAttribute(getId(), "_timeLong", "检测时长", "Integer"));
		weight.addAttribute(new ModelAttribute(getId(), "_weight", "体重值", "Double"));

		Model weightAnalysis = new Model(getId(), "WeightAnalysis", "体重分析报告", "_weightAnalysisId", project);
		weightAnalysis.addAttribute(new ModelAttribute(getId(), "_weightAnalysisId", "体重分析报告编号", "String"));
		weightAnalysis.addAttribute(new ModelAttribute(getId(), "_finalValue", "最终值", "Double"));
		weightAnalysis.addAttribute(new ModelAttribute(getId(), "_result", "结果判定", "Integer"));
		weightAnalysis.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		weightAnalysis.addAttribute(new ModelAttribute(getId(), "_bodytemperatureId", "体温检测编号", "String"));

		Model height = new Model(getId(), "Height", "身高检测", "_heightId", project);
		height.addAttribute(new ModelAttribute(getId(), "_heightId", "体重检测编号", "String"));
		height.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		height.addAttribute(new ModelAttribute(getId(), "_startTime", "检测开始时间", "Timestamp"));
		height.addAttribute(new ModelAttribute(getId(), "_endTime", "检测结束时间", "Timestamp"));
		height.addAttribute(new ModelAttribute(getId(), "_timeLong", "检测时长", "Integer"));
		height.addAttribute(new ModelAttribute(getId(), "_height", "身高值", "Double"));

		Model heightAnalysis = new Model(getId(), "WeightAnalysis", "身高分析报告", "_heightAnalysisId", project);
		heightAnalysis.addAttribute(new ModelAttribute(getId(), "_heightAnalysisId", "身高分析报告编号", "String"));
		heightAnalysis.addAttribute(new ModelAttribute(getId(), "_finalValue", "最终值", "Double"));
		heightAnalysis.addAttribute(new ModelAttribute(getId(), "_result", "结果判定", "Integer"));
		heightAnalysis.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		heightAnalysis.addAttribute(new ModelAttribute(getId(), "_heightId", "体温检测编号", "String"));

		Model headCircumference = new Model(getId(), "HeadCircumference", "头围检测", "_headCircumferenceId", project);
		headCircumference.addAttribute(new ModelAttribute(getId(), "_headCircumferenceId", "体重检测编号", "String"));
		headCircumference.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		headCircumference.addAttribute(new ModelAttribute(getId(), "_startTime", "检测开始时间", "Timestamp"));
		headCircumference.addAttribute(new ModelAttribute(getId(), "_endTime", "检测结束时间", "Timestamp"));
		headCircumference.addAttribute(new ModelAttribute(getId(), "_timeLong", "检测时长", "Integer"));
		headCircumference.addAttribute(new ModelAttribute(getId(), "_headCircumference", "头围值", "Double"));

		Model headCircumferenceAnalysis = new Model(getId(), "HeadCircumferenceAnalysis", "头围检测分析报告",
				"_headCircumferenceAnalysisId", project);
		headCircumferenceAnalysis.addAttribute(new ModelAttribute(getId(), "_headCircumferenceAnalysisId",
				"头围检测分析报告编号", "String"));
		headCircumferenceAnalysis.addAttribute(new ModelAttribute(getId(), "_finalValue", "最终值", "Double"));
		headCircumferenceAnalysis.addAttribute(new ModelAttribute(getId(), "_result", "结果判定", "Integer"));
		headCircumferenceAnalysis.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		headCircumferenceAnalysis
				.addAttribute(new ModelAttribute(getId(), "_headCircumferenceId", "头围检测检测编号", "String"));

		Model module = new Model(getId(), "Module", "模块", "_moduleId", project);
		module.addAttribute(new ModelAttribute(getId(), "_moduleId", "模块编号", "String"));
		module.addAttribute(new ModelAttribute(getId(), "_moduleName", "模块名", "String"));
		module.addAttribute(new ModelAttribute(getId(), "_status", "状态", "Integer"));

		Model baby = new Model(getId(), "Baby", "宝宝", "_babyId", project);
		baby.addAttribute(new ModelAttribute(getId(), "_babyId", "宝宝编号", "String"));
		baby.addAttribute(new ModelAttribute(getId(), "_babyName", "宝宝姓名", "String"));
		baby.addAttribute(new ModelAttribute(getId(), "_nickname", "宝宝昵称", "String"));
		baby.addAttribute(new ModelAttribute(getId(), "_gender", "性别", "String"));
		baby.addAttribute(new ModelAttribute(getId(), "_birthday", "生日", "String"));

		Model testSet = new Model(getId(), "TestSet", "宝宝监测设置", "_testSetId", project);
		testSet.addAttribute(new ModelAttribute(getId(), "_testSetId", "编号", "String"));
		testSet.addAttribute(new ModelAttribute(getId(), "_standardValue", "标准值", "Double"));
		testSet.addAttribute(new ModelAttribute(getId(), "_maxTestLong", "最高检测时长", "Double"));
		testSet.addAttribute(new ModelAttribute(getId(), "_minTestLong", "最低检测时长", "Double"));
		testSet.addAttribute(new ModelAttribute(getId(), "_maxAlarmValue", "报警值上限", "Double"));
		testSet.addAttribute(new ModelAttribute(getId(), "_minAlarmValue", "报警值下限", "Double"));
		testSet.addAttribute(new ModelAttribute(getId(), "_type", "类型", "String"));
		testSet.addAttribute(new ModelAttribute(getId(), "_babId", "宝宝编号", "String"));

		Model testSetDefault = new Model(getId(), "DefaultTestSet", "系统监测设置", "_testSetDefaultId", project);
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_testSetDefaultId", "编号", "String"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_standardValue", "标准值", "Double"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_maxTestLong", "最高检测时长", "Double"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_minTestLong", "最低检测时长", "Double"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_maxAlarmValue", "报警值上限", "Double"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_minAlarmValue", "报警值下限", "Double"));
		testSetDefault.addAttribute(new ModelAttribute(getId(), "_type", "类型", "String"));
		// 关系列表

		Relation oxygenPulserateOxygenPulserateDetail = new Relation(getId(), "oxygenPulserateDetails", "OneToMany",
				oxygenPulserate);
		Relation oxygenPulserateDetailOxygenPulserate = new Relation(getId(), "oxygenPulserate", "ManyToOne",
				oxygenPulserateDetail);
		Relation oxygenPulserateBodyTemperatureDetail = new Relation(getId(), "bodyTemperatureDetail", "OneToOne",
				oxygenPulserate);
		Relation bodyTemperatureDetailOxygenPulserate = new Relation(getId(), "oxygenPulserate", "OneToOne",
				bodyTemperatureDetail);
		Relation babyTestset = new Relation(getId(), "testSets", "OneToMany", baby);
		Relation testsetBaby = new Relation(getId(), "baby", "ManyToOne", testSet);
		Relation oxygenPulserateOxygenPulserateAnalysis = new Relation(getId(), "oxygenPulserateAnalysises",
				"OneToMany", oxygenPulserate);
		Relation oxygenPulserateAnalysisOxygenPulserate = new Relation(getId(), "oxygenPulserate", "ManyToOne",
				oxygenPulserateAnalysis);

		// 关系设置
		oxygenPulserateDetailOxygenPulserate.setRelation(oxygenPulserateOxygenPulserateDetail);
		oxygenPulserateOxygenPulserateDetail.setRelation(oxygenPulserateDetailOxygenPulserate);

		bodyTemperatureDetailOxygenPulserate.setRelation(oxygenPulserateBodyTemperatureDetail);
		oxygenPulserateBodyTemperatureDetail.setRelation(bodyTemperatureDetailOxygenPulserate);

		oxygenPulserateAnalysisOxygenPulserate.setRelation(oxygenPulserateOxygenPulserateAnalysis);
		oxygenPulserateOxygenPulserateAnalysis.setRelation(oxygenPulserateAnalysisOxygenPulserate);

		testsetBaby.setRelation(babyTestset);
		babyTestset.setRelation(testsetBaby);

		// 添加关系
		oxygenPulserate.addRelation(oxygenPulserateOxygenPulserateDetail);
		oxygenPulserateDetail.addRelation(oxygenPulserateDetailOxygenPulserate);

		oxygenPulserate.addRelation(oxygenPulserateBodyTemperatureDetail);
		bodyTemperatureDetail.addRelation(bodyTemperatureDetailOxygenPulserate);

		oxygenPulserate.addRelation(oxygenPulserateOxygenPulserateAnalysis);
		oxygenPulserateAnalysis.addRelation(oxygenPulserateAnalysisOxygenPulserate);

		baby.addRelation(babyTestset);
		testSet.addRelation(testsetBaby);

		// 添加模型
		models.add(oxygenPulserate);
		models.add(oxygenPulserateDetail);
		models.add(bodyTemperatureDetail);
		models.add(oxygenPulserateAnalysis);
		models.add(bodyTemperature);
		models.add(bodyTemperatureAnalysis);
		models.add(weight);
		models.add(weightAnalysis);
		models.add(height);
		models.add(heightAnalysis);
		models.add(headCircumference);
		models.add(headCircumferenceAnalysis);
		models.add(headCircumference);
		models.add(module);
		models.add(baby);
		models.add(testSet);
		models.add(testSetDefault);
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
		Project project = new Project("123456", "BBCareHealthyCenter", "BBcare健康中心", new Frame(getId(), "sh", "SH"),
				new Frame(getId(), "smartadmin", "SmartAdmin"), new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.healthy");
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
		project
				.setDataSource(new DataSource(
						getId(),
						"mysql",
						"mysql",
						"mysql://lecbuild.mysql.rds.aliyuncs.com:3306/bbcare_cloud_healthy?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"username", "password"));
		return project;
	}
}
