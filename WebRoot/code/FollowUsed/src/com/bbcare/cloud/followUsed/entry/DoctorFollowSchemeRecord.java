package com.bbcare.cloud.followUsed.entry;	

import java.util.List;
import java.util.Date;
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
 * @name:会员随访记录	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_doctorFollowSchemeRecord")	
public class DoctorFollowSchemeRecord {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//计划名称	
	@Column(name="_name")
	private String name;	
	
	//记录类型	
	@Column(name="_type")
	private String type;	
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//宝宝记录Id	
	@Column(name="_babyFollowSchemeRecordId")
	private String babyFollowSchemeRecordId;	
	
	//完成时间	
	@Column(name="_completeTime")
	private Date completeTime;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属宝宝随访方案
	@ManyToOne
    @JoinColumn(name="_babyFollowScheme_id")
    private BabyFollowScheme babyFollowScheme;
    
    //关联宝宝随访方案名称
	@Column(name="_babyFollowScheme_name")
    private String babyFollowSchemeName;
	
	//包含会员随访记录内容
	@OneToMany(mappedBy="doctorFollowSchemeRecord")
    private List<DoctorFollowSchemeRecordDetail> doctorFollowSchemeRecordDetails;
	
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
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getBabyFollowSchemeRecordId() {	
		return babyFollowSchemeRecordId;	
	}	
	
	public void setBabyFollowSchemeRecordId(String babyFollowSchemeRecordId) {	
		this.babyFollowSchemeRecordId = babyFollowSchemeRecordId;	
	}
	
	public Date getCompleteTime() {	
		return completeTime;	
	}	
	
	public void setCompleteTime(Date completeTime) {	
		this.completeTime = completeTime;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public BabyFollowScheme getBabyFollowScheme() {	
		return babyFollowScheme;	
	}
	
	public void setBabyFollowScheme(BabyFollowScheme babyFollowScheme) {	
		this.babyFollowScheme = babyFollowScheme;	
	}
	
	public String getBabyFollowSchemeName() {	
		return babyFollowSchemeName;	
	}
	
	public void setBabyFollowSchemeName(String babyFollowSchemeName) {	
		this.babyFollowSchemeName = babyFollowSchemeName;	
	}
	
	public List<DoctorFollowSchemeRecordDetail> getDoctorFollowSchemeRecordDetails() {	
		return doctorFollowSchemeRecordDetails;	
	}
	
	public void setDoctorFollowSchemeRecordDetails(List<DoctorFollowSchemeRecordDetail> doctorFollowSchemeRecordDetails) {	
		this.doctorFollowSchemeRecordDetails = doctorFollowSchemeRecordDetails;	
	}
}