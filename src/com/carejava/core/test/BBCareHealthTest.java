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

public class BBCareHealthTest {

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
		Model doctorTeam = new Model(getId(), "DoctorTeam", "品牌医生", "uuid", project);
		doctorTeam.addAttribute(new ModelAttribute(getId(), "name", "名称", "String"));
		doctorTeam.addAttribute(new ModelAttribute(getId(),"doctorId","负责医生","String"));
		
		Model doctorQuestionRecord = new Model(getId(),"DoctorQuestionRecord","问卷记录","uuid",project);
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "name", "问卷名", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "note", "问卷说明", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "totalScore", "问卷总分", "Integer"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "gainScore", "获得分数", "Integer"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "healthLevel", "健康等级", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "doctorAdvice", "医生指导", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "BabyQuestionRecordId", "宝宝问卷Id", "String"));
		doctorQuestionRecord.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		
		Model provideServer = new Model(getId(),"ProvideServer","提供服务","uuid",project);
		provideServer.addAttribute(new ModelAttribute(getId(), "name", "服务名称", "String"));
		provideServer.addAttribute(new ModelAttribute(getId(), "store", "库存", "Integer"));
		provideServer.addAttribute(new ModelAttribute(getId(), "price", "服务价格", "Integer"));
		provideServer.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model extraProductPackage = new Model(getId(),"ExtraProductPackage","增值包","uuid",project);
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "name", "服务名称", "String"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "upTime", "上架时间", "Date"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "downTime", "下架时间", "Date"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "doctorTeamId", "医生团队Id", "String"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "consulObjectId", "咨询对象", "String"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "type", "增值类型", "String"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "isDefault", "是否默认包含", "Boolean"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "store", "库存量", "Integer"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "price", "价格", "Integer"));
		extraProductPackage.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model questionnairePackage = new Model(getId(),"QuestionnairePackage","问卷包","uuid",project);
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "name", "问卷包名称", "String"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "upTime", "上架时间", "Date"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "downTime", "下架时间", "Date"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "cycle", "有效期", "String"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "cycleUnit", "有效期单位", "String"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "price", "价格", "Integer"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "menberSource", "开放会员", "String"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "type", "公开性类型", "String"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "sort", "排序", "Integer"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "isDelete", "是否删除", "Boolean"));
		questionnairePackage.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));


		Model questionnaire = new Model(getId(),"Questionnaire","问卷","uuid",project);
		questionnaire.addAttribute(new ModelAttribute(getId(), "name", "问卷名", "String"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "ageMax", "适用最大年龄", "Integer"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "ageMin", "适用最小年龄", "Integer"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "totalScore", "总分", "Integer"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "note", "问卷说明", "String"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "isLock", "是否锁定", "Boolean"));
		questionnaire.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model healthLevel = new Model(getId(),"HealthLevel","健康等级","uuid",project);
		healthLevel.addAttribute(new ModelAttribute(getId(), "scoreMax", "适用最大分数", "Integer"));
		healthLevel.addAttribute(new ModelAttribute(getId(), "scoreMin", "适用最小分数", "Integer"));
		healthLevel.addAttribute(new ModelAttribute(getId(), "levelName", "级别名称", "String"));
		healthLevel.addAttribute(new ModelAttribute(getId(), "note", "系统测评", "String"));

		Model healthGuidePackage = new Model(getId(),"HealthGuidePackage","健康指导包","uuid",project);
		healthGuidePackage.addAttribute(new ModelAttribute(getId(), "name", "健康指导名称", "String"));
		healthGuidePackage.addAttribute(new ModelAttribute(getId(), "provider", "提供者", "String"));
		healthGuidePackage.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model healthGuide = new Model(getId(),"HealthGuide","健康指导","uuid",project);
		healthGuide.addAttribute(new ModelAttribute(getId(), "scoreMax", "适用最大分数", "Integer"));
		healthGuide.addAttribute(new ModelAttribute(getId(), "scoreMin", "适用最小分数", "Integer"));
		healthGuide.addAttribute(new ModelAttribute(getId(), "sort", "序号", "Integer"));
		healthGuide.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model healthGuideDetail = new Model(getId(),"HealthGuideDetail","健康指导详情","uuid",project);
		healthGuideDetail.addAttribute(new ModelAttribute(getId(), "sort", "序号", "Integer"));
		healthGuideDetail.addAttribute(new ModelAttribute(getId(), "note", "详细指导", "String"));
		healthGuideDetail.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));


		Model babyQuestionRecord = new Model(getId(),"BabyQuestionRecord","宝宝问卷记录","uuid",project);
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "name", "问卷名", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "note", "问卷说明", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "questionId", "未完成Id", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "totalScore", "问卷总分", "Integer"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "gainScore", "获得分数", "Integer"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "sysNote", "系统测评", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "healthLevel", "健康等级", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "sysHealthGuide", "系统健康指导", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "sysHealthGuideTime", "指导时间", "Date"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "doctorTeamId", "医生团队Id", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "doctorAdvice", "医生建议", "String"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "doctorAdviceTime", "医生建议时间", "Date"));
		babyQuestionRecord.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));

		Model babyQuestionDetail = new Model(getId(),"BabyQuestionDetail","宝宝问卷详情","uuid",project);
		babyQuestionDetail.addAttribute(new ModelAttribute(getId(), "questionId", "问题Id", "String"));
		babyQuestionDetail.addAttribute(new ModelAttribute(getId(), "optionId", "选择的选项Id", "String"));
		babyQuestionDetail.addAttribute(new ModelAttribute(getId(), "sorce", "分数", "Integer"));
		babyQuestionDetail.addAttribute(new ModelAttribute(getId(), "type", "类型", "String"));

		Model question = new Model(getId(),"Question","问题","uuid",project);
		question.addAttribute(new ModelAttribute(getId(), "sorce", "分数", "Integer"));
		question.addAttribute(new ModelAttribute(getId(), "type", "问题类型", "String"));
		question.addAttribute(new ModelAttribute(getId(), "lastId", "上一题Id", "String"));
		question.addAttribute(new ModelAttribute(getId(), "nextId", "下一题Id", "String"));
		question.addAttribute(new ModelAttribute(getId(), "relaType", "关联类型", "String"));
		question.addAttribute(new ModelAttribute(getId(), "note", "问题描述", "String"));
		question.addAttribute(new ModelAttribute(getId(), "filePathType", "附件路径类型", "String"));
		question.addAttribute(new ModelAttribute(getId(), "filePath", "附件路径", "String"));
		question.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		

		Model options = new Model(getId(),"Options","问题选项","uuid",project);
		options.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		options.addAttribute(new ModelAttribute(getId(), "note", "选择描述", "String"));
		options.addAttribute(new ModelAttribute(getId(), "lastId", "上一题Id", "String"));
		options.addAttribute(new ModelAttribute(getId(), "nextId", "下一题Id", "String"));
		options.addAttribute(new ModelAttribute(getId(), "filePathType", "附件路径类型", "String"));
		options.addAttribute(new ModelAttribute(getId(), "filePath", "附件路径", "String"));

		Model babyQuestionnairePackage = new Model(getId(),"BabyQuestionnairePackage","宝宝问卷包","uuid",project);
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "buyTime", "购买时间", "Date"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "endTime", "到期时间", "Date"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "price", "价格", "Integer"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "babyId","宝宝Id","String"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "babyName","宝宝名","String"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "birthday","宝宝生日","Date"));
		babyQuestionnairePackage.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));


		Model babyExtraProduct = new Model(getId(),"BabyExtraProduct","宝宝增值产品","uuid",project);
		babyExtraProduct.addAttribute(new ModelAttribute(getId(), "type", "服务类型", "String"));
		babyExtraProduct.addAttribute(new ModelAttribute(getId(), "consultObjectId", "咨询对象Id", "String"));
		babyExtraProduct.addAttribute(new ModelAttribute(getId(), "store", "库存量", "Integer"));
		babyExtraProduct.addAttribute(new ModelAttribute(getId(), "usedNumber", "已用次数", "Integer"));

		/**

		Model orders = new Model(getId(),"Orders","订单","uuid",project);
		orders.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		orders.addAttribute(new ModelAttribute(getId(), "type", "订单类型", "String"));
		orders.addAttribute(new ModelAttribute(getId(), "productId", "产品Id", "String"));
		orders.addAttribute(new ModelAttribute(getId(), "price", "价格", "Integer"));
		orders.addAttribute(new ModelAttribute(getId(), "status", "状态", "String"));
		*/
		
		Model customClass = new Model(getId(),"CustomClass","题库分类","uuid",project);
		customClass.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		customClass.addAttribute(new ModelAttribute(getId(), "name", "分类名称", "String"));
		customClass.addAttribute(new ModelAttribute(getId(), "adminId", "系统管理员Id", "String"));

		Model sysHealthGuideLibrary = new Model(getId(),"SysHealthGuideLibrary","系统健康指导库","uuid",project);
		sysHealthGuideLibrary.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		sysHealthGuideLibrary.addAttribute(new ModelAttribute(getId(), "note", "指导内容", "String"));


		Model questionLibrary = new Model(getId(),"QuestionLibrary","题库问题","uuid",project);
		questionLibrary.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		questionLibrary.addAttribute(new ModelAttribute(getId(), "type", "问题类型", "String"));
		questionLibrary.addAttribute(new ModelAttribute(getId(), "relaType", "关联类型", "String"));
		questionLibrary.addAttribute(new ModelAttribute(getId(), "note", "问题描述", "Integer"));
		questionLibrary.addAttribute(new ModelAttribute(getId(), "filePathType", "附件路径类型", "String"));
		questionLibrary.addAttribute(new ModelAttribute(getId(), "filePath", "附件路径", "String"));

		Model optionLibrary = new Model(getId(),"OptionLibrary","题库问题选项","uuid",project);
		optionLibrary.addAttribute(new ModelAttribute(getId(), "createTime", "创建时间", "Date"));
		optionLibrary.addAttribute(new ModelAttribute(getId(), "note", "选项描述", "Integer"));
		optionLibrary.addAttribute(new ModelAttribute(getId(), "filePathType", "附件路径类型", "String"));
		optionLibrary.addAttribute(new ModelAttribute(getId(), "filePath", "附件路径", "String"));


		// 关系列表
		Relation doctorTeamProvideServer = new Relation(getId(),"provideServers","OneToMany",doctorTeam);
		Relation provideServerDoctorTeam = new Relation(getId(),"doctorTeam","ManyToOne",provideServer);

		Relation doctorTeamDoctorQuestionRecord = new Relation(getId(),"doctorQuestionRecords","OneToMany",doctorTeam);
		Relation doctorQuestionRecordDoctorTeam = new Relation(getId(),"doctorTeam","ManyToOne",doctorQuestionRecord);

		Relation provideServerExtraProductPackage = new Relation(getId(),"extraProductPackages","OneToMany",provideServer);
		Relation extraProductPackageProvideServer = new Relation(getId(),"provideServer","ManyToOne",extraProductPackage);

		Relation questionnairePackageExtraProductPackage = new Relation(getId(),"extraProductPackages","OneToMany",questionnairePackage);
		Relation extraProductPackageQuestionnairePackage = new Relation(getId(),"questionnairePackage","ManyToOne",extraProductPackage);

		Relation questionnairePackageBabyQuestionnairePackage = new Relation(getId(),"babyQuestionnairePackages","OneToMany",questionnairePackage);
		Relation babyQuestionnairePackageQuestionnairePackage = new Relation(getId(),"questionnairePackage","ManyToOne",babyQuestionnairePackage);

		Relation babyQuestionnairePackageBabyExtraProduct = new Relation(getId(),"babyExtraProducts","OneToMany",babyQuestionnairePackage);
		Relation babyExtraProductBabyQuestionnairePackage = new Relation(getId(),"babyQuestionnairePackage","ManyToOne",babyExtraProduct);

		Relation babyQuestionnairePackageBabyQuestionRecord = new Relation(getId(),"babyQuestionRecords","OneToMany",babyQuestionnairePackage);
		Relation babyQuestionRecordBabyQuestionnairePackage = new Relation(getId(),"babyQuestionnairePackage","ManyToOne",babyQuestionRecord);

		Relation babyQuestionRecordBabyQuestionDetail = new Relation(getId(),"babyQuestionDetails","OneToMany",babyQuestionRecord);
		Relation babyQuestionDetailBabyQuestionRecord  = new Relation(getId(),"babyQuestionRecord","ManyToOne",babyQuestionDetail);

		Relation questionBabyQuestionDetail = new Relation(getId(),"babyQuestionDetails","OneToMany",question);
		Relation babyQuestionDetailQuestion  = new Relation(getId(),"question","ManyToOne",babyQuestionDetail);

		Relation questionOptions = new Relation(getId(),"optionss","OneToMany",question);
		Relation optionsQuestion  = new Relation(getId(),"question","ManyToOne",options);

		Relation questionnaireBabyQuestionRecord = new Relation(getId(),"babyQuestionRecords","OneToMany",questionnaire);
		Relation babyQuestionRecordQuestionnaire  = new Relation(getId(),"questionnaire","ManyToOne",babyQuestionRecord);

		Relation questionnaireQuestion = new Relation(getId(),"questions","OneToMany",questionnaire);
		Relation questionQuestionnaire  = new Relation(getId(),"questionnaire","ManyToOne",question);

		Relation questionnaireHealthLevel = new Relation(getId(),"healthLevels","OneToMany",questionnaire);
		Relation healthLevelQuestionnaire  = new Relation(getId(),"questionnaire","ManyToOne",healthLevel);

		Relation healthLevelHealthGuidePackage = new Relation(getId(),"healthGuidePackages","OneToMany",healthLevel);
		Relation healthGuidePackageHealthLevel = new Relation(getId(),"healthLevel","ManyToOne",healthGuidePackage);

		Relation healthGuidePackageHealthGuide = new Relation(getId(),"healthGuides","OneToMany",healthGuidePackage);
		Relation healthGuideHealthGuidePackage = new Relation(getId(),"healthGuidePackage","ManyToOne",healthGuide);

		Relation healthGuideHealthGuideDetail = new Relation(getId(),"healthGuideDetails","OneToMany",healthGuide);
		Relation healthGuideDetailHealthGuide = new Relation(getId(),"healthGuide","ManyToOne",healthGuideDetail);

		Relation customClassSysHealthGuideLibrary = new Relation(getId(),"healthGuideLibrarys","OneToMany",customClass);
		Relation syshealthGuideLibraryCustomClass = new Relation(getId(),"customClass","ManyToOne",sysHealthGuideLibrary);

		Relation customClassQuestionLibrary = new Relation(getId(),"questionLibrarys","OneToMany",customClass);
		Relation questionLibraryCustomClass = new Relation(getId(),"customClass","ManyToOne",questionLibrary);

		Relation questionLibraryOptionLibrary = new Relation(getId(),"optionLibrarys","OneToMany",optionLibrary);
		Relation optionLibraryQuestionLibrary = new Relation(getId(),"questionLibrary","ManyToOne",questionLibrary);

		Relation questionnairePackageQuestionnaire = new Relation(getId(),"questionnaires","OneToMany",questionnairePackage);
		Relation questionnaireQuestionnairePackage = new Relation(getId(),"questionnairePackage","ManyToOne",questionnaire);


		// 关系设置
		
		doctorTeamProvideServer.setRelation(provideServerDoctorTeam);
		provideServerDoctorTeam.setRelation(doctorTeamProvideServer);

		doctorTeamDoctorQuestionRecord.setRelation(doctorQuestionRecordDoctorTeam);
		doctorQuestionRecordDoctorTeam.setRelation(doctorTeamDoctorQuestionRecord);

		provideServerExtraProductPackage.setRelation(extraProductPackageProvideServer);
		extraProductPackageProvideServer.setRelation(provideServerExtraProductPackage);

		questionnairePackageExtraProductPackage.setRelation(extraProductPackageQuestionnairePackage);
		extraProductPackageQuestionnairePackage.setRelation(questionnairePackageExtraProductPackage);

		questionnairePackageBabyQuestionnairePackage.setRelation(babyQuestionnairePackageQuestionnairePackage);
		babyQuestionnairePackageQuestionnairePackage.setRelation(questionnairePackageBabyQuestionnairePackage);

		babyQuestionnairePackageBabyExtraProduct.setRelation(babyExtraProductBabyQuestionnairePackage);
		babyExtraProductBabyQuestionnairePackage.setRelation(babyQuestionnairePackageBabyExtraProduct);

		babyQuestionnairePackageBabyQuestionRecord.setRelation(babyQuestionRecordBabyQuestionnairePackage);
		babyQuestionRecordBabyQuestionnairePackage .setRelation(babyQuestionnairePackageBabyQuestionRecord);

		babyQuestionRecordBabyQuestionDetail.setRelation(babyQuestionDetailBabyQuestionRecord);
		babyQuestionDetailBabyQuestionRecord.setRelation(babyQuestionRecordBabyQuestionDetail);

		questionBabyQuestionDetail.setRelation(babyQuestionDetailQuestion);
		babyQuestionDetailQuestion.setRelation(questionBabyQuestionDetail);

		questionOptions.setRelation(optionsQuestion);
		optionsQuestion.setRelation(questionOptions);

		questionnaireBabyQuestionRecord.setRelation(babyQuestionRecordQuestionnaire);
		babyQuestionRecordQuestionnaire.setRelation(questionnaireBabyQuestionRecord);

		questionnaireQuestion.setRelation(questionQuestionnaire);
		questionQuestionnaire.setRelation(questionnaireQuestion);

		questionnaireHealthLevel.setRelation(healthLevelQuestionnaire);
		healthLevelQuestionnaire.setRelation(questionnaireHealthLevel);

		healthLevelHealthGuidePackage.setRelation(healthGuidePackageHealthLevel);
		healthGuidePackageHealthLevel.setRelation(healthLevelHealthGuidePackage);

		healthGuidePackageHealthGuide.setRelation(healthGuideHealthGuidePackage);
		healthGuideHealthGuidePackage.setRelation(healthGuidePackageHealthGuide);

		healthGuideHealthGuideDetail.setRelation(healthGuideDetailHealthGuide);
		healthGuideDetailHealthGuide.setRelation(healthGuideHealthGuideDetail);

		customClassSysHealthGuideLibrary.setRelation(syshealthGuideLibraryCustomClass);
		syshealthGuideLibraryCustomClass.setRelation(customClassSysHealthGuideLibrary);

		customClassQuestionLibrary.setRelation(questionLibraryCustomClass);
		questionLibraryCustomClass.setRelation(customClassQuestionLibrary);

		questionLibraryOptionLibrary.setRelation(optionLibraryQuestionLibrary);
		optionLibraryQuestionLibrary.setRelation(questionLibraryOptionLibrary);

		questionnairePackageQuestionnaire.setRelation(questionnaireQuestionnairePackage);
		questionnaireQuestionnairePackage.setRelation(questionnairePackageQuestionnaire);
		
		//添加关系
		doctorTeam.addRelation(doctorTeamDoctorQuestionRecord);
		doctorTeam.addRelation(doctorTeamProvideServer);

		doctorQuestionRecord.addRelation(doctorQuestionRecordDoctorTeam);

		provideServer.addRelation(provideServerDoctorTeam);
		provideServer.addRelation(provideServerExtraProductPackage);

		extraProductPackage.addRelation(extraProductPackageQuestionnairePackage);
		extraProductPackage.addRelation(extraProductPackageProvideServer);		

		questionnairePackage.addRelation(questionnairePackageQuestionnaire);
		questionnairePackage.addRelation(questionnairePackageBabyQuestionnairePackage);
		questionnairePackage.addRelation(questionnairePackageExtraProductPackage);

		questionnaire.addRelation(questionnaireQuestion);
		questionnaire.addRelation(questionnaireQuestionnairePackage);
		questionnaire.addRelation(questionnaireHealthLevel);

		healthLevel.addRelation(healthLevelQuestionnaire);
		healthLevel.addRelation(healthLevelHealthGuidePackage);

		healthGuidePackage.addRelation(healthGuidePackageHealthGuide);
		healthGuidePackage.addRelation(healthGuidePackageHealthLevel);

		healthGuide.addRelation(healthGuideHealthGuidePackage);
		healthGuide.addRelation(healthGuideHealthGuidePackage);

		healthGuideDetail.addRelation(healthGuideDetailHealthGuide);

		babyQuestionRecord.addRelation(babyQuestionRecordQuestionnaire);
		babyQuestionRecord.addRelation(babyQuestionRecordBabyQuestionDetail);
		babyQuestionRecord.addRelation(babyQuestionRecordBabyQuestionnairePackage);

		babyQuestionDetail.addRelation(babyQuestionDetailQuestion);
		babyQuestionDetail.addRelation(babyQuestionDetailBabyQuestionRecord);

		question.addRelation(questionBabyQuestionDetail);
		question.addRelation(questionOptions);
		question.addRelation(questionQuestionnaire);

		options.addRelation(optionsQuestion);

		babyQuestionnairePackage.addRelation(babyQuestionnairePackageQuestionnairePackage);
		babyQuestionnairePackage.addRelation(babyQuestionnairePackageBabyQuestionRecord);
		babyQuestionnairePackage.addRelation(babyQuestionnairePackageBabyExtraProduct);

		babyExtraProduct.addRelation(babyExtraProductBabyQuestionnairePackage);

		customClass.addRelation(customClassSysHealthGuideLibrary);
		customClass.addRelation(customClassQuestionLibrary);

		sysHealthGuideLibrary.addRelation(syshealthGuideLibraryCustomClass);

		questionLibrary.addRelation(questionLibraryCustomClass);
		questionLibrary.addRelation(questionLibraryOptionLibrary);

		optionLibrary.addRelation(optionLibraryQuestionLibrary);

		// 添加模型
		
		models.add(doctorTeam);
		models.add(doctorQuestionRecord);
		models.add(provideServer);
		models.add(extraProductPackage);
		models.add(questionnairePackage);
		models.add(questionnaire);
		models.add(healthLevel);
		models.add(healthGuidePackage);
		models.add(healthGuide);
		models.add(healthGuideDetail);
		models.add(babyQuestionRecord);
		models.add(babyQuestionDetail);
		models.add(question);
		models.add(options);
		models.add(babyQuestionnairePackage);
		models.add(babyExtraProduct);
		models.add(customClass);
		models.add(sysHealthGuideLibrary);
		models.add(questionLibrary);
		models.add(optionLibrary);
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
		Project project = new Project("123456", "BBCareHealthTest", "BBcare测评管理后台", new Frame(getId(), "ssh", "SSH"),
				new Frame(getId(), "smartadmin", "SmartAdmin"), new Frame(getId(), "jquerymobile", "jquerymobile"));
		project.setPkgName("com.bbcare.cloud.healthTest");
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
						"mysql://lecbuild.mysql.rds.aliyuncs.com:3306/test_bbcare_health_test?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
						"username", "password"));
		return project;
	}
}
