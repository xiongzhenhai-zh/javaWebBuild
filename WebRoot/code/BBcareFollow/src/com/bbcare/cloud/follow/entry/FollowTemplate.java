package com.bbcare.cloud.follow.entry;	

import java.util.List;
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
 * @name:随访模版	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followTemplate")	
public class FollowTemplate {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//模版名称	
	@Column(name="_name")
	private String name;	
	
	//模版类型	
	@Column(name="_type")
	private String type;	
	
	//适用者类型	
	@Column(name="_usedType")
	private String usedType;	
	
	//适用者等级	
	@Column(name="_usedLevel")
	private String usedLevel;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//包含执行模版
	@OneToMany(mappedBy="followTemplate")
    private List<ExecutiveTemplate> executiveTemplates;
	
	//包含随访内容
	@OneToMany(mappedBy="followTemplate")
    private List<FollowContent> followContents;
	
	//所属随访模型
	@ManyToOne
    @JoinColumn(name="_followModel_id")
    private FollowModel  followModel;
    
    //关联随访模型名称
	@Column(name="_followModel_name")
    private String followModelName;
	
	//包含内容分类
	@OneToMany(mappedBy="followTemplate")
    private List<ContentClass> ContentClasss;
	
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
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public String getUsedType() {	
		return usedType;	
	}	
	
	public void setUsedType(String usedType) {	
		this.usedType = usedType;	
	}
	
	public String getUsedLevel() {	
		return usedLevel;	
	}	
	
	public void setUsedLevel(String usedLevel) {	
		this.usedLevel = usedLevel;	
	}
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public List<ExecutiveTemplate> getExecutiveTemplates() {	
		return executiveTemplates;	
	}
	
	public void setExecutiveTemplates(List<ExecutiveTemplate> executiveTemplates) {	
		this.executiveTemplates = executiveTemplates;	
	}
	
	public List<FollowContent> getFollowContents() {	
		return followContents;	
	}
	
	public void setFollowContents(List<FollowContent> followContents) {	
		this.followContents = followContents;	
	}
	
	public FollowModel  getFollowModel() {	
		return followModel;	
	}
	
	public void setFollowModel(FollowModel  followModel) {	
		this.followModel = followModel;	
	}
	
	public String getFollowModelName() {	
		return followModelName;	
	}
	
	public void setFollowModelName(String followModelName) {	
		this.followModelName = followModelName;	
	}
	
	public List<ContentClass> getContentClasss() {	
		return ContentClasss;	
	}
	
	public void setContentClasss(List<ContentClass> ContentClasss) {	
		this.ContentClasss = ContentClasss;	
	}
}