package com.bbcare.cloud.follow.entry;	

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访任务	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followTask")	
public class FollowTask {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//任务时间	
	@Column(name="_taskTime")
	private Date taskTime;	
	
	//任务状态	
	@Column(name="_status")
	private String status;	
	
	//执行模版	
	@Column(name="_modelId")
	private String modelId;	
	
	//所属随访计划
	@ManyToOne
    @JoinColumn(name="_followPlan_id")
    private FollowPlan followPlan;
    
    //关联随访计划名称
	@Column(name="_followPlan_name")
    private String followPlanName;
	
	//所属随访任务类型
	@ManyToOne
    @JoinColumn(name="_followTaskType_id")
    private FollowTaskType followTaskType;
    
    //关联随访任务类型名称
	@Column(name="_followTaskType_name")
    private String followTaskTypeName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public Date getTaskTime() {	
		return taskTime;	
	}	
	
	public void setTaskTime(Date taskTime) {	
		this.taskTime = taskTime;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getModelId() {	
		return modelId;	
	}	
	
	public void setModelId(String modelId) {	
		this.modelId = modelId;	
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
	
	public FollowTaskType getFollowTaskType() {	
		return followTaskType;	
	}
	
	public void setFollowTaskType(FollowTaskType followTaskType) {	
		this.followTaskType = followTaskType;	
	}
	
	public String getFollowTaskTypeName() {	
		return followTaskTypeName;	
	}
	
	public void setFollowTaskTypeName(String followTaskTypeName) {	
		this.followTaskTypeName = followTaskTypeName;	
	}
}