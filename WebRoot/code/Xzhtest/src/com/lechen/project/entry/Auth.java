package com.lechen.project.entry;	

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:角色	
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
@Entity	
@Table(name="t_auth")	
public class Auth {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//名字	
	@Column(name="_name")
	private String name;	
	
	//所属用户
	@ManyToOne
    @JoinColumn(name="_user_id")
    private User user;
    
    //关联用户名称
	@Column(name="_user_name")
    private String userName;
	
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