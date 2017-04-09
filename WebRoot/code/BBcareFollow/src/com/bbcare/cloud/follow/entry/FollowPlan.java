package com.bbcare.cloud.follow.entry;	

import java.util.List;
import java.util.Date;
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
 * @name:随访计划	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followPlan")	
public class FollowPlan {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//随访宝宝	
	@Column(name="_babyId")
	private Date babyId;	
	
	//开始时间	
	@Column(name="_startTime")
	private Date startTime;	
	
	//创建医生	
	@Column(name="_createDoctorId")
	private String createDoctorId;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含随访记录
	@OneToMany(mappedBy="followPlan")
    private List<BabyFollowRecord> babyFollowRecords;
	
	//所属随访模型
	@ManyToOne
    @JoinColumn(name="_followModel_id")
    private FollowModel  followModel;
    
    //关联随访模型名称
	@Column(name="_followModel_name")
    private String followModelName;
	
	//包含随访计划
	@OneToMany(mappedBy="followPlan")
    private List<FollowPlan> followTasks;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public Date getBabyId() {	
		return babyId;	
	}	
	
	public void setBabyId(Date babyId) {	
		this.babyId = babyId;	
	}
	
	public Date getStartTime() {	
		return startTime;	
	}	
	
	public void setStartTime(Date startTime) {	
		this.startTime = startTime;	
	}
	
	public String getCreateDoctorId() {	
		return createDoctorId;	
	}	
	
	public void setCreateDoctorId(String createDoctorId) {	
		this.createDoctorId = createDoctorId;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public List<BabyFollowRecord> getBabyFollowRecords() {	
		return babyFollowRecords;	
	}
	
	public void setBabyFollowRecords(List<BabyFollowRecord> babyFollowRecords) {	
		this.babyFollowRecords = babyFollowRecords;	
	}
	
	public FollowModel  getFollowModel() {	
		return followModel;	
	}
	
	public void setFollowModel(FollowModel  followModel) {	
		this.followModel = followModel;	
	}
	
	public String getFollowModelName() {	
		return followModelName;	
	}
	
	public void setFollowModelName(String followModelName) {	
		this.followModelName = followModelName;	
	}
	
	public List<FollowPlan> getFollowTasks() {	
		return followTasks;	
	}
	
	public void setFollowTasks(List<FollowPlan> followTasks) {	
		this.followTasks = followTasks;	
	}
}