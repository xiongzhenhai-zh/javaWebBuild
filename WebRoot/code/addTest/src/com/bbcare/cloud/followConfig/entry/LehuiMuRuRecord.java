package com.bbcare.cloud.followConfig.entry;	

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:乐慧母乳调查临时	
 * @author:	
 * @createTime: 2016-12-15 18:28:16
 */	
	
@Entity	
@Table(name="t_lehuiMuRuRecord")	
public class LehuiMuRuRecord {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//问题Id	
	@Column(name="_questionId")
	private String questionId;	
	
	//问卷Id	
	@Column(name="_followTemplateId")
	private String followTemplateId;	
	
	//创建日期	
	@Column(name="_createTime")
	private Date createTime;	
	
	//题目	
	@Column(name="_note")
	private String note;	
	
	//openId	
	@Column(name="_openId")
	private String openId;	
	
	//答案	
	@Column(name="_answer")
	private String answer;	
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getQuestionId() {	
		return questionId;	
	}	
	
	public void setQuestionId(String questionId) {	
		this.questionId = questionId;	
	}
	
	public String getFollowTemplateId() {	
		return followTemplateId;	
	}	
	
	public void setFollowTemplateId(String followTemplateId) {	
		this.followTemplateId = followTemplateId;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public String getOpenId() {	
		return openId;	
	}	
	
	public void setOpenId(String openId) {	
		this.openId = openId;	
	}
	
	public String getAnswer() {	
		return answer;	
	}	
	
	public void setAnswer(String answer) {	
		this.answer = answer;	
	}
}