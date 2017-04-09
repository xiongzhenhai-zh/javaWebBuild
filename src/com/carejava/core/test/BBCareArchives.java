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

public class BBCareArchives {

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
		Model baby = new Model(getId(), "Baby", "宝宝", "uuid", project);
		baby.addAttribute(new ModelAttribute(getId(),"username","宝宝名字","String"));
		baby.addAttribute(new ModelAttribute(getId(), "password", "登陆密码", "String"));
		baby.addAttribute(new ModelAttribute(getId(),"photo","宝宝头像","String"));
		baby.addAttribute(new ModelAttribute(getId(), "brithday", "出生日期", "Date"));
		baby.addAttribute(new ModelAttribute(getId(),"writetime","填写日期","Date"));
		baby.addAttribute(new ModelAttribute(getId(), "yunweek", "孕周", "Integer"));
		baby.addAttribute(new ModelAttribute(getId(), "health", "健康状态", "String"));
		baby.addAttribute(new ModelAttribute(getId(),"relationship","与我的关系","String"));
		baby.addAttribute(new ModelAttribute(getId(),"card","医保卡号","String"));


		Model caseRecord =new Model(getId(),"CaseRecord","病例记录","uuid",project);
		caseRecord.addAttribute(new ModelAttribute(getId(),"hospital","病例医院","String"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"doctor","病例医生","String"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"type","病例类型","String"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"time","病例时间","Date"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"writertime","填写时间","Date"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"file","病例附件","String"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"isOpen","是否公开","Boolean"));
		caseRecord.addAttribute(new ModelAttribute(getId(),"note","病例备注","String"));


		Model caseDetail =new Model(getId(),"CaseDetail","病例详情","uuid",project);
		caseDetail.addAttribute(new ModelAttribute(getId(),"value","详细记录","String"));


		Model caseProject =new Model(getId(),"CaseProject","病例项目","uuid",project);
		caseProject.addAttribute(new ModelAttribute(getId(),"name","项目名称", "String"));


		
		Model developRecord =new Model(getId(),"DevelopRecord","发育评估","uuid", project);
		developRecord.addAttribute(new ModelAttribute(getId(), "age", "评估年龄", "Integer"));
		developRecord.addAttribute(new ModelAttribute(getId(), "writertime", "填写时间", "Date"));
		developRecord.addAttribute(new ModelAttribute(getId(), "number", "发育评估值", "Integer"));
		
		
		Model developProject=new Model(getId(),"DevelopProject","发育评估项目","uuid", project);
		developProject.addAttribute(new ModelAttribute(getId(), "name", "项目名称", "String"));
		
		
		Model developStandard=new Model(getId(),"DevelopStandard","发育标准","uuid", project);
		developStandard.addAttribute(new ModelAttribute(getId(), "age", "项目年龄", "Integer"));
		developStandard.addAttribute(new ModelAttribute(getId(), "number", "标准值", "Integer"));


		Model standard=new Model(getId(),"Standard","标准","uuid", project);
		standard.addAttribute(new ModelAttribute(getId(), "name", "标准的名称", "String"));
		
		

		Model monitorRecord=new Model(getId(),"MonitorRecord","监测方案","uuid", project);
		monitorRecord.addAttribute(new ModelAttribute(getId(), "writertime", "创建时间", "Date"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "time", "监测时间", "Date"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "writer", "监测记录填写人", "String"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "starttime", "监测开始时间", "Date"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "endtime", "监测结束时间", "Date"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "number", "监测频率", "Integer"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "onetime", "监测单次时长", "Integer"));
		monitorRecord.addAttribute(new ModelAttribute(getId(), "note", "监测备注", "String"));
		
		
		Model monitorProject=new Model(getId(),"MonitorProject","监测项目","uuid", project);
		monitorProject.addAttribute(new ModelAttribute(getId(), "title", "项目名称", "String"));;
		
		Model examRecord=new Model(getId(),"ExamRecord","体检记录","uuid", project);
		examRecord.addAttribute(new ModelAttribute(getId(), "hospital", "体检医院", "String"));
		examRecord.addAttribute(new ModelAttribute(getId(), "type", "体检类型", "String"));
		examRecord.addAttribute(new ModelAttribute(getId(), "time", "体检时间", "Date"));
		examRecord.addAttribute(new ModelAttribute(getId(), "writertime", "填写时间", "Date"));
		examRecord.addAttribute(new ModelAttribute(getId(), "writer", "填写人", "String"));
		examRecord.addAttribute(new ModelAttribute(getId(), "file", "体检附件", "String"));
		examRecord.addAttribute(new ModelAttribute(getId(), "note", "体检备注", "String"));
		
		
		Model examDetail=new Model(getId(),"ExamDetail","体检详情","uuid", project);
		examDetail.addAttribute(new ModelAttribute(getId(), "value", "体检结果", "String"));
		
		
		Model examProject = new Model(getId(),"ExamProject","体检项目","uuid", project);
		examProject.addAttribute(new ModelAttribute(getId(), "name", "项名名称", "String"));
		examProject.addAttribute(new ModelAttribute(getId(), "datatype", "项目数据类型", "String"));

