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
@Table(name="t_babyFollowSchemeRecord")	
public class BabyFollowSchemeRecord {	
	
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
	
	//医生记录Id	
	@Column(name="_doctorFollowSchemeRecordId")
	private String doctorFollowSchemeRecordId;	
	
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
	@OneToMany(mappedBy="babyFollowSchemeRecord")
    private List<BabyFollowSchemeRecordDetail> babyFollowSchemeRecordDetails;
	
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
	
	public String getDoctorFollowSchemeRecordId() {	
		return doctorFollowSchemeRecordId;	
	}	
	
	public void setDoctorFollowSchemeRecordId(String doctorFollowSchemeRecordId) {	
		this.doctorFollowSchemeRecordId = doctorFollowSchemeRecordId;	
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
	
	public List<BabyFollowSchemeRecordDetail> getBabyFollowSchemeRecordDetails() {	
		return babyFollowSchemeRecordDetails;	
	}
	
	public void setBabyFollowSchemeRecordDetails(List<BabyFollowSchemeRecordDetail> babyFollowSchemeRecordDetails) {	
		this.babyFollowSchemeRecordDetails = babyFollowSchemeRecordDetails;	
	}
}