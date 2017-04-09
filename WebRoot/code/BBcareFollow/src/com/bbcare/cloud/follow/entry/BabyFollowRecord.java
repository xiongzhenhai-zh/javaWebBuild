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
 * @name:随访记录	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_babyFollowRecord")	
public class BabyFollowRecord {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//随访模版	
	@Column(name="_followTemplateId")
	private String followTemplateId;	
	
	//随访时间	
	@Column(name="_followTime")
	private Date followTime;	
	
	//随访对象	
	@Column(name="_babyId")
	private String babyId;	
	
	//包含随访情况
	@OneToMany(mappedBy="babyFollowRecord")
    private List<BabyFollowDetail> babyFollowDetails;
	
	//所属随访计划
	@ManyToOne
    @JoinColumn(name="_followPlan_id")
    private FollowPlan followPlan;
    
    //关联随访计划名称
	@Column(name="_followPlan_name")
    private String followPlanName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getFollowTemplateId() {	
		return followTemplateId;	
	}	
	
	public void setFollowTemplateId(String followTemplateId) {	
		this.followTemplateId = followTemplateId;	
	}
	
	public Date getFollowTime() {	
		return followTime;	
	}	
	
	public void setFollowTime(Date followTime) {	
		this.followTime = followTime;	
	}
	
	public String getBabyId() {	
		return babyId;	
	}	
	
	public void setBabyId(String babyId) {	
		this.babyId = babyId;	
	}
	
	public List<BabyFollowDetail> getBabyFollowDetails() {	
		return babyFollowDetails;	
	}
	
	public void setBabyFollowDetails(List<BabyFollowDetail> babyFollowDetails) {	
		this.babyFollowDetails = babyFollowDetails;	
	}
	
	public FollowPlan getFollowPlan() {	
		return followPlan;	
	}
	
	public void setFollowPlan(FollowPlan followPlan) {	
		this.followPlan = followPlan;	
	}
	
	public String getFollowPlanName() {	
		return followPlanName;	
	}
	
	public void setFollowPlanName(String followPlanName) {	
		this.followPlanName = followPlanName;	
	}
}