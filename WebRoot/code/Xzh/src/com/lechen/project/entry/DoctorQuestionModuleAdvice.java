package com.lechen.project.entry;	

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:医生模块建议	
 * @author:	
 * @createTime: 2016-01-20 13:13:59
 */	
	
@Entity	
@Table(name="t_doctorQuestionModuleAdvice")	
public class DoctorQuestionModuleAdvice {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//警戒值	
	@Column(name="_cordon")
	private Integer cordon;	
	
	//平均分	
	@Column(name="_average")
	private Integer average;	
	
	//获得分数	
	@Column(name="_score")
	private Integer score;	
	
	//记录Id	
	@Column(name="_qoctorQuestionRecordId")
	private String qoctorQuestionRecordId;	
	
	//标题	
	@Column(name="_title")
	private String title;	
	
	//标题	
	@Column(name="_title")
	private String title;	
	
	//指导	
	@Column(name="_note")
	private String note;	
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public Integer getCordon() {	
		return cordon;	
	}	
	
	public void setCordon(Integer cordon) {	
		this.cordon = cordon;	
	}
	
	public Integer getAverage() {	
		return average;	
	}	
	
	public void setAverage(Integer average) {	
		this.average = average;	
	}
	
	public Integer getScore() {	
		return score;	
	}	
	
	public void setScore(Integer score) {	
		this.score = score;	
	}
	
	public String getQoctorQuestionRecordId() {	
		return qoctorQuestionRecordId;	
	}	
	
	public void setQoctorQuestionRecordId(String qoctorQuestionRecordId) {	
		this.qoctorQuestionRecordId = qoctorQuestionRecordId;	
	}
	
	public String getTitle() {	
		return title;	
	}	
	
	public void setTitle(String title) {	
		this.title = title;	
	}
	
	public String getTitle() {	
		return title;	
	}	
	
	public void setTitle(String title) {	
		this.title = title;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
}