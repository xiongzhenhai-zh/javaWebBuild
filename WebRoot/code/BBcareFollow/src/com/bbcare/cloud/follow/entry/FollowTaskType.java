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
 * @name:随访任务类型	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followTaskType")	
public class FollowTaskType {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//类型名称	
	@Column(name="_name")
	private String name;	
	
	//发送随访内容	
	@Column(name="_content")
	private String content;	
	
	//包含随访任务
	@OneToMany(mappedBy="followTaskType")
    private List<FollowTask> followTasks;
	
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
	
	public String getContent() {	
		return content;	
	}	
	
	public void setContent(String content) {	
		this.content = content;	
	}
	
	public List<FollowTask> getFollowTasks() {	
		return followTasks;	
	}
	
	public void setFollowTasks(List<FollowTask> followTasks) {	
		this.followTasks = followTasks;	
	}
}