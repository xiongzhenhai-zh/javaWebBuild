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
 * @name:宝宝随访详情选项	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_babyFollowDetailOption")	
public class BabyFollowDetailOption {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//选项名	
	@Column(name="_name")
	private String name;	
	
	//所属随访情况
	@ManyToOne
    @JoinColumn(name="_babyFollowDetail_id")
    private BabyFollowDetail babyFollowDetail;
    
    //关联随访情况名称
	@Column(name="_babyFollowDetail_name")
    private String babyFollowDetailName;
	
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
	
	public BabyFollowDetail getBabyFollowDetail() {	
		return babyFollowDetail;	
	}
	
	public void setBabyFollowDetail(BabyFollowDetail babyFollowDetail) {	
		this.babyFollowDetail = babyFollowDetail;	
	}
	
	public String getBabyFollowDetailName() {	
		return babyFollowDetailName;	
	}
	
	public void setBabyFollowDetailName(String babyFollowDetailName) {	
		this.babyFollowDetailName = babyFollowDetailName;	
	}
}