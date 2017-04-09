package com.bbcare.cloud.followUsed.entry;	

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
 * @name:宝宝随访任务	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_babyFollowSchemeTask")	
public class BabyFollowSchemeTask {	
	
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
	
	//开始执行时间	
	@Column(name="_executeStartTime")
	private String executeStartTime;	
	
	//结束执行时间	
	@Column(name="_executeEndTime")
	private String executeEndTime;	
	
	//发送短信	
	@Column(name="_sendSms")
	private String sendSms;	
	
	//发送应用内消息	
	@Column(name="_sendMsg")
	private String sendMsg;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//执行窗口期	
	@Column(name="_executePhase")
	private Integer executePhase;	
	
	//执行类型	
	@Column(name="_executeType")
	private String executeType;	
	
	//建档信息	
	@Column(name="_firstRecord")
	private String firstRecord;	
	
	//任务总数	
	@Column(name="_total")
	private Integer total;	
	
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
	
	//包含宝宝随访任务内容
	@OneToMany(mappedBy="babyFollowSchemeTask")
    private List<BabyFollowSchemeContent> babyFollowSchemeContents;
	
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
	
	public String getExecuteStartTime() {	
		return executeStartTime;	
	}	
	
	public void setExecuteStartTime(String executeStartTime) {	
		this.executeStartTime = executeStartTime;	
	}
	
	public String getExecuteEndTime() {	
		return executeEndTime;	
	}	
	
	public void setExecuteEndTime(String executeEndTime) {	
		this.executeEndTime = executeEndTime;	
	}
	
	public String getSendSms() {	
		return sendSms;	
	}	
	
	public void setSendSms(String sendSms) {	
		this.sendSms = sendSms;	
	}
	
	public String getSendMsg() {	
		return sendMsg;	
	}	
	
	public void setSendMsg(String sendMsg) {	
		this.sendMsg = sendMsg;	
	}
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public Integer getExecutePhase() {	
		return executePhase;	
	}	
	
	public void setExecutePhase(Integer executePhase) {	
		this.executePhase = executePhase;	
	}
	
	public String getExecuteType() {	
		return executeType;	
	}	
	
	public void setExecuteType(String executeType) {	
		this.executeType = executeType;	
	}
	
	public String getFirstRecord() {	
		return firstRecord;	
	}	
	
	public void setFirstRecord(String firstRecord) {	
		this.firstRecord = firstRecord;	
	}
	
	public Integer getTotal() {	
		return total;	
	}	
	
	public void setTotal(Integer total) {	
		this.total = total;	
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
	
	public List<BabyFollowSchemeContent> getBabyFollowSchemeContents() {	
		return babyFollowSchemeContents;	
	}
	
	public void setBabyFollowSchemeContents(List<BabyFollowSchemeContent> babyFollowSchemeContents) {	
		this.babyFollowSchemeContents = babyFollowSchemeContents;	
	}
}