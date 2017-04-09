package com.lechen.project.service.impl;

import com.lechen.project.entry.User;
import com.lechen.project.dao.IUserDAO;
import com.lechen.project.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @name:用户	持久层接口
 * @author:	
 * @createTime: 2016-01-11 12:47:43
 */	
	
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;	
	
    public String add(User user) throws Exception {
    	User tempUser = new User();
		tempUser.setName(user.getName());
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
	
}