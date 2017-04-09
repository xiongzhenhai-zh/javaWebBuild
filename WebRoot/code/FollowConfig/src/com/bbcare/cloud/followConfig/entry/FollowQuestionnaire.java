package com.bbcare.cloud.followConfig.entry;	

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
 * @name:随访问卷版本	
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
@Entity	
@Table(name="t_followQuestionnaire")	
public class FollowQuestionnaire {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//问卷类型	
	@Column(name="_type")
	private String type;	
	
	//状态	
	@Column(name="_status")
	private Integer status;	
	
	//问卷名	
	@Column(name="_name")
	private String name;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//所属随访库
	@ManyToOne
    @JoinColumn(name="_followLibrary_id")
    private FollowLibrary followLibrary;
    
    //关联随访库名称
	@Column(name="_followLibrary_name")
    private String followLibraryName;
	
	//包含随访问卷版本
	@OneToMany(mappedBy="followQuestionnaire")
    private List<FollowQuestionnaireVersion> followQuestionnaireVersions;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public Integer getStatus() {	
		return status;	
	}	
	
	public void setStatus(Integer status) {	
		this.status = status;	
	}
	
	public String getName() {	
		return name;	
	}	
	
	public void setName(String name) {	
		this.name = name;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public FollowLibrary getFollowLibrary() {	
		return followLibrary;	
	}
	
	public void setFollowLibrary(FollowLibrary followLibrary) {	
		this.followLibrary = followLibrary;	
	}
	
	public String getFollowLibraryName() {	
		return followLibraryName;	
	}
	
	public void setFollowLibraryName(String followLibraryName) {	
		this.followLibraryName = followLibraryName;	
	}
	
	public List<FollowQuestionnaireVersion> getFollowQuestionnaireVersions() {	
		return followQuestionnaireVersions;	
	}
	
	public void setFollowQuestionnaireVersions(List<FollowQuestionnaireVersion> followQuestionnaireVersions) {	
		this.followQuestionnaireVersions = followQuestionnaireVersions;	
	}
}