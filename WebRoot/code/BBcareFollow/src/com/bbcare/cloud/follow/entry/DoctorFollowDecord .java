package com.bbcare.cloud.follow.entry;	

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
 * @name:医生归档档案	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_doctorFollowDecord ")	
public class DoctorFollowDecord  {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//归档名称	
	@Column(name="_name")
	private String name;	
	
	//医生Id	
	@Column(name="_doctorId")
	private String doctorId;	
	
	//状态	
	@Column(name="_status")
	private Integer status;	
	
	//宝宝Id	
	@Column(name="_babyId")
	private String babyId;	
	
	//宝宝归档年龄	
	@Column(name="_babyAge")
	private Integer babyAge;	
	
	//归档备注	
	@Column(name="_note")
	private String note;	
	
	//归档时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含医生归档详情
	@OneToMany(mappedBy="doctorFollowDecord")
    private List<DoctorFollowDecordDetail > doctorFollowDecordDetails;
	
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
	
	public String getDoctorId() {	
		return doctorId;	
	}	
	
	public void setDoctorId(String doctorId) {	
		this.doctorId = doctorId;	
	}
	
	public Integer getStatus() {	
		return status;	
	}	
	
	public void setStatus(Integer status) {	
		this.status = status;	
	}
	
	public String getBabyId() {	
		return babyId;	
	}	
	
	public void setBabyId(String babyId) {	
		this.babyId = babyId;	
	}
	
	public Integer getBabyAge() {	
		return babyAge;	
	}	
	
	public void setBabyAge(Integer babyAge) {	
		this.babyAge = babyAge;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public List<DoctorFollowDecordDetail > getDoctorFollowDecordDetails() {	
		return doctorFollowDecordDetails;	
	}
	
	public void setDoctorFollowDecordDetails(List<DoctorFollowDecordDetail > doctorFollowDecordDetails) {	
		this.doctorFollowDecordDetails = doctorFollowDecordDetails;	
	}
}