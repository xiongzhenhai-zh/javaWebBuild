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
 * @name:触发器	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_trigger")	
public class Trigger {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//触发器名称	
	@Column(name="_name")
	private String name;	
	
	//状态	
	@Column(name="_status")
	private Integer status;	
	
	//触发事件	
	@Column(name="_event")
	private String event;	
	
	//类型	
	@Column(name="_type")
	private Integer type;	
	
	//触发条件	
	@Column(name="_condition")
	private String condition;	
	
	//所属随访模版
	@ManyToOne
    @JoinColumn(name="_executiveTemplate_id")
    private FollowTemplate executiveTemplate;
    
    //关联随访模版名称
	@Column(name="_executiveTemplate_name")
    private String executiveTemplateName;
	
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
	
	public Integer getStatus() {	
		return status;	
	}	
	
	public void setStatus(Integer status) {	
		this.status = status;	
	}
	
	public String getEvent() {	
		return event;	
	}	
	
	public void setEvent(String event) {	
		this.event = event;	
	}
	
	public Integer getType() {	
		return type;	
	}	
	
	public void setType(Integer type) {	
		this.type = type;	
	}
	
	public String getCondition() {	
		return condition;	
	}	
	
	public void setCondition(String condition) {	
		this.condition = condition;	
	}
	
	public FollowTemplate getExecutiveTemplate() {	
		return executiveTemplate;	
	}
	
	public void setExecutiveTemplate(FollowTemplate executiveTemplate) {	
		this.executiveTemplate = executiveTemplate;	
	}
	
	public String getExecutiveTemplateName() {	
		return executiveTemplateName;	
	}
	
	public void setExecutiveTemplateName(String executiveTemplateName) {	
		this.executiveTemplateName = executiveTemplateName;	
	}
}