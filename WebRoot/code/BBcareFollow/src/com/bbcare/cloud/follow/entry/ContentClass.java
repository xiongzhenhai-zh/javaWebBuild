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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:内容分类	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_contentClass")	
public class ContentClass {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//分类名称	
	@Column(name="_name")
	private String name;	
	
	//所属人ID	
	@Column(name="_writerId")
	private String writerId;	
	
	//包含随访内容
	@OneToMany(mappedBy="contentClass")
    private List<FollowContent> followContents;
	
	//包含内容分类
	@OneToMany(mappedBy="parent")
    private List<ContentClass> children;
	
	//所属内容分类
	@ManyToOne
    @JoinColumn(name="_parent_id")
    private ContentClass parent;
    
    //关联内容分类名称
	@Column(name="_parent_name")
    private String parentName;
	
	//所属随访模版
	@ManyToOne
    @JoinColumn(name="_followTemplate_id")
    private FollowTemplate followTemplate;
    
    //关联随访模版名称
	@Column(name="_followTemplate_name")
    private String followTemplateName;
	
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
	
	public String getWriterId() {	
		return writerId;	
	}	
	
	public void setWriterId(String writerId) {	
		this.writerId = writerId;	
	}
	
	public List<FollowContent> getFollowContents() {	
		return followContents;	
	}
	
	public void setFollowContents(List<FollowContent> followContents) {	
		this.followContents = followContents;	
	}
	
	public List<ContentClass> getChildren() {	
		return children;	
	}
	
	public void setChildren(List<ContentClass> children) {	
		this.children = children;	
	}
	
	public ContentClass getParent() {	
		return parent;	
	}
	
	public void setParent(ContentClass parent) {	
		this.parent = parent;	
	}
	
	public String getParentName() {	
		return parentName;	
	}
	
	public void setParentName(String parentName) {	
		this.parentName = parentName;	
	}
	
	public FollowTemplate getFollowTemplate() {	
		return followTemplate;	
	}
	
	public void setFollowTemplate(FollowTemplate followTemplate) {	
		this.followTemplate = followTemplate;	
	}
	
	public String getFollowTemplateName() {	
		return followTemplateName;	
	}
	
	public void setFollowTemplateName(String followTemplateName) {	
		this.followTemplateName = followTemplateName;	
	}
}