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
 * @name:会员随访记录内容	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_doctorFollowSchemeRecordDetail")	
public class DoctorFollowSchemeRecordDetail {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//名称	
	@Column(name="_name")
	private String name;	
	
	//会员详情id	
	@Column(name="_babyFollowSchemeRecordDetailId")
	private String babyFollowSchemeRecordDetailId;	
	
	//问题id	
	@Column(name="_questionId")
	private String questionId;	
	
	//内容类型	
	@Column(name="_type")
	private String type;	
	
	//答案	
	@Column(name="_answer")
	private String answer;	
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//方案版本Id	
	@Column(name="_followSchemeVersionId")
	private String followSchemeVersionId;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属会员随访记录
	@ManyToOne
    @JoinColumn(name="_doctorFollowSchemeRecord_id")
    private DoctorFollowSchemeRecord doctorFollowSchemeRecord;
    
    //关联会员随访记录名称
	@Column(name="_doctorFollowSchemeRecord_name")
    private String doctorFollowSchemeRecordName;
	
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
	
	public String getBabyFollowSchemeRecordDetailId() {	
		return babyFollowSchemeRecordDetailId;	
	}	
	
	public void setBabyFollowSchemeRecordDetailId(String babyFollowSchemeRecordDetailId) {	
		this.babyFollowSchemeRecordDetailId = babyFollowSchemeRecordDetailId;	
	}
	
	public String getQuestionId() {	
		return questionId;	
	}	
	
	public void setQuestionId(String questionId) {	
		this.questionId = questionId;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public String getAnswer() {	
		return answer;	
	}	
	
	public void setAnswer(String answer) {	
		this.answer = answer;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getFollowSchemeVersionId() {	
		return followSchemeVersionId;	
	}	
	
	public void setFollowSchemeVersionId(String followSchemeVersionId) {	
		this.followSchemeVersionId = followSchemeVersionId;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public DoctorFollowSchemeRecord getDoctorFollowSchemeRecord() {	
		return doctorFollowSchemeRecord;	
	}
	
	public void setDoctorFollowSchemeRecord(DoctorFollowSchemeRecord doctorFollowSchemeRecord) {	
		this.doctorFollowSchemeRecord = doctorFollowSchemeRecord;	
	}
	
	public String getDoctorFollowSchemeRecordName() {	
		return doctorFollowSchemeRecordName;	
	}
	
	public void setDoctorFollowSchemeRecordName(String doctorFollowSchemeRecordName) {	
		this.doctorFollowSchemeRecordName = doctorFollowSchemeRecordName;	
	}
}