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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:随访内容	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_followContent")	
public class FollowContent {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//内容名称	
	@Column(name="_name")
	private String name;	
	
	//是否必填	
	@Column(name="_isNull")
	private Boolean isNull;	
	
	//配置信息	
	@Column(name="_config")
	private String config;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//所属人ID	
	@Column(name="_writerId")
	private String writerId;	
	
	//所属内容分类
	@ManyToOne
    @JoinColumn(name="_contentClass_id")
    private ContentClass contentClass;
    
    //关联内容分类名称
	@Column(name="_contentClass_name")
    private String contentClassName;
	
	//所属内容类型
	@ManyToOne
    @JoinColumn(name="_contentType_id")
    private ContentType contentType;
    
    //关联内容类型名称
	@Column(name="_contentType_name")
    private String contentTypeName;
	
	//所属内容单位
	@ManyToOne
    @JoinColumn(name="_contentUnit_id")
    private ContentUnit contentUnit;
    
    //关联内容单位名称
	@Column(name="_contentUnit_name")
    private String contentUnitName;
	
	//所属随访模版
	@ManyToOne
    @JoinColumn(name="_followTemplate_id")
    private FollowTemplate followTemplate;
    
    //关联随访模版名称
	@Column(name="_followTemplate_name")
    private String followTemplateName;
	
	//包含随访选项
	@OneToMany(mappedBy="followContent")
    private List<FollowOption> followOptions;
	
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
	
	public Boolean getIsNull() {	
		return isNull;	
	}	
	
	public void setIsNull(Boolean isNull) {	
		this.isNull = isNull;	
	}
	
	public String getConfig() {	
		return config;	
	}	
	
	public void setConfig(String config) {	
		this.config = config;	
	}
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public String getWriterId() {	
		return writerId;	
	}	
	
	public void setWriterId(String writerId) {	
		this.writerId = writerId;	
	}
	
	public ContentClass getContentClass() {	
		return contentClass;	
	}
	
	public void setContentClass(ContentClass contentClass) {	
		this.contentClass = contentClass;	
	}
	
	public String getContentClassName() {	
		return contentClassName;	
	}
	
	public void setContentClassName(String contentClassName) {	
		this.contentClassName = contentClassName;	
	}
	
	public ContentType getContentType() {	
		return contentType;	
	}
	
	public void setContentType(ContentType contentType) {	
		this.contentType = contentType;	
	}
	
	public String getContentTypeName() {	
		return contentTypeName;	
	}
	
	public void setContentTypeName(String contentTypeName) {	
		this.contentTypeName = contentTypeName;	
	}
	
	public ContentUnit getContentUnit() {	
		return contentUnit;	
	}
	
	public void setContentUnit(ContentUnit contentUnit) {	
		this.contentUnit = contentUnit;	
	}
	
	public String getContentUnitName() {	
		return contentUnitName;	
	}
	
	public void setContentUnitName(String contentUnitName) {	
		this.contentUnitName = contentUnitName;	
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
	
	public List<FollowOption> getFollowOptions() {	
		return followOptions;	
	}
	
	public void setFollowOptions(List<FollowOption> followOptions) {	
		this.followOptions = followOptions;	
	}
}