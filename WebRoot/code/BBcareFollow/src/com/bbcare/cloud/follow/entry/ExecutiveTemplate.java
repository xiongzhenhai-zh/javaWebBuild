package com.bbcare.cloud.follow.entry;	

import java.util.List;
import java.util.Date;
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
 * @name:执行模版	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_executiveTemplate")	
public class ExecutiveTemplate {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//执行开始时间	
	@Column(name="_startTime")
	private Date startTime;	
	
	//超时时间	
	@Column(name="_timeOut")
	private Date timeOut;	
	
	//类型	
	@Column(name="_type")
	private Integer type;	
	
	//所属随访模版
	@ManyToOne
    @JoinColumn(name="_followTemplate_id")
    private FollowTemplate followTemplate;
    
    //关联随访模版名称
	@Column(name="_followTemplate_name")
    private String followTemplateName;
	
	//包含触发器
	@OneToMany(mappedBy="executiveTemplate")
    private List<Trigger> triggers;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public Date getStartTime() {	
		return startTime;	
	}	
	
	public void setStartTime(Date startTime) {	
		this.startTime = startTime;	
	}
	
	public Date getTimeOut() {	
		return timeOut;	
	}	
	
	public void setTimeOut(Date timeOut) {	
		this.timeOut = timeOut;	
	}
	
	public Integer getType() {	
		return type;	
	}	
	
	public void setType(Integer type) {	
		this.type = type;	
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
	
	public List<Trigger> getTriggers() {	
		return triggers;	
	}
	
	public void setTriggers(List<Trigger> triggers) {	
		this.triggers = triggers;	
	}
}