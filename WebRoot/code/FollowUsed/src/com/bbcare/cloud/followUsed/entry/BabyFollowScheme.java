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
 * @name:宝宝随访方案	
 * @author:	
 * @createTime: 2016-11-18 11:53:05
 */	
	
@Entity	
@Table(name="t_babyFollowScheme")	
public class BabyFollowScheme {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//方案名称	
	@Column(name="_name")
	private String name;	
	
	//宝宝Id	
	@Column(name="_userId")
	private String userId;	
	
	//方案Id	
	@Column(name="_followSchemeId")
	private String followSchemeId;	
	
	//方案版本	
	@Column(name="_followSchemeVersion")
	private String followSchemeVersion;	
	
	//方案版本Id	
	@Column(name="_followSchemeVersionId")
	private String followSchemeVersionId;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含宝宝随访任务
	@OneToMany(mappedBy="babyFollowScheme")
    private List<BabyFollowSchemeTask> babyFollowSchemeTasks;
	
	//包含会员随访记录
	@OneToMany(mappedBy="babyFollowScheme")
    private List<DoctorFollowSchemeRecord> doctorFollowSchemeRecords;
	
	//所属随访用户
	@ManyToOne
    @JoinColumn(name="_followUser_id")
    private FollowUser followUser;
    
    //关联随访用户名称
	@Column(name="_followUser_name")
    private String followUserName;
	
	//包含会员随访记录
	@OneToMany(mappedBy="babyFollowScheme")
    private List<BabyFollowSchemeRecord> babyFollowSchemeRecords;
	
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
	
	public String getUserId() {	
		return userId;	
	}	
	
	public void setUserId(String userId) {	
		this.userId = userId;	
	}
	
	public String getFollowSchemeId() {	
		return followSchemeId;	
	}	
	
	public void setFollowSchemeId(String followSchemeId) {	
		this.followSchemeId = followSchemeId;	
	}
	
	public String getFollowSchemeVersion() {	
		return followSchemeVersion;	
	}	
	
	public void setFollowSchemeVersion(String followSchemeVersion) {	
		this.followSchemeVersion = followSchemeVersion;	
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
	
	public List<BabyFollowSchemeTask> getBabyFollowSchemeTasks() {	
		return babyFollowSchemeTasks;	
	}
	
	public void setBabyFollowSchemeTasks(List<BabyFollowSchemeTask> babyFollowSchemeTasks) {	
		this.babyFollowSchemeTasks = babyFollowSchemeTasks;	
	}
	
	public List<DoctorFollowSchemeRecord> getDoctorFollowSchemeRecords() {	
		return doctorFollowSchemeRecords;	
	}
	
	public void setDoctorFollowSchemeRecords(List<DoctorFollowSchemeRecord> doctorFollowSchemeRecords) {	
		this.doctorFollowSchemeRecords = doctorFollowSchemeRecords;	
	}
	
	public FollowUser getFollowUser() {	
		return followUser;	
	}
	
	public void setFollowUser(FollowUser followUser) {	
		this.followUser = followUser;	
	}
	
	public String getFollowUserName() {	
		return followUserName;	
	}
	
	public void setFollowUserName(String followUserName) {	
		this.followUserName = followUserName;	
	}
	
	public List<BabyFollowSchemeRecord> getBabyFollowSchemeRecords() {	
		return babyFollowSchemeRecords;	
	}
	
	public void setBabyFollowSchemeRecords(List<BabyFollowSchemeRecord> babyFollowSchemeRecords) {	
		this.babyFollowSchemeRecords = babyFollowSchemeRecords;	
	}
}