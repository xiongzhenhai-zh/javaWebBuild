package com.bbcare.cloud.follow.entry;	

import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:内容类型	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_contentType")	
public class ContentType {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//类型名称	
	@Column(name="_name")
	private String name;	
	
	//所属人ID	
	@Column(name="_writerId")
	private String writerId;	
	
	//包含随访内容
	@OneToMany(mappedBy="contentType")
    private List<FollowContent> followContents;
	
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
}