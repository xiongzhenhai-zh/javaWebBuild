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
 * @name:随访情况	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_babyFollowDetail")	
public class BabyFollowDetail {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//所属随访内容	
	@Column(name="_followContenId")
	private String followContenId;	
	
	//随访情况	
	@Column(name="_note")
	private String note;	
	
	//内容类型	
	@Column(name="_contentType")
	private String contentType;	
	
	//内容类型	
	@Column(name="_contentClass")
	private String contentClass;	
	
	//内容单位	
	@Column(name="_contentUnit")
	private String contentUnit;	
	
	//排序	
	@Column(name="_sort")
	private Integer sort;	
	
	//所属随访记录
	@ManyToOne
    @JoinColumn(name="_babyFollowRecord_id")
    private BabyFollowRecord babyFollowRecord;
    
    //关联随访记录名称
	@Column(name="_babyFollowRecord_name")
    private String babyFollowRecordName;
	
	//包含宝宝随访详情选项
	@OneToMany(mappedBy="babyFollowDetail")
    private List<BabyFollowDetailOption> babyFollowDetailOptions;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getFollowContenId() {	
		return followContenId;	
	}	
	
	public void setFollowContenId(String followContenId) {	
		this.followContenId = followContenId;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public String getContentType() {	
		return contentType;	
	}	
	
	public void setContentType(String contentType) {	
		this.contentType = contentType;	
	}
	
	public String getContentClass() {	
		return contentClass;	
	}	
	
	public void setContentClass(String contentClass) {	
		this.contentClass = contentClass;	
	}
	
	public String getContentUnit() {	
		return contentUnit;	
	}	
	
	public void setContentUnit(String contentUnit) {	
		this.contentUnit = contentUnit;	
	}
	
	public Integer getSort() {	
		return sort;	
	}	
	
	public void setSort(Integer sort) {	
		this.sort = sort;	
	}
	
	public BabyFollowRecord getBabyFollowRecord() {	
		return babyFollowRecord;	
	}
	
	public void setBabyFollowRecord(BabyFollowRecord babyFollowRecord) {	
		this.babyFollowRecord = babyFollowRecord;	
	}
	
	public String getBabyFollowRecordName() {	
		return babyFollowRecordName;	
	}
	
	public void setBabyFollowRecordName(String babyFollowRecordName) {	
		this.babyFollowRecordName = babyFollowRecordName;	
	}
	
	public List<BabyFollowDetailOption> getBabyFollowDetailOptions() {	
		return babyFollowDetailOptions;	
	}
	
	public void setBabyFollowDetailOptions(List<BabyFollowDetailOption> babyFollowDetailOptions) {	
		this.babyFollowDetailOptions = babyFollowDetailOptions;	
	}
}