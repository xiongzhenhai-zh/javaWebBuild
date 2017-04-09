package com.careJava.code.service.impl;

import com.careJava.code.entry.User;
import com.careJava.code.dao.IUserDAO;
import com.careJava.code.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:用户表	持久层接口
 * @author:	
 * @createTime: 2017-04-06 18:11:32
 */	
	
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;	
	
    public String add(User user) throws Exception {
    	User tempUser = new User();
		tempUser.setName(user.getName());
		tempUser.setCreateTime(user.getCreateTime());
		tempUser.setUserName(user.getUserName());
		tempUser.setPassword(user.getPassword());
		tempUser.setStatus(user.getStatus());
		tempUser.setType(user.getType());
		return userDAO.save(tempUser);	
	}
	
    public void remove(User user) throws Exception {	
		userDAO.delete(user.getId());	
	}
	
    public User modify(User user) throws Exception {	
		User tempUser = userDAO.get(user.getId());
		
		if(user.getName()!=null){
			tempUser.setName(user.getName());
		}
		if(user.getCreateTime()!=null){
			tempUser.setCreateTime(user.getCreateTime());
		}
		if(user.getUserName()!=null){
			tempUser.setUserName(user.getUserName());
		}
		if(user.getPassword()!=null){
			tempUser.setPassword(user.getPassword());
		}
		if(user.getStatus()!=null){
			tempUser.setStatus(user.getStatus());
		}
		if(user.getType()!=null){
			tempUser.setType(user.getType());
		}
		userDAO.update(tempUser);	
		return tempUser;	
	}
	
    public User read(User user) throws Exception {	
		return userDAO.get(user.getId());	
	}	
	
    public List<User> list(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		return userDAO.list(dc, page, rows);	
	}	
	
	public Long getSize(final DetachedCriteria dc) throws Exception {	
		return userDAO.getSize(dc);	
	}
	
    public List<Map<String,String>> combo(final DetachedCriteria dc,final int page,final int rows) throws Exception {	
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		List<User> users = userDAO.list(dc, page, rows);
		for(User user:users){
			Map<String,String> obj = new HashMap<String,String>();
			obj.put("value",user.getId());
			obj.put("text",user.getName());
			list.add(obj);
		}
		return list;	
	}	
	
    public Boolean review(User user) throws Exception {
    	if(user.getStatus()==null){
    		return false;
    	}
		User tempUser = userDAO.get(user.getId());
		if(tempUser!=null){
			tempUser.setStatus(user.getStatus());
			userDAO.update(tempUser);
			return true;
		}else{
			return false;
		}
	}
	
}