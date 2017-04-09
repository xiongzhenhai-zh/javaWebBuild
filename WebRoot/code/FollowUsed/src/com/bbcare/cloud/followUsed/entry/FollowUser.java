package com.bbcare.cloud.followUsed.entry;	

import java.util.List;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访用户	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_followUser")	
public class FollowUser {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//注册号码	
	@Column(name="_accountName")
	private String accountName;	
	
	//宝宝Id	
	@Column(name="_babyId")
	private String babyId;	
	
	//宝宝名称	
	@Column(name="_babyName")
	private String babyName;	
	
	//性别	
	@Column(name="_gender")
	private String gender;	
	
	//出生日期	
	@Column(name="_birthday")
	private String birthday;	
	
	//孕周	
	@Column(name="_pregnancyWeek")
	private String pregnancyWeek;	
	
	//住院号	
	@Column(name="_inpatientNum")
	private String inpatientNum;	
	
	//身份证号	
	@Column(name="_idCard")
	private String idCard;	
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//用户类型	
	@Column(name="_type")
	private String type;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含宝宝随访方案
	@OneToMany(mappedBy="followUser")
    private List<BabyFollowScheme> babyFollowSchemes;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getAccountName() {	
		return accountName;	
	}	
	
	public void setAccountName(String accountName) {	
		this.accountName = accountName;	
	}
	
	public String getBabyId() {	
		return babyId;	
	}	
	
	public void setBabyId(String babyId) {	
		this.babyId = babyId;	
	}
	
	public String getBabyName() {	
		return babyName;	
	}	
	
	public void setBabyName(String babyName) {	
		this.babyName = babyName;	
	}
	
	public String getGender() {	
		return gender;	
	}	
	
	public void setGender(String gender) {	
		this.gender = gender;	
	}
	
	public String getBirthday() {	
		return birthday;	
	}	
	
	public void setBirthday(String birthday) {	
		this.birthday = birthday;	
	}
	
	public String getPregnancyWeek() {	
		return pregnancyWeek;	
	}	
	
	public void setPregnancyWeek(String pregnancyWeek) {	
		this.pregnancyWeek = pregnancyWeek;	
	}
	
	public String getInpatientNum() {	
		return inpatientNum;	
	}	
	
	public void setInpatientNum(String inpatientNum) {	
		this.inpatientNum = inpatientNum;	
	}
	
	public String getIdCard() {	
		return idCard;	
	}	
	
	public void setIdCard(String idCard) {	
		this.idCard = idCard;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public List<BabyFollowScheme> getBabyFollowSchemes() {	
		return babyFollowSchemes;	
	}
	
	public void setBabyFollowSchemes(List<BabyFollowScheme> babyFollowSchemes) {	
		this.babyFollowSchemes = babyFollowSchemes;	
	}
}