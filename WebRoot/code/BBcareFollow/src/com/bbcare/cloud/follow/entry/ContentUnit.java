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
 * @name:内容单位	
 * @author:	
 * @createTime: 2016-01-28 20:00:43
 */	
	
@Entity	
@Table(name="t_contentUnit")	
public class ContentUnit {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//单位名称	
	@Column(name="_name")
	private String name;	
	
	//单位符号	
	@Column(name="_symbol")
	private String symbol;	
	
	//单位备注	
	@Column(name="_note")
	private String note;	
	
	//单位类别	
	@Column(name="_type")
	private String type;	
	
	//所属人ID	
	@Column(name="_writerId")
	private String writerId;	
	
	//包含随访内容
	@OneToMany(mappedBy="contentUnit")
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
	
	public String getSymbol() {	
		return symbol;	
	}	
	
	public void setSymbol(String symbol) {	
		this.symbol = symbol;	
	}
	
	public String getNote() {	
		return note;	
	}	
	
	public void setNote(String note) {	
		this.note = note;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
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