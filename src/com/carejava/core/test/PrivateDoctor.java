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

public class PrivateDoctor {

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
		
		Model product = new Model(getId(),"Product","产品","uuid",project);
		product.addAttribute(new ModelAttribute(getId(),"parentId","前置产品","String"));
		product.addAttribute(new ModelAttribute(getId(),"ProductName","产品名称","String"));
		product.addAttribute(new ModelAttribute(getId(),"type","产品类型","String"));
		product.addAttribute(new ModelAttribute(getId(),"cycle","服务周期","Integer"));
		product.addAttribute(new ModelAttribute(getId(),"cycleUnit","周期单位","Integer"));
		product.addAttribute(new ModelAttribute(getId(),"money","产品金额","Integer"));
		product.addAttribute(new ModelAttribute(getId(),"information","使用须知","String"));
		product.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		product.addAttribute(new ModelAttribute(getId(),"status","产品状态","String"));
		
		Model productItem =new Model(getId(),"ProductItem","产品项","uuid",project);
		productItem.addAttribute(new ModelAttribute(getId(),"name","产品项名","String"));
		productItem.addAttribute(new ModelAttribute(getId(),"note","产品详情","String"));
		productItem.addAttribute(new ModelAttribute(getId(),"introduce","产品介绍","String"));
		productItem.addAttribute(new ModelAttribute(getId(),"icon","产品项图标","String"));
		productItem.addAttribute(new ModelAttribute(getId(),"type","类型","String"));
		
		Model appointment=new Model(getId(),"Appointment","门诊预约","uuid",project);
		appointment.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		
		Model expertorConsult = new Model(getId(),"ExpertorConsult","专家咨询","uuid",project);
		expertorConsult.addAttribute(new ModelAttribute(getId(),"week","周几","Integer"));
		expertorConsult.addAttribute(new ModelAttribute(getId(),"timeSolt","时间段","String"));
		expertorConsult.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		expertorConsult.addAttribute(new ModelAttribute(getId(),"onesLength","单次通话时长","Integer"));
		
		Model onlineQuestion =new Model(getId(),"OnlineQuestion","在线提问","uuid",project);
		onlineQuestion.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		
		Model orders=new Model(getId(),"Orders","产品订单","uuid",project);
		orders.addAttribute(new ModelAttribute(getId(),"type","订单类型","String"));
		orders.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		orders.addAttribute(new ModelAttribute(getId(),"money","花费金额","Integer"));
		orders.addAttribute(new ModelAttribute(getId(),"status","订单状态","String"));
		
		Model babyProduct= new Model(getId(),"BabyProduct","已订购产品","uuid",project);
		babyProduct.addAttribute(new ModelAttribute(getId(),"cycle","服务周期","String"));
		babyProduct.addAttribute(new ModelAttribute(getId(),"buyTime","购买时间","Date"));
		babyProduct.addAttribute(new ModelAttribute(getId(),"endTime","到期时间","Date"));
		babyProduct.addAttribute(new ModelAttribute(getId(),"money","产品金额","Integer"));
		babyProduct.addAttribute(new ModelAttribute(getId(),"type","产品类型","String"));
		babyProduct.addAttribute(new ModelAttribute(getId(),"information","使用须知","String"));
		
		Model babyProductItem = new Model(getId(),"BabyProductItem","产品项详情","uuid",project);
		babyProductItem.addAttribute(new ModelAttribute(getId(),"name","产品项名","String"));
		babyProductItem.addAttribute(new ModelAttribute(getId(),"note","产品项介绍","String"));
		babyProductItem.addAttribute(new ModelAttribute(getId(),"icon","产品项图标","String"));
		babyProductItem.addAttribute(new ModelAttribute(getId(),"type","类型","String"));
		
		Model babyAppointment=new Model(getId(),"BabyAppointment","门诊预约","uuid",project);
		babyAppointment.addAttribute(new ModelAttribute(getId(),"doctorId","医生Id","String"));
		babyAppointment.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		babyAppointment.addAttribute(new ModelAttribute(getId(),"usedNumber","已使用次数","Integer"));
		
