package com.careJava.code.entry;	

import java.util.List;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:用户表	
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
@Entity	
@Table(name="t_user")	
public class User {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//昵称	
	@Column(name="_name")
	private String name;	
	
	//注册时间	
	@Column(name="_createTime")
	private Date createTime;	
	
	//用户名	
	@Column(name="_userName")
	private String userName;	
	
	//密码	
	@Column(name="_password")
	private String password;	
	
	//状态	
	@Column(name="_status")
	private String status;	
	
	//类型	
	@Column(name="_type")
	private String type;	
	
	//包含文章
	@OneToMany(mappedBy="user")
    private List<Article> articles;
	
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
	
	public Date getCreateTime() {	
		return createTime;	
	}	
	
	public void setCreateTime(Date createTime) {	
		this.createTime = createTime;	
	}
	
	public String getUserName() {	
		return userName;	
	}	
	
	public void setUserName(String userName) {	
		this.userName = userName;	
	}
	
	public String getPassword() {	
		return password;	
	}	
	
	public void setPassword(String password) {	
		this.password = password;	
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
	
	public List<Article> getArticles() {	
		return articles;	
	}
	
	public void setArticles(List<Article> articles) {	
		this.articles = articles;	
	}
}