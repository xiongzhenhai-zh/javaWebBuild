package com.bbcare.cloud.followConfig.entry;	

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
 * @name:随访问卷版本	
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
@Entity	
@Table(name="t_followQuestionnaireVersion")	
public class FollowQuestionnaireVersion {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//备注	
	@Column(name="_note")
	private String note;	
	
	//状态	
	@Column(name="_status")
	private Integer status;	
	
	//版本数据	
	@Column(name="_json")
	private String json;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属随访问卷版本
	@ManyToOne
    @JoinColumn(name="_followQuestionnaire_id")
    private FollowQuestionnaire followQuestionnaire;
    
    //关联随访问卷版本名称
	@Column(name="_followQuestionnaire_name")
    private String followQuestionnaireName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public Integer getStatus() {	
		return status;	
	}	
	
	public void setStatus(Integer status) {	
		this.status = status;	
	}
	
	public String getJson() {	
		return json;	
	}	
	
	public void setJson(String json) {	
		this.json = json;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public FollowQuestionnaire getFollowQuestionnaire() {	
		return followQuestionnaire;	
	}
	
	public void setFollowQuestionnaire(FollowQuestionnaire followQuestionnaire) {	
		this.followQuestionnaire = followQuestionnaire;	
	}
	
	public String getFollowQuestionnaireName() {	
		return followQuestionnaireName;	
	}
	
	public void setFollowQuestionnaireName(String followQuestionnaireName) {	
		this.followQuestionnaireName = followQuestionnaireName;	
	}
}