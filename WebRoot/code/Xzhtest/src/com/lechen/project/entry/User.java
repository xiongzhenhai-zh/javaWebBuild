package com.lechen.project.entry;	

import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @name:用户	
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
@Entity	
@Table(name="t_user")	
public class User {	
	
	@Id	
	@GenericGenerator(name="systemUUID",strategy="uuid")	
	@GeneratedValue(generator="systemUUID")	
	@Column(name="_id")
	private String id;
	
	//名字	
	@Column(name="_name")
	private String name;	
	
	//包含角色
	@OneToMany(mappedBy="user")
    private List<Auth> auths;
	
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
	
	public List<Auth> getAuths() {	
		return auths;	
	}
	
	public void setAuths(List<Auth> auths) {	
		this.auths = auths;	
	}
}