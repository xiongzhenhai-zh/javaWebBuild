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
 * @name:随访库	
 * @author:	
 * @createTime: 2016-11-15 16:45:58
 */	
	
@Entity	
@Table(name="t_followLibrary")	
public class FollowLibrary {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//库名称	
	@Column(name="_name")
	private String name;	
	
	//所属人类型	
	@Column(name="_masterType")
	private String masterType;	
	
	//所属人Id	
	@Column(name="_masterId")
	private Integer masterId;	
	
	//创建时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//包含随访库
	@OneToMany(mappedBy="parent")
    private List<FollowLibrary> children;
	
	//所属随访库
	@ManyToOne
    @JoinColumn(name="_parent_id")
    private FollowLibrary parent;
    
    //关联随访库名称
	@Column(name="_parent_name")
    private String parentName;
	
	//包含随访问卷版本
	@OneToMany(mappedBy="followLibrary")
    private List<FollowQuestionnaire> followQuestionnaires;
	
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
	
	public String getMasterType() {	
		return masterType;	
	}	
	
	public void setMasterType(String masterType) {	
		this.masterType = masterType;	
	}
	
	public Integer getMasterId() {	
		return masterId;	
	}	
	
	public void setMasterId(Integer masterId) {	
		this.masterId = masterId;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public List<FollowLibrary> getChildren() {	
		return children;	
	}
	
	public void setChildren(List<FollowLibrary> children) {	
		this.children = children;	
	}
	
	public FollowLibrary getParent() {	
		return parent;	
	}
	
	public void setParent(FollowLibrary parent) {	
		this.parent = parent;	
	}
	
	public String getParentName() {	
		return parentName;	
	}
	
	public void setParentName(String parentName) {	
		this.parentName = parentName;	
	}
	
	public List<FollowQuestionnaire> getFollowQuestionnaires() {	
		return followQuestionnaires;	
	}
	
	public void setFollowQuestionnaires(List<FollowQuestionnaire> followQuestionnaires) {	
		this.followQuestionnaires = followQuestionnaires;	
	}
}