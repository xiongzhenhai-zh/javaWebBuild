package com.bbcare.cloud.follow.entry;	

import java.util.List;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访模型	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followModel ")	
public class FollowModel  {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//名称	
	@Column(name="_name")
	private String name;	
	
	//医生Id	
	@Column(name="_doctorId")
	private String doctorId;	
	
	//状态	
	@Column(name="_status")
	private Integer status;	
	
	//简介	
	@Column(name="_introduction")
	private String introduction;	
	
	//目标	
	@Column(name="_targer")
	private String targer;	
	
	//说明	
	@Column(name="_note")
	private String note;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含随访计划
	@OneToMany(mappedBy="followModel")
    private List<FollowPlan> followPlans;
	
	//包含随访模版
	@OneToMany(mappedBy="followModel")
    private List<FollowTemplate> followTemplates;
	
	//所属模型分类
	@ManyToOne
    @JoinColumn(name="_modelClass_id")
    private ModelClass modelClass;
    
    //关联模型分类名称
	@Column(name="_modelClass_name")
    private String modelClassName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getName() {	
		return name;	
	}	
	
	public void setName(String name) {	
		this.name = name;	
	}
	
	public String getDoctorId() {	
		return doctorId;	
	}	
	
	public void setDoctorId(String doctorId) {	
		this.doctorId = doctorId;	
	}
	
	public Integer getStatus() {	
		return status;	
	}	
	
	public void setStatus(Integer status) {	
		this.status = status;	
	}
	
	public String getIntroduction() {	
		return introduction;	
	}	
	
	public void setIntroduction(String introduction) {	
		this.introduction = introduction;	
	}
	
	public String getTarger() {	
		return targer;	
	}	
	
	public void setTarger(String targer) {	
		this.targer = targer;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public List<FollowPlan> getFollowPlans() {	
		return followPlans;	
	}
	
	public void setFollowPlans(List<FollowPlan> followPlans) {	
		this.followPlans = followPlans;	
	}
	
	public List<FollowTemplate> getFollowTemplates() {	
		return followTemplates;	
	}
	
	public void setFollowTemplates(List<FollowTemplate> followTemplates) {	
		this.followTemplates = followTemplates;	
	}
	
	public ModelClass getModelClass() {	
		return modelClass;	
	}
	
	public void setModelClass(ModelClass modelClass) {	
		this.modelClass = modelClass;	
	}
	
	public String getModelClassName() {	
		return modelClassName;	
	}
	
	public void setModelClassName(String modelClassName) {	
		this.modelClassName = modelClassName;	
	}
}