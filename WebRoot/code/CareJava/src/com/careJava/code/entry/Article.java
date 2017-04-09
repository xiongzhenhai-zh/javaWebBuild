package com.careJava.code.entry;	

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:文章	
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
@Entity	
@Table(name="t_article")	
public class Article {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//标题	
	@Column(name="_title")
	private String title;	
	
	//注册时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//关键字	
	@Column(name="_keyWord")
	private String keyWord;	
	
	//内容	
	@Column(name="_content")
	private String content;	
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//类型	
	@Column(name="_type")
	private String type;	
	
	//所属用户表
	@ManyToOne
    @JoinColumn(name="_user_id")
    private User user;
    
    //关联用户表名称
	@Column(name="_user_name")
    private String userName;
	
	public String getId() {	
		return id;	
	}	
	
	public void setId(String id) {	
		this.id = id;	
	}
	
	public String getTitle() {	
		return title;	
	}	
	
	public void setTitle(String title) {	
		this.title = title;	
	}
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public String getKeyWord() {	
		return keyWord;	
	}	
	
	public void setKeyWord(String keyWord) {	
		this.keyWord = keyWord;	
	}
	
	public String getContent() {	
		return content;	
	}	
	
	public void setContent(String content) {	
		this.content = content;	
	}
	
	public String getStatus() {	
		return status;	
	}	
	
	public void setStatus(String status) {	
		this.status = status;	
	}
	
	public String getType() {	
		return type;	
	}	
	
	public void setType(String type) {	
		this.type = type;	
	}
	
	public User getUser() {	
		return user;	
	}
	
	public void setUser(User user) {	
		this.user = user;	
	}
	
	public String getUserName() {	
		return userName;	
	}
	
	public void setUserName(String userName) {	
		this.userName = userName;	
	}
}