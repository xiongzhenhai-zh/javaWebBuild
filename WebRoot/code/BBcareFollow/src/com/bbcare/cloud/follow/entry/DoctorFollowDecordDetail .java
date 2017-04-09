package com.bbcare.cloud.follow.entry;	

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
 * @name:医生归档详情	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_doctorFollowDecordDetail ")	
public class DoctorFollowDecordDetail  {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//归档名称	
	@Column(name="_name")
	private String name;	
	
	//问题	
	@Column(name="_question")
	private String question;	
	
	//答案	
	@Column(name="_answer")
	private Integer answer;	
	
	//归档时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属医生归档档案
	@ManyToOne
    @JoinColumn(name="_doctorFollowDecord_id")
    private DoctorFollowDecord  doctorFollowDecord;
    
    //关联医生归档档案名称
	@Column(name="_doctorFollowDecord_name")
    private String doctorFollowDecordName;
	
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
	
	public String getQuestion() {	
		return question;	
	}	
	
	public void setQuestion(String question) {	
		this.question = question;	
	}
	
	public Integer getAnswer() {	
		return answer;	
	}	
	
	public void setAnswer(Integer answer) {	
		this.answer = answer;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public DoctorFollowDecord  getDoctorFollowDecord() {	
		return doctorFollowDecord;	
	}
	
	public void setDoctorFollowDecord(DoctorFollowDecord  doctorFollowDecord) {	
		this.doctorFollowDecord = doctorFollowDecord;	
	}
	
	public String getDoctorFollowDecordName() {	
		return doctorFollowDecordName;	
	}
	
	public void setDoctorFollowDecordName(String doctorFollowDecordName) {	
		this.doctorFollowDecordName = doctorFollowDecordName;	
	}
}