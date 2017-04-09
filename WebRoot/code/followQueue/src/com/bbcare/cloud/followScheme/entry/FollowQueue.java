package com.bbcare.cloud.followScheme.entry;	

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访队列	
 * @author:	
 * @createTime: 2016-11-15 10:46:05
 */	
	
@Entity	
@Table(name="t_followQueue")	
public class FollowQueue {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//队列名称	
	@Column(name="_name")
	private String name;	
	
	//所属人类型	
	@Column(name="_masterType")
	private String masterType;	
	
	//所属人名称	
	@Column(name="_masterName")
	private String masterName;	
	
	//所属人Id	
	@Column(name="_masterId")
	private Integer masterId;	
	
	//简介	
	@Column(name="_introduction")
	private String introduction;	
	
	//备注	
	@Column(name="_note")
	private String note;	
	
	//队列状态	
	@Column(name="_status")
	private String status;	
	
	//目标人数	
	@Column(name="_targerNumber")
	private Integer targerNumber;	
	
	//已用人数	
	@Column(name="_usedNumber")
	private Integer usedNumber;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
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
	
	public String getMasterType() {	
		return masterType;	
	}	
	
	public void setMasterType(String masterType) {	
		this.masterType = masterType;	
	}
	
	public String getMasterName() {	
		return masterName;	
	}	
	
	public void setMasterName(String masterName) {	
		this.masterName = masterName;	
	}
	
	public Integer getMasterId() {	
		return masterId;	
	}	
	
	public void setMasterId(Integer masterId) {	
		this.masterId = masterId;	
	}
	
	public String getIntroduction() {	
		return introduction;	
	}	
	
	public void setIntroduction(String introduction) {	
		this.introduction = introduction;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public Integer getTargerNumber() {	
		return targerNumber;	
	}	
	
	public void setTargerNumber(Integer targerNumber) {	
		this.targerNumber = targerNumber;	
	}
	
	public Integer getUsedNumber() {	
		return usedNumber;	
	}	
	
	public void setUsedNumber(Integer usedNumber) {	
		this.usedNumber = usedNumber;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
}