		Model babyExpertorConsult = new Model(getId(),"BabyExpertorConsult","专家咨询","uuid",project);
		babyExpertorConsult.addAttribute(new ModelAttribute(getId(),"doctorId","医生Id","String"));
		babyExpertorConsult.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		babyExpertorConsult.addAttribute(new ModelAttribute(getId(),"onesLength","单次通话时长","Integer"));
		babyExpertorConsult.addAttribute(new ModelAttribute(getId(),"usedNumber","已使用次数","String"));
		
		Model babyOnlineQuestion =new Model(getId(),"BabyOnlineQuestion","在线提问","uuid",project);
		babyOnlineQuestion.addAttribute(new ModelAttribute(getId(),"doctorId","医生Id","String"));
		babyOnlineQuestion.addAttribute(new ModelAttribute(getId(),"store","使用总次数","Integer"));
		babyOnlineQuestion.addAttribute(new ModelAttribute(getId(),"usedNumber","已使用次数","Integer"));
		
		
		Model appointmentDeatil=new Model(getId(),"AppointmentDeatil","门诊预约","uuid",project);
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"orderNumber","预约单号","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"visitTime","就诊时间","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"type","门诊类型","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"cost","门诊金额","Integer"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"address","门诊地址","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"note","病情描述","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"file","附件","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"information","注意事项","String"));
		appointmentDeatil.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		
		Model expertorConsultDetail = new Model(getId(),"ExpertorConsultDetail","专家咨询","uuid",project);
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"callTime","预约通话时间","Date"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"callLength","预约通话时长","Integer"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"phone","电话号码","String"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"actualTime","实际通话时间","Integer"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"recordPath","录音地址","String"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		expertorConsultDetail.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		
		Model onlineQuestionDetail =new Model(getId(),"OnlineQuestionDetail","在线提问","uuid",project);
		onlineQuestionDetail.addAttribute(new ModelAttribute(getId(),"title","标题","String"));
		onlineQuestionDetail.addAttribute(new ModelAttribute(getId(),"note","问题描述","String"));
		onlineQuestionDetail.addAttribute(new ModelAttribute(getId(),"type","类型","String"));
		onlineQuestionDetail.addAttribute(new ModelAttribute(getId(),"crateTime","提问时间","Date"));
		onlineQuestionDetail.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		
		Model onlineQuestionReply = new Model(getId(),"OnlineQuestionReply","提问回复","uuid",project);
		onlineQuestionReply.addAttribute(new ModelAttribute(getId(),"replyType","回复人类型","String"));
		onlineQuestionReply.addAttribute(new ModelAttribute(getId(),"note","回复内容","String"));
		onlineQuestionReply.addAttribute(new ModelAttribute(getId(),"createTime","回复时间","Date"));
		
		Model illDescribe =new Model(getId(),"IllDescribe","问题描述","uuid",project);
		illDescribe.addAttribute(new ModelAttribute(getId(),"question","问题","String"));
		illDescribe.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		illDescribe.addAttribute(new ModelAttribute(getId(),"answer","回答","String"));
		
		Model question =new Model(getId(),"Question","问题","uuid",project);
		question.addAttribute(new ModelAttribute(getId(),"questionName","问题","String"));
		question.addAttribute(new ModelAttribute(getId(),"type","类型","String"));
		question.addAttribute(new ModelAttribute(getId(),"nextQuestion","下一个问题Id","String"));
		
		Model options=new Model(getId(),"OPtions","问题选项","uuid",project);
		options.addAttribute(new ModelAttribute(getId(),"option","问题选项","String"));
		question.addAttribute(new ModelAttribute(getId(),"nextQuestion","下一个问题Id","String"));
		
		Model outpatientDetail =new Model(getId(),"OutpatientDetail","门诊详情","uuid",project);
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"startTime","开始时间","Date"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"endTime","结束时间","Date"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"outpaientType","门诊类型","String"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"address","门诊地址","String"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"money","挂号费","Integer"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"sales","已挂号数量","Integer"));
		outpatientDetail.addAttribute(new ModelAttribute(getId(),"store","总号数量","Integer"));
		
		Model outpaient =new Model(getId(),"Outpaient","门诊信息","uuid",project);
		outpaient.addAttribute(new ModelAttribute(getId(),"startTime","开始时间","Date"));
		outpaient.addAttribute(new ModelAttribute(getId(),"endTime","结束时间","Date"));
		outpaient.addAttribute(new ModelAttribute(getId(),"outpaientType","门诊类型","String"));
		outpaient.addAttribute(new ModelAttribute(getId(),"week","周数","String"));
		outpaient.addAttribute(new ModelAttribute(getId(),"money","挂号费","Integer"));
		outpaient.addAttribute(new ModelAttribute(getId(),"store","总号数量","Integer"));
		
		Model doctor =new Model(getId(),"Doctor","品牌医生","uuid",project);
		doctor.addAttribute(new ModelAttribute(getId(),"name","医生姓名","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"account","账号","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"password","密码","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"professional","职称","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"gender","科室","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"birthday","生日","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"picture","照片","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"introduct","个人简介","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"goodAt","擅长领域","String"));
		doctor.addAttribute(new ModelAttribute(getId(),"isOpen","是否公开","Boolean"));
		doctor.addAttribute(new ModelAttribute(getId(),"createTime","创建时间","Date"));
		
		Model hospital = new Model(getId(),"Hospital","医院","uuid",project);
		hospital.addAttribute(new ModelAttribute(getId(),"agencyId","机构","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"name","名称","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"introduct","介绍","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"telephone","医院电话","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"logo","医院LOGO","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"web","医院网站","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"type","医院类别","String"));
		hospital.addAttribute(new ModelAttribute(getId(),"seniority","医院资质","String"));

		Model assistantDoctor =new Model(getId(),"AssistantDoctor","助理医生","uuid",project);
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"name","医生姓名","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"account","账号","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"password","密码","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"status","状态","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"professional","职称","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"gender","科室","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"birthday","生日","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"picture","照片","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"introduct","个人简介","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"goodAt","擅长领域","String"));
		assistantDoctor.addAttribute(new ModelAttribute(getId(),"isOpen","是否公开","Boolean"));

		Model baby=new Model(getId(),"Baby","宝宝","uuid",project);
		baby.addAttribute(new ModelAttribute(getId(),"accountBalance","账户余额","Integer"));
		
		Model doctor_AssistantDoctor=new Model(getId(),"Doctor_AssistantDoctor","医生助理医生中间表","uuid",project);
		doctor_AssistantDoctor.addAttribute(new ModelAttribute(getId(),"crateTime","创建时间","Date"));
		doctor_AssistantDoctor.addAttribute(new ModelAttribute(getId(),"status","状态","Date"));
		doctor_AssistantDoctor.addAttribute(new ModelAttribute(getId(),"validity","有效期","Integer"));
		
		
		// 关系列表
		Relation hospitalDoctor=new Relation(getId(),"doctors","OneToMany",hospital);
		Relation doctorHospital=new Relation(getId(),"hospital","ManyToOne",doctor);

		Relation hospitalProduct=new Relation(getId(),"products","OneToMany",hospital);
		Relation productHospital=new Relation(getId(),"hospital","ManyToOne",product);

		Relation hospitalAssistantDoctor=new Relation(getId(),"assistantDoctors","OneToMany",hospital);
		Relation assistantDoctorHospital=new Relation(getId(),"hospital","ManyToOne",assistantDoctor);

		Relation doctorDoctor_AssistantDoctor=new Relation(getId(),"doctor_AssistantDoctors","OneToMany",doctor);
		Relation doctor_AssistantDoctorDoctor=new Relation(getId(),"doctor","ManyToOne",doctor_AssistantDoctor);

		Relation assistantDoctorDoctor_AssistantDoctor=new Relation(getId(),"doctor_AssistantDoctors","OneToMany",assistantDoctor);
		Relation doctor_AssistantDoctorAssistantDoctor=new Relation(getId(),"assistantDoctor","ManyToOne",doctor_AssistantDoctor);

		Relation doctorAssistantDoctor=new Relation(getId(),"assistantDoctors","OneToMany",doctor);
		Relation assistantDoctorDoctor=new Relation(getId(),"doctor","ManyToMany",assistantDoctor);

		Relation productOrders=new Relation(getId(),"orderss","OneToMany",product);
		Relation ordersProduct=new Relation(getId(),"product","ManyToOne",orders);

		Relation productBabyProduct=new Relation(getId(),"babyProducts","OneToMany",product);
		Relation babyProductProduct=new Relation(getId(),"product","ManyToOne",babyProduct);

		Relation productProductItem=new Relation(getId(),"productItems","OneToMany",product);
		Relation productItemProduct=new Relation(getId(),"product","ManyToOne",productItem);

		Relation appointmentProductItem=new Relation(getId(),"productItems","OneToMany",appointment);
		Relation productItemAppointment=new Relation(getId(),"appointment","ManyToOne",productItem);

		Relation experConsultProductItem=new Relation(getId(),"productItems","OneToMany",expertorConsult);
		Relation productItemExperConsult=new Relation(getId(),"experConsult","ManyToOne",productItem);

		Relation onlineQuestionProductItem=new Relation(getId(),"productItems","OneToMany",onlineQuestion);
		Relation productItemOnlineQuestion=new Relation(getId(),"onlineQuestion","ManyToOne",productItem);

		Relation babyOrders=new Relation(getId(),"orderss","OneToMany",baby);
		Relation ordersBaby=new Relation(getId(),"baby","ManyToOne",orders);
		
		Relation babyBabyProduct=new Relation(getId(),"babyProducts","OneToMany",baby);
		Relation babyProductBaby=new Relation(getId(),"baby","ManyToOne",babyProduct);

		Relation babyProductBabyProductItem=new Relation(getId(),"babyProductItems","OneToMany",babyProduct);
		Relation babyProductItemBabyProduct=new Relation(getId(),"babyProduct","ManyToOne",babyProductItem);
		
		Relation babyAppointmentBabyProductItem=new Relation(getId(),"babyProductItems","OneToMany",babyAppointment);
		Relation babyProductItemBabyAppointment=new Relation(getId(),"babyAppointment","ManyToOne",babyProductItem);

		Relation babyExpertorConsultBabyProductItem=new Relation(getId(),"babyProductItems","OneToMany",babyExpertorConsult);
		Relation babyProductItemBabyExpertorConsult=new Relation(getId(),"babyExpertorConsult","ManyToOne",babyProductItem);

		Relation babyOnlineQuestionBabyProductItem=new Relation(getId(),"babyProductItems","OneToMany",babyOnlineQuestion);
		Relation babyProductItemBabyOnlineQuestion=new Relation(getId(),"babyOnlineQuestion","ManyToOne",babyProductItem);
		
		Relation babyAppointmentAppointmentDeatil=new Relation(getId(),"appointmentDeatils","OneToMany",babyAppointment);
		Relation appointmentDeatilBabyAppointment=new Relation(getId(),"babyAppointment","ManyToOne",appointmentDeatil); 

		Relation babyExpertorConsultExpertorConsultDetail=new Relation(getId(),"expertorConsultDetails","OneToMany",babyExpertorConsult);
		Relation expertorConsultDetailBabyExpertorConsult=new Relation(getId(),"babyExpertorConsult","ManyToOne",expertorConsultDetail);

		Relation babyOnlineQuestionOnlineQuestionDetail=new Relation(getId(),"onlineQuestionDetails","OneToMany",babyOnlineQuestion);
		Relation onlineQuestionDetailBabyOnlineQuestion=new Relation(getId(),"babyOnlineQuestion","ManyToOne",onlineQuestionDetail);

		Relation doctorBabyProduct =new Relation(getId(),"babyProducts","OneToMany",doctor);
		Relation babyProductDoctor =new Relation(getId(),"doctor","ManyToOne",babyProduct);

		Relation doctorAppointmentDeatil =new Relation(getId(),"appointmentDeatils","OneToMany",doctor);
		Relation appointmentDeatilDoctor =new Relation(getId(),"doctor","ManyToOne",appointmentDeatil);

		Relation doctorExpertorConsultDetail =new Relation(getId(),"expertorConsultDetails","OneToMany",doctor);
		Relation expertorConsultDetailDoctor =new Relation(getId(),"doctor","ManyToOne",expertorConsultDetail);

		Relation doctorOnlineQuestionDetail =new Relation(getId(),"onlineQuestionDetails","OneToMany",doctor);
		Relation onlineQuestionDetailDoctor =new Relation(getId(),"doctor","ManyToOne",onlineQuestionDetail);

		Relation doctorOutpatientDetail =new Relation(getId(),"outpatientDetails","OneToMany",doctor);
		Relation outpatientDetailDoctor =new Relation(getId(),"doctor","ManyToOne",outpatientDetail);

		Relation doctorOutpaient =new Relation(getId(),"outpaients","OneToMany",doctor);
		Relation outpaientDoctor =new Relation(getId(),"doctor","ManyToOne",outpaient);

		Relation onlineQuestionDetailOnlineQuestionReply =new Relation(getId(),"onlineQuestionReplys","OneToMany",onlineQuestionDetail);
		Relation onlineQuestionReplyOnlineQuestionDetail =new Relation(getId(),"onlineQuestionDetail","ManyToOne",onlineQuestionReply);

		Relation onlineQuestionDetailIllDescribe =new Relation(getId(),"illDescribes","OneToMany",onlineQuestionDetail);
		Relation illDescribeOnlineQuestionDetail =new Relation(getId(),"onlineQuestionDetail","ManyToOne",illDescribe);

		Relation questionOptions=new Relation(getId(),"optionss","OneToMany",question);
		Relation optionsQuestion=new Relation(getId(),"question","ManyToOne",options);

		// 关系设置
		doctorDoctor_AssistantDoctor.setRelation(doctor_AssistantDoctorDoctor);
		doctor_AssistantDoctorDoctor.setRelation(doctorDoctor_AssistantDoctor);

		assistantDoctorDoctor_AssistantDoctor.setRelation(doctor_AssistantDoctorAssistantDoctor);
		doctor_AssistantDoctorAssistantDoctor.setRelation(assistantDoctorDoctor_AssistantDoctor);


		hospitalDoctor.setRelation(doctorHospital);
		doctorHospital.setRelation(hospitalDoctor);

		hospitalAssistantDoctor.setRelation(assistantDoctorHospital);
		assistantDoctorHospital.setRelation(hospitalAssistantDoctor);

		doctorAssistantDoctor.setRelation(assistantDoctorDoctor);
		assistantDoctorDoctor.setRelation(doctorAssistantDoctor);

		hospitalProduct.setRelation(productHospital);
		productHospital.setRelation(hospitalProduct);
		
		productOrders.setRelation(ordersProduct);
		ordersProduct.setRelation(productOrders);

		productBabyProduct.setRelation(babyProductProduct);
		babyProductProduct.setRelation(productBabyProduct);

		productProductItem.setRelation(productItemProduct);
		productItemProduct.setRelation(productProductItem);

		appointmentProductItem.setRelation(productItemAppointment);
		productItemAppointment.setRelation(appointmentProductItem);

		experConsultProductItem.setRelation(productItemExperConsult);
		productItemExperConsult.setRelation(experConsultProductItem);

		onlineQuestionProductItem.setRelation(productItemOnlineQuestion);
		productItemOnlineQuestion.setRelation(onlineQuestionProductItem);

		babyOrders.setRelation(ordersBaby);
		ordersBaby.setRelation(babyOrders);
		
		babyBabyProduct.setRelation(babyProductBaby);
		babyProductBaby.setRelation(babyBabyProduct);

		babyProductBabyProductItem.setRelation(babyProductItemBabyProduct);
		babyProductItemBabyProduct.setRelation(babyProductBabyProductItem);
		
		babyAppointmentBabyProductItem.setRelation(babyProductItemBabyAppointment);
		babyProductItemBabyAppointment.setRelation(babyAppointmentBabyProductItem);

		babyExpertorConsultBabyProductItem.setRelation(babyProductItemBabyExpertorConsult);
		babyProductItemBabyExpertorConsult.setRelation(babyExpertorConsultBabyProductItem);

		babyOnlineQuestionBabyProductItem.setRelation(babyProductItemBabyOnlineQuestion);
		babyProductItemBabyOnlineQuestion.setRelation(babyOnlineQuestionBabyProductItem);
		
		babyAppointmentAppointmentDeatil.setRelation(appointmentDeatilBabyAppointment);
		appointmentDeatilBabyAppointment.setRelation(babyAppointmentAppointmentDeatil);

		babyExpertorConsultExpertorConsultDetail.setRelation(expertorConsultDetailBabyExpertorConsult);
		expertorConsultDetailBabyExpertorConsult.setRelation(babyExpertorConsultExpertorConsultDetail);

		babyOnlineQuestionOnlineQuestionDetail.setRelation(onlineQuestionDetailBabyOnlineQuestion);
		onlineQuestionDetailBabyOnlineQuestion.setRelation(babyOnlineQuestionOnlineQuestionDetail);

		doctorBabyProduct.setRelation(babyProductDoctor);
		babyProductDoctor.setRelation(doctorBabyProduct);

		doctorAppointmentDeatil.setRelation(appointmentDeatilDoctor);
		appointmentDeatilDoctor.setRelation(doctorAppointmentDeatil);

		doctorExpertorConsultDetail.setRelation(expertorConsultDetailDoctor);
		expertorConsultDetailDoctor.setRelation(doctorExpertorConsultDetail);

		doctorOnlineQuestionDetail.setRelation(onlineQuestionDetailDoctor);
		onlineQuestionDetailDoctor.setRelation(doctorOnlineQuestionDetail);

		doctorOutpatientDetail.setRelation(outpatientDetailDoctor);
		outpatientDetailDoctor.setRelation(doctorOutpatientDetail);

		doctorOutpaient.setRelation(doctorOutpaient);
		outpaientDoctor.setRelation(outpaientDoctor);

		onlineQuestionDetailOnlineQuestionReply.setRelation(onlineQuestionReplyOnlineQuestionDetail);
		onlineQuestionReplyOnlineQuestionDetail.setRelation(onlineQuestionDetailOnlineQuestionReply);

		onlineQuestionDetailIllDescribe.setRelation(illDescribeOnlineQuestionDetail);
		illDescribeOnlineQuestionDetail.setRelation(onlineQuestionDetailIllDescribe);

		questionOptions.setRelation(optionsQuestion);
		optionsQuestion.setRelation(questionOptions);
		
		
		// 添加关系
		hospital.addRelation(hospitalProduct);
		hospital.addRelation(hospitalDoctor);
		hospital.addRelation(hospitalAssistantDoctor);

		product.addRelation(productHospital);
		product.addRelation(productOrders);
		product.addRelation(productBabyProduct);
		product.addRelation(productProductItem);
		
		productItem.addRelation(productItemProduct);
		productItem.addRelation(productItemAppointment);
		productItem.addRelation(productItemExperConsult);
		productItem.addRelation(productItemOnlineQuestion);

		appointment.addRelation(appointmentProductItem);
	
		expertorConsult.addRelation(experConsultProductItem);

		onlineQuestion.addRelation(onlineQuestionProductItem);

		orders.addRelation(ordersBaby);
		orders.addRelation(ordersProduct);

		baby.addRelation(babyOrders);
		baby.addRelation(babyBabyProduct);

		babyProduct.addRelation(babyProductProduct);
		babyProduct.addRelation(babyProductDoctor);
		babyProduct.addRelation(babyProductBaby);
		babyProduct.addRelation(babyProductBabyProductItem);

		babyProductItem.addRelation(babyProductItemBabyAppointment);
		babyProductItem.addRelation(babyProductItemBabyProduct);
		babyProductItem.addRelation(babyProductItemBabyOnlineQuestion);
		babyProductItem.addRelation(babyProductItemBabyExpertorConsult);

		babyAppointment.addRelation(babyAppointmentBabyProductItem);
		babyAppointment.addRelation(babyAppointmentAppointmentDeatil);

		babyExpertorConsult.addRelation(babyExpertorConsultBabyProductItem);
		babyExpertorConsult.addRelation(babyExpertorConsultExpertorConsultDetail);

		babyOnlineQuestion.addRelation(babyOnlineQuestionBabyProductItem);
		babyOnlineQuestion.addRelation(babyOnlineQuestionOnlineQuestionDetail);

		appointmentDeatil.addRelation(appointmentDeatilDoctor);
		appointmentDeatil.addRelation(appointmentDeatilBabyAppointment);

		expertorConsultDetail.addRelation(expertorConsultDetailDoctor);
		expertorConsultDetail.addRelation(expertorConsultDetailBabyExpertorConsult);

		onlineQuestionDetail.addRelation(onlineQuestionDetailDoctor);
		onlineQuestionDetail.addRelation(onlineQuestionDetailBabyOnlineQuestion);
		onlineQuestionDetail.addRelation(onlineQuestionDetailOnlineQuestionReply);
		onlineQuestionDetail.addRelation(onlineQuestionDetailIllDescribe);

		onlineQuestionReply.addRelation(onlineQuestionReplyOnlineQuestionDetail);

		illDescribe.addRelation(illDescribeOnlineQuestionDetail);

		question.addRelation(questionOptions);

		options.addRelation(optionsQuestion);

		outpatientDetail.addRelation(outpatientDetailDoctor);

		outpaient.addRelation(outpaientDoctor);

		doctor.addRelation(doctorBabyProduct);
		doctor.addRelation(doctorAppointmentDeatil);
		doctor.addRelation(doctorExpertorConsultDetail);
		doctor.addRelation(doctorOutpatientDetail);
		doctor.addRelation(doctorOnlineQuestionDetail);
		doctor.addRelation(doctorOutpaient);
		doctor.addRelation(doctorHospital);
		doctor.addRelation(doctorAssistantDoctor);

		assistantDoctor.addRelation(assistantDoctorDoctor);
		assistantDoctor.addRelation(assistantDoctorHospital);

		doctor_AssistantDoctor.addRelation(doctor_AssistantDoctorDoctor);
		doctor_AssistantDoctor.addRelation(doctor_AssistantDoctorAssistantDoctor);

		// 添加模型
		models.add(hospital);
		models.add(product);
		models.add(productItem);
		models.add(appointment);
		models.add(expertorConsult);
		models.add(onlineQuestion);
		models.add(baby);
		models.add(orders);
		models.add(babyProduct);
		models.add(babyProductItem);
		models.add(babyAppointment);
		models.add(appointmentDeatil);
		models.add(babyExpertorConsult);
		models.add(expertorConsultDetail);
		models.add(babyOnlineQuestion);
		models.add(onlineQuestionDetail);
		models.add(onlineQuestionReply);
		models.add(illDescribe);
		models.add(question);
		models.add(options);
		models.add(doctor);
		models.add(outpatientDetail);
		models.add(outpaient);
		models.add(doctor_AssistantDoctor);
		models.add(assistantDoctor);
		
		
	
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
	Project project = new Project("123456", "BBcareServer",
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
	"mysql://localhost:3306/bbcare_cloud_server?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true",
	"root", ""));
return project;
}
}
