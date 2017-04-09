package com.bbcare.cloud.follow.entry;	

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访选项	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followOption")	
public class FollowOption {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//选项名	
	@Column(name="_name")
	private String name;	
	
	//所属随访内容
	@ManyToOne
    @JoinColumn(name="_followContent_id")
    private FollowContent followContent;
    
    //关联随访内容名称
	@Column(name="_followContent_name")
    private String followContentName;
	
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
	
	public FollowContent getFollowContent() {	
		return followContent;	
	}
	
	public void setFollowContent(FollowContent followContent) {	
		this.followContent = followContent;	
	}
	
	public String getFollowContentName() {	
		return followContentName;	
	}
	
	public void setFollowContentName(String followContentName) {	
		this.followContentName = followContentName;	
	}
}