		Model examProjectGroup = new Model(getId(),"ExamProjectGroup","体检项目组","uuid", project);
		examProjectGroup.addAttribute(new ModelAttribute(getId(),"name","分组名称","String"));


		Model vaccineRecord = new Model(getId(),"VaccineRecord","疫苗接种记录","uuid",project);
        vaccineRecord.addAttribute(new ModelAttribute(getId(),"vaccineProject_name","疫苗项目名称","String"));
		vaccineRecord.addAttribute(new ModelAttribute(getId(),"number","疫苗的接种次数","Integer"));
		vaccineRecord.addAttribute(new ModelAttribute(getId(),"isVaccine","疫苗是否已经接种","Boolean"));
		vaccineRecord.addAttribute(new ModelAttribute(getId(),"starttime","疫苗的接种时间","Date"));
		vaccineRecord.addAttribute(new ModelAttribute(getId(),"endtime","疫苗的接种的截止时间","Date"));


		Model vaccineProject = new Model(getId(),"VaccineProject","接种疫苗项目","uuid",project);
		vaccineProject.addAttribute(new ModelAttribute(getId(),"name","疫苗名称","String"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"total","疫苗接种次数","Integer"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"rand","疫苗距离下次接种时间","Integer"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"note","疫苗简介","String"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"prevent","疫苗预防疾病","String"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"attention","疫苗注意事项","String"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"startage","疫苗接种疫苗最早周龄","Integer"));
		vaccineProject.addAttribute(new ModelAttribute(getId(),"endage","疫苗接种疫苗最迟周龄","Integer"));

        Model vaccineRand =new Model(getId(),"VaccineRand","接种疫苗次数","uuid",project);
		vaccineRand.addAttribute(new ModelAttribute(getId(),"num","次数","Integer"));
        vaccineRand.addAttribute(new ModelAttribute(getId(),"rand","周期","Integer"));

