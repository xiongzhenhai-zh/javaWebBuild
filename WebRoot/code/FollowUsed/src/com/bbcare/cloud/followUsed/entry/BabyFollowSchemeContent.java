package com.bbcare.cloud.followUsed.entry;	

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:宝宝随访任务内容	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_babyFollowSchemeContent")	
public class BabyFollowSchemeContent {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//任务名称	
	@Column(name="_name")
	private String name;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//来源Id	
	@Column(name="_sourceId")
	private String sourceId;	
	
	//来源类型	
	@Column(name="_sourceType")
	private String sourceType;	
	
	//使用者类型	
	@Column(name="_userType")
	private String userType;	
	
	//类型	
	@Column(name="_type")
	private String type;	
	
	//数据	
	@Column(name="_data")
	private String data;	
	
	//建档信息	
	@Column(name="_firstRecord")
	private String firstRecord;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属宝宝随访任务
	@ManyToOne
    @JoinColumn(name="_babyFollowSchemeTask_id")
    private BabyFollowSchemeTask babyFollowSchemeTask;
    
    //关联宝宝随访任务名称
	@Column(name="_babyFollowSchemeTask_name")
    private String babyFollowSchemeTaskName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getName() {	
		return name;	
	}	
	
	public void setName(String name) {	
		this.name = name;	
	}
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public String getSourceId() {	
		return sourceId;	
	}	
	
	public void setSourceId(String sourceId) {	
		this.sourceId = sourceId;	
	}
	
	public String getSourceType() {	
		return sourceType;	
	}	
	
	public void setSourceType(String sourceType) {	
		this.sourceType = sourceType;	
	}
	
	public String getUserType() {	
		return userType;	
	}	
	
	public void setUserType(String userType) {	
		this.userType = userType;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public String getData() {	
		return data;	
	}	
	
	public void setData(String data) {	
		this.data = data;	
	}
	
	public String getFirstRecord() {	
		return firstRecord;	
	}	
	
	public void setFirstRecord(String firstRecord) {	
		this.firstRecord = firstRecord;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public BabyFollowSchemeTask getBabyFollowSchemeTask() {	
		return babyFollowSchemeTask;	
	}
	
	public void setBabyFollowSchemeTask(BabyFollowSchemeTask babyFollowSchemeTask) {	
		this.babyFollowSchemeTask = babyFollowSchemeTask;	
	}
	
	public String getBabyFollowSchemeTaskName() {	
		return babyFollowSchemeTaskName;	
	}
	
	public void setBabyFollowSchemeTaskName(String babyFollowSchemeTaskName) {	
		this.babyFollowSchemeTaskName = babyFollowSchemeTaskName;	
	}
}