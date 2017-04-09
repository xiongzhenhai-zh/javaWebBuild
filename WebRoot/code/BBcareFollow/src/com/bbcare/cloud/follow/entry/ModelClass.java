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
 * @name:模型分类	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_modelClass")	
public class ModelClass {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//分类名称	
	@Column(name="_name")
	private String name;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//包含模型分类
	@OneToMany(mappedBy="parent")
    private List<ModelClass> children;
	
	//包含随访模型
	@OneToMany(mappedBy="modelClass")
    private List<FollowModel > followModels;
	
	//所属模型分类
	@ManyToOne
    @JoinColumn(name="_parent_id")
    private ModelClass parent;
    
    //关联模型分类名称
	@Column(name="_parent_name")
    private String parentName;
	
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
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public List<ModelClass> getChildren() {	
		return children;	
	}
	
	public void setChildren(List<ModelClass> children) {	
		this.children = children;	
	}
	
	public List<FollowModel > getFollowModels() {	
		return followModels;	
	}
	
	public void setFollowModels(List<FollowModel > followModels) {	
		this.followModels = followModels;	
	}
	
	public ModelClass getParent() {	
		return parent;	
	}
	
	public void setParent(ModelClass parent) {	
		this.parent = parent;	
	}
	
	public String getParentName() {	
		return parentName;	
	}
	
	public void setParentName(String parentName) {	
		this.parentName = parentName;	
	}
}