        Model healthAssessRecord=new Model(getId(),"HealthAssessRecord","健康档案","uuid",project);
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"writertime","创建时间","Date"));
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"isRead","是否可读","Boolean"));
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"year","年","Integer"));
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"month","月","Integer"));

        Model healthAssessDetail=new Model(getId(),"HealthAssessDetail","健康档案详情","uuid",project);
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"doctor","医生","String"));
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"position","位置","String"));
        healthAssessRecord.addAttribute(new ModelAttribute(getId(),"note","备注","String"));
 
        Model testReport =new Model(getId(),"TestReport","体检报告","uuid",project);
        testReport.addAttribute(new ModelAttribute(getId(),"testTime","体检时间","Date"));
        testReport.addAttribute(new ModelAttribute(getId(),"babyName","就诊人","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"testProject","体检项目","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"hospitalName","体检医院","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"file","附件","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"type","类型","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"tid","编号","String"));
        testReport.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		// 关系列表 
		Relation babyCaseRecord = new Relation(getId(), "caseRecords", "OneToMany",baby);
		Relation caseRecordBaby= new Relation(getId(), "baby", "ManyToOne",caseRecord);


		Relation babyDevelopRecord = new Relation(getId(), "develRecords", "OneToMany",baby);
		Relation developRecordBaby= new Relation(getId(), "baby", "ManyToOne",developRecord);

		Relation babyExamRecord = new Relation(getId(), "examRecords", "OneToMany",baby);
		Relation examRecordBaby= new Relation(getId(), "baby", "ManyToOne",examRecord);

		Relation babyMonitorRecord = new Relation(getId(), "monitorRecords", "OneToMany",baby);
		Relation monitorRecordBaby= new Relation(getId(), "baby", "ManyToOne",monitorRecord);
		

		Relation caseRecordCaseDetail= new Relation(getId(),"caseDetails", "OneToMany",caseRecord);
		Relation caseDetailCaseRecord= new Relation(getId(),"caseRecord", "ManyToOne",caseDetail);


		Relation caseProjectCaseDetail= new Relation(getId(),"caseDetails", "OneToMany",caseProject);
		Relation caseDetailCaseProject= new Relation(getId(),"caseProject", "ManyToOne",caseDetail);


		Relation developProjectDevelopRecord=new Relation(getId(),"developRecord", "OneToMany",developProject);
		Relation developRecordDevelopProject=new Relation(getId(),"developProject", "ManyToOne",developRecord);


		Relation developProjectDevelopStandard= new Relation(getId(),"developStandards", "OneToMany",developProject);
		Relation developStandardDevelopProject=new Relation(getId(),"developProject", "ManyToOne",developStandard);


		Relation standardDevelopStandard= new Relation(getId(),"developStandards", "OneToMany",standard);
		Relation developStandardStandard=new Relation(getId(),"standard", "ManyToOne",developStandard);


		Relation monitorProjectMonitorRecord =new Relation(getId(),"monitorRecords","OneToMany",monitorProject);
		Relation monitorRecordMonitorProject =new Relation(getId(),"monitorProject","ManyToOne",monitorRecord);


		Relation examRecordExamDetail =new Relation(getId(),"examDetails","OneToMany",examRecord);
		Relation examDetailExamRecord =new Relation(getId(),"examRecord","ManyToOne",examDetail);


		Relation examProjectExamDetail =new Relation(getId(),"examDetails","OneToMany",examProject);
		Relation examDetailExamProject =new Relation(getId(),"examProject","ManyToOne",examDetail);

		Relation examProjectGroupExamProject =new Relation(getId(),"examProjects","OneToMany",examProjectGroup);
		Relation examProjectExamProjectGroup =new Relation(getId(),"examProjectGroup","ManyToOne",examProject);


		Relation babyVaccineRecord= new Relation(getId(),"vaccineRecords","OneToMany",baby);
		Relation vaccineRecordBaby = new Relation(getId(),"baby","ManyToOne",vaccineRecord);
                 
		Relation vaccineProjectVaccineRecord=new Relation(getId(),"vaccineRecords","OneToMany",vaccineProject);
        Relation vaccineRecordVaccineProject=new Relation(getId(),"vaccineProject","ManyToOne",vaccineRecord);
    
        Relation vaccineProjectVaccineRand=new Relation(getId(),"vaccineRands","OneToMany",vaccineProject);
        Relation vaccineRandVaccineProject=new Relation(getId(),"vaccineProject","ManyToOne",vaccineRand);

        Relation babyHealthAssessRecord = new Relation(getId(),"healthAssessRecords","OneToMany",baby);
        
        Relation healthAssessRecordBaby = new Relation(getId(),"baby","ManyToOne",healthAssessRecord);
        Relation healthAssessRecordHealthAssessDetail=new Relation(getId(),"healthAssessDetails","OneToMany",healthAssessRecord);
        Relation healthAssessDetailHealthAssessRecord=new Relation(getId(),"healthAssessRecord","ManyToOne",healthAssessDetail);

        Relation babyTestReport =new Relation(getId(),"testReports","OneToMany",baby);
        Relation testReportBaby=new Relation(getId(),"baby","ManyToOne",testReport);
        
		// 关系设置
		babyCaseRecord.setRelation(caseRecordBaby);
		caseRecordBaby.setRelation(babyCaseRecord);

		babyDevelopRecord.setRelation(developRecordBaby);
		developRecordBaby.setRelation(babyDevelopRecord);

		babyExamRecord.setRelation(examRecordBaby); 
		examRecordBaby.setRelation(babyExamRecord);


		babyMonitorRecord.setRelation(monitorRecordBaby); 
		monitorRecordBaby.setRelation(babyMonitorRecord);
		

		caseRecordCaseDetail.setRelation(caseDetailCaseRecord);
		caseDetailCaseRecord.setRelation(caseRecordCaseDetail);

		caseProjectCaseDetail.setRelation(caseDetailCaseProject);
		caseDetailCaseProject.setRelation(caseProjectCaseDetail);


		developProjectDevelopRecord.setRelation(developRecordDevelopProject);
		developRecordDevelopProject.setRelation(developProjectDevelopRecord);


		developProjectDevelopStandard.setRelation(developStandardDevelopProject);
		developStandardDevelopProject.setRelation(developProjectDevelopStandard);

		standardDevelopStandard.setRelation(developStandardStandard);
		developStandardStandard.setRelation(standardDevelopStandard);


		monitorProjectMonitorRecord.setRelation(monitorRecordMonitorProject);
		monitorRecordMonitorProject.setRelation(monitorProjectMonitorRecord);

		examRecordExamDetail.setRelation(examDetailExamRecord);
		examDetailExamRecord.setRelation(examRecordExamDetail);


		examProjectExamDetail.setRelation(examDetailExamProject);
		examDetailExamProject.setRelation(examProjectExamDetail);

		examProjectGroupExamProject.setRelation(examProjectExamProjectGroup);
		examProjectExamProjectGroup.setRelation(examProjectGroupExamProject);


		babyVaccineRecord.setRelation(vaccineRecordBaby);
		vaccineRecordBaby.setRelation(babyVaccineRecord);
                
        vaccineProjectVaccineRecord.setRelation(vaccineRecordVaccineProject);
        vaccineRecordVaccineProject.setRelation(vaccineProjectVaccineRecord); 
  
        vaccineProjectVaccineRand.setRelation(vaccineRandVaccineProject);
        vaccineRandVaccineProject.setRelation(vaccineProjectVaccineRand);

        babyHealthAssessRecord.setRelation(healthAssessRecordBaby);
        healthAssessRecordBaby.setRelation(babyHealthAssessRecord);

        healthAssessRecordHealthAssessDetail.setRelation(healthAssessDetailHealthAssessRecord);
        healthAssessDetailHealthAssessRecord.setRelation(healthAssessRecordHealthAssessDetail);
        
        babyTestReport.setRelation(testReportBaby);
        testReportBaby.setRelation(babyTestReport);
        
		// 添加关系
		baby.addRelation(babyCaseRecord);
		baby.addRelation(babyDevelopRecord);
		baby.addRelation(babyMonitorRecord);
		baby.addRelation(babyExamRecord);
		baby.addRelation(babyVaccineRecord);
		baby.addRelation(babyHealthAssessRecord); 
		baby.addRelation(babyTestReport);

		vaccineRecord.addRelation(vaccineRecordBaby);
        vaccineRecord.addRelation(vaccineRecordVaccineProject);
        vaccineProject.addRelation(vaccineProjectVaccineRand);
        vaccineProject.addRelation(vaccineProjectVaccineRecord);       

        healthAssessRecord.addRelation(healthAssessRecordBaby);
        healthAssessRecord.addRelation(healthAssessRecordHealthAssessDetail);
        
        healthAssessDetail.addRelation(healthAssessDetailHealthAssessRecord);
 
		caseRecord.addRelation(caseRecordBaby);
		caseRecord.addRelation(caseRecordCaseDetail);

		caseDetail.addRelation(caseDetailCaseRecord);
		caseDetail.addRelation(caseDetailCaseProject);

		caseProject.addRelation(caseProjectCaseDetail);

		developRecord.addRelation(developRecordBaby);
		developRecord.addRelation(developRecordDevelopProject);

		developProject.addRelation(developProjectDevelopStandard);
		developProject.addRelation(developProjectDevelopRecord);

		developStandard.addRelation(developStandardStandard);
		developStandard.addRelation(developRecordDevelopProject);
		
		standard.addRelation(standardDevelopStandard);

		examRecord.addRelation(examRecordBaby);
		examRecord.addRelation(examRecordExamDetail);


		examDetail.addRelation(examDetailExamRecord);
		examDetail.addRelation(examDetailExamProject);


		examProject.addRelation(examProjectExamDetail);
		examProject.addRelation(examProjectExamProjectGroup);

		examProjectGroup.addRelation(examProjectGroupExamProject);


		monitorRecord.addRelation(monitorRecordBaby);
		monitorRecord.addRelation(monitorRecordMonitorProject);

		monitorProject.addRelation(monitorProjectMonitorRecord);

		testReport.addRelation(testReportBaby);
		
		// 添加模型
		models.add(baby);
		models.add(caseRecord);
		models.add(caseDetail);
		models.add(caseProject);
		models.add(developRecord);
		models.add(developProject);
		models.add(developStandard);
		models.add(standard);
		models.add(monitorRecord);
		models.add(monitorProject);
		models.add(examRecord);
		models.add(examDetail);
		models.add(examProject);
		models.add(examProjectGroup);
		models.add(vaccineRecord);
        models.add(vaccineRand);
        models.add(healthAssessDetail);
        models.add(healthAssessRecord);
        models.add(testReport);
models.add(vaccineProject);
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
	Project project = new Project("123456", "BBcareUserArchives_v2",
		"BBcare用户档案", new Frame(getId(), "sh", "SH"), new Frame(getId(),
			"smartadmin", "SmartAdmin"), new Frame(getId(),
			"jquerymobile", "jquerymobile"));
	project.setPkgName("com.bbcare.cloud.user.archives");
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
	"mysql://localhost:3306/bbcare_cloud_user?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
	"root", ""));
return project;
}
}
